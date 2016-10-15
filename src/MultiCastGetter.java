import java.io.*;
import java.util.*;
import java.net.*;

public class MultiCastGetter {
 public static void main(String ar[])throws IOException{
	 DatagramPacket dp=new DatagramPacket(new byte[65508],65508);
	 InetAddress ia=InetAddress.getByName("235.123.44.55");
	 MulticastSocket ms=new MulticastSocket(10000);
	 ms.joinGroup(ia);
	 ms.receive(dp);
	 ms.leaveGroup(ia);
	 ms.close();
	 
	 System.out.println("sender="+dp.getAddress().getHostAddress());
	 System.out.println("³»¿ë¹°="+new String(dp.getData()).trim());
 
 }
}
