package org.springsource.oauth;

import java.util.List;

public interface FacebookUserInfoService {

	User getUserInfo();

	List<Permission> getPermissions();
}
