import java.rmi.*;

public interface P_FirstRMI extends Remote{
	public String sayHello(String name) throws RemoteException;
}
