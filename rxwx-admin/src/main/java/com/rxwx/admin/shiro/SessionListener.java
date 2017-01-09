package com.rxwx.admin.shiro;

import org.apache.shiro.session.Session;  

public class SessionListener implements org.apache.shiro.session.SessionListener {  

	@Override  
    public void onStart(Session session) {//会话创建触发 已进入shiro的过滤连就触发这个方法  
        System.out.println("会话创建：" + session.getId());  
    }  
  
    @Override  
    public void onStop(Session session) {//退出  
        System.out.println("退出会话：" + session.getId());  
    }  
  
    @Override  
    public void onExpiration(Session session) {//会话过期时触发  
        System.out.println("会话过期：" + session.getId());   
    }  

}
