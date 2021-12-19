package com.sip.ams;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.sip.ams.controllers.ControllerBook;

@SpringBootApplication
public class AmsVermegBookStoreApplication {

	public static void main(String[] args) {
		new File(ControllerBook.uploadDirectory).mkdir();
		new File(ControllerBook.pdfDirectory).mkdir();
		SpringApplication.run(AmsVermegBookStoreApplication.class, args);
	}

}
