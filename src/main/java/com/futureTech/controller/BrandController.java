package com.futureTech.controller;

import com.futureTech.entity.Brand;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.serviceImpl.ImageSaver;
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

    @Autowired
    CommodityService commodityService;


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

    @GetMapping("/updateBrand/{id}")
    public  String updateBrand(@PathVariable int id, Model model)
    {

        model.addAttribute("brand",brandService.findOne(id));
        model.addAttribute("id",id);
        return "updateBrand";
    }

    @PostMapping("/updateBrand/{id}")
    public String saveUpdatedBrand(@RequestParam("name") String name, @RequestParam MultipartFile image, @PathVariable int id)
    {
        Brand brand = brandService.findOne(id);

        brand.setName(name);
        if(!image.getOriginalFilename().equals(""))
        {
            ImageSaver.saveImage(brand,image);
        }

        brandService.update(brand);


        return "redirect:/newBrand";
    }

    @GetMapping("/deleteBrand/{id}")
    public  String deleteBrand(@PathVariable int id, Model model)
    {

        try {
            brandService.delete(id);
        }catch (Exception e){
            model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
            model.addAttribute("brandExeption", "To this brand attached some commodities, you cant delete it");
            return "views-user-error";
        }

        return "redirect:/newBrand";
    }


}
