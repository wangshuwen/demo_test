package com.zkxh.demo_test.qr_code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.Hashtable;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author wangshuwen
 * @Description:
 * @Date 2019/1/21/11:18
 */
public class QRCode {
    public static void main(String[] args) {
        String text = "{\"emissivePower\":15,\"baseStationNum\":171,,\"channel\":50,\"antennaGain\":20,\"updateTime\":1547290509000,\"subnetMask\":\"255.255.255.0\",\"ssid\":\"zkxh-1-2-啊101\",\"baseStationId\":83661,\"powerSupply\":\"15\",\",\"encryption\":0,\"createTime\":1543390808000,\"baseStationIp\":\"192.168.1.22\",\"hardwareVersion\":\"000\",,\"softwareVersion\":\"000\",\"status\":1}";
        int width = 100;
        int height = 100;
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new java.io.File("D:/new.png").toPath();//在D盘生成二维码图片
            try {
                MatrixToImageWriter.writeToPath(bitMatrix, format, file);
                System.out.println("成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
