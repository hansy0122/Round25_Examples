import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

public class S_SecondRMI extends UnicastRemoteObject implements S_FirstRMI {

	public S_SecondRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector getRoots() throws RemoteException {
		// TODO Auto-generated method stub
		Vector imsi=new Vector();
		File[] roots=File.listRoots();  //root구하기
		for(int i=0;i<roots.length;i++){
			//이름만 저장하기
			imsi.add(roots[i].toString());
		}
		return imsi;
	}

	@Override
	public Vector getFolders(String path) throws RemoteException {
		// TODO Auto-generated method stub
		Vector imsi=new Vector();
		File dir=new File(path);
		if(!dir.isDirectory()||!dir.exists())return null; // dir이 폴더가 아니거나 혹은 존재하지 않으면 null값을 반환
		File[] lists=dir.listFiles();
	//Folder만 vector에 담는다
		for(int i=0;i<lists.length;i++){
			if(lists[i].isDirectory()){
				imsi.add(lists[i].getPath());
			}
		}
		return imsi;
	}
	
	//binding
	public static void main(String ar[]) {
		//(RMI Server Start + 3번째 기능)을 2번쨰에 구현한 것.
		try{
		Runtime rt=Runtime.getRuntime();
		rt.exec("C:\\java\\Java\\jdk1.8.0_91\\bin\\rmiregistry.exe");
		}catch(IOException ee){}
		//객체 선언
		try{
		S_SecondRMI ssr=new S_SecondRMI();
		//객체 binding
		System.out.println("Server ready");
		Naming.rebind("exp", ssr);
		}catch(RemoteException ee){System.err.println("1"+ee);
		}catch(MalformedURLException ee){System.err.println("2"+ee);}
		}
		
	}

