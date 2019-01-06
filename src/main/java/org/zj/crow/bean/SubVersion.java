package org.zj.crow.bean;

/**
 * @BelongsProject: crowdycw
 * @BelongsPackage: org.zj.crow.bean
 * @Author: ZhangJun
 * @CreateTime: 2019/1/5
 * @Description: 子分类
 */
public class SubVersion {
    private String brandId;//品牌id
    private String modelGroupId;//车型组id
    private String subVersionId;//子分类id
    private String subVersionName;//子分类名

    private String year;//年份
    private String link;//所在链接
    private String cszdj;//厂商指导价
    private String scyhj;//市场优惠价

    private String picLink;//图片链接
    private String escjgHndq;//二手车价格_华南地区
    private String escjgHddq;//二手车价格_华东地区
    private String escjgHbdq;//二手车价格_华北地区
    private String escjgxndq;//二手车价格_西南地区
    private String cxdp;//车型点评
    private String yd;//优点
    private String qd;//缺点

    private String kssm;//款式说明
    private String ksmc;//款式名称
    private String ccsj;//出场时间
    private String cxnk;//车型年款
    private String pfbz;//排放标准


    public String ctxs;//车体形式
    public String zkgmm;//长/宽/高(mm)
    public String qhljmm;//前/后轮距(mm)
    public String qhxzdmm;//前/后悬长度(mm)
    public String zjmm;//轴距(mm)
    public String fzxscd;//风阻系数(cd)
    public String zbzlkg;//整备质量(kg)
    public String zdzzlkg;//最大总质量(kg)
    public String yxrjl;//油箱容积(l)
    public String xlxrjl;//行李箱容积(l)
    public String zdxlxrjl;//最大行李箱容积(l)
    public String cmshhcm;//车门数(含后车门)
    public String cyshjsy;//乘员数(含驾驶员)
    public String jjj;//接近角(°)
    public String lqj;//离去角(°)
    public String fdjzyjs;//发动机重要技术
    public String fdjms;//发动机描述
    public String fdjxh;//发动机型号
    public String fdjsccj;//发动机生产厂家
    public String sglkwl;//升功率(kw/l)
    public String zhyhL100km;//综合油耗(L/100km)
    public String ysb;//压缩比
    public String gjmm;//缸径(mm)
    public String xcmm;//行程(mm)
    public String ggcl;//缸盖材料
    public String mgqms;//每缸气门数
    public String gtcl;//缸体材料
    public String zdglkwpsrpm;//最大功率(kw(ps)/rpm)
    public String zdnjnmrpm;//最大扭矩(n.m/rpm)
    public String rllxbh;//燃料类型标号
    public String rygjfs;//燃油供给方式
    public String pqlml;//排气量(ml)
    public String qgs;//气缸数
    public String fdjfzfx;//发动机放置方向
    public String fdjfzwz;//发动机放置位置
    public String jqfs;//进气方式
    public String lqxt;//冷却系统
    public String bsqxs;//变速器形式
    public String pdfs;//排档方式
    public String qdfs;//驱动方式
    public String zxxt;//转向系统
    public String qxj;//前悬架
    public String hxj;//后悬架
    public String qzd;//前制动
    public String hzd;//后制动
    public String bsqmc;//变速器名称
    public String zcpt;//整车平台
    public String qltgg;//前轮胎规格
    public String hltgg;//后轮胎规格
    public String btgg;//备胎规格
    public String btlgcl;//备胎轮毂材料
    public String qlgcl;//前轮毂材料
    public String hlgcl;//后轮毂材料
    public String qdltkdmm;//驱动轮胎宽度(mm)
    public String qdltbpb;//驱动轮胎扁平比(%)
    public String qdltfhzs;//驱动轮胎负荷指数
    public String qdltsdjb;//驱动轮胎速度级别
    public String qdlgzjyc;//驱动轮毂直径(英寸)
    public String zgcskmh;//最高车速(km/h)
    public String km0100hjssjs;//0-100km/h加速时间(s)//0100kmhjssjs
    public String zdppd;//最大爬坡度(%)
    public String aqqn;//安全气囊
    public String bxq;//保修期
    public String km100h0zdjlm;//100km/h-0制动距离(m)



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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

    public String getSubVersionId() {
        return subVersionId;
    }

