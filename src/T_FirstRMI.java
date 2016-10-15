import java.rmi.*;
import java.rmi.RemoteException;

public interface T_FirstRMI extends Remote {
	public void setClient(T_SecondRMI cc)throws RemoteException;
	public void setMessage(String msg)throws RemoteException;

}