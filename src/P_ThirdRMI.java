import java.rmi.*;
import java.util.*;
import javax.naming.*;

public class P_ThirdRMI {
	public static void main(String ar[]){
		try{
			Hashtable ht=new Hashtable();
			ht.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
			ht.put("java.naming.provider.url","iiop://127.0.0.1:900");
			Context ct=new InitialContext(ht);
			//naming class¶û À¯»çÇÏ´Ù
			P_SecondRMI psr=new P_SecondRMI();
			ct.rebind("iioprmi", psr);
			System.out.println("server ready");
		}catch(NamingException e){System.err.println("1="+e);}catch(RemoteException ee){System.err.println("2="+ee);
			
		}
		
	}
}
