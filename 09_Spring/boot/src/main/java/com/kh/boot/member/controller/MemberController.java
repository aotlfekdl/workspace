package com.kh.boot.member.controller;

import com.kh.boot.member.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {


    /*
     * spring에서 클라이언트가 보낸 정보를 받는 방법
     * 1. httpServletRequest를 활용해서 전달값을 가져옴
     * 메소드에 매개변수로 HttpServletRequest를 작성해주면
     * 스프링컨테이너가 해당 메서드를 호출할 때 자동으로 객체생성해서 매개변수로 주입
     * */

    /*
    @PostMapping("login.me")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("userId");
        String password = request.getParameter("userPwd");

        System.out.println(id);
        System.out.println(password);
        return null;
    }
    */

    /*
     * 2. @RequestParam 어노테이션을 이용
     * request.getParameter(키)로 벨류를 추출하는  역할을 대신 해주는 어노테이션
     * 요청파라미터의 key값과 동일하게 매개변수명을 설정해주면 @RequestParam어노테이션을 생략해도 됨
     *
     * */
/*
    @PostMapping("login.me")
    public String login(@RequestParam(value = "userId", defaultValue = "user01") String Id, String userPwd){
        System.out.println(Id);
        System.out.println(userPwd);
        return null;
    }


 */
    /*
    객체를 이용하는 방법
    HTML 폼 데이터를 객체로 받을 때 사용할 수 있음
    요청 시 전달값들을 담고자하는 클래스타입을 만들어준뒤
    전달되는 key값과 매개변수 클래스에 필드명을 동일하게 작성해주면
    객체를 매개변수로해서 값을 담아 전달해준다.
    * */
//    @PostMapping("login.me")
//    public String login(@ModelAttribute Member member) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPwd());
//
//
//        return null;
//    }


    /*
     요청처리후에 응답하는 방법(포워딩 or url)
     1. 스프링에서 제공하는 Model 객체를 이용하는 방법
     포워딩할 응답뷰로 전달하고자 하는 데이터를 맵 형식으로(key - value)으로 담을 수 있는 영역
     Model객체에 requsetScope값도 전달
     */
//    @PostMapping("login.me")
//    public String login(@ModelAttribute Member member, Model model) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPwd());
//
//        model.addAttribute("id", member.getUserId());
//        model.addAttribute("pwd", member.getUserPwd());
//        return "index";
//
//    }

    //2. HttpSession이용한 값 저장 후 url재요청

//
//    @PostMapping("login.me")
//    public String login(@ModelAttribute Member member, HttpSession session) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPwd());
//
//        session.setAttribute("id", member.getUserId());
//        session.setAttribute("pwd", member.getUserPwd());
//
//        //url재요청을 원할 시 return내용을 redirect: 재요청url로 해주면 됨
//        return "redirect:/";

//    }

    /*
    3. ModelAndView객체를 이용한 방법 -> 아이디를 담고 리턴형식까지 지정할 수 있음

     */


    @PostMapping("login.me")
    public ModelAndView login(@ModelAttribute Member member, ModelAndView mv) {
        System.out.println(member.getUserId());
        System.out.println(member.getUserPwd());

        mv.addObject("id", member.getUserId());
        mv.addObject("pwd", member.getUserPwd());

        mv.setViewName("redirecet:/");

        //url재요청을 원할 시 return내용을 redirect: 재요청url로 해주면 됨
        return mv;


    }
}






