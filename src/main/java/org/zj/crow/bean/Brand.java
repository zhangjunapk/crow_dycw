package org.zj.crow.bean;

/**
 * @BelongsProject: crowdycw
 * @BelongsPackage: org.zj.crow.bean
 * @Author: ZhangJun
 * @CreateTime: 2019/1/5
 * @Description: ${Description}
 */
public class Brand {
    private String brandName;//品牌名
    private String brandId;//品牌id
    private String url;//这个品牌的url
    private String picUrl;//这个品牌的logo图片

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "品牌{" +
                "品牌名='" + brandName + '\'' +
                ", 品牌id='" + brandId + '\'' +
                ", 链接='" + url + '\'' +
                ", 图片链接='" + picUrl + '\'' +
                '}';
    }
}
