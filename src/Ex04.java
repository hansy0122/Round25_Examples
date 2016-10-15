import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;
public class Ex04 {
	public static void main(String ar[])throws IOException{
		DatagramPacket dp=new DatagramPacket(new byte[65508],65508);   //���� ��������
		DatagramSocket ds=new DatagramSocket(1234);      // ���� ��Ʈ�ּ�
		System.out.println("server ready");
		ds.receive(dp);
		
		
		String str=new String(dp.getData()).trim();
		String data="";
		if(str.equals("time")){
			SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			data=format.format(new Date());
		}else if(str.equals("date")){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			data=format.format(new Date());
		}else if(str.equals("datetime")){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			data=format.format(new Date());
		}else{
			data="�߸��� �ɼ��Դϴ�.";
		}
		
		dp=new DatagramPacket(data.getBytes(),data.getBytes().length,dp.getAddress(),32111); // ���� ����ũ�� �޴³� ip �ּ� �޴³� ��Ʈ�ּ�
		ds.send(dp);
		ds.close();
	}
}
