package com.generator;


import com.generator.util.DbUtil;
import com.generator.util.Field;
import com.generator.util.FreemarkerUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

public class ServerGenerator {

    public static String MODULE = "src\\main\\java\\com\\";
    public static String DB_TABLE="kehuhuikuan";
    static String toDaoPath = MODULE+"dao\\";
    static String toServerPath = MODULE+"service\\";
    static String toServerImplPath = MODULE+"service\\impl\\";
    static String toControllerPath = MODULE+"controller\\admin\\";
    static String toControllerWebPath = MODULE+"controller\\web\\";
    //static String toControllerPath = MODULE+"\\src\\main\\java\\com\\course\\"+MODULE+"\\controller\\admin\\";
   public static String generatorConfigPath = MODULE+"generator\\generatorConfig.xml";

    public static void main(String[] args) throws Exception {
        String module= MODULE;
        // 只生成配置文件中的第一个table节点
        File file = new File(generatorConfigPath);
        SAXReader reader=new SAXReader();
        //读取xml文件到Document中
        Document doc=reader.read(file);
        //获取xml文件的根节点
        Element rootElement=doc.getRootElement();
        //读取context节点
        Element contextElement = rootElement.element("context");
        //定义一个Element用于遍历
        Element tableElement;
        //取第一个“table”的节点
        tableElement=contextElement.elementIterator("table").next();
        String Domain = tableElement.attributeValue("domainObjectName");
        String tableName = tableElement.attributeValue("tableName");
        String tableNameCn = DbUtil.getTableComment(tableName);
        String domain = Domain.substring(0, 1).toLowerCase() + Domain.substring(1);
        System.out.println("表："+tableElement.attributeValue("tableName"));
        System.out.println("Domain："+tableElement.attributeValue("domainObjectName"));

        List<Field> fieldList = DbUtil.getColumnByTableName(tableName);
       /* String Domain="Section";
        String domain="section";
        String tableNameCn="小节";
        List<Field> fieldList = DbUtil.getColumnByTableName(domain);*/

        Set<String> typeSet = getJavaTypes(fieldList);
        Map<String,Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn",tableNameCn);
        map.put("module",module);
        map.put("fieldList",fieldList);
        map.put("typeSet",typeSet);

        /*生成dao*/
        FreemarkerUtil.initConfig("dao.ftl");
        FreemarkerUtil.generator(toDaoPath+Domain+"Mapper.java",map);

        /*生成server*/
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServerPath+Domain+"Service.java",map);

        /*生成serverImpl*/
        FreemarkerUtil.initConfig("serviceImpl.ftl");
        FreemarkerUtil.generator(toServerImplPath+Domain+"ServiceImpl.java",map);

        /*生成controller*/
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);
        /*生成controller*/
       /* FreemarkerUtil.initConfig("controller_web.ftl");
        FreemarkerUtil.generator(toControllerWebPath+Domain+"ForeController.java",map);*/
        /*生成controller_img*/
       /* FreemarkerUtil.initConfig("controller_img.ftl");
        FreemarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);*/


    }

    /**
     * 获取所有的Java类型，使用Set去重
     */
    private static Set<String> getJavaTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}
