



import java.rmi.*; // binding ㅎㅏ기 위해서 필요함
import java.net.*;

// 서버측 바인딩 클래스 //실행클래스 
public class ThirdRMI {
	public static void main(String ar[]) {
		
		try{
			SecondRMI rmi= new SecondRMI();
			Naming.rebind("remote", rmi); // 사용자들이 사용할수있게 rmi를 remote라는 이름으로 올림
			System.out.println("Server Ready...");
		}catch(RemoteException ee){System.err.println("1="+ee);}catch(MalformedURLException ee){System.err.println("2="+ee);}
		
		
		
		
	}
}
