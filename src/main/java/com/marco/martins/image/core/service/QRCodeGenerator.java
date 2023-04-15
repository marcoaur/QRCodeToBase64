package com.marco.martins.image.core.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.marco.martins.image.core.response.QRCodeResponse;

@Service
public class QRCodeGenerator {

	public QRCodeResponse generateQRCode(String data) throws WriterException {
		int width = 300;
		int height = 300;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
		BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
		try {
			return new QRCodeResponse(bufferedImageToBase64(image), data);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private String bufferedImageToBase64(BufferedImage image) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		baos.flush();
		byte[] imageBytes = baos.toByteArray();
		baos.close();
		String base64Content = Base64.getEncoder().encodeToString(imageBytes);
		return "data:image/png;base64," + base64Content;
	}

}
