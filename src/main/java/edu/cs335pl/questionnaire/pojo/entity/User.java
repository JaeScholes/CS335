package edu.cs335pl.questionnaire.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //有这个注解，默认set和get方法都会帮你自动写好
@NoArgsConstructor //有这个注解，默认的无参构造方法会自动写好
@AllArgsConstructor //有这个注解，有参构造方法会自动写好
@ApiModel(value="User实体类", description="")
public class User {
    @ApiModelProperty(value = "用户id")
    @TableId(type = IdType.AUTO) // IdType.INPUT id会自增
    private Long id;

    //以下部分你可以自己加字段

    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "公司")
    private String company;

    //red=1 amber=10 green=100
    @ApiModelProperty(value = "Legal Compliance")
    private int legal_point;
    @ApiModelProperty(value = "Hours of Work and Leave")
    private int hours_point;
    @ApiModelProperty(value = "Policies & Practices")
    private int pp_point;
    @ApiModelProperty(value = "Employee Relations")
    private int er_point;
    @ApiModelProperty(value = "Performance Management")
    private int pm_point;
    @ApiModelProperty(value = "Training and Training")
    private int tt_point;
    @ApiModelProperty(value = "Recruitment & Retention")
    private int rr_point;
    @ApiModelProperty(value = "Change and Reorganisation")
    private int cr_point;
    @ApiModelProperty(value = "Pay and Benefits")
    private int pb_point;
    @ApiModelProperty(value = "Employee Communication & Engagement")
    private int ece_point;
    @ApiModelProperty(value = "Health and Safety")
    private int hs_point;
    @ApiModelProperty(value = "Covid Related")
    private int covid_point;
    @ApiModelProperty(value = "Employee Records and GDPR")
    private int erg_point;



    //以下别动，如果要存数据库的话
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmt_create;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmt_modified;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleted;

    public void setCovid_point(int covid_point) {
        this.covid_point = covid_point;
    }

    public int getCovid_point() {
        return covid_point;
    }

    public void setCr_point(int cr_point) {
        this.cr_point = cr_point;
    }

    public int getCr_point() {
        return cr_point;
    }

    public void setEce_point(int ece_point) {
        this.ece_point = ece_point;
    }

    public int getEce_point() {
        return ece_point;
    }

    public int getEr_point() {
        return er_point;
    }

    public void setEr_point(int er_point) {
        this.er_point = er_point;
    }

    public void setErg_point(int erg_point) {
        this.erg_point = erg_point;
    }

    public int getErg_point() {
        return erg_point;
    }

    public void setLegal_point(int legal_point) {
        this.legal_point = legal_point;
    }

    public int getLegal_point() {
        return legal_point;
    }

    public void setHours_point(int hours_point) {
        this.hours_point = hours_point;
    }

    public int getHours_point() {
        return hours_point;
    }

    public void setHs_point(int hs_point) {
        this.hs_point = hs_point;
    }

    public int getHs_point() {
        return hs_point;
    }

    public void setPb_point(int pb_point) {
        this.pb_point = pb_point;
    }

    public int getPb_point() {
        return pb_point;
    }

    public void setPm_point(int pm_point) {
        this.pm_point = pm_point;
    }

    public int getPm_point() {
        return pm_point;
    }

    public void setPp_point(int pp_point) {
        this.pp_point = pp_point;
    }

    public int getPp_point() {
        return pp_point;
    }

    public void setRr_point(int rr_point) {
        this.rr_point = rr_point;
    }

    public int getRr_point() {
        return rr_point;
    }

    public void setTt_point(int tt_point) {
        this.tt_point = tt_point;
    }

    public int getTt_point() {
        return tt_point;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }
}
