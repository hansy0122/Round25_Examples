



import java.net.MalformedURLException;
import java.rmi.*;


//Ŭ���̾�Ʈ
public class ForthRMI {
	public static void main(String ar[])throws Exception{
		
	
			
			try{
				FirstRMI fr=null;//Ŭ���̾�Ʈ�� secondRMI�� �� FirstRMI�ۿ� �� �׷��� F�� �����Ͽ� S�� �����ϴ� �������� �̿�
				Object obj=Naming.lookup("rmi://127.0.0.1/remote");       //rmi�� ��������
				fr=(FirstRMI)obj;
				String msg=fr.sayHello("���¿�");
				System.out.println("msg="+msg);
				
			}catch(RemoteException ee){
				
			}catch(MalformedURLException ew){
				
			}catch(NotBoundException eq){}
			
			}
	}

