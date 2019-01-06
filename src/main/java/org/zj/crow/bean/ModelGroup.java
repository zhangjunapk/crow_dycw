package org.zj.crow.bean;

/**
 * @BelongsProject: crowdycw
 * @BelongsPackage: org.zj.crow.bean
 * @Author: ZhangJun
 * @CreateTime: 2019/1/5
 * @Description: 车型组
 */
public class ModelGroup {
    private String brandId;//品牌id
    private String modelGroupId;//车型组id
    private String modelGroupName;//车型组名
    private String url;//所在url

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getModelGroupId() {
        return modelGroupId;
    }

    public void setModelGroupId(String modelGroupId) {
        this.modelGroupId = modelGroupId;
    }

    public String getModelGroupName() {
        return modelGroupName;
    }

    public void setModelGroupName(String modelGroupName) {
        this.modelGroupName = modelGroupName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "车型组{" +
                "品牌id='" + brandId + '\'' +
                ", 车型组id='" + modelGroupId + '\'' +
                ", 车型组名='" + modelGroupName + '\'' +
                ", 链接='" + url + '\'' +
                '}';
    }
}
