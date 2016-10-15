import java.rmi.*;
import java.net.*;

public class I_ThirdRMI {
	public static void main(String ar[]){
		try{
			I_SecondRMI isr=new I_SecondRMI();
			
			Naming.rebind("web", isr);
			System.out.println("Server Ready");
		}catch(RemoteException ee){System.err.println("1"+ee);}catch(MalformedURLException ee){System.err.println("2"+ee);}
	}
}
