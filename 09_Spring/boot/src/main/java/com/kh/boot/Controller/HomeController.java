package com.kh.boot.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Bean에 class응용하는 방법으로도 @Conponent을 클래스에 부여한다.
// @Controller -> getComponet * Controller객체가 가질 수 있는 예외처리등의 기능을 포함하는 어노테이션


@Controller

public class HomeController {
    @RequestMapping("/")


    public String home(){

        return "index";
    }
}
