package com.springbook.biz.user;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTestCase {

	private final static AbstractApplicationContext container = new GenericXmlApplicationContext(
			"applicationContext.xml");
	private final static UserService userService = container.getBean("userService", UserService.class);

	@Order(1)
	@DisplayName("insertUser")
	@Test
	void insertUser() {
		UserVO vo = new UserVO("lee", "0000", "0000", "user");
		userService.insertUser(vo);
		UserVO savedUser = userService.getUser(vo);
		System.out.println("insertUser: " + savedUser);
	}

	@Order(2)
	@DisplayName("getUser")
	@Test
	void getUser() {
		UserVO vo = new UserVO("lee", "0000", "", "");
		UserVO savedUser = userService.getUser(vo);
		System.out.println(savedUser.toString());
	}

	@Order(3)
	@DisplayName("updateUser")
	@Test
	void updateUser() {
		UserVO vo = new UserVO("lee", "0000", "lee", "admin");
		userService.updateUser(vo);
		UserVO updatedUser = userService.getUser(vo);
		System.out.println("updatedUser: " + updatedUser);
	}

	@Order(4)
	@DisplayName("loginUser")
	@Test
	void loginUser() {
		UserVO vo = new UserVO("lee", "0000", "", "");
        UserVO user = userService.login(vo);
        System.out.println("loginUser: " + user);
    }

	@Order(5)
	@DisplayName("getUserList")
	@Test
	void getUserList() {
		List<UserVO> userList = userService.getUserList();
		System.out.println("========== Users in DB ==========");
		userList.forEach(System.out::println);
		System.out.println("=================================");
	}

	@Order(6)
	@DisplayName("deleteUser")
	@Test
	void deleteUser() {
		UserVO vo = new UserVO("lee", "", "", "");
		userService.deleteUser(vo);
		System.out.println("deleteUser: " + vo);
	}
}
