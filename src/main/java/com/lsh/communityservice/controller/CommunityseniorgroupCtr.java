package com.lsh.communityservice.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsh.communityservice.entry.Communityseniorgroup;
import com.lsh.communityservice.service.CommunityseniorgroupService;
import com.lsh.communityservice.vo.BaseController;
import com.lsh.communityservice.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/11 0:24
 * @Version 1.0
 */
@RestController
@RequestMapping("senior")
public class CommunityseniorgroupCtr extends BaseController {

    @Autowired
    private CommunityseniorgroupService communityseniorgroupService;

    @RequestMapping("list")
    public Result list(Long olderlD,String emergency,String ageStr) {
        LambdaQueryWrapper<Communityseniorgroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != olderlD,Communityseniorgroup::getOlderlD,olderlD)
                .like(StrUtil.isNotBlank(emergency),Communityseniorgroup::getEmergency,emergency);
        if (StrUtil.isNotBlank(ageStr)) {
            String[] split = ageStr.split("-");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if (b < a) {
                int c = a;
                a = b;
                b = c;
            }
            wrapper.gt(Communityseniorgroup::getAge,a).lt(Communityseniorgroup::getAge,b);
        }
        List<Communityseniorgroup> list = communityseniorgroupService.list(wrapper);
        return Result.success(list);
    }

    @RequestMapping("addOrUpdate")
    public Result addOrUpdate(Communityseniorgroup communityseniorgroup) {
        Long olderlD = communityseniorgroup.getOlderlD();
        communityseniorgroupService.saveOrUpdate(communityseniorgroup);
        return Result.success("操作成功！");
    }

    @RequestMapping("delete")
    public Result delete(Long olderlD) {
        communityseniorgroupService.removeById(olderlD);
        return Result.success("删除成功！");
    }

}
