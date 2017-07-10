package com.futureTech.controller;

import com.futureTech.entity.Brand;
import com.futureTech.entity.MobileTelephone;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.service.MobileTelephoneService;
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
 * Created by Victor on 08.06.2017.
 */
@Controller
public class MobileTelephoneController {

    @Autowired
    MobileTelephoneService mobileTelephoneService;

    @Autowired
    CommodityService commodityService;

    @Autowired
    BrandService brandService;



    @GetMapping("/newMobileTelephone")
    public String newMobilePhone(Model model)
    {
        model.addAttribute("brands", brandService.findAllByOrderByName());
        return  "newMobileTelephone";
    }

    @PostMapping("/newMobileTelephone")
    public  String saveMobileTelephone(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                                       @RequestParam("price") double price,@RequestParam("3g") boolean $3g,
                                       @RequestParam("wifi") boolean wifi, @RequestParam("battery") double battery,
                                       @RequestParam("amounts") int ammountofsim,@RequestParam("memory") int memory,
                                       @RequestParam("RAM") int RAM, @RequestParam("camera") double camera,
                                       @RequestParam("OS") String OS, @RequestParam("Screendiagonal") double Screendiagonal,
                                       @RequestParam MultipartFile image)

    {
        MobileTelephone mobileTelephone = new MobileTelephone();
        mobileTelephone.setName(name);
        mobileTelephone.setBrand(brandService.findOne(brandID));
        mobileTelephone.setPrice(price);
        mobileTelephone.set$3g($3g);
        mobileTelephone.setWifi(wifi);
        mobileTelephone.setBatteryCapacity(battery);
        mobileTelephone.setAmountOfSimCards(ammountofsim);
        mobileTelephone.setMemory(memory);
        mobileTelephone.setRAM(RAM);
        mobileTelephone.setCamera(camera);
        mobileTelephone.setOS(OS);
        mobileTelephone.setScreenDiagonal(Screendiagonal);

        try {
            mobileTelephoneService.save(mobileTelephone, image);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/adminPage";
    }


    @PostMapping("/updateMobileTelephone/{id}")
    public String updateMobileTelephone(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                                        @RequestParam("price") double price, @RequestParam("3g") boolean $3g,
                                        @RequestParam("wifi") boolean wifi, @RequestParam("battery") double battery,
                                        @RequestParam("amounts") int ammountofsim, @RequestParam("memory") int memory,
                                        @RequestParam("RAM") int RAM, @RequestParam("camera") double camera,
                                        @RequestParam("OS") String OS, @RequestParam("Screendiagonal") double Screendiagonal,
                                        @RequestParam MultipartFile image, @PathVariable int id){


        MobileTelephone mobileTelephone = mobileTelephoneService.findOne(id);
        mobileTelephone.setName(name);
        mobileTelephone.setBrand(brandService.findOne(brandID));
        mobileTelephone.setPrice(price);
        mobileTelephone.set$3g($3g);
        mobileTelephone.setWifi(wifi);
        mobileTelephone.setBatteryCapacity(battery);
        mobileTelephone.setAmountOfSimCards(ammountofsim);
        mobileTelephone.setMemory(memory);
        mobileTelephone.setRAM(RAM);
        mobileTelephone.setCamera(camera);
        mobileTelephone.setOS(OS);
        mobileTelephone.setScreenDiagonal(Screendiagonal);
        if(!image.getOriginalFilename().equals(""))
        {
            ImageSaver.saveImage(mobileTelephone,image);
        }


        mobileTelephoneService.update(mobileTelephone);




        return "redirect:/adminPage";
    }
    @GetMapping("/telephoneList")
    public  String telephoneList(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("telephoneList", mobileTelephoneService.findAllPages(pageable));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-telephoneList";
    }



}
