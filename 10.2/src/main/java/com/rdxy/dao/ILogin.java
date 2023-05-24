package com.rdxy.dao;

import javax.servlet.http.HttpServletRequest;

import com.rdxy.entity.Operator;

public interface ILogin
{
	// 检验账号是否匹配
	public String login(HttpServletRequest request, Operator operator);
}
