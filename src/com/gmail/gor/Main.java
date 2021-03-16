package com.gmail.gor;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File folder = new File(".");
		File folder2 = new File("folder");
		folder2.mkdirs();
		File[] fileList = chek(folder);
		copyFile(fileList, folder2);
	}

	public static File[] chek(File folder) {
		ExtensionFileFilter eFF = new ExtensionFileFilter("doc");
		File[] fileList = folder.listFiles(eFF);
		return fileList;
	}

	public static void copyFile(File[] fileList, File folder) {

		for (File in : fileList) {
			File out = new File(folder + "/" + in.getName());
			try {
				FileService.copyFile(in, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
