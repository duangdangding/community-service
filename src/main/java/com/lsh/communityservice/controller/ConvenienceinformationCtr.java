package com.lsh.communityservice.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.communityservice.entry.Convenienceinformation;
import com.lsh.communityservice.service.ConvenienceinformationService;
import com.lsh.communityservice.vo.BaseController;
import com.lsh.communityservice.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/10 14:31
 * @Version 1.0
 */
@RestController
@RequestMapping("convenience")
public class ConvenienceinformationCtr extends BaseController {

    @Autowired
    private ConvenienceinformationService convenienceinformationService;

    @RequestMapping("list")
    public Result<Object> list(String title,Long convenientID) {
        LambdaQueryWrapper<Convenienceinformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(title),Convenienceinformation::getTitle,title)
                .eq(null != convenientID ,Convenienceinformation::getConvenientID,convenientID);
        List<Convenienceinformation> list = convenienceinformationService.list(queryWrapper);
        return Result.success(list);
    }
//    @RequestMapping("list")
//    public ModelAndView list(int page,int size) {
//        Page<Convenienceinformation> pageO = new Page<>(page,size);
//        Page<Convenienceinformation> pageInfo = convenienceinformationService.page(pageO, null);
//        Map<String,Page<Convenienceinformation>> result = new HashMap<>();
//        result.put("list",pageInfo);
//        return jumpPage("2",result);
//    }

    @RequestMapping("add")
    public Result<Object> add(Convenienceinformation convenienceinformation) {
        if (ObjectUtil.isEmpty(convenienceinformation.getConvenientID())) {
            LambdaQueryWrapper<Convenienceinformation> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Convenienceinformation::getTitle,convenienceinformation.getTitle());
            Convenienceinformation one = convenienceinformationService.getOne(queryWrapper);
            if (null != one) {
                return failure("信息重复！！！");
            }
            convenienceinformationService.save(convenienceinformation);
            return success("新增成功！");
        } else {
            return edit(convenienceinformation);
        }

    }

    @RequestMapping("edit")
    public Result<Object> edit(Convenienceinformation convenienceinformation) {
        LambdaQueryWrapper<Convenienceinformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Convenienceinformation::getTitle,convenienceinformation.getTitle())
                .notIn(Convenienceinformation::getConvenientID,convenienceinformation.getConvenientID());
        Convenienceinformation one = convenienceinformationService.getOne(queryWrapper);
        if (null != one) {
            return failure("信息重复！！！");
        }
        convenienceinformationService.updateById(convenienceinformation);
        return success("修改成功！");
    }
    @RequestMapping("delete")
    public Result<Object> delete(Long id) {
        convenienceinformationService.removeById(id);
        return success("删除成功！");
    }

}
