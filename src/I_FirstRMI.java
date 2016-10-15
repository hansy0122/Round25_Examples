import java.rmi.*;

public interface I_FirstRMI extends Remote {
	public String openWeb(String addr) throws RemoteException;
}
