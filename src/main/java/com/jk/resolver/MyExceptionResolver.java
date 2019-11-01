package com.jk.resolver;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(ex.getClass());
        ex.printStackTrace();//开发时必需
        ModelAndView mv = new ModelAndView();
        if (ex instanceof IncorrectCredentialsException || ex instanceof UnknownAccountException) {
            //跳转登录页面，重新登录
            mv.setViewName("redirect:/user/login");
        }
        return mv;
    }

//    /**
//     * 权限异常
//     *
//     * @param request
//     * @param response
//     * @return
//     */
//    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
//    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", "-1001");
//        map.put("message", "无权限");
//        writeJson(map, response);
//        return null;
//    }
}

