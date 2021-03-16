package com.gmail.gor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Task2 {

	public static void main(String[] args) {
		File file1 = new File("first.txt");
		File file2 = new File("second.txt");
		File file3 = new File("final.txt");

		try {
			file3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String comp = comparsion(file1, file2);
		saveToFile(file3, comp);

	}

	public static String comparsion(File file1, File file2) {
		String[] f1 = splitWorlds(loadFromFile(file1));
		String[] f2 = splitWorlds(loadFromFile(file2));
		String comparsion = "";
		for (String word1 : f1) {
			for (String word2 : f2) {
				if (word1.equalsIgnoreCase(word2)) {
					comparsion += word1 + " ";
				}
			}
		}
		return comparsion;
	}

	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());

			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return sb.toString();
	}

	public static String[] splitWorlds(String string) {
		String[] splitWorlds = string.replaceAll("[^\\dA-Za-z ]", " ").split(" ");

		return splitWorlds;
	}

	public static void saveToFile(File file, String text) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
