package com.aaa.controller;
import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.service.impl.*;
import com.aaa.until.JwtUtils;
import com.aaa.until.UUIDUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
    public Object find(HttpServletRequest request) {
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        List<Map<String, Object>> promiss = promissionService.findPromiss(Integer.parseInt(id));
        return promiss;
    }

    //圆工增删改
    @RequestMapping("findemp")
    public List<Employee> findall() {
        return empService.findall();
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Integer add(@RequestBody Employee employee) {
        return empService.add(employee);
    }

    @RequestMapping(value = "delete/{eid}", method = RequestMethod.GET)
    public Integer delete(@PathVariable("eid") Integer eid) {
        return empService.delete(eid);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Integer update(@RequestBody Employee employee) {
        System.out.println(employee);
        return empService.update(employee);
    }

    //权限查询
    @RequestMapping("findAllRole")
    public List<Role> findAllRole() {
        return roleService.findAllRole();
    }

    /**
     * 角色修改
     *
     * @param role
     * @return
     */
    @RequestMapping("role_update")
    @ResponseBody
    public int update(@RequestBody Role role) {
        int update = roleService.update(role);
        if (update == 1) {
            return update;
        } else {
            return 0;
        }
    }


    //账号增删改
    @Resource
    AccountService accountService;

    @ResponseBody
    @RequestMapping("ListAll")
    public Object list() {
        List<Account> accounts = accountService.ListAll();
        return accounts;
    }
    @ResponseBody
    @RequestMapping("insert")
    public Object insert(@RequestBody Account account) {
        //获取后台传来的密码，并进行转码操作
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPwd(encode);
        Integer insert = accountService.insert(account);
        if (insert == 1) {
            return insert;
        } else {
            return 0;
        }
    }

    @RequestMapping("update_account")
    public Object update(@RequestBody Account account) {
        Integer update = accountService.update(account);
        if (update == 1) {
            return update;
        } else {
            return 0;
        }
    }

    @RequestMapping("del")
    public Object del(@RequestBody Map map) {
        Integer del = accountService.del((Integer) map.get("aid"));
        if (del == 1) {
            return del;
        } else {
            return 0;
        }
    }

    //分类添加删除修改
    @Resource
    TypeServiceImpl typeService;

    @RequestMapping("queryAll")
    public List<Type> queryAll() {
        List<Type> type = typeService.queryAll();
        return type;
    }

    @RequestMapping("addType")
    public int add(@RequestBody Type type) {
        Integer add = typeService.add(type);
        if (add == 1) {
            return add;
        } else {
            return 0;
        }
    }

    @RequestMapping("updateType")
    public int update(@RequestBody Type type) {
        Integer update = typeService.update(type);
        if (update == 1) {
            return update;
        } else {
            return 0;
        }
    }


    @RequestMapping(value = "deleteType/{tid}",method = RequestMethod.GET )
    public Integer delete_type(@PathVariable("tid") Integer tid)
    {
        return typeService.delete(tid);
    }

    //用户管理
    @Resource
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("FindUser")
    private List<User> findAll() {
        return userService.findAll();
    }
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public Integer updateuser(@RequestBody User user) {
        System.out.println(user);
        return userService.updateUser(user);
    }
    //菜谱管理
    @Resource
    CookBookServiceImpl cookBookService;
    @RequestMapping("findCookBook")
    public List<CookBook> listAll(){
        return cookBookService.listAll();
    }
    @RequestMapping(value = "deleteCookBook/{cid}",method = RequestMethod.GET )
    public Integer deleteCookBook(@PathVariable("cid") Integer cid)
    {
        return cookBookService.delete(cid);
    }
    //社区管理
    @Resource
    ShareService shareService;

    @RequestMapping("findShare")
    public List<Share> listShare(){
        return shareService.listShare();
    }

    @RequestMapping(value = "delShare/{sid}",method = RequestMethod.GET )
    public Integer delShare(@PathVariable("sid") Integer sid)
    {
        return shareService.delShare(sid);
    }

    //举报管理
    @Resource
    ReportServiceImpl reportService;
    @RequestMapping("FindReport")
    public List<Report> show(){
        return reportService.Show();
    }
    @RequestMapping("updateReport")
    public int updateReport(@RequestBody Report report) {
        System.out.println(report);
        if (report.getAnswer().getAnswer().equals("举报成功") )
        {
            report.setAreportid(2);
        }else if (report.getAnswer().getAnswer().equals("举报失败") )
        {
            report.setAreportid(3);
        }else
        {
            report.setAreportid(1);
        }
        System.out.println(report);
        Integer update = reportService.updateReport(report);
        if (update == 1) {
            return update;
        } else {
            return 0;
        }
    }


    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("upload")
    @ResponseBody
    public Result upload(MultipartFile file) throws Exception {
        Result result = new Result();
        String upload="";
        if (null!=file){
            String contentType = file.getContentType();
            if (contentType.equals("image/png")||contentType.equals("image/jpeg")||contentType.equals("image/jpg")) {


                try {
                    String name = UUIDUtils.ImgName();

                    upload = AliOSS.upload(name, file);

                } catch (Exception e) {
                    return ResultUtil.error(ResultCode.ERROR, "文件上传失败");

                }
            }else {
                return ResultUtil.error(ResultCode.ERROR, "上传文件类型请选择图片格式");
            }
            //   System.out.println(upload);
            Map<String,Object>map=new HashMap<>();
            map.put("msg","上传成功");
            map.put("head",upload);
            return ResultUtil.success(ResultCode.SUCCESS,map);
        }

        return ResultUtil.error(ResultCode.ERROR, "文件上传失败");

    }


    @RequestMapping(value = "addShare", method = RequestMethod.POST)
    public Integer addShare(@RequestBody Share share) {
        return shareService.addShare(share);
    }

}
