package com.futureTech.controller;

import com.futureTech.entity.Role;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.service.MailSenderService;
import com.futureTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class IndexController {


    @Autowired
    UserService userService;

    @Autowired
    BrandService brandService;
    @Autowired
    CommodityService commodityService;
    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping({"/","index","home"})
    public String index(Model model){



        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        model.addAttribute("brands", brandService.findAll());

        return "views-base-index";
    }

    @PostMapping({"/","index","home"})
    public String indexAfterLogin(Principal principal,Model model){


//        try {
//           if (principal.getName().equals("admin")) {
//                return "adminPage";
//           }
//       }catch (Exception e)
//        {
//            return "adminPage";
//        }

        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-base-index";
    }

    @GetMapping({"/contacts"} )
    public String contacts(Model model){


        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-contacts";
    }


    @GetMapping("/adminPage")
    public String adminPage()
    {
        return "adminPage";
    }

    @PostMapping("/sendMessage")
    public  String sendMessage(@RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("subject") String theme,
                               @RequestParam("message") String mail, Model model )
    {


        mailSenderService.sendMessageToAdministration(theme,mail,email, name);

        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-sendMessage";
    }



}
