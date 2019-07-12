package com.iverson.sed_erp.util;

import com.iverson.sed_erp.vo.ResultVO;

public class ResultVoUtil {

    /**
     * 有数据返回(success)
     * @param o
     * @return
     */
    public static ResultVO success(Object o){
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(o);
        return resultVo;
    }

    /**
     * 无数据返回(success)
     * @return
     */
    public static ResultVO success(){
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg){
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
