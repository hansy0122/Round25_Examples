import java.rmi.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class I_FourthRMI {
	public static void main(String ar[]) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.print("접속할 ip=");
		String ip=in.readLine();
		
		try{
			I_FirstRMI ifr=(I_FirstRMI)Naming.lookup("rmi://"+ip+"/web");
			System.out.print("띄울 사이트=");
			String adr=in.readLine();
			ifr.openWeb(adr);
		}catch(RemoteException ee){
			System.err.println("1="+ee);
			
		}catch(MalformedURLException ew){
			System.err.println("2="+ew);
		}catch(NotBoundException eq){System.err.println("3="+eq);}
		
		}
		
	}
	

}
