package HA.DocUploadApplication.Docs.Service.impl;

import HA.DocUploadApplication.Docs.Repository.DocsRepository;
import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import HA.DocUploadApplication.core.utils.DocsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @Override
    public String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception {

        Docs docs = new Docs(multipartFile.getOriginalFilename(),docsUploadDTO.getCategory(),DocsUtil.compressImage(multipartFile.getBytes()) ,docsUploadDTO.getDesc(),docsUploadDTO.getRemark());

        docsRepository.save(docs);
        if (docs != null) {
            return "file uploaded successfully : " + docs.getFileName();
        }
        return null;
    }

    @Override
    public Docs findDocsById(Integer id) throws IOException {
        Docs docs = docsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("File not found."));

        return docs;
    }
}
