package com.iverson.erp.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@Data
public class LogInfo {
    /** id */
    private int id;
    /** 客户端IP */
    private String clientIp;
    /** 链接 */
    private String uri;
    /** 请求类型 */
    private String type;
    /** 请求方法名 */
    private String method;
    /** 请求参数*/
    private String param;
    /** 请求密钥 */
    private String token;
    /** 返回结果数据 */
    private String returnData;
    /** 网络状态码 */
    private String httpStatusCode;
    /** 发起请求时间 */
    private Timestamp time;
    /** 结果返回时间 */
    private String returnTime;
    /** 消耗时间 */
    private Integer timeConsuming;
}
