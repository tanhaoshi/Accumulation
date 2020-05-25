package com.example.accumulation.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

import com.example.accumulation.App;


/**
 * create by tanhs on 2020/5/25 8:49
 */
public final class ClipboardUtils {

    public  static ClipboardUtils mClipboardUtils;
    private ClipboardManager mClipboardManager;

    public static ClipboardUtils getInstance(){
        if(mClipboardUtils == null){
            mClipboardUtils = new ClipboardUtils();
        }
        return mClipboardUtils;
    }

    private ClipboardUtils(){
        if(null == mClipboardManager) mClipboardManager =
                (ClipboardManager) App.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
    }

    /**
     *  获取到剪贴板内容
     */
    public String getClipboardContent() {
        try {
            mClipboardManager = (ClipboardManager) App.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
            if (mClipboardManager == null)
                return "";
            ClipData abc = mClipboardManager.getPrimaryClip();
            if (abc == null)
                return "";
            ClipData.Item item = abc.getItemAt(0);
            if (item == null)
                return "";
            if (TextUtils.isEmpty(item.getText()))
                return "";
            String strClipboardContent = item.getText().toString();
            if (TextUtils.isEmpty(strClipboardContent))
                return "";
            return strClipboardContent;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 复制内容
     * @param mContext
     * @param copyContent
     */
    public void toCopy(Context mContext, String copyContent) {
        try {
            // 得到剪贴板管理器
            if (!TextUtils.isEmpty(copyContent)) {
                //ClipboardManager cmb = (ClipboardManager)mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                // cmb.setText(copy_str);
                //获取剪贴板管理器：
                mClipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", copyContent);
                // 将ClipData内容放到系统剪贴板里。
                if (mClipboardManager != null)
                    mClipboardManager.setPrimaryClip(mClipData);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 清空
     * @param context
     */
    public void clearClipboard(Context context) {
        try {
            mClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (mClipboardManager != null) {
                ClipData myClip = ClipData.newPlainText("text", " ");
                mClipboardManager.setPrimaryClip(myClip);
            }
        } catch (Exception e) {

        }
    }
    private void release(){
        mClipboardManager = null;
        mClipboardUtils = null;
    }
}
