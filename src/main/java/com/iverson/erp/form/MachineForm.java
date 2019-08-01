package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
@Data
public class MachineForm {
    private String machineNo;
    /** 商店编号 */
    @NotBlank(message = "商店编号不能为空")
    private String shopNo;
    /** 机器序列号 */
    @NotBlank(message = "序列号不能为空")
    private String serialNumber;
    /** 机器名称 */
    @NotBlank(message = "机器名称不能为空")
    private String machineName;
}
