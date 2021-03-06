package com.example.printer_demo_58mm;

import android.content.Context;
import android.graphics.Bitmap;

public class JBInterface {

	public static boolean openPrinter() {
		int result = GpioControl.activate(GpioControl.printer_o, true);
		if (result == 0)
			return true;
		else
			return false;
	}

	public static boolean closePrinter() {
		int result = GpioControl.activate(GpioControl.printer_o, false);
		if (result == 0)
			return true;
		else
			return false;
	}

	public static boolean convertPrinterControl() {
		int result = GpioControl.convertPrinter();
		C.printSerialPortTools = new SerialPortTools(C.printPort_58mm,
				C.printBaudrate_58mm);
		if (result == 0)
			return true;
		else
			return false;
	}

	/** 自检 */
	public static void testPrinter() {
		PrintTools_58mm.printTest();
	}

	/** 打印文字GB2312 */
	public static void printText_GB2312(String text) {
		PrintTools_58mm.printText_GB2312(text);
	}
	
	/** 打印文字Unicode */
	public static void printText_Unicode(String text) {
		PrintTools_58mm.printText_Unicode(text);
	}

	public static void printQRCodeWithPath(String qrcodeImagePath) {
		PrintTools_58mm.printPhotoWithPath(qrcodeImagePath);
	}

	public static void printImageWithPath(String iamgePath) {
		PrintTools_58mm.printPhotoWithPath(iamgePath);
	}

	public static void printQRCode(Bitmap bitmap) {
		byte[] command = PrintTools_58mm.decodeBitmap(bitmap);
		PrintTools_58mm.printPhoto(command);
	}

	public static void printImage(Bitmap bitmap) {
		byte[] command = PrintTools_58mm.decodeBitmap(bitmap);
		PrintTools_58mm.printPhoto(command);
	}
	
	public static void printQRCodeImageInAssets(Context context,String fileName){
		PrintTools_58mm.printPhotoInAssets(context, fileName);
	}
	
	public static void printImageInAssets(Context context,String fileName){
		PrintTools_58mm.printPhotoInAssets(context, fileName);
	}
}
