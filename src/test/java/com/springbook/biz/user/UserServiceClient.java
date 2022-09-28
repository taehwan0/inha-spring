package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

    public static void main(String[] args) {

        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        UserService userService = container.getBean("userService", UserService.class);

        UserVO user = new UserVO("lee", "1234", "Lee", "user");
        userService.insertUser(user);
    }
}
