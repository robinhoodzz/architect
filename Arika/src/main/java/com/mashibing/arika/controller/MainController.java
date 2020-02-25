package com.mashibing.arika.controller;

import com.mashibing.arika.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/2/5.
 */
@Controller
public class MainController {

    @RequestMapping("")
    public String index() {
        System.out.println("index");
        return "arica";
    }

    /**
     * 显示添加 item 表单
     * @return
     */
    @RequestMapping("addtor")
    public String addtor() {
        return "add";
    }

    /**
     * 表单接受，入库
     * @param item
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Item item, Model model) {

//        Item itemRecord = itemSrv.insert(item);
//
//        model.addAttribute("msg", "添加商品成功, <a href = 'view?id="
//                +itemRecord.getId()+"' target='_blank' class=\"layui-btn\">预览一下</a>");

        return "success";
    }


    @RequestMapping("/abc")
    @ResponseBody
    public String abc() {
        return "abc";
    }

}
