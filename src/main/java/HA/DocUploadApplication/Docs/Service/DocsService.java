package HA.DocUploadApplication.Docs.Service;

import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocsService {

    String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception;

    Docs findDocsById(Integer id) throws IOException;

    List<Docs> findDocsList();

    String deleteDocsByRefNo(Integer refNo);

    List<Docs> searchDocsList(DocsUploadDTO docsUploadDTO);
}
