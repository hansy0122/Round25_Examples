import java.rmi.*;
import java.rmi.server.*;
public class U_FourthRMI extends UnicastRemoteObject implements U_SecondRMI{

	public U_FourthRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setScreenDate(String str) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(str);
		
	}
	public static void main(String ar[])throws Exception{
		U_FirstRMI ufr=(U_FirstRMI)Naming.lookup("rmi://127.0.0.1/both");
		U_FourthRMI uftr=new U_FourthRMI();
		ufr.setClient(uftr);
		while(true){
			System.out.println("message= ");
			int xx=System.in.read()-48;
			System.in.read();
			System.in.read();
			if(xx==1) ufr.setDate();
		}
		
	}

}
