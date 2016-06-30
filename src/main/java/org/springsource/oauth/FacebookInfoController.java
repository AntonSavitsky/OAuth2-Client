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
	public ModelAndView getCV() {
		User userInfo = userInfoService.getUserInfo();
		System.out.println(userInfo);
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userInfo.getName());
		params.put("userId", userInfo.getId());
		ModelAndView modelAndView = new ModelAndView("user-info", params);


		List<Permission> list=userInfoService.getPermissions();
		System.out.println("permissions:");
		Iterator iterator=list.iterator();
		while(iterator.hasNext()) {
			Permission permission = (Permission) iterator.next();
			System.out.println("name: " + permission.getName() + "|" + "status: " + permission.getStatus());
		}
		return modelAndView;
	}

	@Autowired
	public void setUserInfoService(FacebookUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
