import java.io.*;
import java.net.*;

public class Ex02 {
	public static void main(String ar[])throws IOException{
		
		byte[] by=new byte[65508]; // �ִ����Ʈ
		DatagramPacket dp=new DatagramPacket(by,by.length);
		DatagramSocket soc=new DatagramSocket(7777);
		System.out.println("Server ready");
		soc.receive(dp);
		soc.close();
		
		System.out.println("sender="+dp.getAddress().getHostAddress());
		System.out.println("���빰="+new String(dp.getData()).trim());
	
	
	}
}
