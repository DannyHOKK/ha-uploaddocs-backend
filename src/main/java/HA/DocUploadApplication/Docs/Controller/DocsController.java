package HA.DocUploadApplication.Docs.Controller;


import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/api")
public class DocsController {


    @Autowired
    private DocsService docsService;

    @PostMapping("/docsUpload")
    public ResultVO uploadDocs(@RequestPart(value = "file") MultipartFile multipartFiles, @RequestPart(value = "details") DocsUploadDTO docsUploadDTO){
        try{
            if (docsUploadDTO == null){
                return ResultVoUtil.error("Cannot be empty");
            }
            String msg = docsService.uploadDocs(multipartFiles, docsUploadDTO);

            return ResultVoUtil.success(msg);
        }catch (Exception e){
            return ResultVoUtil.error("Upload failed");
        }
    }

    @PostMapping("/docsDownload")
    public ResultVO downloadDocs(@RequestBody(required = false) Integer id, HttpServletResponse response){
        try {


            Docs docs = docsService.findDocsById(id);

            // Get the file path
            Path filePath = Paths.get("<path_to_files_directory>", docs.getFileName());

            // Load the file resource
            Resource resource = new InputStreamResource(Files.newInputStream(filePath));

            // Set the content disposition header to make the browser download the file
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", docs.getFileName());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


            return ResultVoUtil.success();
        }catch (Exception e){
            return ResultVoUtil.error("Download failed");
        }
    }
}
