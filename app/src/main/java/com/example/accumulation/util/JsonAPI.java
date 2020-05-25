package com.example.accumulation.util;

import android.os.Build;
import android.text.TextUtils;

import com.blankj.utilcode.util.AppUtils;
import com.example.accumulation.App;
import com.example.accumulation.been.RegisterRequest;
import com.example.accumulation.been.SmsCodeRequest;

/**
 * <p>JsonAPI
 *
 * @author zhanghuiyu
 * @version 1.0.0
 * @createTime 2017/11/20 17:46
 * @updateTime 2017/11/20 17:46
 */

public class JsonAPI {

    private static final String TAG = "JsonAPI";


    /**
     * 获取短信注册验证码
     *
     * @param mobile 手机号
     *               306:提现业务 307:后台登录 308:客服发送短信给客户
     *               309:后台监控通知 310:实名认证 311:绑定银行卡 312:解绑银行卡
     * @return
     */
    public static SmsCodeRequest getRegisterSmsCodeBody(String mobile, String imei) {
        SmsCodeRequest request = new SmsCodeRequest();
        request.setMobile(mobile);
        request.setImei(imei);
        return request;
    }

    /**
     * 获取登录or注册
     *
     * @param mobile 手机号
     * @param code   短信验证码
     * @return
     */
    public static RegisterRequest getRegister(String mobile, String code) {
        RegisterRequest request = new RegisterRequest();
        request.setUserMobile(mobile);
        request.setVerificationCode(code);
        request.setImei(ImelUtils.getIMEI(App.getInstance()));
        if (TextUtils.isEmpty(Build.VERSION.RELEASE)) {
            request.setDeviceOs("API_" + Build.VERSION.SDK_INT);
        } else {
            request.setDeviceOs(Build.VERSION.RELEASE);
        }
        request.setDeviceModel(Build.BRAND + "->" + Build.MODEL);
        request.setImVersion(AppUtils.getAppVersionName());
        return request;
    }


//    /**
//     * 获取登录
//     *
//     * @param mobile   手机号
//     * @param password 短信验证码
//     * @return
//     */
//    public static LoginRequest getLogin(String mobile, String kfId, String password) {
//        password = MD5Utils.md5(password);
//        LoginRequest loginRequest = new LoginRequest(mobile, kfId, password, KFIMConfigManager.getIMEI());
//        return loginRequest;
//    }
//
//    /**
//     * token登录
//     */
//    public static LoginRequest getLogin(String token) {
//        return new LoginRequest(token);
//    }


//    /**
//     * 获取 用户资料
//     *
//     * @param userId 用户id
//     * @param isBoy  是否是男生
//     * @return
//     */
//    public static SetBaseInfoRequest getUserInfo(int userId, String headPath, String headPathHD, boolean isBoy, String nickName, String birthday, int address) {
//        SetBaseInfoRequest request = new SetBaseInfoRequest(userId, headPath, headPathHD, isBoy ? 1 : 0, nickName, birthday, address);
//        LOG.i(TAG, "" + request);
//        return request;
//    }

////    /**
////     * 获取 动态发布
////     *
////     * @param userId   用户id
////     * @param sourceId
////     * @return
////     */
////    public static DynamicPublishRequest getDynamicPublish(String userId, int createType, String sourceId, int dynamicType, String content, String address, boolean hasPhoto, List<Integer> tags) {
////        DynamicPublishRequest request = new DynamicPublishRequest();
////        request.setUserId(userId);
////        request.setSourceDynamicId(sourceId);
////        request.setDynamicType(dynamicType);
////        request.setAreaAddress(address);
////        request.setType(createType);
////        request.setContent(content);
////        request.setHavePhoto(hasPhoto ? 1 : 0);
////        request.setLabelList(tags);
////        LOG.i(TAG, "" + request);
////        return request;
////    }
//
//    /**
//     * 删除动态
//     *
//     * @return
//     */
//    public static DeleteDynamicRequest deleteDynamic(String userId, String dynamicId) {
//        DeleteDynamicRequest request = new DeleteDynamicRequest(userId, dynamicId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * * 获取 用户动态
//     *
//     * @param userId     用户id
//     * @param partnerId
//     * @param startIndex 开始位置（1-20）下表从0开始
//     * @param endIndex
//     * @return
//     */
////    public static UserDynamicRequest getUserDynamic(String userId, String partnerId, int startIndex, int endIndex) {
////        UserDynamicRequest request = new UserDynamicRequest(userId, partnerId, startIndex, endIndex);
////
////        LOG.i(TAG, "" + request);
////        return request;
////    }
//
//
//    /**
//     * 获取 所有 动态(自己，好友，已关注的人)
//     */
//    public static AllDynamicRequest getAllDynamic(String sdate, int rows) {
//        AllDynamicRequest request = new AllDynamicRequest(sdate, rows);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 根据话题ID获取最新动态列表
//     */
//    public static Map<String, Object> getTopicDynamic(int topicId, String sdate, int rows) {
//        Map<String, Object> request = new HashMap<>();
//        request.put("topicId", topicId);
//        request.put("sdate", sdate);
//        request.put("rows", rows);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 根据话题ID获取最新动态列表
//     */
//    public static Map<String, Object> getTopicHotDynamic(int topicId, int tagId, int rows, String rankNo, int pullDirect) {
//        Map<String, Object> request = new HashMap<>();
//        request.put("userId", KFIMClient.getInstance().getUserId());
//        request.put("topicId", topicId);
//        request.put("tagId", tagId);
//        request.put("rows", rows);
//        request.put("rankNo", rankNo);
//        request.put("pullDirect", pullDirect);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//
//    /**
//     * 根据话题ID获取最新动态列表
//     */
//    public static Map<String, Object> getUserDynamic(String userId, String sdate, int rows, int type) {
//        Map<String, Object> request = new HashMap<>();
//        request.put("userId", userId);
//        request.put("sdate", sdate);
//        request.put("rows", rows);
//        request.put("type", type);
//        request.put("curUserId", KFIMClient.getInstance().getUserId());
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//
//    /**
//     * 获取 单个动态的所有回复
//     *
//     * @return
//     */
//    public static DynamicAllReplyRequest getDynamicAllReply(String dynamicId, String sdate) {
//        if (!TextUtils.isEmpty(sdate)) {
//            sdate = sdate.replace("/", "-");
//        }
//        DynamicAllReplyRequest request = new DynamicAllReplyRequest(dynamicId, sdate, DynamicHelper.PAGE_SIZE);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 添加用户评论
//     */
//    public static AddDynamicReplyRequest addDynamicReply(String dynamicId, String replyContent, String atUserId, String atUserName, String replyUserId, String replyUserName, String replyUserPhoto, String replyId) {
//        AddDynamicReplyRequest request = new AddDynamicReplyRequest(dynamicId, replyContent, atUserId, atUserName, replyUserId, replyUserName, replyUserPhoto, replyId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 删除用户评论
//     */
//    public static DeleteReplyRequest deleteDynamicReply(String userId, String dynamicReplyId) {
//        DeleteReplyRequest request = new DeleteReplyRequest(userId, dynamicReplyId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
////    /**
////     * 点赞
////     */
////    public static AddDynamicReplyRequest addDynamicLike(String userId, String dynamicId, String dynamicCreateId) {
////        AddDynamicReplyRequest request = new AddDynamicReplyRequest(userId, dynamicId, dynamicCreateId, "", "", false);
////        LOG.i(TAG, "" + request);
////        return request;
////    }
//
//    /**
//     * 点赞 \取消点赞
//     */
//    public static PraiseRequest getPraiseReq(String userId, String dynamicId, boolean isInterest) {
//        PraiseRequest request = new PraiseRequest(dynamicId, userId, isInterest);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 17.校验动态ID或回复ID是否存在
//     */
//    public static CheckDynamicOrReplyRequest checkDynamicOrReply(List<CheckDynamicOrReplyRequest.DynamicOrReply> data) {
//        CheckDynamicOrReplyRequest request = new CheckDynamicOrReplyRequest(data);
//        LOG.i(TAG, data.size() + "," + request);
//        return request;
//    }
//
//    /**
//     * 18.根据动态id查询单条动态
//     */
//    public static Map<String, String> getDynamicInfo(String dynamicId) {
//        Map<String, String> map = new HashMap<>();
//        map.put("dynamicId", dynamicId);
//        return map;
//    }
//
//    /**
//     * 回复推荐或删除
//     */
//    public static Map<String, Object> getDynamicReply(String replyId, int isRecommand, boolean delFlage) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("replyId", replyId);
//        map.put("isRecommand", isRecommand);
//        map.put("delFlage", delFlage);
//        LOG.i("getDynamicReply: ------" + map);
//        return map;
//    }
//
//
//    /**
//     * 28.设置用户动态封面图
//     */
//    public static DynamicBackgroundRequest setMyDynamicBackground(String loginId, String background) {
//        DynamicBackgroundRequest request = new DynamicBackgroundRequest(loginId, background);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    ///////////////////////////////////////////////////////////////////////////
//    // 密码相关
//    ///////////////////////////////////////////////////////////////////////////
//
//
//    /**
//     * 是否设置登录密码
//     */
//    public static CheckPwdIsExistRequest hasLoginPassword(String mobile) {
//        CheckPwdIsExistRequest request = new CheckPwdIsExistRequest(mobile);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//
//    ///////////////////////////////////////////////////////////////////////////
//    // 空间相关
//    ///////////////////////////////////////////////////////////////////////////
//
//    /**
//     * 获取用户空间信息
//     */
//    public static GetSpaceBaseInfoRequest getUserSpaceInfo(String loginId, String userId) {
//        GetSpaceBaseInfoRequest request = new GetSpaceBaseInfoRequest(loginId, userId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 获取用户空间信息
//     */
//    public static ExitEnterSpaceRequest exitEnterSpace(String userId, String spaceId, @IMFinal.ExitEnterSpaceType int actionType) {
//        ExitEnterSpaceRequest request = new ExitEnterSpaceRequest(userId, spaceId, actionType);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /* *//**
//     * 保存装饰物件信息
//     *//*
//    public static UpdateDecorateLabelRequest updateDecorateRequest(String loginId, List<DecorateInfo> decorateInfo) {
//        UpdateDecorateLabelRequest request = new UpdateDecorateLabelRequest(loginId, decorateInfo);
//        LOG.i(TAG, "" + request);
//        return request;
//    }*/
//
//    /**
//     * 分页获取物件信息
//     */
//    public static GetDecorateInfoRequest getDecorateInfo(String loginId, int decorateType, int min, int max) {
//        GetDecorateInfoRequest request = new GetDecorateInfoRequest(decorateType, min, max);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 获取空间场景信息
//     */
//    public static GetSceneInfoRequest getSpaceSceneInfo(String userId, int spaceBackgroundId) {
//        GetSceneInfoRequest request = new GetSceneInfoRequest(userId, spaceBackgroundId);
//        LOG.i(TAG, request.toString());
//        return request;
//    }
//
//    /**
//     * 空间点赞
//     */
//    public static SpacePraiseRequest getSpacePraiseRequest(String loginId, String userId, int praiseType) {
//        SpacePraiseRequest request = new SpacePraiseRequest(loginId, userId, praiseType);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 关注
//     *
//     * @param loginId
//     * @param userId
//     * @return
//     */
//    public static AddAttentionRequest getAddAttentionRequest(String loginId, String userId) {
//        AddAttentionRequest request = new AddAttentionRequest(loginId, userId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 取消关注
//     */
//    public static AddAttentionRequest getDeleteAttentionRequest(String loginId, String userId, int strangerLinkId) {
//        DeleteAttentionRequest request = new DeleteAttentionRequest(loginId, userId, strangerLinkId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    public static PullOfflineMessageRequest getPullOfflineMessageRequest(String spaceId, String lastDatetime, int maxReadRow, @IMFinal.TimeType int timeType) {
//        PullOfflineMessageRequest request = new PullOfflineMessageRequest(spaceId, lastDatetime, maxReadRow, timeType);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 更新空间标签及物件
//     */
//    public static UpdateDecorateLabelRequest getUpdateDecorateLabelRequest(String userId, List<DecorateInfo> decorateList, List<SpaceLabInfo> labList) {
//        UpdateDecorateLabelRequest request = new UpdateDecorateLabelRequest(userId, decorateList, labList);
//        return request;
//    }
//
//
//    /**
//     * 获取多方图
//     * https://blog.csdn.net/jason_hd/article/details/80635387
//     *
//     * @param decorateId
//     * @return
//     */
//    public static RequestBody getDecorateAngImgJson(int decorateId) {
//        RequestBody requestBody = null;
//        try {
//            JSONObject requestData = new JSONObject();
//            requestData.put("decorateId", decorateId);
//            requestBody = RequestBody.create(MediaType.parse("application/json"), requestData.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return requestBody;
//    }
//
//
//    /**
//     * 标签参数
//     * https://blog.csdn.net/jason_hd/article/details/80635387
//     *
//     * @param decorateId
//     * @return
//     */
//    public static JSONObject getSpaceLabJson(int decorateId) {
//        JSONObject requestData = new JSONObject();
//        try {
//            requestData.put("decorateId", decorateId);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return requestData;
//    }
//
//    /***
//     * 新增物件
//     * @return
//     */
//    public static InsertDecorateRequest getDecorateInfoReq(DecorateInfo info, DecorateAngImgInfo mDecorateAngImgInfo,
//                                                           List<DecorateInfo> allDecorateInfos, int type, DecorateInfo mDecorateInfo) {
//        InsertDecorateRequest request = new InsertDecorateRequest();
//        request.userId = KFIMClient.getInstance().getUserId();
//        request.setDecorateId(info.getDecorateId());
//        Point screenSize = SystemUtils.getRealScreenSize(KFIMClient.getInstance().getContext());
//        request.setScreenwidth(screenSize.x);
//        request.setScreenheight(screenSize.y);
//        request.setDecorateTypeId(info.getDecorateTypeId());
//
//
//        info.setScreenwidth(screenSize.x);
//        info.setScreenheight(screenSize.y);
//        //物件
//        if (type != 0) {
//            if (mDecorateAngImgInfo != null) {
//                request.curAngImgId = mDecorateAngImgInfo.getAngImgId();
//            }
//
//            if (mDecorateInfo != null) {
//                request.oldDecorateUserId = mDecorateInfo.getDecorateUserId();
//                info.setLeft(mDecorateInfo.getLeft());
//                info.setTop(mDecorateInfo.getTop());
//                info.setWidth(mDecorateInfo.getWidth());
//                info.setHeight(mDecorateInfo.getHeight());
//            } else {
//                int top = 0, left = 0;
//
//                //100 300  500
//                //100 300 500
//                //[1, 100]
//                Random random = new Random();
//                top = random.nextInt(100) + random.nextInt(100) + random.nextInt(100) + 50; // [53, 350]
//                left = random.nextInt(100) + random.nextInt(100) + random.nextInt(100) + random.nextInt(100) + 100; //[104, 400]
//                request.setTop(top);
//                request.setLeft(left);
//
//                info.setLeft(left);
//                info.setTop(top);
//
//                LOG.i("left : " + left + ", top : " + top);
//            }
//
//            if (info.getWidth() == 0 || info.getHeight() == 0) {
//                request.setWidth(240);
//                request.setHeight(240);
//            } else {
//                request.setWidth(info.getWidth()); // 65
//                request.setHeight(info.getHeight());
//            }
//            request.setTop(info.getTop());
//            request.setLeft(info.getLeft());
//        }
//        //背景
//        else {
//
//        }
//
//        return request;
//    }
//
//
//    ///////////////////////////////////////////////////////////////////////////
//    //
//    ///////////////////////////////////////////////////////////////////////////
//
//    /**
//     * 意见反馈
//     *
//     * @param s
//     * @return
//     */
//    public static AddFeedBackRequest getAddFeedBackRequest(String s) {
//        return new AddFeedBackRequest(KFIMClient.getInstance().getUserId(), s, 1);
//    }
//
//    /**
//     * 获取敏感词
//     *
//     * @return
//     */
//    public static RequestBody getSensitiveWordsReq() {
//        //        String time = SPUtils.getInstance().getString("SensitiveWordsVersionTime",null);
//        RequestBody requestBody = null;
//        try {
//            JSONObject requestData = new JSONObject();
//            requestData.put("time", SensitivewordFilter.getUpdateTime());
//            requestBody = RequestBody.create(MediaType.parse("application/json"), requestData.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return requestBody;
//    }
//
//    /**
//     * 更换手机号
//     *
//     * @param code 验证码
//     */
//    public static ChangePhoneRequest getChangetPhone(String userId, String phone, String code) {
//        ChangePhoneRequest request = new ChangePhoneRequest(userId, phone, code);
//        LOG.i(TAG, request.toString());
//        return request;
//    }
//
//
//    /**
//     * 获取启动页详情
//     */
//    public static GetSplashInfoRequest getSplashInfo(int width, int height) {
//        GetSplashInfoRequest request = new GetSplashInfoRequest(width, height);
//        LOG.i(TAG, request.toString());
//        return request;
//    }
//
//
//    /**
//     * 退出登录
//     */
//    public static HttpLogoutRequest logout(String userId, int unReadNum) {
//        HttpLogoutRequest request = new HttpLogoutRequest(userId, unReadNum);
//        LOG.i(TAG, request.toString());
//        return request;
//    }
//
//    //<editor-fold desc="动态">
//
//
//    /**
//     * 转推动态
//     */
//    public static ForwardDynamicReq forwardDynamicReq(String mDynamicId) {
//        ForwardDynamicReq request = new ForwardDynamicReq(mDynamicId);
//        LOG.i(TAG, request.toString());
//        return request;
//    }
//
//    /**
//     * 获取钱包数据
//     */
//    public static GetWalletRequest getWalletRequest(String userId) {
//        GetWalletRequest request = new GetWalletRequest(userId);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 31.查询个人零钱收支明细
//     */
//    public static PocketMoneyListRequest getPocketMoneyList(String userId, int start, int end) {
//        int temp = Integer.valueOf(userId);
//        PocketMoneyListRequest request = new PocketMoneyListRequest(temp, start, end);
//        LOG.i(TAG, "" + request);
//        return request;
//    }
//
//    /**
//     * 查询个人零钱支付详情
//     */
//    public static PocketMoneyInfoRequest getPocketMoneyInfo(String changeSn) {
//        PocketMoneyInfoRequest request = new PocketMoneyInfoRequest(changeSn);
//        LOG.i(TAG, "" + request);
//        return request;
//    }


    //</editor-fold>
}
