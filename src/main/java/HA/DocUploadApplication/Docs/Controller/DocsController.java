package HA.DocUploadApplication.Docs.Controller;


import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import HA.DocUploadApplication.core.utils.ResultVoUtil;
import HA.DocUploadApplication.core.vo.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
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
@CrossOrigin
public class DocsController {


    @Autowired
    private DocsService docsService;

    @PostMapping(value = "/docsUpload" , consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResultVO uploadDocs(@RequestParam(value = "fileDetails") String fileDetails,@RequestPart(value = "file") MultipartFile multipartFiles){
        try{

            DocsUploadDTO uploadDTO = new DocsUploadDTO();
            ObjectMapper objectMapper = new ObjectMapper();
            uploadDTO = objectMapper.readValue(fileDetails, DocsUploadDTO.class);
            if (fileDetails == null || fileDetails.isEmpty()){
                return ResultVoUtil.error("Cannot be empty");
            }
            String msg = docsService.uploadDocs(multipartFiles, uploadDTO);

            if (msg == null){
                return ResultVoUtil.success("success uploaded");
            }else {
                return ResultVoUtil.error(msg);
            }
        }catch (Exception e){
            return ResultVoUtil.error("Upload file failed");
        }
    }

//    @PostMapping("/docsDownload")
//    public ResponseEntity<InputStreamResource> downloadDocs(@RequestParam Integer id){
//        try {
//            Docs docs = docsService.findDocsById(id);
//
//            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(docs.getData()));
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentDispositionFormData("attachment",docs.getFilename());
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .body(resource);
//        }catch (Exception e){
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @PostMapping("/docsDownload")
    public ResponseEntity<byte[]> downloadDocs(@RequestParam Integer id){
        try {
            Docs docs = docsService.findDocsById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",docs.getFilename());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.set("Content-Encoding", "UTF-8");
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(docs.getData());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getDocsList")
    public ResultVO getDocsList(@RequestBody(required = false) DocsUploadDTO docsUploadDTO){
        try{
            List<Docs> docsList = docsService.findDocsList();

            if (docsList == null){
                return ResultVoUtil.error("fail to get docs list");
            }
            return ResultVoUtil.success("Get Docs Successfully", docsList);
        }catch (Exception e){
            return ResultVoUtil.error("Get Docs List Failed");
        }
    }

    @PostMapping("/deleteDocs")
    public ResultVO deleteDocs(@RequestParam Integer refNo){
        try{
            String msg = docsService.deleteDocsByRefNo(refNo);

            if (StringUtils.isNotEmpty(msg)){
                return ResultVoUtil.error(msg);
            }

            return ResultVoUtil.success("delete success");

        }catch (Exception e){
            return ResultVoUtil.error("delete Docs failed");
        }
    }

    @PostMapping("/searchDocsList")
    public ResultVO searchDocsList(@RequestBody DocsUploadDTO docsUploadDTO){
        try{

            List<Docs> docsUploadDTOList = docsService.searchDocsList(docsUploadDTO);

            return ResultVoUtil.success(docsUploadDTOList);

        }catch (Exception e){
            return ResultVoUtil.error("Search DocsList failed");
        }
    }

}
