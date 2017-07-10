package com.futureTech.controller;

import com.futureTech.entity.PC;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.service.PCService;
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
public class PCController {


    @Autowired
    BrandService brandService;

    @Autowired
    PCService pcService;

    @Autowired
    CommodityService commodityService;



    @GetMapping("/newPC")
    public String newPC(Model model)
    {
        model.addAttribute("brands", brandService.findAllByOrderByName());

        return "newPC";

    }

    @PostMapping("/newPC")
    public  String savePC(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                                       @RequestParam("price") double price, @RequestParam("videoAdapter") String videoAdaper,
                                       @RequestParam("processor") String processor, @RequestParam("memory") int memory,
                                       @RequestParam("RAM") int RAM, @RequestParam("MotherLoad") String motherBoard,
                                       @RequestParam("OS") String OS, @RequestParam("weight") double weight,
                                       @RequestParam MultipartFile image)
    {

        PC pc = new PC();

        pc.setName(name);
        pc.setBrand(brandService.findOne(brandID));
        pc.setPrice(price);
        pc.setVideoAdapterType(videoAdaper);
        pc.setProcessor(processor);
        pc.setMemory(memory);
        pc.setRAM(RAM);
        pc.setMotherboard(motherBoard);
        pc.setOS(OS);
        pc.setWeight(weight);

        pcService.save(pc, image);

        return "redirect:/adminPage";
    }


    @PostMapping("/updatePC/{id}")
    public String updatePc(Model model, @RequestParam("name")String name, @RequestParam("brand") int brandID,
                           @RequestParam("price") double price, @RequestParam("videoAdapter") String videoAdaper,
                           @RequestParam("processor") String processor, @RequestParam("memory") int memory,
                           @RequestParam("RAM") int RAM, @RequestParam("MotherLoad") String motherBoard,
                           @RequestParam("OS") String OS, @RequestParam("weight") double weight,
                           @RequestParam MultipartFile image, @PathVariable int id,@PageableDefault Pageable pageable)
    {


        PC pc = pcService.findOne(id);

        pc.setName(name);
        pc.setBrand(brandService.findOne(brandID));
        pc.setPrice(price);
        pc.setVideoAdapterType(videoAdaper);
        pc.setProcessor(processor);
        pc.setMemory(memory);
        pc.setRAM(RAM);
        pc.setMotherboard(motherBoard);
        pc.setOS(OS);
        pc.setWeight(weight);

        if(!image.getOriginalFilename().equals(""))
        {
            ImageSaver.saveImage(pc,image);
        }

        pcService.update(pc);



        return "redirect:/adminPage";

    }

    @GetMapping("/pcList")
    public  String pcList(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("computers", pcService.findAllPages(pageable));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-pcList";
    }





}
