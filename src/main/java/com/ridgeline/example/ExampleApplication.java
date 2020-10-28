package com.ridgeline.example;


import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ridgeline.example.index.utility.IndexGeneratorUtil;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner{
	
	private static Logger log = LoggerFactory.getLogger(ExampleApplication.class);
	
	@Autowired
	IndexGeneratorUtil indexGeneratorUtil;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ExampleApplication.class);
		
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started...");
		
		Resource resource = new ClassPathResource("xml/mlb.xml");
		
		File xmlFile = resource.getFile();
		
		indexGeneratorUtil.beginIndexCreationProcess(xmlFile);	
		
		System.exit(0);
	}
}
