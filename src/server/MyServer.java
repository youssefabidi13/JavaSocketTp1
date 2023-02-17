package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket =new ServerSocket(2000);
		System.out.println("J'attend la connection ...");
		Socket socket =serverSocket.accept();
		InputStream inputStream =socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		System.out.println("J'attend le client envoie un octet");
		int nb =inputStream.read();
		System.out.println("J'ai recu le nombre "+nb);
		int res=nb*5;
		System.out.println("J'envoie la reponse "+res);
		outputStream.write(res);
		socket.close();

	}

}
