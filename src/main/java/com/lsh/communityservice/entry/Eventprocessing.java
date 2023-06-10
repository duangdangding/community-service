package com.lsh.communityservice.entry;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 事件处理表(eventprocessing)
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("eventprocessing")
public class Eventprocessing {

    @TableId(type = IdType.AUTO)
    private Long eventID;
        
    @TableField("createtime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
        
    @TableField("contact")
    private String contact;
        
    @TableField("progress")
    private String progress;
        
}