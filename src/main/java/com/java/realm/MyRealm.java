package com.java.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.java.entity.Manager;
import com.java.service.ManagerService;

public class MyRealm extends AuthorizingRealm{

	@Resource
	private ManagerService managerService;
	
	
	/*
	 * ��ǰ��¼�û��Ľ�ɫ��Ȩ��
	 * */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}
    
	/**
	 * ��֤��ǰ��¼���û�
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String)token.getPrincipal();
		Manager manager = managerService.getByUserName(userName);
		if (manager!=null) {
			SecurityUtils.getSubject().getSession().setAttribute("currentUser",manager);
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(manager.getUserName(),manager.getPassword(),"XXX");
			return authcInfo;
		}else {
			return null;
		}
	}

}
