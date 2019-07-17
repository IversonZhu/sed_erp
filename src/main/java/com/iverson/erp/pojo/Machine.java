package com.iverson.erp.pojo;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/17
 */
@Data
public class Machine {
    /** id */
    private int id;
    /** 机器编号 */
    private String machineNo;
    /** 商店编号 */
    private String shopNo;
    /** 机器名称 */
    private String machineName;
    /** 机器token */
    private String machineToken;
}
