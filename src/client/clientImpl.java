package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import shared.clientside;
import shared.serverside;

public class clientImpl implements clientside{
	
	private serverside server;
	public int myId = 0;
	public String clientName;
	
	public clientImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	public void clientInit() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		server = (serverside) registry.lookup("server");
		System.out.printf("Client Connected!\n");
		
		System.out.print("Enter your name: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		clientName = sc.nextLine();
		server.registerClient(this, clientName);
	}
	
	@Override
	public void printClientId(int clientId) throws RemoteException {		
		System.out.printf("\nCLIENT ID: %d\nWelcome to the chat %s!\n\n", clientId, clientName);
		myId = clientId;
	}
	
	public void sendStr(int myId, String clientName, String str) {
		try {
			server.receiveStr(str, myId, clientName, this);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not contact the server!");
		}
	}

	@Override
	public void printStr(int myId, String clientName, String str) {
		System.out.printf("(ID: %d) %s: %s\n", myId, clientName, str);
	}
}
