package org.scheming.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码格式过滤器
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:54:32
 * @TODO
 */
public class CharsetFilter implements Filter {
	private static final String CHARSET_STRING = "charSet";
	private String charset;

	public CharsetFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter(CHARSET_STRING);
	}

}
