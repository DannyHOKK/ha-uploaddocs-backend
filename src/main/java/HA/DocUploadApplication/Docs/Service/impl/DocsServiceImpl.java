package HA.DocUploadApplication.Docs.Service.impl;

import HA.DocUploadApplication.Docs.Repository.DocsRepository;
import HA.DocUploadApplication.Docs.Service.DocsService;
import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.util.*;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private static final Map<String, String> CONTENT_TYPE_TO_EXTENSION = new HashMap<>();

    static {
        CONTENT_TYPE_TO_EXTENSION.put("application/pdf", "pdf");
        CONTENT_TYPE_TO_EXTENSION.put("image/jpeg", "jpeg");
        CONTENT_TYPE_TO_EXTENSION.put("application/msword", "doc");
        CONTENT_TYPE_TO_EXTENSION.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        CONTENT_TYPE_TO_EXTENSION.put("application/vnd.ms-powerpoint", "ppt");
        CONTENT_TYPE_TO_EXTENSION.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        CONTENT_TYPE_TO_EXTENSION.put("application/zip", "zip");
        CONTENT_TYPE_TO_EXTENSION.put("application/vnd.ms-excel", "xls");
        CONTENT_TYPE_TO_EXTENSION.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        // Add more mappings as needed
    }

    @Override
    public String uploadDocs(MultipartFile multipartFile, DocsUploadDTO docsUploadDTO) throws Exception {

        try {//dealing with the larger size of file.
            //multipartFile.getBytes() is easier to use, but for the small size of file
            UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            byte[] fileData = multipartFile.getBytes();
            String fileType = null;

            Docs docs = new Docs(getFileType(multipartFile.getContentType()), multipartFile.getOriginalFilename(), fileData, docsUploadDTO.getDesc(), docsUploadDTO.getRemark() ,new Date(), userDetail.getUsername());
            docsRepository.save(docs);
            return "success";
        }catch (Exception e){
            return "upload failed";
        }
    }

    public static String getFileType(String contentType) {
        return CONTENT_TYPE_TO_EXTENSION.getOrDefault(contentType, "unknown");
    }

    @Override
    public Docs findDocsById(Integer id) throws IOException {
        Docs docs = docsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("File not found."));
        return docs;
    }

    @Override
    public List<Docs> findDocsList() {
        try {
            List<Docs> docsList = docsRepository.findAll();

            return docsList;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public String deleteDocsByRefNo(Integer refNo) {
        try {
            docsRepository.deleteById(refNo);
            return "";
        }catch (Exception e){
            return "delete docs failed";
        }
    }

    @Override
    public List<Docs> searchDocsList(DocsUploadDTO docsUploadDTO) {

        String sql = "select * from docs where 1=1 ";
        StringBuilder sqlScript = new StringBuilder(sql);

        String category = null;
        String desc= null;
        String remark= null;
        String createBy= null;

        if (ObjectUtils.isNotEmpty(docsUploadDTO)){
                category = docsUploadDTO.getCategory();
                desc = docsUploadDTO.getDesc();
                remark = docsUploadDTO.getRemark();
                createBy = docsUploadDTO.getCreateBy();
        }

        if(StringUtils.isNotEmpty(category)){
            sqlScript.append(" and category = :category");
        }
        if(StringUtils.isNotEmpty(desc)){
            sqlScript.append(" and description = :desc");
        }
        if(StringUtils.isNotEmpty(remark)){
            sqlScript.append(" and remark = :remark");
        }
        if(StringUtils.isNotEmpty(createBy)){
            sqlScript.append(" and create_by = :createBy");
        }

        Query query = entityManager.createNativeQuery(sqlScript.toString(), Docs.class);


        if(StringUtils.isNotEmpty(category)){
            query.setParameter("category", category);
        }
        if(StringUtils.isNotEmpty(desc)){
            query.setParameter("desc", desc);
        }
        if(StringUtils.isNotEmpty(remark)){
            query.setParameter("remark", remark);
        }
        if(StringUtils.isNotEmpty(createBy)){
            query.setParameter("createBy", createBy);
        }

        List<Docs> docsList = query.getResultList();



        return docsList;
    }
}
