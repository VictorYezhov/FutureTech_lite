package com.futureTech.controller;

import com.futureTech.entity.Tablet;
import com.futureTech.service.BrandService;
import com.futureTech.service.CommodityService;
import com.futureTech.service.TabletService;
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
public class TabletController {

    @Autowired
    TabletService tabletService;


    @Autowired
    CommodityService commodityService;

    @Autowired
    BrandService brandService;



    @GetMapping("/newTablet")
    public String newMobilePhone(Model model)
    {
        model.addAttribute("brands", brandService.findAllByOrderByName());
        return  "newTablet";
    }

    @PostMapping("/newTablet")
    public  String saveMobileTelephone(@RequestParam("name")String name, @RequestParam("brand") int brandID,
                                       @RequestParam("price") double price,
                                       @RequestParam("wifi") boolean wifi, @RequestParam("battery") double battery,
                                       @RequestParam("amounts") int ammountofsim, @RequestParam("memory") int memory,
                                       @RequestParam("RAM") int RAM, @RequestParam("camera") double camera,
                                       @RequestParam("OS") String OS, @RequestParam("Screendiagonal") double Screendiagonal,
                                        @RequestParam MultipartFile image)

    {
        Tablet tablet = new Tablet();
        tablet.setName(name);
        tablet.setBrand(brandService.findOne(brandID));
        tablet.setPrice(price);

        tablet.setWifi(wifi);
        tablet.setBatteryCapacity(battery);
        tablet.setAmountOfSimCards(ammountofsim);
        tablet.setMemory(memory);
        tablet.setRAM(RAM);
        tablet.setCamera(camera);
        tablet.setOS(OS);
        tablet.setScreenDiagonal(Screendiagonal);

        try {
            tabletService.save(tablet,image);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/adminPage";
    }

    @PostMapping("/updateTablet/{id}")
    public  String updateTablet( @RequestParam("name")String name, @RequestParam("brand") int brandID,
                                @RequestParam("price") double price,
                                @RequestParam("wifi") boolean wifi, @RequestParam("battery") double battery,
                                @RequestParam("amounts") int ammountofsim, @RequestParam("memory") int memory,
                                @RequestParam("RAM") int RAM, @RequestParam("camera") double camera,
                                @RequestParam("OS") String OS, @RequestParam("Screendiagonal") double Screendiagonal,
                                @RequestParam MultipartFile image, @PathVariable int id)
    {

        Tablet tablet = tabletService.findOne(id);
        tablet.setName(name);
        tablet.setBrand(brandService.findOne(brandID));
        tablet.setPrice(price);
        tablet.setWifi(wifi);
        tablet.setBatteryCapacity(battery);
        tablet.setAmountOfSimCards(ammountofsim);
        tablet.setMemory(memory);
        tablet.setRAM(RAM);
        tablet.setCamera(camera);
        tablet.setOS(OS);
        tablet.setScreenDiagonal(Screendiagonal);

        if(!image.getOriginalFilename().equals(""))
        {
            ImageSaver.saveImage(tablet,image);
        }

        tabletService.update(tablet);



        return "redirect:/adminPage";
    }

    @GetMapping("/tabletList")
    public String tabletList(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("tablets", tabletService.findAllPages(pageable));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("maxPrice",commodityService.findCommodityWitMaxPrice());
        return "views-user-tabletList";


    }


}
