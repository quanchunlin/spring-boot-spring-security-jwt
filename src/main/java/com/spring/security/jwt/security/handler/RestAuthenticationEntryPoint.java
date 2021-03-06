package com.spring.security.jwt.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定401返回值(身份验证失败)
 */
@Slf4j
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    public RestAuthenticationEntryPoint() {}
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {

        log.info("**********RestAuthenticationEntryPoint Unauthorized**********");

        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(401);
    }
}