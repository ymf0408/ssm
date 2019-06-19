package com.itcast.web;

import com.itcast.domain.UserInfo;
import com.itcast.service.UserServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserWeb {

    @Autowired
    private UserServicce userServicce;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) throws Exception{
        List<UserInfo> userList = userServicce.findAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception{
        userServicce.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id,ModelAndView modelAndView) throws Exception{
        UserInfo userInfo = userServicce.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }
}
