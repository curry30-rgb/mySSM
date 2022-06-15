package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.User;
import com.itheima.dao.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(Date date) throws IOException {
        System.out.println(date);
        // Cannot convert value of type 'java.lang.String' to required type 'java.util.Date':
        //      no matching editors or conversion strategy found
    }
    

    @RequestMapping(value = "/quick15/{username}")
    @ResponseBody
    public void save15(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] str) throws IOException {
        System.out.println(Arrays.asList(str));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) throws IOException {
        System.out.println(user);
    }


    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("wangwu");
        user.setAge(19);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(19);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody //直接回写加  不加的话是找拼接试图
    public String save7() throws IOException {
        return "hello itheima...";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast...");
    }


    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","勒布朗");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","斯蒂芬");
        return "success";
    }


    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","itcast");
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping("/quick")
    public String save(){
        System.out.println("controller running....");
        return "success";
    }
}
