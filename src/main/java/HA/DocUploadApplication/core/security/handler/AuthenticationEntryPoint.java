package HA.DocUploadApplication.core.security.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        json.put("code", -3);
        json.put("msg", "You do have a token with you.");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json.toString());
    }
}
