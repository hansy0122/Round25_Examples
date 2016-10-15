import java.rmi.*;
import javax.naming.*;
import java.util.*;

public class P_FourthRMI {
	public static void main(String ar[]){
		Hashtable ht=new Hashtable();
		ht.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
		ht.put("java.naming.provider.url","iiop://127.0.0.1:900");
		try{
			Context ct=new InitialContext(ht);
			Object obj=ct.lookup("iioprmi");
			P_FirstRMI pfr=(P_FirstRMI) obj;
			String str=pfr.sayHello("ÇÑ½Â¿±");
			System.out.println(str);
			
		}catch(NamingException ee){
			System.err.println("1="+ee);
		}catch(RemoteException ee){
			System.err.println("2="+ee);
		}
	}
}
