package com.kh.boot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


/*
    Interceptor
    -Spring Mav 컨트롤러 실행 전후에 동작
    -DispatcherServlet 이후 단계에서 실행됨

    장점
    -Spring MVC컨트롤러 실행 전후 동작하므로 특정URL 단위로 비즈니스 로직을 분석할 수 있음

    단점
    -요청 본문(Body)을 직접 읽고 조작하기 어려움

    보통 api 요청별로 어떤 작업을 처리하기 위해서 사용
    인증/권한 체크
 */

@Slf4j
@Component
public class LogginInterceptor implements HandlerInterceptor {
    //요청이 컨트롤러에 전달되기 전에
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //요청시작시간 기록(컨트롤러가 동작하는덴 얼마가 걸리는지)
        request.setAttribute("startTime", System.currentTimeMillis());

        log.info("request Method : {}",request.getMethod());
        log.info("request URI : {}",request.getRequestURI());
        log.info("request IP : {}",request.getRemoteAddr());
        log.info("request Agent : {}",request.getMethod());

        return true;
    }

    //요청한 컨트롤러가 동작을 완료한 후에
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    //완료되기까지의 시간을 계산
        long startTime = (Long)request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;

        log.info("request Status : {} duration: {}ms", response.getStatus(), duration);
    }
}
