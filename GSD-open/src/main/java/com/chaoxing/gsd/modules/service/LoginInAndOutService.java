package com.chaoxing.gsd.modules.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaoxing.gsd.core.utils.JwtUtils;
import com.chaoxing.gsd.web.res.BaseResponse;
/**
 * 登录，登出服务
 * @author winsl
 *
 */
@Service
public class LoginInAndOutService {

	private static Logger logger = LoggerFactory.getLogger(LoginInAndOutService.class);
	
	@Autowired
	JwtUtils jwtUtils;
	
	/**
	 * 登录服务
	 * @param userName
	 * @param passWord
	 * @param verCode
	 * @return
	 */
	public BaseResponse login(String userName, String passWord)
	{
		logger.info("Enter into method login.");
		BaseResponse out = new BaseResponse();

		Map<String, Object> reqPara = new HashMap<String, Object>();

		String uid = null;

		String realName = null;

		String at = null;

		// TODO 需要实现简单的密码校验登录验证
		reqPara.put("name", userName);
		reqPara.put("pwd", passWord);

		out.setStatu(true);
		reqPara.clear();
		reqPara.put("userid", uid);
		reqPara.put("token", at);
		reqPara.put("timeouthours", 24*30);
		reqPara.put("realname", realName);
		out.setData(reqPara);
		out.setMsg("login succ.");
		return out;
	}
	
}
