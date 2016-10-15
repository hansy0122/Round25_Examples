import java.io.*;
import java.net.*;

public class DataSender {
	public static void main (String ar[]) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket();
		System.out.println("전송 준비 완료");
		while(true){
			System.out.println("전송할 내용=");
			String contend=in.readLine();
			InetAddress ia=InetAddress.getByName("localhost");
			DatagramPacket dp=new DatagramPacket(contend.getBytes(), contend.getBytes().length,ia,8888); //byte형태로 변환시킨 이후에 전송
			ds.send(dp);
			if(contend.equals("종료"))break;
		}
		System.out.println("전송 종료");
		
		
	}
}
