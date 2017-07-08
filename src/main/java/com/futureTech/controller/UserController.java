package com.futureTech.controller;

import com.futureTech.entity.MP3;
import com.futureTech.entity.MobileTelephone;
import com.futureTech.entity.Role;
import com.futureTech.entity.User;
import com.futureTech.service.*;
import com.futureTech.validator.UserLoginValidator.UserLoginValidatorMessages;
import com.futureTech.validator.UserValidator.UserValidatorMessages;
import com.futureTech.validator.Validator;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private MobileTelephoneService telephoneService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private MP3Service mp3Service;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "views-user-login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "views-user-signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user, Model model, @RequestParam("confirmPass")String confirmPass) {

        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);


        if(!user.getPassword().equals(confirmPass))
        {
            model.addAttribute("passwordException", "Passwords are not same");
            return "views-user-signUp";
        }


        try {
            userService.save(user);
        } catch (Exception e) {
            if(e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)){
                model.addAttribute("usernameException", e.getMessage());
            }else if(e.getMessage().equals(UserValidatorMessages.EMPTY_EMAIL_FIELD)||
                    e.getMessage().equals(UserValidatorMessages.EMAIL_ALREDY_EXIST)||
                    e.getMessage().equals(UserValidatorMessages.INCORRECT_EMAIL)){
                model.addAttribute("emailException", e.getMessage());
            }else if(e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD_FIELD)||
                    e.getMessage().equals(UserValidatorMessages.INCORRECT_PASSWORD_FIELD)){
                model.addAttribute("passwordException", e.getMessage());
            }

            System.out.println("user = " + user);
            return "views-user-signUp";
        }

        String theme = "Confirm registration";
        String mailBody =
                "Link to confirm:       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        userService.update(user);

        return "redirect:/";
    }

    @GetMapping("/changeActive/{id}")
    public  String makeActive(@PathVariable int id)
    {

        User user = userService.findOne(id);
        if(user.isEnable()==false) {
            user.setEnable(true);
        }
        else {
            user.setEnable((false));
        }
        userService.update(user);

        return "redirect:/showClients";
    }

    @GetMapping("/changeRole/{id}")
    public String changeRole(@PathVariable int id)
    {
        User user = userService.findOne(id);

        if(user.getRole().equals(Role.ROLE_USER)) {
            user.setRole(Role.ROLE_ADMIN);
        }else{
            user.setRole(Role.ROLE_USER);
        }

        userService.update(user);
        return "redirect:/showClients";
    }





    @GetMapping("/showClients")
    public String showClients(Model model)
    {

        model.addAttribute("users", userService.findAllByOrderByName());
        return "allUsersList";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id)
    {

        userService.delete(id);

        return "redirect:/showClients";
    }

    @GetMapping("/account")
    public  String account(Principal principal, Model model)
    {


        if(principal.getName().equals("admin"))
        {

            return "redirect:/adminPage";
        }


        model.addAttribute("user",userService.findUserWithOrder(Integer.parseInt(principal.getName())));
        //model.addAttribute("orders",userService.findUserWithOrder(Integer.parseInt(principal.getName())).getOrders());
        return "views-user-account";
    }

    @GetMapping("/updateUserInfo")
    public String updateUser(/*Principal principal, Model model*/)
    {


       // model.addAttribute("user",userService.findUserWithOrder(Integer.parseInt(principal.getName())));
        return "views-user-updateInfo";
    }


    @PostMapping("/updateUserInfo")
    public  String saveUpdates(Principal principal,  @RequestParam MultipartFile image,@RequestParam("name")String name,
                               @RequestParam("email")String email, @RequestParam("address") String address)
    {
        User user = userService.findOne(Integer.parseInt(principal.getName()));

        if(!name.equals(""))
        {
            user.setName(name);

        }
        if(!email.equals(""))
        {
            user.setEmail(email);

        }
        if(!address.equals(""))
        {
            user.setAdress(address);

        }

        if(!image.getOriginalFilename().equals(""))
        {
            userService.update(user,image);
        }

        userService.update(user);


        return "redirect:/account";
    }

    @GetMapping("/shoppingCart")
    public String shoppingCart(Principal principal, Model model) {


            if (principal.getName().equals("admin")) {

                model.addAttribute("adminError", "This is only administrative account, you can`t buy commodity from it");
                return "views-user-error";
            }


        model.addAttribute("orders", ordersService.findOrderByUser(userService.findOne(Integer.parseInt(principal.getName()))));


        return "views-user-shoppingCart";
    }


    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username, @RequestParam String password){

        try {
            validator.validate(new User(username,password));
        } catch (Exception e) {
            if(e.getMessage().equals(UserLoginValidatorMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserLoginValidatorMessages.EMPTY_PASSWORD_FIELD) ||
                    e.getMessage().equals(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD)) {
                model.addAttribute("exception", e.getMessage());
            }
        }

        model.addAttribute("user", new User());

        return "views-user-login";
    }


}
