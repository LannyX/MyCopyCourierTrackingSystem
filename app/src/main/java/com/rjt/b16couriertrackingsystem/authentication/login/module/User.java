package com.rjt.b16couriertrackingsystem.authentication.login.module;

public class User {
    private String msg;
    private String userid;
    private String useremail;
    private String appapikey;

    public User(String msg, String userid, String useremail, String appapikey) {
        this.msg = msg;
        this.userid = userid;
        this.useremail = useremail;
        this.appapikey = appapikey;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getAppapikey() {
        return appapikey;
    }

    public void setAppapikey(String appapikey) {
        this.appapikey = appapikey;
    }
}