    public void setSubVersionId(String subVersionId) {
        this.subVersionId = subVersionId;
    }

    public String getSubVersionName() {
        return subVersionName;
    }

    public void setSubVersionName(String subVersionName) {
        this.subVersionName = subVersionName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCszdj() {
        return cszdj;
    }

    public void setCszdj(String cszdj) {
        this.cszdj = cszdj;
    }

    public String getScyhj() {
        return scyhj;
    }

    public void setScyhj(String scyhj) {
        this.scyhj = scyhj;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getEscjgHndq() {
        return escjgHndq;
    }

    public void setEscjgHndq(String escjgHndq) {
        this.escjgHndq = escjgHndq;
    }

    public String getEscjgHddq() {
        return escjgHddq;
    }

    public void setEscjgHddq(String escjgHddq) {
        this.escjgHddq = escjgHddq;
    }

    public String getEscjgHbdq() {
        return escjgHbdq;
    }

    public void setEscjgHbdq(String escjgHbdq) {
        this.escjgHbdq = escjgHbdq;
    }

    public String getEscjgxndq() {
        return escjgxndq;
    }

    public void setEscjgxndq(String escjgxndq) {
        this.escjgxndq = escjgxndq;
    }

    public String getCxdp() {
        return cxdp;
    }

    public void setCxdp(String cxdp) {
        this.cxdp = cxdp;
    }

    public String getYd() {
        return yd;
    }

    public void setYd(String yd) {
        this.yd = yd;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public String getKssm() {
        return kssm;
    }

    public void setKssm(String kssm) {
        this.kssm = kssm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getCcsj() {
        return ccsj;
    }

    public void setCcsj(String ccsj) {
        this.ccsj = ccsj;
    }

    public String getCxnk() {
        return cxnk;
    }

    public void setCxnk(String cxnk) {
        this.cxnk = cxnk;
    }

    public String getPfbz() {
        return pfbz;
    }

    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getCtxs() {
        return ctxs;
    }

    public void setCtxs(String ctxs) {
        this.ctxs = ctxs;
    }

    public String getZkgmm() {
        return zkgmm;
    }

    public void setZkgmm(String zkgmm) {
        this.zkgmm = zkgmm;
    }

    public String getQhljmm() {
        return qhljmm;
    }

    public void setQhljmm(String qhljmm) {
        this.qhljmm = qhljmm;
    }

    public String getQhxzdmm() {
        return qhxzdmm;
    }

    public void setQhxzdmm(String qhxzdmm) {
        this.qhxzdmm = qhxzdmm;
    }

    public String getZjmm() {
        return zjmm;
    }

    public void setZjmm(String zjmm) {
        this.zjmm = zjmm;
    }

    public String getFzxscd() {
        return fzxscd;
    }

    public void setFzxscd(String fzxscd) {
        this.fzxscd = fzxscd;
    }

    public String getZbzlkg() {
        return zbzlkg;
    }

    public void setZbzlkg(String zbzlkg) {
        this.zbzlkg = zbzlkg;
    }

    public String getZdzzlkg() {
        return zdzzlkg;
    }

    public void setZdzzlkg(String zdzzlkg) {
        this.zdzzlkg = zdzzlkg;
    }

    public String getYxrjl() {
        return yxrjl;
    }

    public void setYxrjl(String yxrjl) {
        this.yxrjl = yxrjl;
    }

    public String getXlxrjl() {
        return xlxrjl;
    }

    public void setXlxrjl(String xlxrjl) {
        this.xlxrjl = xlxrjl;
    }

    public String getZdxlxrjl() {
        return zdxlxrjl;
    }

    public void setZdxlxrjl(String zdxlxrjl) {
        this.zdxlxrjl = zdxlxrjl;
    }

    public String getCmshhcm() {
        return cmshhcm;
    }

    public void setCmshhcm(String cmshhcm) {
        this.cmshhcm = cmshhcm;
    }

    public String getCyshjsy() {
        return cyshjsy;
    }

    public void setCyshjsy(String cyshjsy) {
        this.cyshjsy = cyshjsy;
    }

    public String getJjj() {
        return jjj;
    }

    public void setJjj(String jjj) {
        this.jjj = jjj;
    }

    public String getLqj() {
        return lqj;
    }

    public void setLqj(String lqj) {
        this.lqj = lqj;
    }

    public String getFdjzyjs() {
        return fdjzyjs;
    }

    public void setFdjzyjs(String fdjzyjs) {
        this.fdjzyjs = fdjzyjs;
    }

    public String getFdjms() {
        return fdjms;
    }

    public void setFdjms(String fdjms) {
        this.fdjms = fdjms;
    }

    public String getFdjxh() {
        return fdjxh;
    }

    public void setFdjxh(String fdjxh) {
        this.fdjxh = fdjxh;
    }

    public String getFdjsccj() {
        return fdjsccj;
    }

    public void setFdjsccj(String fdjsccj) {
        this.fdjsccj = fdjsccj;
    }

    public String getSglkwl() {
        return sglkwl;
    }

    public void setSglkwl(String sglkwl) {
        this.sglkwl = sglkwl;
    }

    public String getZhyhL100km() {
        return zhyhL100km;
    }

    public void setZhyhL100km(String zhyhL100km) {
        this.zhyhL100km = zhyhL100km;
    }

    public String getYsb() {
        return ysb;
    }

    public void setYsb(String ysb) {
        this.ysb = ysb;
    }

    public String getGjmm() {
        return gjmm;
    }

    public void setGjmm(String gjmm) {
        this.gjmm = gjmm;
    }

    public String getXcmm() {
        return xcmm;
    }

    public void setXcmm(String xcmm) {
        this.xcmm = xcmm;
    }

    public String getGgcl() {
        return ggcl;
    }

    public void setGgcl(String ggcl) {
        this.ggcl = ggcl;
    }

    public String getMgqms() {
        return mgqms;
    }

    public void setMgqms(String mgqms) {
        this.mgqms = mgqms;
    }

    public String getGtcl() {
        return gtcl;
    }

    public void setGtcl(String gtcl) {
        this.gtcl = gtcl;
    }

    public String getZdglkwpsrpm() {
        return zdglkwpsrpm;
    }

    public void setZdglkwpsrpm(String zdglkwpsrpm) {
        this.zdglkwpsrpm = zdglkwpsrpm;
    }

    public String getZdnjnmrpm() {
        return zdnjnmrpm;
    }

    public void setZdnjnmrpm(String zdnjnmrpm) {
        this.zdnjnmrpm = zdnjnmrpm;
    }

    public String getRllxbh() {
        return rllxbh;
    }

    public void setRllxbh(String rllxbh) {
        this.rllxbh = rllxbh;
    }

    public String getRygjfs() {
        return rygjfs;
    }

    public void setRygjfs(String rygjfs) {
        this.rygjfs = rygjfs;
    }

    public String getPqlml() {
        return pqlml;
    }

    public void setPqlml(String pqlml) {
        this.pqlml = pqlml;
    }

    public String getQgs() {
        return qgs;
    }

    public void setQgs(String qgs) {
        this.qgs = qgs;
    }

    public String getFdjfzfx() {
        return fdjfzfx;
    }

    public void setFdjfzfx(String fdjfzfx) {
        this.fdjfzfx = fdjfzfx;
    }

    public String getFdjfzwz() {
        return fdjfzwz;
    }

    public void setFdjfzwz(String fdjfzwz) {
        this.fdjfzwz = fdjfzwz;
    }

    public String getJqfs() {
        return jqfs;
    }

    public void setJqfs(String jqfs) {
        this.jqfs = jqfs;
    }

    public String getLqxt() {
        return lqxt;
    }

    public void setLqxt(String lqxt) {
        this.lqxt = lqxt;
    }

    public String getBsqxs() {
        return bsqxs;
    }

    public void setBsqxs(String bsqxs) {
        this.bsqxs = bsqxs;
    }

    public String getPdfs() {
        return pdfs;
    }

    public void setPdfs(String pdfs) {
        this.pdfs = pdfs;
    }

    public String getQdfs() {
        return qdfs;
    }

    public void setQdfs(String qdfs) {
        this.qdfs = qdfs;
    }

    public String getZxxt() {
        return zxxt;
    }

    public void setZxxt(String zxxt) {
        this.zxxt = zxxt;
    }

    public String getQxj() {
        return qxj;
    }

    public void setQxj(String qxj) {
        this.qxj = qxj;
    }

    public String getHxj() {
        return hxj;
    }

    public void setHxj(String hxj) {
        this.hxj = hxj;
    }

    public String getQzd() {
        return qzd;
    }

    public void setQzd(String qzd) {
        this.qzd = qzd;
    }

    public String getHzd() {
        return hzd;
    }

    public void setHzd(String hzd) {
        this.hzd = hzd;
    }

    public String getBsqmc() {
        return bsqmc;
    }

    public void setBsqmc(String bsqmc) {
        this.bsqmc = bsqmc;
    }

    public String getZcpt() {
        return zcpt;
    }

    public void setZcpt(String zcpt) {
        this.zcpt = zcpt;
    }

    public String getQltgg() {
        return qltgg;
    }

    public void setQltgg(String qltgg) {
        this.qltgg = qltgg;
    }

    public String getHltgg() {
        return hltgg;
    }

    public void setHltgg(String hltgg) {
        this.hltgg = hltgg;
    }

    public String getBtgg() {
        return btgg;
    }

    public void setBtgg(String btgg) {
        this.btgg = btgg;
    }

    public String getBtlgcl() {
        return btlgcl;
    }

    public void setBtlgcl(String btlgcl) {
        this.btlgcl = btlgcl;
    }

    public String getQlgcl() {
        return qlgcl;
    }

    public void setQlgcl(String qlgcl) {
        this.qlgcl = qlgcl;
    }

    public String getHlgcl() {
        return hlgcl;
    }

    public void setHlgcl(String hlgcl) {
        this.hlgcl = hlgcl;
    }

    public String getQdltkdmm() {
        return qdltkdmm;
    }

    public void setQdltkdmm(String qdltkdmm) {
        this.qdltkdmm = qdltkdmm;
    }

    public String getQdltbpb() {
        return qdltbpb;
    }

    public void setQdltbpb(String qdltbpb) {
        this.qdltbpb = qdltbpb;
    }

    public String getQdltfhzs() {
        return qdltfhzs;
    }

    public void setQdltfhzs(String qdltfhzs) {
        this.qdltfhzs = qdltfhzs;
    }

    public String getQdltsdjb() {
        return qdltsdjb;
    }

    public void setQdltsdjb(String qdltsdjb) {
        this.qdltsdjb = qdltsdjb;
    }

    public String getQdlgzjyc() {
        return qdlgzjyc;
    }

    public void setQdlgzjyc(String qdlgzjyc) {
        this.qdlgzjyc = qdlgzjyc;
    }

    public String getZgcskmh() {
        return zgcskmh;
    }

    public void setZgcskmh(String zgcskmh) {
        this.zgcskmh = zgcskmh;
    }

    public String getKm0100hjssjs() {
        return km0100hjssjs;
    }

    public void setKm0100hjssjs(String km0100hjssjs) {
        this.km0100hjssjs = km0100hjssjs;
    }

    public String getZdppd() {
        return zdppd;
    }

    public void setZdppd(String zdppd) {
        this.zdppd = zdppd;
    }

    public String getAqqn() {
        return aqqn;
    }

    public void setAqqn(String aqqn) {
        this.aqqn = aqqn;
    }

    public String getBxq() {
        return bxq;
    }

    public void setBxq(String bxq) {
        this.bxq = bxq;
    }

    public String getKm100h0zdjlm() {
        return km100h0zdjlm;
    }

    public void setKm100h0zdjlm(String km100h0zdjlm) {
        this.km100h0zdjlm = km100h0zdjlm;
    }

    @Override
    public String toString() {
        return "SubVersion{" +
                "brandId='" + brandId + '\'' +
                ", modelGroupId='" + modelGroupId + '\'' +
                ", subVersionId='" + subVersionId + '\'' +
                ", subVersionName='" + subVersionName + '\'' +
                ", year='" + year + '\'' +
                ", link='" + link + '\'' +
                ", cszdj='" + cszdj + '\'' +
                ", scyhj='" + scyhj + '\'' +
                ", picLink='" + picLink + '\'' +
                ", escjgHndq='" + escjgHndq + '\'' +
                ", escjgHddq='" + escjgHddq + '\'' +
                ", escjgHbdq='" + escjgHbdq + '\'' +
                ", escjgxndq='" + escjgxndq + '\'' +
                ", cxdp='" + cxdp + '\'' +
                ", yd='" + yd + '\'' +
                ", qd='" + qd + '\'' +
                ", kssm='" + kssm + '\'' +
                ", ksmc='" + ksmc + '\'' +
                ", ccsj='" + ccsj + '\'' +
                ", cxnk='" + cxnk + '\'' +
                ", pfbz='" + pfbz + '\'' +
                ", ctxs='" + ctxs + '\'' +
                ", zkgmm='" + zkgmm + '\'' +
                ", qhljmm='" + qhljmm + '\'' +
                ", qhxzdmm='" + qhxzdmm + '\'' +
                ", zjmm='" + zjmm + '\'' +
                ", fzxscd='" + fzxscd + '\'' +
                ", zbzlkg='" + zbzlkg + '\'' +
                ", zdzzlkg='" + zdzzlkg + '\'' +
                ", yxrjl='" + yxrjl + '\'' +
                ", xlxrjl='" + xlxrjl + '\'' +
                ", zdxlxrjl='" + zdxlxrjl + '\'' +
                ", cmshhcm='" + cmshhcm + '\'' +
                ", cyshjsy='" + cyshjsy + '\'' +
                ", jjj='" + jjj + '\'' +
                ", lqj='" + lqj + '\'' +
                ", fdjzyjs='" + fdjzyjs + '\'' +
                ", fdjms='" + fdjms + '\'' +
                ", fdjxh='" + fdjxh + '\'' +
                ", fdjsccj='" + fdjsccj + '\'' +
                ", sglkwl='" + sglkwl + '\'' +
                ", zhyhL100km='" + zhyhL100km + '\'' +
                ", ysb='" + ysb + '\'' +
                ", gjmm='" + gjmm + '\'' +
                ", xcmm='" + xcmm + '\'' +
                ", ggcl='" + ggcl + '\'' +
                ", mgqms='" + mgqms + '\'' +
                ", gtcl='" + gtcl + '\'' +
                ", zdglkwpsrpm='" + zdglkwpsrpm + '\'' +
                ", zdnjnmrpm='" + zdnjnmrpm + '\'' +
                ", rllxbh='" + rllxbh + '\'' +
                ", rygjfs='" + rygjfs + '\'' +
                ", pqlml='" + pqlml + '\'' +
                ", qgs='" + qgs + '\'' +
                ", fdjfzfx='" + fdjfzfx + '\'' +
                ", fdjfzwz='" + fdjfzwz + '\'' +
                ", jqfs='" + jqfs + '\'' +
                ", lqxt='" + lqxt + '\'' +
                ", bsqxs='" + bsqxs + '\'' +
                ", pdfs='" + pdfs + '\'' +
                ", qdfs='" + qdfs + '\'' +
                ", zxxt='" + zxxt + '\'' +
                ", qxj='" + qxj + '\'' +
                ", hxj='" + hxj + '\'' +
                ", qzd='" + qzd + '\'' +
                ", hzd='" + hzd + '\'' +
                ", bsqmc='" + bsqmc + '\'' +
                ", zcpt='" + zcpt + '\'' +
                ", qltgg='" + qltgg + '\'' +
                ", hltgg='" + hltgg + '\'' +
                ", btgg='" + btgg + '\'' +
                ", btlgcl='" + btlgcl + '\'' +
                ", qlgcl='" + qlgcl + '\'' +
                ", hlgcl='" + hlgcl + '\'' +
                ", qdltkdmm='" + qdltkdmm + '\'' +
                ", qdltbpb='" + qdltbpb + '\'' +
                ", qdltfhzs='" + qdltfhzs + '\'' +
                ", qdltsdjb='" + qdltsdjb + '\'' +
                ", qdlgzjyc='" + qdlgzjyc + '\'' +
                ", zgcskmh='" + zgcskmh + '\'' +
                ", km0100hjssjs='" + km0100hjssjs + '\'' +
                ", zdppd='" + zdppd + '\'' +
                ", aqqn='" + aqqn + '\'' +
                ", bxq='" + bxq + '\'' +
                ", km100h0zdjlm='" + km100h0zdjlm + '\'' +
                '}';
    }
}
