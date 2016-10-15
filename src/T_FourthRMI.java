import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class T_FourthRMI extends UnicastRemoteObject  implements T_SecondRMI{

	public T_FourthRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMessage(String str) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(str);
	}
	
	public static void main(String ar[]) throws Exception{
	T_FourthRMI tfor=new T_FourthRMI();
	T_FirstRMI tfr=(T_FirstRMI)Naming.lookup("rmi://127.0.0.1/chat");
	
	tfr.setClient(tfor);
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	while(true){
		System.out.println("msg = ");
		String msg=in.readLine();
		tfr.setMessage(msg);
		
	}
	}

}
