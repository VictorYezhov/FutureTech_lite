package com.futureTech.controller;

import com.futureTech.entity.MP3;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.service.MP3Service;
import com.futureTech.serviceImpl.ImageSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Victor on 12.06.2017.
 */
@Controller
public class MP3Controller {

    @Autowired
    BrandService brandService;

    @Autowired
    MP3Service mp3Service;

    @Autowired
    CommodityService commodityService;

    @GetMapping("/newMP3")
    public String newMP3(Model model)
    {
        model.addAttribute("brands", brandService.findAllByOrderByName());
        return  "newMusicPlayer";
    }

    @GetMapping("/mp3List")
    public  String mp3List(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("mp3list", mp3Service.findAllPages(pageable));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-mp3list";
    }

    @PostMapping("/newMP3")
    public String saveMP3(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                          @RequestParam("price") double price, @RequestParam("battery") double battery,
                          @RequestParam("memory") int memory, @RequestParam MultipartFile image)
    {
        MP3 mp3 = new MP3();

        mp3.setName(name);
        mp3.setBrand(brandService.findOne(brandID));
        mp3.setPrice(price);
        mp3.setBatteryCapacity(battery);
        mp3.setMemory(memory);

        mp3Service.save(mp3,image);

        return  "redirect:/adminPage";
    }

    @PostMapping("/updateMP3/{id}")
    public String updateMP3(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                            @RequestParam("price") double price, @RequestParam("battery") double battery,
                            @RequestParam("memory") int memory, @RequestParam MultipartFile image, @PathVariable int id)
    {

        MP3 mp3 = mp3Service.findOne(id);

        mp3.setName(name);
        mp3.setBrand(brandService.findOne(brandID));
        mp3.setPrice(price);
        mp3.setBatteryCapacity(battery);
        mp3.setMemory(memory);

        if(!image.getOriginalFilename().equals(""))
        {
            ImageSaver.saveImage(mp3, image);
        }

        mp3Service.update(mp3);


        return "redirect:/adminPage";

    }

}
