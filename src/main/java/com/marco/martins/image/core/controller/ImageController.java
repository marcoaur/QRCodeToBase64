package com.marco.martins.image.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.marco.martins.image.core.response.QRCodeResponse;
import com.marco.martins.image.core.service.QRCodeGenerator;

@RestController
public class ImageController {

	@Autowired
	private QRCodeGenerator qrCodeGenerator;

	@PostMapping("/qrcode")
	public QRCodeResponse QRCodeGenerator(@RequestParam String value) throws WriterException {

		return qrCodeGenerator.generateQRCode(value);
	}

}
