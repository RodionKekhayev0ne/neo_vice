package com.example.demo.controllers;






import com.example.demo.models.Page;
import com.example.demo.models.Roles;
import com.example.demo.models.User;
import com.example.demo.repos.PageRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.PageService;
import com.example.demo.services.PageView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class DefaultController {


    private PageRepo pageRepo;
    private UserRepo userRepo;

    private User admin;

    @Autowired
    public DefaultController(PageRepo pageRepo, UserRepo userRepo) {
        this.pageRepo = pageRepo;
        this.userRepo = userRepo;
    }


    @RequestMapping("/")
    private String main(Model model){

        String message = "Thymeleaf is working now n db";



        List<PageView> pageViews = new ArrayList<>();
        for (Page page : pageRepo.findAll()){
            pageViews.add(new PageView(page.getHeader(),   page.getPath() + "?id=" + page.getId()));
        }

        for (User user : userRepo.findAll()){
            System.out.println(user.getRole());
        }


//        Page page = new Page();
//        page.setPath("/page");
//        page.setContent("С другой стороны консультация с широким активом способствует подготовки и реализации новых предложений. Товарищи! укрепление и развитие структуры обеспечивает широкому кругу (специалистов) участие в формировании позиций, занимаемых участниками в отношении поставленных задач. Значимость этих проблем настолько очевидна, что консультация с широким активом влечет за собой процесс внедрения и модернизации систем массового участия. Равным образом укрепление и развитие структуры позволяет оценить значение соответствующий условий активизации. С другой стороны дальнейшее развитие различных форм деятельности позволяет оценить значение соответствующий условий активизации. Разнообразный и богатый опыт дальнейшее развитие различных форм деятельности играет важную роль в формировании новых предложений.");
//        page.setHeader("Vacancy");
//        page.setEmail("romankim2005@gmail.com");
//        page.setNumber("+77083911983");
//
//        pageRepo.save(page);
        model.addAttribute("message", message );

        model.addAttribute("values", pageViews);


        return "index";
    }

    @GetMapping(value = "/page")
    private String check(@RequestParam("id") Integer id, Model model){

        Page page = pageRepo.findById(id).get();

        model.addAttribute("title", page.getHeader());
        model.addAttribute("content", page.getContent());
        model.addAttribute("number", page.getNumber());
        model.addAttribute("mail", page.getEmail());



        log.info("Other page controller activated");
        return "vacancy";
    }

    @GetMapping(value = "/registration/form")
    private String registration(){
        log.info("registration form is working");

        return "registration";
    }

    @PostMapping(value = "/createUser")
    private String createUser(@ModelAttribute User user){

        User newUser = new User();

        System.out.println(user.getPassword());


        newUser.setName(user.getName());

        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        userRepo.save(newUser);

        if (user.isRoleAdmin()){
            newUser.setRole(Roles.ADMIN);
        }else {
            newUser.setRole(Roles.USER);
        }
        userRepo.save(newUser);
        if (user.isRoleAdmin()) {

            return "redirect:/admin/panel?id=" + userRepo.findByName(user.getName()).get(0).getId();
        }else {
            return "redirect:/";
        }
    }

    @GetMapping(value = "/entry")
    private String entry(@ModelAttribute User user){

        for (User user1 : userRepo.findByName(user.getName())){
            if (user1.getPassword().equals(user.getPassword())){
                log.info("success");
                User checkUser = userRepo.findByName(user.getName()).get(0);
                if (checkUser.getRole() == Roles.ADMIN) {
                    return "redirect:/admin/panel?id=" + checkUser.getId();
                }else {
                    return "redirect:/";
                }
            }
        }

        return "redirect:/registration/form";
    }

    @GetMapping("/admin/panel")
    public String admin(@RequestParam("id") Integer id,Model model){

        model.addAttribute("values", pageRepo.findByAdminId(id).stream().toList());
        model.addAttribute("adminId", "/create?id=" + id );
        return "adminpanel";
    }

    @PostMapping(value = "/create")
    public String admin(@RequestParam("id") Integer id,@ModelAttribute Page page){

        Page createdPage = new Page();
        createdPage.setPreview(page.getPreview());
        createdPage.setHeader(page.getHeader());
        createdPage.setContent(page.getContent());
        createdPage.setNumber(page.getNumber());
        createdPage.setCompanyName(page.getCompanyName());
        createdPage.setEmail(page.getEmail());
        createdPage.setCreator(id);
        createdPage.setPublishingDate(new Date());
        createdPage.setPath("/page");

        pageRepo.save(createdPage);

        return "redirect:/admin/panel?id=" + id;
    }



}
