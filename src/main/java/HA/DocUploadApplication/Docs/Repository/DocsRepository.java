package HA.DocUploadApplication.Docs.Repository;

import HA.DocUploadApplication.core.dto.DocsUploadDTO;
import HA.DocUploadApplication.core.entity.Docs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocsRepository extends JpaRepository<Docs,Integer> {

}
