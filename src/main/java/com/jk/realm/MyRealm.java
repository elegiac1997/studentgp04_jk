package com.jk.realm;

import com.jk.pojo.User;
//import com.jk.service.PermissionService;
//import com.jk.service.RoleService;
import com.jk.service.RoleService;
import com.jk.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.context.ContextLoader;

import java.util.Set;

@Setter
public class MyRealm extends AuthorizingRealm {
//    private UserService userService;

    private UserService userService;
    private RoleService roleService;
//    private PermissionService permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("在realm中 查询权限");
        // 获取当前用户的用户名
        String username = (String)principals.getPrimaryPrincipal();
        // 查询当前用户的所有 权限信息： RoleService: public List<String:RoleName> queryAllRolesByUsername(String username)
        //                          PermissionService: public List<String:PermissionStr> queryAllPermissionsByUsername(String username)
        RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
//        PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
//         //查询当前用户的权限信息
        System.out.println("------"+username);
        System.out.println(roleService.selectAllRoleByUsername(username));
        Set<String> roles = roleService.selectAllRoleByUsername(username);
//        Set<String> perms = permissionService.selectPermissionByUsername(username);
//        // 将查询出的信息 封装
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
//        simpleAuthorizationInfo.setStringPermissions(perms);
//        System.out.println("------角色权限-------"+simpleAuthorizationInfo);
        return simpleAuthorizationInfo;
//        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("在Realm中查询身份");
        // 获取用户登录时发送来的用户名
        String username = (String)token.getPrincipal();
        // 查询用户信息： UserService:public User queryUserByUsername(String username);
        UserService userService = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);
        //查询到用户信息
        User user = userService.findByUserName(username);
        //判断用户信息是否为null
        if(user==null){//不存在用户名
            return null;//在后续流程中会抛出异常  UnknownAccountException
        }
        // 将用户信息封装在  AuthenticationInfo 中
        /*return new SimpleAuthenticationInfo(user.getUsername(),//数据库中用户名
                                     user.getPassword(), //数据库中的密码
                                     this.getName());*/// realm的标识
        return new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName());

    }
}
