package com.yixiaolabs.admin.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

/**
 * 功能描述: 对数据进行加密操作
 * <p>
 * 作者: WangLei
 * 日期: 2018/1/9 9:48
 */
public class EncryptUtil {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public static String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
