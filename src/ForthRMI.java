



import java.net.MalformedURLException;
import java.rmi.*;


//클라이언트
public class ForthRMI {
	public static void main(String ar[])throws Exception{
		
	
			
			try{
				FirstRMI fr=null;//클라이언트는 secondRMI는 모름 FirstRMI밖에 모름 그래서 F를 생성하여 S를 저장하는 다형성을 이용
				Object obj=Naming.lookup("rmi://127.0.0.1/remote");       //rmi는 프로토콜
				fr=(FirstRMI)obj;
				String msg=fr.sayHello("감승엽");
				System.out.println("msg="+msg);
				
			}catch(RemoteException ee){
				
			}catch(MalformedURLException ew){
				
			}catch(NotBoundException eq){}
			
			}
	}

