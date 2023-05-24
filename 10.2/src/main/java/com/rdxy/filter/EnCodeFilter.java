package com.rdxy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EnCodeFilter implements Filter
{
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// 过滤器，保证整个项目之前的数据所使用的编码都是UTF-8，避免乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);



		HttpServletRequest hs=(HttpServletRequest) request;
		request.setCharacterEncoding("UTF-8");

		System.out.println("这里是EnCodeFilter");
		System.out.println(hs.getRequestURL());
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

}
