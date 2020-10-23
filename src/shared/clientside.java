package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface clientside extends Remote{
	void printClientId(int clientId) throws RemoteException;
	void printStr(int myId, String clientName, String str) throws RemoteException;
}
