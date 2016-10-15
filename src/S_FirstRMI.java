import java.rmi.*;
import java.util.*;

public interface S_FirstRMI extends Remote {
	//root 주기
	public Vector getRoots()throws RemoteException;
	//Folder 주기
	public Vector getFolders(String path)throws RemoteException;

}
