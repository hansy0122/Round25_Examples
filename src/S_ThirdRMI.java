import java.io.*;
import java.rmi.*;
import java.util.*;
import java.sql.*;

public class S_ThirdRMI { // Ŭ���̾�Ʈ��
	public static void main(String ar[]) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		//server ip����
		System.out.print("IP=");
		String ip=in.readLine();
		//server�� root������ �����ֱ�
		S_FirstRMI sfr=(S_FirstRMI) Naming.lookup("rmi://"+ip+"/exp");
		Vector vc=sfr.getRoots();
		for(int i=0;i<vc.size();i++){
			String data=(String)vc.elementAt(i);
			System.out.println(i+1+" : "+data);
		}
		System.out.println();
		///c:�� ������ �����ͼ� ȭ�鿡 �����ֱ�
		Vector vc1=sfr.getFolders("c:\\");
		for(int i=0;i<vc1.size();i++){
			String data=(String)vc1.elementAt(i);
			System.out.println(i+1+" : "+data);
		}
	
		
		
	}
}
