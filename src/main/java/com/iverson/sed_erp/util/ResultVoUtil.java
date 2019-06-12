package com.iverson.sed_erp.util;

import com.iverson.sed_erp.vo.ResultVo;

public class ResultVoUtil {

    /**
     * 有数据返回(success)
     * @param o
     * @return
     */
    public static ResultVo success(Object o){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(o);
        return resultVo;
    }

    /**
     * 无数据返回(success)
     * @return
     */
    public static ResultVo success(){
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static ResultVo error(Integer code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
