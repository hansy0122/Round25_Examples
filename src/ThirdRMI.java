



import java.rmi.*; // binding ������ ���ؼ� �ʿ���
import java.net.*;

// ������ ���ε� Ŭ���� //����Ŭ���� 
public class ThirdRMI {
	public static void main(String ar[]) {
		
		try{
			SecondRMI rmi= new SecondRMI();
			Naming.rebind("remote", rmi); // ����ڵ��� ����Ҽ��ְ� rmi�� remote��� �̸����� �ø�
			System.out.println("Server Ready...");
		}catch(RemoteException ee){System.err.println("1="+ee);}catch(MalformedURLException ee){System.err.println("2="+ee);}
		
		
		
		
	}
}
