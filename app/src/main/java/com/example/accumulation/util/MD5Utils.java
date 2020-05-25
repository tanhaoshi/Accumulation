package com.example.accumulation.util;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.reset();
            secretBytes = md.digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        int length = md5code.length();
        for (int i = 0; i < 32 - length; i++) {
            md5code.insert(0, "0");
        }
        return md5code.toString();
    }

    public static String getBytesMd5(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(bytes, 0, bytes.length);

            byte[] jimbyte = md.digest();
            for (byte b : jimbyte) {
                int bdata = b & 0xff;
                String hex = Integer.toHexString(bdata);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                sb.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String getBitmapMd5(Bitmap bitmap) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bao);
        return getBytesMd5(bao.toByteArray());
    }

    public static String getFileMd5(File file) {
        String filepath = file.getPath();
        return getFileMd5(filepath);
    }

    // 获取文件的md5
    public static String getFileMd5(String file) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("md5");

            FileInputStream fis = new FileInputStream(file);
            byte buffer[] = new byte[1024 * 4];
            int len = fis.read(buffer);
            while (len != -1) {
                md.update(buffer, 0, len);
                len = fis.read(buffer);
            }
            fis.close();

            byte[] jimbyte = md.digest();
            for (byte b : jimbyte) {
                int bdata = b & 0xff;
                String hex = Integer.toHexString(bdata);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                sb.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 校验IM文件的md5码,IM文件的文件名就是md5名
     *
     * @param file
     * @return
     */
    public static boolean voildMd5(File file) {
        String md5 = MD5Utils.getFileMd5(file);
        // 获取文件的md5名称
        String fileName = null;
        String name = file.getName();
        if (name.contains(".") && name.lastIndexOf(".") != -1) {
            fileName = name.substring(0, name.lastIndexOf("."));
        } else {
            fileName = name;
        }
        boolean isSame = fileName.equals(md5);
        if (!isSame) {
            file.delete();
        }
        return isSame;
    }


    public static String md5Signature(String timestamp, String sign,
                                      String serverTag) {
        StringBuffer buf = new StringBuffer();
        buf.append(timestamp).append(sign).append(serverTag);

        return MD5Utils.md5(buf.toString());
    }

}
