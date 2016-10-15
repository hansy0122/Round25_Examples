import java.io.*;
import java.net.*;

public class DataGetter {
	public static void main(String ar[])throws IOException{
		
		
		DatagramSocket ds=new DatagramSocket(8888);
		System.out.println("server ready");
		
		while(true){
			System.out.println("git");
			byte[] by=new byte[65508];
			DatagramPacket dp=new DatagramPacket(by,by.length);
			ds.receive(dp);
			System.out.println("주소="+dp.getAddress().getHostAddress()+"내용물="+new String(dp.getData()).trim());
		}
		
	}

}
