package HA.DocUploadApplication.core.dto;

public class DocsUploadDTO{


    private String category;

    private String fileName;

    private String desc;

    private String remark;

    public DocsUploadDTO() {
    }

    public DocsUploadDTO( String category, String fileName, String desc, String remark) {
        this.category = category;
        this.fileName = fileName;
        this.desc = desc;
        this.remark = remark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
}