package Assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1222);
			System.out.println("Server Started");

			Socket client = server.accept();

			DataInputStream in = new DataInputStream(client.getInputStream());

			DataOutputStream out = new DataOutputStream(client.getOutputStream());

			String line = in.readLine();

			System.out.println(line);

			out.writeBytes("Hello Client\n");

			client.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
