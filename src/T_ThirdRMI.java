import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class T_ThirdRMI extends UnicastRemoteObject implements T_FirstRMI  {

	
	private static Vector vc=new Vector();
	
	public T_ThirdRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setClient(T_SecondRMI cc) throws RemoteException {
		// TODO Auto-generated method stub
		vc.add(cc);
	}

	@Override
	public void setMessage(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<vc.size();i++){
			T_SecondRMI cc=(T_SecondRMI)vc.elementAt(i);
			cc.setMessage(msg);
		}
	}
	
	public static void main(String ar[]) throws Exception{
		T_ThirdRMI ttr=new T_ThirdRMI();
		Naming.rebind("chat", ttr);
		System.out.println("Server Ready...");
	}

	

}
