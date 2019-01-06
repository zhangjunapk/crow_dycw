package org.zj.crow;

import javafx.geometry.Dimension2DBuilder;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.zj.crow.bean.Brand;
import org.zj.crow.bean.ModelGroup;
import org.zj.crow.bean.SubVersion;
import org.zj.crow.util.DBUtil;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: crowdycw
 * @BelongsPackage: org.zj.crow
 * @Author: ZhangJun
 * @CreateTime: 2019/1/5
 * @Description: ${Description}
 */
public class Content {
    static PhantomJSDriver driver;
    private static final String baseUrl="https://www.iautos.cn";
    private static final String link = "https://www.iautos.cn/chexing/";
    public static List<Brand> brands = new ArrayList<>();
    public static List<ModelGroup> modelGroups = new ArrayList<>();
    public static List<SubVersion> subVersions = new ArrayList<>();
    static Map<String, String> headMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
       // createTable();
        crow();
        //genBean();
        //test();
    }

    private static void createTable() throws Exception {
        String brand=genCreateTable(new File("D:\\java\\base\\crowdycw\\src\\main\\java\\org\\zj\\crow\\bean\\Brand.java"),"dycw_brand");
        String modelgroup=genCreateTable(new File("D:\\java\\base\\crowdycw\\src\\main\\java\\org\\zj\\crow\\bean\\ModelGroup.java"),"dycw_modelgroup");
        String subversion=genCreateTable(new File("D:\\java\\base\\crowdycw\\src\\main\\java\\org\\zj\\crow\\bean\\SubVersion.java"),"dycw_subversion");
        new DBUtil().runSql(brand);
        new DBUtil().runSql(modelgroup);
        new DBUtil().runSql(subversion);
    }

    private static String genCreateTable(File file,String tableName) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(file));
        StringBuilder sb=new StringBuilder("create table "+tableName+"(");
        String line=null;
        while((line=br.readLine())!=null){
            if(line.contains("//")){
                String[] split = line.split("//");
                String comment=split[1];
                String[] s = split[0].split(" ");
                System.out.println(Arrays.toString(s));
                String name=s[s.length-1].replace(";","");
                sb.append(" ").append(name).append(" varchar(50) comment '").append(comment).append("',");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }

    private static void crow() {
        doCrow();
        insert();
    }

    private static void insert() {
        doInsert();
    }

    private static void doInsert() {
        DBUtil dbUtil = new DBUtil();
        for(Brand brand:brands){
            String sql=genInsertSql("dycw_brand",brand);
            dbUtil.runSql(sql);
        }
        for(ModelGroup modelGroup:modelGroups){
            String sql=genInsertSql("dycw_modelgroup",modelGroup);
            dbUtil.runSql(sql);
        }
        for(SubVersion subVersion:subVersions){
            String sql=genInsertSql("dycw_subversion",subVersion);
            dbUtil.runSql(sql);
        }
    }

    private static String genInsertSql(String tableName,Object obj) {
        StringBuilder beforeSb=new StringBuilder("insert into "+tableName+"(");

        for(Field f:obj.getClass().getDeclaredFields()){
            beforeSb.append(f.getName()).append(",");
        }
        beforeSb.deleteCharAt(beforeSb.length()-1);
        beforeSb.append(") values (");

        StringBuilder afterSb=new StringBuilder();
        for(Field f:obj.getClass().getDeclaredFields()){
            f.setAccessible(true);
            try {
                afterSb.append("'"+f.get(obj)+"'").append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        afterSb.deleteCharAt(afterSb.length()-1);
        afterSb.append(")");
        return beforeSb.toString()+afterSb.toString();
    }


    private static void doCrow() {
        Element elementByOkHttp = getElementBySe(link);

        parseBrandModelAndInflate(elementByOkHttp);

        parseSubversion();
    }

    private static void parseSubversion() {
        for(ModelGroup modelGroup:modelGroups){
            Element elementBySe = getElementBySe(modelGroup.getUrl());
            SubVersion subVersion = parseAndInflateSubversions(elementBySe, modelGroup.getBrandId(), modelGroup.getModelGroupId());
            inflateOtherParam(subVersion);
        }
    }

    /**
     * 填充其他参数
     * @param subVersion
     */
    private static void inflateOtherParam(SubVersion subVersion) {
        if(subVersion.getLink()==null||"".equals(subVersion.getLink())){
            return;
        }
        System.out.println("从这个链接获得其他参数:-->"+subVersion.getLink());
        Element elementBySe = getElementBySe(subVersion.getLink());
        doInflateOtherParam(subVersion,elementBySe);
    }

    /**
     * 请求详情url,填充其他数据
     * @param subVersion
     * @param elementBySe
     */
    private static void doInflateOtherParam(SubVersion subVersion, Element elementBySe) {
        String hbdqJg=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDetailRightTop > ul:nth-child(5) > li:nth-child(1) > b").text();
        String hddqJg=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDetailRightTop > ul:nth-child(5) > li:nth-child(2) > b").text();
        String hndqJg=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDetailRightTop > ul:nth-child(5) > li:nth-child(4) > b").text();
        String xndqJg=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDetailRightTop > ul:nth-child(5) > li:nth-child(4) > b").text();
        String yd=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDp > ul > li:nth-child(2)").text();
        String qd=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.carDetail > div.carDetailRight > div.carDp > ul > li:nth-child(3)").text();
        String kssm=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div.kssm > div > p").text();
        String ksmc=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div:nth-child(4) > div > table > tbody > tr:nth-child(1) > td.jbxxBg2").text();
        String cxnk=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div:nth-child(4) > div > table > tbody > tr:nth-child(3) > td.jbxxBg2").text();
        String pfbz=elementBySe.select("#webpage > div:nth-child(12) > div.mainRight > div:nth-child(4) > div > table > tbody > tr:nth-child(4) > td:nth-child(2)").text();
        subVersion.setEscjgHbdq(hbdqJg);
        System.out.println(hbdqJg);
        subVersion.setEscjgHddq(hddqJg);
        System.out.println(hddqJg);
        subVersion.setEscjgHndq(hndqJg);
        System.out.println(hndqJg);
        subVersion.setEscjgxndq(xndqJg);
        System.out.println(xndqJg);
        subVersion.setYd(yd);
        subVersion.setQd(qd);
        System.out.println(yd);
        System.out.println(qd);
        subVersion.setKssm(kssm);
        System.out.println(kssm);
        subVersion.setKsmc(ksmc);
        System.out.println(ksmc);
        subVersion.setCxnk(cxnk);
        System.out.println(cxnk);
        subVersion.setPfbz(pfbz);
        System.out.println(pfbz);
        inflateOtherParam(elementBySe,subVersion);
    }

    /**
     * 这里面的参数都通过反射来注入
     * @param element
     * @param subVersion
     */
    private static void inflateOtherParam(Element element, SubVersion subVersion) {

        List<Element> jbxxs=element.select("#webpage > div:nth-child(12) > div.mainRight > div.jbxx");
        for(Element ele:jbxxs){

            List<Element> trs=ele.select("> div > table > tbody > tr");

            for(Element e:trs){

                List<Element> tds=e.select("> td");

                for(int i=0;i<tds.size();i+=2){
                    String name=tds.get(i).text();
                    String fieldName = getFirstSpell(name);
                    Element valEle = tds.get(i+1);
                    diValue(fieldName,valEle,subVersion);
                }
            }
        }

    }

    private static void diValue(String fieldName, Element valEle, SubVersion subVersion) {

        if("100kmh0zdjlm".equals(fieldName)){
            fieldName="km100h0zdjlm";
        }

        if("0100kmhjssjs".equals(fieldName)){
            fieldName="km0100hjssjs";
        }

        Class<? extends SubVersion> aClass = subVersion.getClass();
        try {
            Field field = aClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            System.out.println(valEle.text());
            field.set(subVersion,valEle.text());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 解析element 得到subversion 然后放到list
     * @param elementBySe
     * @param brandId
     * @param modelGroupId
     */
    private static SubVersion parseAndInflateSubversions(Element elementBySe, String brandId, String modelGroupId) {
        SubVersion subVersion=new SubVersion();
        Element element = elementBySe;

        List<Element> trs = element.select("#eTrims > table > tbody > tr");
        String year="";
        for(Element tr:trs){
            //先获得他的第一个td
            List<Element> tds=tr.getElementsByTag("td");

            Integer nameIndex=0;
            Integer cszdjIndex=1;
            Integer sczdjIndex=2;
            if(tds.size()==4){
                nameIndex=1;
                cszdjIndex=2;
                sczdjIndex=3;
                Element td=tds.get(0);
                String rowspan = td.attr("rowspan");
                if (rowspan != null) {
                    year = td.text();
                    continue;
                }
            }
            subVersion.setBrandId(brandId+"");
            subVersion.setModelGroupId(modelGroupId);
            Elements subversionNameEle = tds.get(nameIndex).select("> p > a");
            String href = subversionNameEle.attr("href");
            subVersion.setLink(baseUrl+href);
            System.out.println(baseUrl+href);
            subVersion.setSubVersionName(subversionNameEle.text());
            System.out.println(subversionNameEle.text());
            subVersion.setSubVersionId(href.split("=")[1]);
            subVersion.setCszdj(tds.get(cszdjIndex).text());
            System.out.println(subVersion.getCszdj());
            subVersion.setScyhj(tds.get(sczdjIndex).text());
            subVersion.setYear(year);
            System.out.println(subVersion.getYear());
        }
        return subVersion;
    }

    /**
     * 解析element并且把品牌放到brandList
     *
     * @param elementByOkHttp
     */
    private static void parseBrandModelAndInflate(Element elementByOkHttp) {
        int currentBrandId = 0;

        List<Element> eles = elementByOkHttp.select("#modelList");
        //每个系列
        for (Element series : eles) {

            //每一个系列重新生成id
            List<Element> cx_lxcons = series.select("> div");
            for (Element cx_lxcon : cx_lxcons) {

                List<Element> cx_lxcon2s = cx_lxcon.getElementsByTag("div");
                for (Element cx_lxcon2:cx_lxcon2s) {
                    currentBrandId=0;

                    Elements leftEle = cx_lxcon2.select("> .cx_lxConLeft");

                    Elements leftImg = leftEle.select("> img");
                    String leftLogoImg = leftImg.attr("src");
                    String brandName = leftEle.text();

                    String[] ss = leftLogoImg.split("/");

                    String brandId=ss.length>=2?ss[ss.length-2]:"";
                    brandId=brandId.equals("img")?new Random().nextInt(900)+100+"":brandId;
                    Brand brand = new Brand();
                    brand.setPicUrl(leftLogoImg);

                    //接下来就是右边的数据了
                    Elements cx_lxConRight_lis = cx_lxcon2.select("> .cx_lxConRight > div");
                    for (Element eee : cx_lxConRight_lis) {
                        //最后一个是空的
                        if(eee.attr("class")==null||null==eee.attr("class")){
                            continue;
                        }
                        if("cx_lxConRight_tit".equals(eee.attr("class"))){
                            ++currentBrandId;
                            brand.setBrandId(brandId + currentBrandId);
                            brand.setBrandName(eee.text());
                            System.out.println(brand);
                            brands.add(brand);
                            continue;
                        }


                        //后面的直接插入到车型组
                        Elements h2 = eee.getElementsByTag("h2");
                        Elements a = h2.select("> a");

                        ModelGroup modelGroup = new ModelGroup();
                        modelGroup.setBrandId(brandId + currentBrandId);
                        modelGroup.setModelGroupId(currentBrandId + "");
                        //这里车型组id直接从a的href标签中获取
                        modelGroup.setUrl(a.attr("href"));
                        try {

                            modelGroup.setModelGroupId(a.attr("href").split("=")[1]);
                            modelGroups.add(modelGroup);
                            modelGroup.setModelGroupName(a.text());
                        }catch (Exception e){}

                        System.out.println("   >" + modelGroup);

                    }

                }

            }
        }
    }



    private static Element getElementByJsoup(String url) {
        try {
            return Jsoup.connect(url).get().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void initHeadMap() {

        if (headMap.size() != 0) {
            return;
        }

        headMap.put("Content-Type", "application/json; charset=utf-8");
        headMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
    }


    private static Element getElementBySe(String url) {
        if (driver == null) {
            initDriver();
        }
        //打开页面
        driver.get(url);
        return Jsoup.parse(driver.getPageSource()).body();
    }

    private static void initDriver() {

        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持（第二参数表明的是你的phantomjs引擎所在的路径）
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "C:\\Users\\Java\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        //创建无界面浏览器对象

        driver = new PhantomJSDriver(dcaps);

        //设置隐性等待（作用于全局）
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    private static Element testOne(){
        String url="https://www.iautos.cn/chexing/trim.asp?id=156034";
        return getElementBySe(url);
    }


    public static void genBean(){
        Element element=testOne();

        List<Element> jbxxs=element.select("#webpage > div:nth-child(12) > div.mainRight > div.jbxx");
        for(Element ele:jbxxs){

            List<Element> trs=ele.select("> div > table > tbody > tr");

            for(Element e:trs){

                List<Element> tds=e.select("> td");

                for(int i=0;i<tds.size();i+=2){
                    String name=tds.get(i).text();
                    System.out.println("public String "+getFirstSpell(name)+";//"+name);
                }
            }
        }

    }



    /**
     * 用于获得汉字的首拼音
     *
     * @param chinese
     * @return
     */
    public static String getFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }


    public static void test(){
        Element elementBySe = getElementBySe("https://www.iautos.cn/chexing/model.asp?id=1972");
        SubVersion subVersion = parseAndInflateSubversions(elementBySe, "1646", "6464");

        inflateOtherParam(subVersion);

        System.out.println(subVersion);
    }

}
