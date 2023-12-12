package serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {


		try {
			ServerSocket ss = new ServerSocket(1234);
			
			System.out.println("Serveur en attente ...");
			Socket serveur = ss.accept() ;
			System.out.println("Un client connecté ");
			
			DataInputStream in = new DataInputStream(serveur.getInputStream());
			DataOutputStream out = new DataOutputStream(serveur.getOutputStream()) ; 
			
			
			int n = in.readInt();
			
			System.out.println("n = " + n);

			int f=1; 
			for(int i = 1 ; i<=n ;i++)
			   f = f * i ; 

			out.writeInt(f);
			
			serveur.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
