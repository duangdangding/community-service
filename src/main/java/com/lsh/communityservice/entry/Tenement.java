package com.lsh.communityservice.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 住户(tenement)
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("tenement")
public class Tenement {

    @TableId(type = IdType.AUTO)
    private Long residentID;
        
    @TableField("residentName")
    private String residentName;
        
    @TableField("sex")
    private String sex;
        
    @TableField("age")
    private Long age;
        
    @TableField("addr")
    private String addr;
        
    @TableField("phone")
    private String phone;
        
    @TableField("number")
    private String number;
        
    @TableField("workunit")
    private String workunit;
        
}