package edu.cs335pl.questionnaire;

import com.itextpdf.text.DocumentException;
import edu.cs335pl.questionnaire.pojo.entity.User;
import edu.cs335pl.questionnaire.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void testValidate() {
        System.out.println(userService.validateAccount("123456"));
    }

    @Test
    void testRegister() {
        User user = new User();
        user.setAccount("123456");
        user.setPassword("123");
        user.setCompany("fzu");
        System.out.println(userService.register(user));
    }

    @Test
    void testLogin() {
        System.out.println(userService.login("123456","123").toString());
    }

    @Test
    void testSubmit() {
        String account = "123456";
        int legal_point = 210;
        int hours_point =200;
        int pp_point =400;
        int er_point =300;
        int pm_point =220;
        int tt_point =320;
        int rr_point =310;
        int cr_point =390;
        int pb_point =330;
        int ece_point =500;
        int hs_point =410;
        int covid_point =322;
        int erg_point =211;
        System.out.println(userService.submit( account, legal_point ,  hours_point,  pp_point,
         er_point,  pm_point,  tt_point,  rr_point,  cr_point, pb_point,  ece_point,  hs_point,  covid_point,  erg_point));
    }

    @Test
    void testGenerate(){
        User user = userService.find("123456");
        try {
            System.out.println(userService.generateFile(user));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
