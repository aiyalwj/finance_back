package com.finance.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum RespBeanEnum {
    /**
     * 成功
     */
    SUCCESS(200,"成功","success"),

    /**
     * 失败
     */
    ERROR(500,"错误","error"),

    /**
     * id 密码 输入为空
     */
    NOT_DATA(401,"没有数据","warning"),

    /**
     * id为空
     */
    USER_NOT_FOUND(402,"未找到该用户！","warning"),

    /**
     * name为空
     */
    LOGIN_ERROR(403,"密码输入错误！","warning"),

    /**
     * id没有找到
     */
    USER_ID_NOT_FOUND(4004,"该用户ID不存在！","error"),

    /**
     * name没有找到
     */
    USER_NAME_NOT_FOUND(4005,"该用户NAME不存在！","error");





    private final Integer code;
    private final String message;
    private final String type;

}
