import java.io.*;
import java.util.*;
import java.net.*;

public class Ex03 {
	public static void main(String arg[])throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("�ɼ�( �ð�:time ��¥:date ��¥�� �ð�:datetime");
		String option=sc.next();
		InetAddress ia=InetAddress.getByName("192.168.0.9");
		DatagramPacket dp=new DatagramPacket(option.getBytes(),option.getBytes().length,ia,1234); //���� ���Ǳ��� �޴³�ip�ּ� �޴³� ��Ʈ�ּ�
		DatagramSocket ds=new DatagramSocket(32111);												// ���� ��Ʈ�ּ�
		ds.send(dp);
		
		
		byte[] by=new byte[65508];
		dp=new DatagramPacket(by,by.length);            //�ٽ� ���� ���� ���� ���� ����ũ��
		ds.receive(dp);									
		ds.close();
		
		String ss=new String(dp.getData()).trim();
		System.out.println(ss);
		
	}
}	
