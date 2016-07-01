package org.springsource.oauth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookInfoController {

	private FacebookUserInfoService userInfoService;
	
	@RequestMapping(value="/user")
	public ModelAndView getUserInfo() {
		User userInfo = userInfoService.getUserInfo();

		List<Permission> list=userInfoService.getPermissions();
		ModelAndView modelAndView=new ModelAndView("user-info","user", userInfo);
		modelAndView.addObject("permissions", list);
		return modelAndView;
	}


	@Autowired
	public void setUserInfoService(FacebookUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
