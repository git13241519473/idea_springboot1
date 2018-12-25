package com.qing.springboot1.myfilter;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.util.AbstractConfigurationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CasFilter extends AbstractConfigurationFilter  {
    private String casServerLoginUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.casServerLoginUrl = getPropertyFromInitParams(filterConfig, "casServerLoginUrl", "http://localhost:8080/cas/login");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        //Assertion 可以获取用户信息  https://blog.csdn.net/wangyy130/article/details/51922804
        Assertion assertion = session != null ? (Assertion) session.getAttribute("_const_cas_assertion_") : null;

        boolean haveTicket = false;
        if(null != req.getQueryString()) {
            haveTicket = req.getQueryString().contains("ticket");
        }
        if (assertion != null || haveTicket) {
            chain.doFilter(request, response);
            return;
        } else {
            if(req.getRequestURI().indexOf("exit") != -1) {
                resp.sendRedirect(casServerLoginUrl + "?" + req.getQueryString());
                return;
            }
            resp.setStatus(401);
        }
    }

    @Override
    public void destroy() {

    }
}
