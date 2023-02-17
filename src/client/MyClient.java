package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) throws Exception {
		System.out.println("Je me connecte au server");
		Socket socket=new Socket("localhost", 2000);
		InputStream inputStream=socket.getInputStream();
		OutputStream outputStream =socket.getOutputStream();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Donner un nombre");
		int nb =scanner.nextInt();
		System.out.println("J'envoie le nombre "+nb+" au server");
		outputStream.write(nb);
		System.out.println("J'attend la reponse du serveur");
		int rep=inputStream.read();
		System.out.println("reponse de serveur est : "+rep);
	}
}
