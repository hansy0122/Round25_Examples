import java.rmi.*;

import java.rmi.server.*;

public class I_SecondRMI extends UnicastRemoteObject implements I_FirstRMI {
	
	public I_SecondRMI()throws RemoteException{}
	@Override
	public String openWeb(String addr) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println("���� ��="+addr);
		try{
			Runtime rt=Runtime.getRuntime();
			rt.exec("explorer.exe "+addr);
					
		}catch(Exception ee){System.err.println("error="+ee);}
		return "���� ���� ����";
	}

}
