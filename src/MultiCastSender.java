import java.io.*;
import java.util.*;
import java.net.*;

public class MultiCastSender {
	public static void main(String ar[])throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("���۹�=");
		String str=sc.nextLine();
		System.out.println(str);
		InetAddress ia=InetAddress.getByName("235.123.44.55"); //multicast�� ������ �ּ� 225~239��������!
		DatagramPacket dp=new DatagramPacket(str.getBytes(),str.getBytes().length,ia,10000);
		MulticastSocket ms=new MulticastSocket();
		ms.send(dp);
		ms.close();
	
	}
}
