package com.example.accumulation.been;

/**
 * <p>RegisterRequest注册or登录请求
 *
 * @author zhanghuiyu
 * @version 1.0.0
 * @createTime 2017/11/27 9:45
 * @updateTime 2017/11/27 9:45
 */
public class RegisterRequest {

    /**
     * 手机号 （必须）	18612345678
     */
    private String userMobile;
    /**
     * 邮箱	xx@manjiba.com
     */
    private String userEmail;
    /**
     * IP所属地址	广东深圳龙岗
     */
    private String ipBelongArea;
    /**
     * IP	192.168.1.1
     */
    private String ip;
    /**
     * 设备型号	IPHONE X
     */
    private String deviceModel;
    /**
     * 设备操作系统	OS X 10.11.3 El Capitan 正式版系统
     */
    private String deviceOs;
    /**
     *
     */
    private String imei;
    /**
     *
     */
    private String idfa;

    /**
     * im版本号	0.0.0.1
     */
    private String imVersion;
    /**
     * 注册来源系统	1
     */
    private int registSource;
    /**
     * 用户来源	1
     */
    private int userComeFrom;
    /**
     * 验证码（必须）	816316
     */
    private String verificationCode;


    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getIpBelongArea() {
        return ipBelongArea;
    }

    public void setIpBelongArea(String ipBelongArea) {
        this.ipBelongArea = ipBelongArea;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getImVersion() {
        return imVersion;
    }

    public void setImVersion(String imVersion) {
        this.imVersion = imVersion;
    }

    public int getRegistSource() {
        return registSource;
    }

    public void setRegistSource(int registSource) {
        this.registSource = registSource;
    }

    public int getUserComeFrom() {
        return userComeFrom;
    }

    public void setUserComeFrom(int userComeFrom) {
        this.userComeFrom = userComeFrom;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "userMobile='" + userMobile + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }

}
