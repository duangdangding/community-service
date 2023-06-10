package com.lsh.communityservice.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 服务场所表(serviceplace)
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("serviceplace")
public class Serviceplace {

    @TableId(type = IdType.AUTO)
    private Long serviceplaceID;
        
    @TableField("serviceplaceName")
    private String serviceplaceName;
        
    @TableField("erviceplacetype")
    private String erviceplacetype;
        
    @TableField("placeadder")
    private String placeadder;
        
    @TableField("number")
    private Long number;
        
    @TableField("bossname")
    private String bossname;
        
    @TableField("phone")
    private String phone;
        
}