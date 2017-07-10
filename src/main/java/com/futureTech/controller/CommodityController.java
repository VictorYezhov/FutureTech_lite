package com.futureTech.controller;

import com.futureTech.entity.Commodity;
import com.futureTech.entity.Orders;
import com.futureTech.entity.User;
import com.futureTech.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 14.06.2017.
 */
@Controller
public class CommodityController {



    @Autowired
    BrandService brandService;

    @Autowired
    private  CommodityService commodityService;

    @Autowired
    private MobileTelephoneService mobileTelephoneService;

    @Autowired
    private PCService pcService;

    @Autowired
    private MP3Service mp3Service;

    @Autowired
    private TabletService tabletService;
    @Autowired
    private  UserService userService;

    @Autowired
    private  OrdersService ordersService;


    @GetMapping("/details/{id}")
    public String details(@PathVariable int id, Model model)
    {

        Commodity commodity  = commodityService.findOne(id);

        String commodityType = commodity.getType();

        switch (commodityType) {
            case "Telephone":
                model.addAttribute("commodityType", commodityType);
                model.addAttribute("item", mobileTelephoneService.findOne(id));
                break;
            case "PC":
                model.addAttribute("commodityType", commodityType);
                model.addAttribute("item", pcService.findOne(id));
                break;
            case "MP3":
                model.addAttribute("commodityType", commodityType);
                model.addAttribute("item", mp3Service.findOne(id));
                break;
            case "Tablet":
                model.addAttribute("commodityType", commodityType);
                model.addAttribute("item", tabletService.findOne(id));
                break;
        }



        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());

        return "views-user-detailedDescription";
    }

    @GetMapping("/addtoCart/{id}")
    public String addToCard(@PathVariable int id,  Model model, Principal principal) throws Exception {

        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        if(principal==null)
        {
            model.addAttribute("user", new User());
            model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
            return "views-user-registration";
        }
        if(principal.getName().equals("admin"))
        {
            model.addAttribute("adminError", "This is only administrative account, you can`t buy commodity from it");
            model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
            return "views-user-error";


        }


        Commodity commodity  = commodityService.findOne(id);

        User user= userService.findUserWithOrder(Integer.parseInt(principal.getName()));

        int count=user.getOrders().size()-1;

        if(count==-1)
        {
            count=0;
        }



        while(true)
        {
         if(user.getOrders().size()==0)
         {
             Orders order = new Orders();
             order.setUser(user);
             order.setDate(LocalDate.now());
             user.getOrders().add(order);
            // System.out.println("OUT!");
             ordersService.save(user.getOrders().get(count));
             break;

         }else if(user.getOrders().get(count).isOpen())
         {
          //   System.out.println("OUT! 2");
             break;
         }else{
           //  System.out.println("OUT! 3 ");
             count++;
             Orders order = new Orders();
             order.setUser(user);
             order.setDate(LocalDate.now());
             user.getOrders().add(order);
             ordersService.save(user.getOrders().get(count));
             break;
         }

        }


        switch (commodity.getType()) {
            case "Telephone":
                user.getOrders().get(count).getCommoditySet().add(mobileTelephoneService.findOne(id));
               // user.getOrders().get(count).getAmountOfCommodity().add(quantity);
                break;
            case "PC":

                user.getOrders().get(count).getCommoditySet().add(pcService.findOne(id));
               // user.getOrders().get(count).getAmountOfCommodity().add(quantity);

                break;
            case "MP3":

                user.getOrders().get(count).getCommoditySet().add(mp3Service.findOne(id));
             //   user.getOrders().get(count).getAmountOfCommodity().add(quantity);

                break;
            case "Tablet":
                user.getOrders().get(count).getCommoditySet().add(tabletService.findOne(id));
              //  user.getOrders().get(count).getAmountOfCommodity().add(quantity);
                break;

            default:{
                    throw  new Exception("No such Commodity");
                }
        }


        ordersService.save(user.getOrders().get(count));



        return "redirect:/shoppingCart";
    }

    @GetMapping("/deleteCommodity/{id}")
    public  String deleteCommodity(@PathVariable int id, Model model) throws Exception {

        try {
            switch (commodityService.findOne(id).getType()) {
                case "Telephone":
                    mobileTelephoneService.delete(id);
                    break;
                case "PC":

                    pcService.delete(id);

                    break;
                case "MP3":

                    mp3Service.delete(id);
                    break;
                case "Tablet":
                    tabletService.delete(id);
                    break;

                default: {
                    throw new Exception("No such Commodity");
                }
            }
        }catch (org.springframework.dao.DataIntegrityViolationException e)
        {
            model.addAttribute("deletingError", "This commodity is still in some orders, you can`t delete it");
            model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
            return "views-user-error";
        }


       // commodityService.delete(id);


        return"redirect:/";
    }

    @GetMapping("/updateCommodity/{id}")
    public  String updateCommodity(@PathVariable int id, Model model) {

        switch (commodityService.findOne(id).getType()) {
            case "Telephone":
                model.addAttribute("Id", id);
                model.addAttribute("telephone",mobileTelephoneService.findOne(id));
                model.addAttribute("brands",brandService.findAllByOrderByName());
                return "updateTelephone";

            case "PC":
                model.addAttribute("Id", id);
                model.addAttribute("pc",pcService.findOne(id));
                model.addAttribute("brands",brandService.findAllByOrderByName());
                return "updatePC";

            case "MP3":
                model.addAttribute("Id", id);
                model.addAttribute("mp3",mp3Service.findOne(id));
                model.addAttribute("brands",brandService.findAllByOrderByName());

                return "updateMP3";

            case "Tablet":
                model.addAttribute("Id", id);
                model.addAttribute("tablet",tabletService.findOne(id));
                model.addAttribute("brands",brandService.findAllByOrderByName());
                return "updateTablet";

            default: {

                model.addAttribute("errorWithCommodity", "No such commodity in DataBase");
                model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
                return "views-user-error";
            }

        }

    }

@PostMapping("/filter")
public String doFilter(Model model, @RequestParam("price1") double price1,@RequestParam("price2")double price2){

         model.addAttribute("items",commodityService.doFilter(price1,price2));
         model.addAttribute("brands", brandService.findAll());
    model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-filtredCommodity";
}

@PostMapping("/search")
public String searchCommodity(@RequestParam("searchName")String searchedName, Model model)
{



    model.addAttribute("items",commodityService.search(searchedName));

    model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
    return "views-user-searchedCommodity";
}



}
