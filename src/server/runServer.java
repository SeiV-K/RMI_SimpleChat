package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class runServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		serverImpl server = new serverImpl();
				
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("server", server);
		
		System.out.println("Server Started!");
	}
}
