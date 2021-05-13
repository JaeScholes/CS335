package edu.cs335pl.questionnaire.service;

import com.itextpdf.text.DocumentException;
import edu.cs335pl.questionnaire.pojo.entity.User;

import java.io.File;
import java.io.FileNotFoundException;

public interface UserService {
    public User login(String account, String password);
    public boolean validateAccount(String account);
    public boolean register(User user);
    public File generateFile(User user) throws FileNotFoundException, DocumentException;
    public boolean submit(String account,int legal_point , int hours_point, int pp_point,
                          int er_point, int pm_point, int tt_point, int rr_point, int cr_point,
                          int pb_point, int ece_point, int hs_point, int covid_point, int erg_point);
    public User find(String account);

}
