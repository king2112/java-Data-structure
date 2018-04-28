package com.company;

import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Socket client = new Socket("localhost", 8888);
		     Scanner in = new Scanner(client.getInputStream());
		     PrintStream out = new PrintStream(client.getOutputStream());
		     Scanner input = new Scanner(System.in);

		) {
			System.out.print("waiting to write a massage\n ");
			String massage ;
			do {

				massage = input.next();
				out.println(massage);
				//out.flush();
				System.out.print("massage sent \n");

				String  receive = in.next();
					System.out.println("received : "+receive);

			} while (!massage.equals("exit"));


		} catch (IOException e) {

		}

	}
}
