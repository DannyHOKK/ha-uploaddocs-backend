package HA.DocUploadApplication.core.entity;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;
import java.util.Date;

@SqlResultSetMapping(name = "DocsResultMapping", entities = {
        @EntityResult(entityClass = DocsMappingEntity.class ,
                fields = {
                        @FieldResult(name = "refNo" , column = "REF_NO"),
                        @FieldResult(name = "category" , column = "CATEGORY"),
                        @FieldResult(name = "filename" , column = "FILE_NAME"),
                        @FieldResult(name = "desc" , column = "DESCRIPTION"),
                        @FieldResult(name = "remark" , column = "REMARK"),
                        @FieldResult(name = "createDT" , column = "CREATE_DT"),
                        @FieldResult(name = "createBy" , column = "CREATE_BY")
                }
)})
public class DocsMappingEntity implements Serializable {

    private Integer refNo;
    private String category;
    private String filename;
    private String desc;
    private String remark;
    private Date createDT;
    private String createBy;

    public DocsMappingEntity() {
    }

    public DocsMappingEntity(Integer refID, String category, String filename, String desc, String remark, Date createDT, String createBy) {
        this.refNo = refID;
        this.category = category;
        this.filename = filename;
        this.desc = desc;
        this.remark = remark;
        this.createDT = createDT;
        this.createBy = createBy;
    }

    public Integer getRefID() {
        return refNo;
    }

    public void setRefID(Integer refID) {
        this.refNo = refID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
