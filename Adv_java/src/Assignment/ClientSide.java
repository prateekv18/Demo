package Assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 1222);

			DataInputStream in = new DataInputStream(client.getInputStream());

			DataOutputStream out = new DataOutputStream(client.getOutputStream());

			out.writeBytes("Hello Server\n");

			String line = in.readLine();

			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
