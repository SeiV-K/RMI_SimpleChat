package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface serverside extends Remote{
	void registerClient(clientside clientside, String clientName) throws RemoteException;
	void receiveStr(String str, int myId, String clientName, clientside clientside) throws RemoteException;
}
