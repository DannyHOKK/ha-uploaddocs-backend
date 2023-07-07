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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @Override
    public String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception {

        try {//dealing with the larger size of file.
            //multipartFile.getBytes() is easier to use, but for the small size of file
            byte[] fileData = StreamUtils.copyToByteArray(multipartFile.getInputStream());
            Docs docs = new Docs(docsUploadDTO.getCategory(), docsUploadDTO.getFileName(), fileData, docsUploadDTO.getDesc(), docsUploadDTO.getRemark());
            docsRepository.save(docs);
            return null;
        }catch (Exception e){
            return "upload failed";
        }


    }

    @Override
    public Docs findDocsById(Integer id) throws IOException {
        Docs docs = docsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("File not found."));
        return docs;
    }

    @Override
    public List<Docs> findDocsList(DocsUploadDTO docsUploadDTO) {


        return null;
    }
}
