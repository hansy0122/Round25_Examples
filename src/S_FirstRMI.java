import java.rmi.*;
import java.util.*;

public interface S_FirstRMI extends Remote {
	//root �ֱ�
	public Vector getRoots()throws RemoteException;
	//Folder �ֱ�
	public Vector getFolders(String path)throws RemoteException;

}
