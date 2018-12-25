package com.qing.springboot1.myfilter;
import org.jasig.cas.client.util.AbstractConfigurationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class LogoutFilters extends AbstractConfigurationFilter {
    private String casServerUrlPrefix;

    private String serverName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.casServerUrlPrefix = getPropertyFromInitParams(filterConfig, "casServerUrlPrefix", "http://localhost:8080/cas");
        this.serverName = getPropertyFromInitParams(filterConfig, "serverName", "http://localhost:8712");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // 跳转跳台URL：
        String redirectUri = req.getQueryString();
        // logo跳转
        String service = serverName + "/exit?service=" + serverName + "/?" + redirectUri;
        resp.sendRedirect(casServerUrlPrefix + "/logout?service=" + service);
    }

    @Override
    public void destroy() {

    }
}
