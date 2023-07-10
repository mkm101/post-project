package com.example.postproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Slf4j(topic = "LoggingFilter")
//@Component 이 어노테이션을 사용하면 Spring의 일반적인 필터로 인식되며 Spring Security의 필터로 인식되지 않아
// Spring Security를 사용할 때 필터의 동작 순서를 보장할 수 없음
@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        log.info(url);

        chain.doFilter(request, response); // 다음 Filter 로 이동

        // 후처리
        log.info("비즈니스 로직 완료");
    }
}