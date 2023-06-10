package com.lsh.communityservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsh.communityservice.entry.Eventprocessing;
import com.lsh.communityservice.service.EventprocessingService;
import com.lsh.communityservice.vo.BaseController;
import com.lsh.communityservice.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/10 21:47
 * @Version 1.0
 */
@RestController
@RequestMapping("event")
public class EventprocessingCtr extends BaseController {

    @Autowired
    private EventprocessingService eventprocessingService;

    @RequestMapping("list")
    public Result<Object> list(Long eventID) {
        LambdaQueryWrapper<Eventprocessing> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != eventID,Eventprocessing::getEventID,eventID);
        List<Eventprocessing> list = eventprocessingService.list(wrapper);
        return Result.success(list);
    }

    @RequestMapping("addOrUpdate")
    public Result addOrUpdate(Eventprocessing eventprocessing) {
        if (null == eventprocessing.getEventID()) {
            eventprocessing.setCreatetime(new Date());
        }
        eventprocessingService.saveOrUpdate(eventprocessing);
        return Result.success("操作成功！");
    }

    @RequestMapping("delete")
    public Result delete(Long eventID) {
        eventprocessingService.removeById(eventID);
        return Result.success("删除成功！");
    }

}
