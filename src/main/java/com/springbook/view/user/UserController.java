package com.springbook.view.user;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser.do")
    public String insertUser(UserVO userVO) {
        userService.insertUser(userVO);

        return "getUserList.do";
    }

    @RequestMapping("/getUser.do")
    public ModelAndView getUser(UserVO userVO, ModelAndView modelAndView) {
        UserVO user = userService.getUser(userVO);

        modelAndView.setViewName("getUser.jsp");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping("/updateUser.do")
    public String updateUser(UserVO userVO) {
        System.out.println(userVO);

        userService.updateUser(userVO);

        return "getUserList.do";
    }

    @RequestMapping("/deleteUser.do")
    public String deleteUser(UserVO userVO) {
        userService.deleteUser(userVO);

        return "getUserList.do";
    }

    @RequestMapping("/getUserList.do")
    public ModelAndView getUserList(ModelAndView modelAndView) {
        List<UserVO> userList = userService.getUserList();

        modelAndView.setViewName("getUserList.jsp");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }

    public String login(UserVO userVO) {

        return null;
    }
}
