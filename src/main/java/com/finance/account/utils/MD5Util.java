package com.finance.account.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import java.util.Random;


public class MD5Util {
    /**
     * MD5Utils 加密 工具类
     * @param src
     * @return
     */
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }


    public MD5Util() {
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<5; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //随机盐值
        salt=sb.toString();
//        System.out.println("盐值"+salt);
    }
    //字符串样板
    private static final String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    //默认盐值
    private static String salt="1a2b3c4d";

    /***
     *  加密函数
     */
    private static String encryp(String str,String salt){
        String md5str1 = salt+md5(str);
        String md5str2 = salt+md5(md5str1);
        return md5str2;
    }



    /**
     * 明文密码与固定盐进行拼装后再进行MD5加密
     * @param inputPass 明文密码
     * @return
     */
    public String inputPassSaveToDBPass(String inputPass){
        String str =""+salt+inputPass;
        String result = encryp(str,salt);
        return result;
    }


    /**
     *输入的明文密码转换成数据库中的密码进行比较
     * @param inputPass 输入密码（明文密码）
     * @param DBPass 数据库密码（加密密码）
     * @return
     */
    public static boolean inputPassEQDBPass(String inputPass,String DBPass){
//        System.out.println("判断区域");
//        System.out.println("DBPass\n"+DBPass);
        String salt = DBPass.substring (0,5);
//        System.out.println("盐值"+salt);
        String inputpassstr =""+salt+inputPass;
        String inputEncryp = encryp(inputpassstr,salt);
//        System.out.println("判断加密后"+inputEncryp);
        if(inputEncryp.equals(DBPass)){
            return true;
        }else {
            return false;
        }
    }

    //编写主类进行测试
    public static void main(String args[]) {

        String s = "123456";
        System.out.println("原始：" + s);
        MD5Util md5 = new MD5Util();

//        System.out.println("加密后："+md5.inputPassToFormPass(s));
        String dbs = md5.inputPassSaveToDBPass(s);
        System.out.println("加密后："+dbs);

        System.out.println("是否相等"+md5.inputPassEQDBPass(s,dbs));


    }

}

