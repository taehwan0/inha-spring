package com.springbook.biz.user;

import org.junit.jupiter.api.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UserTestCase {

    private final static AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    private final static UserService userService = container.getBean("userService", UserService.class);

    @BeforeAll
    @DisplayName("Before: insertUser")
    static void setUp() {
        UserVO vo = new UserVO("lee", "0000", "0000", "user");
        userService.insertUser(vo);
        UserVO savedUser = userService.getUser(vo);
        System.out.println("savedUser: " + savedUser.toString());
    }

//    @Test
//    @DisplayName("getUser Test")
//    void getUser() {
//        UserVO vo = new UserVO("lee", "", "", "");
//        UserVO savedUser = userService.getUser(vo);
//        System.out.println(savedUser.toString());
//    }

    @Test
    @DisplayName("Test: updateUser")
    void updateUser() {
        UserVO vo = new UserVO("lee", "0000", "lee", "admin");
        userService.updateUser(vo);
        UserVO updatedUser = userService.getUser(vo);
        System.out.println("updatedUser: " + updatedUser);
    }

    @Test
    @DisplayName("Test: deleteUser")
    void deleteUser() {
        UserVO vo = new UserVO("lee", "", "", "");
        userService.deleteUser(vo);
        List<UserVO> userList = userService.getUserList();
        System.out.println("deletedUser: " + vo);
        System.out.println("========== Users in DB ==========");
        userList.forEach(System.out::println);
        System.out.println("========== Users in DB ==========");
    }
}
