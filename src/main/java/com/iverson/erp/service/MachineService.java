package com.iverson.erp.service;

import com.iverson.erp.form.MachineForm;
import com.iverson.erp.pojo.Machine;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
public interface MachineService {
    int create(MachineForm machineForm);

    List<Machine> getByShopNo(String shopNo);

    int delete(String machineNo, String shopNo);

    int update(MachineForm machineForm);
}
