package org.springsource.oauth;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.json.JSONException;
import org.springframework.security.oauth2.consumer.OAuth2RestTemplate;
import org.springframework.security.oauth2.consumer.token.OAuth2ClientTokenServices;
import org.springframework.stereotype.Service;

@Service
public class FacebookUserInfoServiceImpl implements FacebookUserInfoService {

	@Value("${user.info.url}")
	private String userInfoUrl;
	@Value("${user.info.granted.permissions}")
	private String permissionsUrl;

	private OAuth2RestTemplate facebookRestTemplate;
	private OAuth2ClientTokenServices tokenServices;

	private CustomResponseErrorHandler customResponseErrorHandler=new CustomResponseErrorHandler();

	@Override
	public User getUserInfo() {
		return facebookRestTemplate.getForObject(URI.create(userInfoUrl), User.class);
	}

	@Override
	public List<Permission> getPermissions(){
		String permissions=facebookRestTemplate.getForObject(URI.create(permissionsUrl), String.class);
		List<Permission> permissionsList=new ArrayList<>();

		JSONArray arrayOfPermissions= (new JSONObject(permissions)).getJSONArray("data");

		for (Object permissionObj : arrayOfPermissions) {
			JSONObject jsonObj = (JSONObject) permissionObj;
			Permission permission = new Permission(
					jsonObj.getString("permission"),
					jsonObj.getEnum(Status.class, "status"));
			permissionsList.add(permission);
		}
		return permissionsList;
	}


	@Autowired
	public void setFacebookRestTemplate(OAuth2RestTemplate facebookRestTemplate) {
		this.facebookRestTemplate = facebookRestTemplate;
		this.facebookRestTemplate.setErrorHandler(customResponseErrorHandler);
	}

	@Autowired
	public void setTokenServices(OAuth2ClientTokenServices tokenServices) {
		this.tokenServices = tokenServices;
	}

	public OAuth2ClientTokenServices getTokenServices() {
		return tokenServices;
	}

}
