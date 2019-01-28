package com.zkxh.demo_test.qr_code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author wangshuwen
 * @Description:
 * @Date 2019/1/21/13:18
 */
public class QRCodeDecord {
    public static void main(String[] args) {
        MultiFormatReader formatReader=new MultiFormatReader();
        File file =new File("D:/new.png");
        BufferedImage image=null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BinaryBitmap binaryBitmap =new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        Hashtable hints=new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Result result= null;
        try {
            result = formatReader.decode(binaryBitmap,hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("解析结果："+result.toString());
        System.out.println(result.getBarcodeFormat());
        System.out.println(result.getText());




    }
}
