package org.scheming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆验证
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:54:46
 * @TODO
 */
public class IsLoginFilter implements Filter {
	private static final String PAGE_STRING = "login_page";
	private String page_url;

	public IsLoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute("user_id") == null) {
			httpServletResponse.sendRedirect(page_url);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		page_url = fConfig.getInitParameter(PAGE_STRING);
	}

}
