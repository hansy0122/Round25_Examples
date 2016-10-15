import java.io.*;
import java.net.*;
import java.util.*;

public class Ex01 {
	public static void main(String ar[]) throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("전송할 데이터=");
		String data=sc.nextLine();
		InetAddress ia=InetAddress.getByName("localhost");
		DatagramPacket dp=new DatagramPacket(data.getBytes(),data.getBytes().length,ia,7777);
		DatagramSocket soc=new DatagramSocket();
		soc.send(dp);
		soc.close();
		
		System.out.println("전송끝");
	
	
	}
}
