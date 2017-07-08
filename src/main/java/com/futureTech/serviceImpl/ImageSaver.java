package com.futureTech.serviceImpl;

import com.futureTech.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Victor on 14.06.2017.
 */
public class ImageSaver {



    public static void saveImage(Brand brand, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/Brands/"
                + brand.getName() + "/" + image.getOriginalFilename();

        brand.setPathImage("/resources/Brands/" + brand.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }

    public static void saveImage(User user, MultipartFile image) {

         String path = System.getProperty("catalina.home") + "/resources/Users/"
            + user.getName() + "/" + image.getOriginalFilename();
        user.setPathImage("resources/Users/" + user.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }

    public static void saveImage(MobileTelephone mobileTelephone, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/Telephones/"
                + mobileTelephone.getName() + "/" + image.getOriginalFilename();

        mobileTelephone.setPathImage("resources/Telephones/" + mobileTelephone.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }

    public static void saveImage(MP3 mp3, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/MP3/"
                + mp3.getName() + "/" + image.getOriginalFilename();
        mp3.setPathImage("resources/MP3/" + mp3.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }
    public static void saveImage(PC pc, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/PCs/"
                + pc.getName() + "/" + image.getOriginalFilename();
        pc.setPathImage("resources/PCs/" + pc.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }
    public static void saveImage(Tablet tablet, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/Tablets/"
                + tablet.getName() + "/" + image.getOriginalFilename();
        tablet.setPathImage("resources/Tablets/" + tablet.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }







}
