import java.io.*;
import java.util.*;
import java.net.*;

public class Ex03 {
	public static void main(String arg[])throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("옵션( 시간:time 날짜:date 날짜와 시간:datetime");
		String option=sc.next();
		InetAddress ia=InetAddress.getByName("192.168.0.9");
		DatagramPacket dp=new DatagramPacket(option.getBytes(),option.getBytes().length,ia,1234); //물건 물건길이 받는놈ip주소 받는놈 포트주소
		DatagramSocket ds=new DatagramSocket(32111);												// 나의 포트주소
		ds.send(dp);
		
		
		byte[] by=new byte[65508];
		dp=new DatagramPacket(by,by.length);            //다시 받을 상자 제조 상자 상자크기
		ds.receive(dp);									
		ds.close();
		
		String ss=new String(dp.getData()).trim();
		System.out.println(ss);
		
	}
}	
