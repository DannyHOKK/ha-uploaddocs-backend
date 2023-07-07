package HA.DocUploadApplication.Docs.Controller;


import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping(value = "/api/docs")
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

            if (msg == null){
                return ResultVoUtil.success("success uploaded");
            }else {
                return ResultVoUtil.error(msg);
            }
        }catch (Exception e){
            return ResultVoUtil.error("Upload file failed");
        }
    }

    @PostMapping("/docsDownload")
    public ResponseEntity<InputStreamResource> downloadDocs(@RequestBody Integer id, HttpServletResponse response){
        try {
            Docs docs = docsService.findDocsById(id);

            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(docs.getData()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",docs.getFilename());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResultVO searchAllDocs(@RequestBody DocsUploadDTO docsUploadDTO){
        try{
            List<Docs> docsList = docsService.findDocsList(docsUploadDTO);

            return ResultVoUtil.success("Get Docs Successfully");
        }catch (Exception e){
            return ResultVoUtil.error("Get Docs List Failed");
        }
    }
}
