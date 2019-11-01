package com.jk.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.pojo.Claz;
import com.jk.pojo.User;
import com.jk.service.ClazService;
import com.jk.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 学生注册
     * JK
     **/
    @PostMapping("/register_student")
    public String register(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),1);
        return "login";
    }

    /**
     * 添加学生
     * JK
     **/
    @PostMapping("/register_student2")
    public String register2(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),1);
        return "forward:studentlist";
    }

    /**
     * 教师注册
     * JK
     **/
    @PostMapping("/register_teacher")
    public String register_teacher(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),2);
        return "login";
    }

    /**
     * 登录
     * JK
     **/
    @RequestMapping("/login")
    public String login(User user){
        System.out.println("登录");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        SecurityUtils.getSubject().login(token);
        System.out.println(user.getUsername()+"----------");
        return "forward:clazlist";
    }

    /**
     * 验证码校验
     * JK
     **/
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


    /**
     * 班级列表查询
     * JK
     **/
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

    /**
     * 指定班级的学生列表查询
     * JK
     **/
    @RequiresRoles(value = "teacher")
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
   // @RequiresRoles(value = "teacher")
    /**
     * 添加学生带参跳转
     * JK
     **/
    @RequestMapping("/insertclaz")
    public String insertClaz(Claz claz){
        clazService.insertClaz(claz);
        System.out.println(claz);
        return "forward:clazlist";
    }

    /**
     * 添加班级
     * JK
     **/
    @RequestMapping("/insertintoclaz")
    public String insertIntoClaz(Integer claz_id,HttpServletRequest request){
        System.out.println(claz_id);
        request.setAttribute("ClazId",claz_id);
        return "insertintoclaz";
    }

    /**
     * 修改学生信息前查询
     * JK
     **/
    @RequestMapping("/findbyusername")
    public String findOneUserByUsername(String username,HttpServletRequest request){
        User user = userService.findByUserName(username);
        System.out.println(user);
        request.setAttribute("User",user);
        return "updateuser";
    }

    /**
     * 更改学生信息
     * JK
     **/
    @RequestMapping("/updateuser")
    public String updateUser(User user){
        System.out.println(user+"================");
        userService.updateUser(user);
        return "forward:clazlist";
    }
}
