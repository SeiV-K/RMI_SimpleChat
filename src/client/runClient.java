package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class runClient {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		
		clientImpl client = new clientImpl();
		client.clientInit();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String line = sc.nextLine();
			if (line.equalsIgnoreCase("exit"))
				break;
			client.sendStr(client.myId, client.clientName, line);
		}
	}
}
