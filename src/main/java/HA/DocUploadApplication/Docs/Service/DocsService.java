package HA.DocUploadApplication.Docs.Service;

import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocsService {

    String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception;

    Docs findDocsById(Integer id) throws IOException;
}