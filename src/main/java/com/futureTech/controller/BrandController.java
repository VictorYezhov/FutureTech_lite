package com.futureTech.controller;

import com.futureTech.entity.Brand;
import com.futureTech.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

/**
 * Created by Victor on 08.06.2017.
 */

@Controller
public class BrandController {

    @Autowired
    BrandService brandService;


    @GetMapping("/newBrand")
    public  String newBrand(Model model)
    {
        model.addAttribute("brands", brandService.findAllByOrderByName());

        return  "newBrand";
    }



    @PostMapping("/newBrand")
    public String addBrand(@RequestParam("name") String name, @RequestParam MultipartFile image, Model model)
    {
        Brand brand = new Brand();
        brand.setName(name);
        try {
            brandService.save(brand,image);
        } catch (Exception e) {
            model.addAttribute("brandExeption", e.getMessage());
            return "redirect:/newBrand";
        }

        return "redirect:/newBrand";
    }

    @GetMapping("/deleteBrand/{id}")
    public  String deleteBrand(@PathVariable int id)
    {

        try {
            brandService.delete(id);
        }catch (Exception e){
            return "redirect:/newBrand";
        }

        return "redirect:/newBrand";
    }


}
