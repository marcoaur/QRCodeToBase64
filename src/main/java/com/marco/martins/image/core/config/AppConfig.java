package com.marco.martins.image.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marco.martins.image.core.service.QRCodeGenerator;

@Configuration
public class AppConfig{
	
	 @Bean
		public QRCodeGenerator qrCodeGenerator() {
			return new QRCodeGenerator();
		}
}
