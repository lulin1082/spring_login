package cn.tedu.ems.commom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCotroller {
  /*  @RequestMapping("/toIndex.do")
    public String toIndex( ){
        return "jsp/index";
    }*/
    @RequestMapping("/toIndex.do")
    String indexUI(){
        return "jsp/index";
    }

}
