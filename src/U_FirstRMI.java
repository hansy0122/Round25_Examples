import java.rmi.*;

public interface U_FirstRMI extends Remote {
	public void setClient(U_SecondRMI usr)throws RemoteException;
	public void setDate() throws RemoteException;

}
