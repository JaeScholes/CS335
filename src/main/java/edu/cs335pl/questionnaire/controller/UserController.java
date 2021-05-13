package edu.cs335pl.questionnaire.controller;

import com.itextpdf.text.DocumentException;
import edu.cs335pl.questionnaire.pojo.ServerResponse;
import edu.cs335pl.questionnaire.pojo.entity.User;
import edu.cs335pl.questionnaire.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ServerResponse login(@ApiParam("account password")
            @RequestBody Map<String, String> inParams,
                                HttpSession session){
        User user = userService.login(inParams.get("account"),inParams.get("password"));
        if(user!=null ){
             String company = user.getCompany();
             session.setAttribute("loginUser",company);
             //应该返回页面！！！！！！！
            //!!!!!!!!!!!!!!!!
            //!!!!!!!!!!!!!!!!
            //!!!!!!!!!!!!!!!!
              return ServerResponse.ofSuccess("成功！");
        }
        return ServerResponse.ofError("用户名或密码错误！");
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ServerResponse register(@ApiParam("account password company")
            @RequestBody Map<String, String> inParams){
        User user = new User();
        user.setAccount(inParams.get("account"));
        user.setPassword(inParams.get("password"));
        user.setCompany(inParams.get("company"));
        if(userService.register(user)){
            return ServerResponse.ofSuccess("注册成功！");
        }
        return ServerResponse.ofError("注册失败！");
    }

    @ApiOperation("验证账号是否被注册")
    @GetMapping("/validate/{account}")
    public ServerResponse validate(@ApiParam("account")
         @PathVariable String account){
        if(userService.validateAccount(account)){
            return ServerResponse.ofSuccess("该账号可以使用");
        }
        return ServerResponse.ofError("该账号已被人注册");
    }

    @ApiOperation("生成结果")
    @GetMapping("/generate")
    public ResponseEntity<FileSystemResource> generate(@ApiParam("account") @RequestParam String account) throws DocumentException, FileNotFoundException {
        User user = userService.find(account);
        //一般此时的帐号不可能会不存在于数据库中
        if(user==null){
            return null;
        }
        else {
                File file = userService.generateFile(user);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");
                headers.add("Last-Modified", new Date().toString());
                headers.add("ETag", String.valueOf(System.currentTimeMillis()));
                return ResponseEntity .ok() .headers(headers) .contentLength(file.length()) .contentType(MediaType.parseMediaType("application/octet-stream")) .body(new FileSystemResource(file));
        }
    }

    @ApiOperation("提交/更新问卷结果")
    @GetMapping("/submit")
    public ServerResponse submit(@ApiParam("account") @RequestParam(required = true) String account,@ApiParam("Point of Legal Compliance") @RequestParam int legal_point ,
                                 @ApiParam("Point of Hours of Work and Leave") @RequestParam int hours_point, @ApiParam("Point of Policies & Practices") @RequestParam int pp_point,
                                 @ApiParam("Point of Employee Relations") @RequestParam int er_point, @ApiParam("Performance Management") @RequestParam int pm_point,
                                 @ApiParam("Point of Training and Training") @RequestParam int tt_point, @ApiParam("Point of Recruitment & Retention") @RequestParam int rr_point,
                                 @ApiParam("Point of Change and Reorganisation") @RequestParam int cr_point, @ApiParam("Point of Pay and Benefits") @RequestParam int pb_point,
                                 @ApiParam("Point of Employee Communication & Engagement") @RequestParam int ece_point, @ApiParam("Point of Health and Safety") @RequestParam int hs_point,
                                 @ApiParam("Point of Covid Related") @RequestParam int covid_point,@ApiParam("Point of Employee Records and GDPR") @RequestParam int erg_point){

       boolean result =  userService.submit(account,legal_point,hours_point,pp_point,er_point,pm_point,tt_point,rr_point,cr_point,pb_point,ece_point,hs_point,covid_point,erg_point);
       if(result){
           return ServerResponse.ofSuccess("Submission is successfully done.");
       }
       else {
           return ServerResponse.ofError("Submission fails.");
       }
    }





}
