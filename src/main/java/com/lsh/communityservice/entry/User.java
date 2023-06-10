package com.lsh.communityservice.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* user
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long userid;
        
    @TableField("username")
    private String username;
        
    @TableField("password")
    private String password;
        
    @TableField("usertype")
    private Long usertype;
        
}