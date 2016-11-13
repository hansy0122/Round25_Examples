import java.io.*;
import java.net.*;

public class DataGetter {
	public static void main(String ar[])throws IOException{
			
			DatagramSocket ds=new DatagramSocket(8888);
			System.out.println("Server ready");
			while(true){
				byte[] by=new byte[65508];
				DatagramPacket dp=new DatagramPacket(by,by.length);
				ds.receive(dp);
				System.out.println("Sender's ip="+dp.getAddress().getHostAddress()+" contends="+ new String(dp.getData()).trim());
			}
	}
}
