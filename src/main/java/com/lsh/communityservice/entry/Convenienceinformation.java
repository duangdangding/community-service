package com.lsh.communityservice.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 便民信息表(convenienceinformation)
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("convenienceinformation")
public class Convenienceinformation {

    @TableId(type = IdType.AUTO)
    private Long convenientID;
        
    @TableField("notice")
    private String notice;
        
    @TableField("activity")
    private String activity;
        
    @TableField("news")
    private String news;

//    审核
    private String subject;
    private String major;
    private String title;

}