import java.rmi.*;

public interface T_SecondRMI extends Remote {
	public void setMessage(String str) throws RemoteException;

}
