package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.clientside;
import shared.serverside;

import java.util.*;

public class serverImpl implements serverside {

	private List<clientside> client_list;

	public serverImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		client_list = new ArrayList<>();
	}
	
	@Override
	public void registerClient(clientside clientside, String clientName) {
		try {
			client_list.add(clientside);
			clientside.printClientId(client_list.size());
		} catch (RemoteException e) {
			//e.printStackTrace();
		}
	}

	@Override
	public void receiveStr(String str, int myId, String clientName, clientside clientside) {
		for (clientside client : client_list) {
			try {
				if (client.equals(clientside)) continue;
				client.printStr(myId, clientName, str);
			} catch (RemoteException e) {
				//e.printStackTrace();
			}
		}
	}
}
