package com.jk.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.pojo.Claz;
import com.jk.pojo.User;
import com.jk.service.ClazService;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JK
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClazService clazService;

    Map<String,String> map = new HashMap<String,String>();

    @PostMapping("/register_student")
    public String register(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),1);
        return "login";
    }

    @PostMapping("/register_teacher")
    public String register_teacher(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),2);
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user){
        System.out.println("登录");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        SecurityUtils.getSubject().login(token);
        return "forward:clazlist";
    }

    @RequestMapping("/checkcode")
    @ResponseBody
    public Map<String,String> captcha(String captchainput, HttpSession session){
        String captcha = (String) session.getAttribute("captcha");
        System.out.println("--------captcha:"+captcha);
        System.out.println("captcha_input:--------"+captchainput);
        System.out.println(captchainput.equalsIgnoreCase(captcha));
        if (captchainput.equalsIgnoreCase(captcha)){
            System.out.println("验证码正确");
            map.put("captcha_check","1");
        }else {
            System.out.println("验证码错误");
            map.put("captcha_check","0");
        }
        return map;
    }

    @RequestMapping("/clazlist")
    public String selectClazList(HttpServletRequest request){
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        int pageNum = 1;
        int pageSize = 5;

        if (!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if (pageNum<1){
                pageNum = 1;
            }
        }
        if (!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
            if (pageSize<1){
                pageSize = 5;
            }
        }

        PageHelper.startPage(pageNum,pageSize);

        List<Claz> clazs = clazService.selectAllClaz();

        PageInfo<Claz> pageInfo = new PageInfo<Claz>(clazs);
        request.setAttribute("page",pageInfo);
        request.setAttribute("clazList",clazs);
        return "clazlist";
    }


    @RequestMapping("/studentlist")
    public String selectStudentList(Integer claz_id,HttpServletRequest request){
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        int pageNum = 1;
        int pageSize = 5;

        if (!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if (pageNum<1){
                pageNum = 1;
            }
        }
        if (!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
            if (pageSize<1){
                pageSize = 5;
            }
        }

        PageHelper.startPage(pageNum,pageSize);

        List<User> userList = clazService.selectUserByClaz_id(claz_id);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println(userList);
        request.setAttribute("page",pageInfo);
        request.setAttribute("studentList",userList);
        return "studentlist";
    }

    @RequestMapping("/insertclaz")
    public String insertClaz(Claz claz){
        clazService.insertClaz(claz);
        System.out.println(claz);
        return "forward:clazlist";
    }
}
