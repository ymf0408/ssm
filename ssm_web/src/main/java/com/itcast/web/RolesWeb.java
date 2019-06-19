package com.itcast.web;

import com.itcast.domain.Role;
import com.itcast.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RolesWeb {

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) throws Exception{
        List<Role> roleList = rolesService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception{
        rolesService.save(role);
        return "redirect:findAll";
    }

}
