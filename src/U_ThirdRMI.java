import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class U_ThirdRMI extends UnicastRemoteObject implements U_FirstRMI { 
	
	private Vector user;
	
	protected U_ThirdRMI() throws RemoteException {
		super();
		user=new Vector();
		
		// TODO Auto-generated constructor stub
	}


	
// 너가 원래 2번째의 역할 (구체화를 맞는듯)

	
	@Override
	public void setClient(U_SecondRMI usr) throws RemoteException {
		// TODO Auto-generated method stub
		user.add(usr);
	}

	@Override
	public void setDate() throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<user.size();i++){
			U_SecondRMI usr=(U_SecondRMI) user.elementAt(i);
			usr.setScreenDate(new Date().toString());
		}
	}
	
	public static void main(String[] ar) throws Exception{
		Runtime rt=Runtime.getRuntime();
		rt.exec("C:\\java\\Java\\jdk1.8.0_91\\bin\\rmiregistry.exe");
		U_ThirdRMI ss=new U_ThirdRMI();
		Naming.rebind("both", ss);
		System.out.println("server ready");
	}
	

}