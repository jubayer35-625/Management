package com.jubayer.spring_boot_api.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeService {

	public  byte[] buildQR(String text, int width, int height) 
             throws WriterException, IOException {

      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter
            .encode(text, BarcodeFormat.QR_CODE,
                  width, height);
      ByteArrayOutputStream pngOutputStream = 
              new ByteArrayOutputStream();
      MatrixToImageConfig con = new MatrixToImageConfig
                (0xFF000002, 0xFF04B4AE);
      MatrixToImageWriter.writeToStream(bitMatrix, 
               "PNG", pngOutputStream, con);
      byte[] pngData = pngOutputStream.toByteArray();
      
      return pngData;
   }
   
   
   public String findQR(String text) {

	      byte[] image = new byte[0];

	      try {
	         // Generate and Return Qr Code in Byte Array
	         image = buildQR(text, 250, 250);

	      } catch (WriterException | IOException e) {
	         e.printStackTrace();
	      }
	      // Convert Byte Array into Base64 Encode String
	      String qrcode = Base64.getEncoder()
	            .encodeToString(image);
	    
	     
	      return qrcode.toString();
	   }
}
