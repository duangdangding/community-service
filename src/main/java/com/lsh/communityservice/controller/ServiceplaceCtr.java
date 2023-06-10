package com.lsh.communityservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsh.communityservice.entry.Serviceplace;
import com.lsh.communityservice.service.ServiceplaceService;
import com.lsh.communityservice.vo.BaseController;
import com.lsh.communityservice.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/10 22:03
 * @Version 1.0
 */
@RestController
@RequestMapping("place")
public class ServiceplaceCtr extends BaseController {

    @Autowired
    private ServiceplaceService serviceplaceService;

    @RequestMapping("list")
    public Result list(Long serviceplaceID) {
        LambdaQueryWrapper<Serviceplace> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != serviceplaceID,Serviceplace::getServiceplaceID,serviceplaceID);
        List<Serviceplace> list = serviceplaceService.list(wrapper);
        return Result.success(list);
    }

    @RequestMapping("addOrUpdate")
    public Result addOrUppdate(Serviceplace serviceplace) {
        Long serviceplaceID = serviceplace.getServiceplaceID();
        if (null == serviceplaceID) {
            LambdaQueryWrapper<Serviceplace> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Serviceplace::getServiceplaceName,serviceplace.getServiceplaceName());
            long count = serviceplaceService.count(wrapper);
            if (count > 0) {
                return Result.failure("信息重复");
            }
            serviceplaceService.save(serviceplace);
        } else {
            LambdaQueryWrapper<Serviceplace> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Serviceplace::getServiceplaceName,serviceplace.getServiceplaceName())
                    .notIn(Serviceplace::getServiceplaceID,serviceplaceID);
            long count = serviceplaceService.count(wrapper);
            if (count > 0) {
                return Result.failure("信息重复");
            }
            serviceplaceService.updateById(serviceplace);

        }
        return Result.success("操作成功");
    }

    @RequestMapping("delete")
    public Result delete(Long serviceplaceID) {
        serviceplaceService.removeById(serviceplaceID);
        return Result.success("删除成功！");
    }

}
