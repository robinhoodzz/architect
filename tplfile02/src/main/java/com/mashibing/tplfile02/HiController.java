package com.mashibing.tplfile02;

import com.jfinal.core.Controller;

/**
 * Created by Administrator on 2020/2/3.
 */
public class HiController extends Controller {

    public void index(){
        renderText("Hi World2!");
//        redirect("http://mashibing.com");
    }
}
