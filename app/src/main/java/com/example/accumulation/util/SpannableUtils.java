package com.example.accumulation.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * create by tanhs on 2020/5/23 15:11
 */
public final class SpannableUtils {

    public  static SpannableUtils spannableUtils;
    private SpannableStringBuilder spannableStringBuilder;

    public static SpannableUtils getInstance(){
        if(spannableUtils == null){
            spannableUtils = new SpannableUtils();
        }
        return spannableUtils;
    }

    /**
     * 创建 spannable 实例 （不需考虑重复创建问题，如果不重复创建的话会被覆盖）
     */
    public SpannableUtils spannableFactory(String charSequence){
        spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        return spannableUtils;
    }

    /**
     * 设置 字体色彩
     */

    public SpannableUtils setSpannableFont(int color, int start, int end, int flags){
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        spannableStringBuilder.setSpan(foregroundColorSpan,start,end,flags);
        return spannableUtils;
    }

    /**
     * 追加 下标 颜色
     */

    public SpannableStringBuilder builder(){
        return spannableStringBuilder;
    }
}
