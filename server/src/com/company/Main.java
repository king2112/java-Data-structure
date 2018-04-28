package com.company;

import com.sun.corba.se.spi.activation.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		try (
				ServerSocket Server = new ServerSocket(8888);

				Socket client = Server.accept();
				Scanner in = new Scanner(client.getInputStream());
				PrintStream out = new PrintStream(client.getOutputStream());
		){
			String massage ;
			do {
				massage= in.next() ;
				System.out.println(massage);
				out.println (massage);
				//out.flush();
			}while (!massage.equals("exit"));


		} catch (IOException e) {

		}

	}
}
