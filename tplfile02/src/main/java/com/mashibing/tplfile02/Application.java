package com.mashibing.tplfile02;

import com.jfinal.kit.Kv;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/2/3.
 */
public class Application {


    public static void main(String[] args) {
        UndertowServer.start(ServerConfig.class, 8080, true);


        // 实例化模板引擎
        Engine engine = Engine.use();
        engine.setDevMode(true);
        // 设置classPath
        engine.setBaseTemplatePath(null);
        engine.setToClassPathSourceFactory();
        // 获取模板
        Template template = engine.getTemplate("templates/girl.tpl");
        Map<String, Object> map = new HashMap<>();

        Girl girl = new Girl();
        girl.setName("Aika");
        girl.setAge(18);
        girl.setPrice(3999);
        Kv kv = Kv.by("girl", girl);

        String fileName = "tmp/girl-maxiao18.html";
        template.render(kv, fileName);
    }

}
