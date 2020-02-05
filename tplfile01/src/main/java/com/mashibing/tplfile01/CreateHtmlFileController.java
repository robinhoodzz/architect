package com.mashibing.tplfile01;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/2/3.
 */
@RestController
public class CreateHtmlFileController {

    @Autowired
    private Configuration tplConf;


    @RequestMapping("create")
    public String create() throws IOException, TemplateException {

        // 获取模板对象
        Template template = tplConf.getTemplate("girl.tpl");

        // 数据集, 用于填充模板位符
        Map<String, Object> map = new HashMap<>();

        Girl girl = new Girl();
        girl.setName("Lucy");
        girl.setAge(33);
        girl.setPrice(298);
        map.put("girl", girl);

        String path = "./tmp";
        int girlId = 18;
        File file = new File(path + File.separator + "girl-" + girlId + ".html");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));



        // 渲染模板
        template.process(map, writer);


        return "ok";
    }

}
