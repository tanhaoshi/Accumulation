package com.example.accumulation.been;

/**
 * Created by Admin on 2017/11/20.
 */

public class SmsCodeRequest {


    /**
     * mobile : sample string 1
     * sms_content : sample string 2
     * user_id : 3
     * sms_type : 4
     * msg_os : 5
     */
    private String mobile;
    private String sms_content;
    private int user_id;
    private int sms_type;
    private int msg_os;
    private String imei;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSms_content() {
        return sms_content;
    }

    public void setSms_content(String sms_content) {
        this.sms_content = sms_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSms_type() {
        return sms_type;
    }

    public void setSms_type(int sms_type) {
        this.sms_type = sms_type;
    }

    public int getMsg_os() {
        return msg_os;
    }

    public void setMsg_os(int msg_os) {
        this.msg_os = msg_os;
    }

    @Override
    public String toString() {
        return "SmsCodeRequest{" +
                "mobile='" + mobile + '\'' +
                ", sms_content='" + sms_content + '\'' +
                ", user_id=" + user_id +
                ", sms_type=" + sms_type +
                ", msg_os=" + msg_os +
                '}';
    }
}
