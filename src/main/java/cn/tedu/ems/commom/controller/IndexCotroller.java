package cn.tedu.ems.commom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCotroller {

    @RequestMapping("index.do")
    String indexUI(){
        return "index";
    }

}
