package com.lsh.communityservice.entry;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 社区老年团表(communityseniorgroup)
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("communityseniorgroup")
public class Communityseniorgroup {

    @TableId(type = IdType.AUTO)
    private Long olderlD;
        
    @TableField("createtime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
        
    @TableField("title")
    private String title;
        
    @TableField("contact")
    private String contact;
        
}