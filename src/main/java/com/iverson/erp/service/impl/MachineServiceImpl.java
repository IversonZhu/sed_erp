package com.iverson.erp.service.impl;

import com.iverson.erp.form.MachineForm;
import com.iverson.erp.mapper.MachineMapper;
import com.iverson.erp.pojo.Machine;
import com.iverson.erp.service.MachineService;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineMapper machineMapper;

    @Override
    public int create(MachineForm machineForm) {
        Machine machine = new Machine();
        machine.setMachineNo(NoGenerateUtil.getMachineNo());
        machine.setShopNo(machineForm.getShopNo());
        machine.setSerialNumber(machineForm.getSerialNumber());
        machine.setMachineName(machineForm.getMachineName());
        machine.setMachineToken(TokenUtil.getInstance().getToken());
        return machineMapper.add(machine);
    }

    @Override
    public List<Machine> getByShopNo(String shopNo) {
        return machineMapper.getByNo(shopNo);
    }

    @Override
    public int delete(String machineNo, String shopNo) {
        return machineMapper.delete(machineNo,shopNo);
    }

    @Override
    public int update(MachineForm machineForm) {
        Machine machine = new Machine();
        machine.setMachineNo(machineForm.getMachineNo());
        machine.setShopNo(machineForm.getShopNo());
        machine.setSerialNumber(machineForm.getSerialNumber());
        machine.setMachineName(machineForm.getMachineName());
        machine.setMachineToken(TokenUtil.getInstance().getToken());
        return machineMapper.update(machine);
    }


}
