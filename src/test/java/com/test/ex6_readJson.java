package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ex6_readJson {

	public static void main(String[] args) throws IOException {

		String data = new String(Files.readAllBytes(Paths
				.get("C:\\Users\\yogesh.shinde\\Spring_STS\\RestApi_Test\\src\\test\\resources\\files\\demo.txt")));

//		System.out.println(data);

		System.out.println(0.2 + 0.4 - 0.6);
	}

}
