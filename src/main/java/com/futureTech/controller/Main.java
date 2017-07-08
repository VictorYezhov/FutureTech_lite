package com.futureTech.controller;


import com.futureTech.entity.*;
import com.futureTech.service.BrandService;
import com.futureTech.service.MP3Service;
import com.futureTech.service.MobileTelephoneService;
import com.futureTech.service.PCService;
import javassist.bytecode.LineNumberAttribute;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.prefs.Preferences;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");









		context.close();
	}

}
