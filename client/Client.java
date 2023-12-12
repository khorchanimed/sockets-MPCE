package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		
		try {
			Socket client = new Socket("127.0.0.1",1234);
						
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream()) ; 
			
			
			System.out.println( "Donner un entier : ");
			int n = sc.nextInt() ; 

            out.writeInt(n);
			out.flush() ; 

			int f = in.readInt() ; 
            System.out.println(n + " ! = " + f );
			
			client.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
