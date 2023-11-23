package com.example.demo.controllers;


import com.example.demo.models.Page;
import com.example.demo.models.User;
import com.example.demo.repos.PageRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.PageView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class AdminController {

//    private PageRepo pageRepo;
//
//    private static User user;
//
//    @Autowired
//    public AdminController(PageRepo pageRepo, UserRepo userRepo) {
//        this.pageRepo = pageRepo;
//    }
//
//    @RequestMapping("/admin/panel/")
//    public String admin(){
//        List<PageView> pageViews = new ArrayList<>();
//
//        for (Page page : pageRepo.findByAdminId(user)){
//            pageViews.add(new PageView(page.getHeader(),   page.getPath() + "?id=" + page.getId()));
//        }
//
//
//
//        return "adminpanel";
//    }
//
//    @RequestMapping("/admin/panel/create")
//    public String admin(@ModelAttribute Page page){
//
//        Page createdPage = page;
//        createdPage.setAdminId(user);
//        createdPage.setPublishingDate(new Date());
//
//        pageRepo.save(createdPage);
//
//        return "adminpanel";
//    }
//
//
//    public static void setAdmin(User admin){
//        user = admin;
//    }


}
