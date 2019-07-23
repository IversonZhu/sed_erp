package com.iverson.erp.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Iverson
 * @class ModuleVO
 * @date 2019/7/22
 */
@Data
public class ModuleVO {
    private String no;
    private String parentNo;
    private String title;
    private String icon;
    private String path;
    private Integer page;
    private List<ModuleVO> moduleVOS;
}
