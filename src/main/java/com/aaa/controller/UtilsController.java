package com.aaa.controller;
import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.service.impl.AccountService;
import com.aaa.service.impl.TypeServiceImpl;
import com.aaa.service.impl.UserServiceImpl;
import com.aaa.until.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("utils")
public class UtilsController {


    @Resource
    PromissionService promissionService;

    @Resource
    EmpService empService;

    @Resource
    RoleService roleService;
    //权限查询

    @RequestMapping("find")
    public Object find(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        List<Map<String, Object>> promiss = promissionService.findPromiss(Integer.parseInt(id));
        return promiss;
    }
    //圆工增删改
    @RequestMapping("findemp")
    public List<Employee> findall()
    {
        return empService.findall();
    }


    @RequestMapping(value = "add",method = RequestMethod.POST )
    public Integer add(@RequestBody Employee employee)
    {
        return empService.add(employee);
    }

    @RequestMapping(value = "delete/{eid}",method = RequestMethod.GET )
    public Integer delete(@PathVariable("eid") Integer eid)
    {
        return empService.delete(eid);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Integer update(@RequestBody Employee employee)
    {
        System.out.println(employee);
        return empService.update(employee);
    }
    //权限查询
    @RequestMapping("findAllRole")
    public List<Role> findAllRole()
    {
        return roleService.findAllRole();
    }

    /**
     * 角色修改
     * @param role
     * @return
     */
    @RequestMapping("role_update")
    @ResponseBody
    public int update(@RequestBody Role role){
        int update = roleService.update(role);
        if(update == 1){
            return update;
        }else {
            return 0;
        }
    }


    //账号增删改
    @Resource
    AccountService accountService;
    @ResponseBody
    @RequestMapping("ListAll")
    public Object list(){
        List<Account> accounts = accountService.ListAll();
        return accounts;
    }
    @ResponseBody
    @RequestMapping("insert")
    public Object insert(@RequestBody Account account){
        //获取后台传来的密码，并进行转码操作
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPwd(encode);
        Integer insert = accountService.insert(account);
        if (insert ==1){
            return insert;
        }else {
            return 0;
        }
    }

    @RequestMapping("update_account")
    public Object update(@RequestBody Account account){
        Integer update = accountService.update(account);
        if (update ==1){
            return update;
        }else {
            return 0;
        }
    }

    @RequestMapping("del")
    public Object del(@RequestBody Map map){
        Integer del = accountService.del((Integer) map.get("aid"));
        if (del == 1){
            return del;
        }else {
            return 0;
        }
    }
    //分类添加删除修改
    @Resource
    TypeServiceImpl typeService;
    @RequestMapping("queryAll")
    public List<Type> queryAll(){
        List<Type> type = typeService.queryAll();
        return type;
    }
    @RequestMapping("addType")
    public int add(@RequestBody Type type){
        Integer add = typeService.add(type);
        if(add ==1){
            return add;
        }else{
            return 0;
        }
    }
    @RequestMapping("updateType")
    public int update(@RequestBody Type type){
        Integer update = typeService.update(type);
        if (update == 1){
            return update;
        }else {
            return 0;
        }
    }
    @RequestMapping("deleteType")
    public Object delete_type(Integer tid){
        Integer del = typeService.delete(tid);
        if (del == 1){
            return del;
        }else {
            return 0;
        }
    }

    //用户查询
    @Resource
    UserServiceImpl userService;
    @ResponseBody
    @RequestMapping("FindUser")
    private List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user){
        return userService.addUser(user);
    }


    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Integer updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


/**
     * @PathVariable 映射 URL 绑定的占位符
     * @param uid
     * @return
     *//*

    @RequestMapping(value = "deleteUser/{uid}",method = RequestMethod.POST)
    public Integer deleteUser(@RequestBody @PathVariable("uid") Integer uid){
        return userServiceImpl.deleteUser(uid);
    }


    @RequestMapping(value = "updateState/{uid}/{state}",method = RequestMethod.POST)
    public Integer update(@PathVariable("state") Integer state,@PathVariable("uid") Integer uid){
        System.out.println("修改用户状态");
        System.out.println(state+""+uid);
        return userServiceImpl.updateState(state,uid);
    }
*/


}
