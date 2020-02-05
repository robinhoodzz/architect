package com.mashibing.tplfile02;

import com.jfinal.config.*;
import com.jfinal.template.Engine;

/**
 * Created by Administrator on 2020/2/3.
 */
public class ServerConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {

    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("hi", HiController.class);
        routes.add("create", CreateController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
