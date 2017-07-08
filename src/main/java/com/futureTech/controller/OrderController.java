package com.futureTech.controller;

import com.futureTech.entity.Commodity;
import com.futureTech.entity.Orders;
import com.futureTech.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Victor on 18.06.2017.
 */
@Controller
public class OrderController {

    @Autowired
    OrdersService ordersService;


    @GetMapping("/buy/{id}")
    public String buy(@PathVariable int id, Model model)
    {
        model.addAttribute("id",id);

        model.addAttribute("order",ordersService.findOne(id));

        return"views-user-checkout";
    }

    @PostMapping("/buy/{id}")
    public String buy_confirm(@PathVariable int id, @RequestParam("payment")int paymentOption, @RequestParam("delivering")int delivering)
    {

        System.out.println(paymentOption+"\n"+delivering);// Пока что эти параментры "для красоты" но потом найду куда их впихнуть

       Orders orders= ordersService.findOne(id);

       orders.setOpen(false);

       ordersService.update(orders);

        return"redirect:/account";
    }




    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id)
    {
        ordersService.delete(id);

        return"redirect:/account";
    }

    @GetMapping("/deleteCommodityFromOrder/{orderId}/{commodityId}")
    @Transactional
    public  String deleteCommodityFromOrder(@PathVariable int orderId, @PathVariable int commodityId){

        ordersService.deleteCommodityFromOrder(orderId,commodityId);
        return "redirect:/shoppingCart";
    }

}
