import java.io.*;
import java.net.*;

public class DataSender {
	public static void main (String ar[]) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket();
		System.out.println("���� �غ� �Ϸ�");
		while(true){
			System.out.println("������ ����=");
			String contend=in.readLine();
			InetAddress ia=InetAddress.getByName("localhost");
			DatagramPacket dp=new DatagramPacket(contend.getBytes(), contend.getBytes().length,ia,8888); //byte���·� ��ȯ��Ų ���Ŀ� ����
			ds.send(dp);
			if(contend.equals("����"))break;
		}
		System.out.println("���� ����");
		
		
	}
}
