package edu.cs335pl.questionnaire.service.impl;


import com.itextpdf.text.DocumentException;
import edu.cs335pl.questionnaire.mapper.UserMapper;
import edu.cs335pl.questionnaire.pojo.entity.User;
import edu.cs335pl.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

@Service//记得要有Service的注解
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("account",account); //相当于是select * from user where account = account，第二个account是你传进去的
        List<User> users = userMapper.selectByMap(map);
        if(0 == users.size()){ //如果这样账号的用户为0个，就说明没有这样的用户，直接返回false
            return null;
        }//否则，匹配密码
        User user = users.get(0);
        //可以直接去get(0)，因为我们默认每个用户的账户是唯一的，这里返回的users要么0个要么1个
        if(password.equals(user.getPassword())){ //密码匹配
            return user;
        }else{ //密码不匹配
            return null;
        }
    }

    @Override
    public boolean validateAccount(String account) { //这个就是为了保证上诉的login注册的账号唯一
        Map<String, Object> map = new HashMap<>();
        map.put("account",account); //相当于是select * from user where account = account，第二个account是你传进去的
        List<User> users = userMapper.selectByMap(map);
        if(users.size() == 0){ //如果这样账号的用户为0个，就说明没有这样的用户，直接返回true，说明用户要注册的这个账号合法
            return true;
        }//否则，说明这个账号已经被人注册了，不允许该用户注册
        return false;
    }

    @Override
    public boolean register(User user) {
        //先验证该用户的账号是否已经被人注册了
        if(validateAccount(user.getAccount())){ //合法才能注册
            userMapper.insert(user); //插入到user表上，说明注册成功
            return true;
        }//否则返回空，说明注册失败
        return false;
    }

    @Override
    public File generateFile(User user) throws FileNotFoundException, DocumentException {
//        Map<String,Object> map = new HashMap<>();
//        map.put("legal_point",legal_point);
//        map.put("hours_point",hours_point);
//        map.put("pp_point",pp_point);
//        map.put("er_point",er_point);
//        map.put("pm_point",pm_point);
//        map.put("tt_point",tt_point);
//        map.put("rr_point",rr_point);
//        map.put("cr_point",cr_point);
//        map.put("pb_point",pb_point);
//        map.put("ece_point",ece_point);
//        map.put("hs_point",hs_point);
//        map.put("covid_point",covid_point);
//        map.put("erg_point",erg_point);
        int legal_point = user.getLegal_point();
        int hours_point = user.getHours_point();
        int pp_point = user.getPp_point();
        int er_point = user.getEr_point();
        int pm_point = user.getPm_point();
        int tt_point = user.getTt_point();
        int rr_point = user.getRr_point();
        int cr_point = user.getCr_point();
        int pb_point = user.getPb_point();
        int ece_point = user.getEce_point();
        int hs_point = user.getHs_point();
        int covid_point = user.getCovid_point();
        int erg_point = user.getErg_point();


        String filename = user.getCompany()+"_Analysis Result.pdf";
        //!!!!!!!!!!!!!!!!!!!!!!
        String address=null;
        //!!!!!!!!!!!!!!!!!!!!!!!1
        Document document = new Document() ;
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(address));
        document.open();


        document.close();
        writer.close();
        File file = new File(address);
        return file;

    }
    @Override
    public boolean submit(String account,int legal_point , int hours_point,
                          int pp_point, int er_point, int pm_point,
                          int tt_point, int rr_point, int cr_point,
                          int pb_point, int ece_point, int hs_point, int covid_point, int erg_point){
        boolean check = validateAccount(account);
        //Check if this user is stored in database
        Map<String, Object> map = new HashMap<>();
        map.put("account",account); //相当于是select * from user where account = account，第二个account是你传进去的
        List<User> users = userMapper.selectByMap(map);
        if(users.size()==0){
            return false;
        }
        User user = users.get(0);
        //Update the information of points of questionnaire
            user.setLegal_point(legal_point);
            user.setHours_point(hours_point);
            user.setPp_point(pp_point);
            user.setHours_point(hours_point);
            user.setEr_point(er_point);
            user.setPm_point(pm_point);
            user.setTt_point(tt_point);
            user.setRr_point(rr_point);
            user.setCr_point(cr_point);
            user.setPb_point(pb_point);
            user.setEce_point(ece_point);
            user.setHs_point(hs_point);
            user.setCovid_point(covid_point);
            user.setErg_point(erg_point);
       userMapper.updateById(user);
       return true;
    }

    @Override
    public User find(String account){
        boolean check = validateAccount(account);
        //Check if this user is stored in database
        Map<String, Object> map = new HashMap<>();
        map.put("account",account); //相当于是select * from user where account = account，第二个account是你传进去的
        List<User> users = userMapper.selectByMap(map);
        if(users.size()==0){
            return null;
        }
        else {
            User user = users.get(0);
            return user;
        }

    }

}
