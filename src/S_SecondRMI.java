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
		File[] roots=File.listRoots();  //root���ϱ�
		for(int i=0;i<roots.length;i++){
			//�̸��� �����ϱ�
			imsi.add(roots[i].toString());
		}
		return imsi;
	}

	@Override
	public Vector getFolders(String path) throws RemoteException {
		// TODO Auto-generated method stub
		Vector imsi=new Vector();
		File dir=new File(path);
		if(!dir.isDirectory()||!dir.exists())return null; // dir�� ������ �ƴϰų� Ȥ�� �������� ������ null���� ��ȯ
		File[] lists=dir.listFiles();
	//Folder�� vector�� ��´�
		for(int i=0;i<lists.length;i++){
			if(lists[i].isDirectory()){
				imsi.add(lists[i].getPath());
			}
		}
		return imsi;
	}
	
	//binding
	public static void main(String ar[]) {
		//(RMI Server Start + 3��° ���)�� 2������ ������ ��.
		try{
		Runtime rt=Runtime.getRuntime();
		rt.exec("C:\\java\\Java\\jdk1.8.0_91\\bin\\rmiregistry.exe");
		}catch(IOException ee){}
		//��ü ����
		try{
		S_SecondRMI ssr=new S_SecondRMI();
		//��ü binding
		System.out.println("Server ready");
		Naming.rebind("exp", ssr);
		}catch(RemoteException ee){System.err.println("1"+ee);
		}catch(MalformedURLException ee){System.err.println("2"+ee);}
		}
		
	}

