package HA.DocUploadApplication.Docs.Repository;

import HA.DocUploadApplication.core.entity.Docs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocsRepository extends JpaRepository<Docs,Integer> {

}
