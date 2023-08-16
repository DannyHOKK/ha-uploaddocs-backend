package HA.DocUploadApplication.Docs.Service.impl;

import HA.DocUploadApplication.Docs.Repository.DocsRepository;
import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.User.Service.UserDetail;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import HA.DocUploadApplication.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @Override
    public String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception {

        try {//dealing with the larger size of file.
            //multipartFile.getBytes() is easier to use, but for the small size of file
            UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            byte[] fileData = StreamUtils.copyToByteArray(multipartFile.getInputStream());
            Docs docs = new Docs(docsUploadDTO.getCategory(), multipartFile.getOriginalFilename(), fileData, docsUploadDTO.getDesc(), docsUploadDTO.getRemark() ,new Date(), userDetail.getUsername());
            docsRepository.save(docs);
            return "success";
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

//        List<Docs> docsList = docsRepository.findAll();



        return null;
    }
}
