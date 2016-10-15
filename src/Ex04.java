import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;
public class Ex04 {
	public static void main(String ar[])throws IOException{
		DatagramPacket dp=new DatagramPacket(new byte[65508],65508);   //받을 상자제조
		DatagramSocket ds=new DatagramSocket(1234);      // 나의 포트주소
		System.out.println("server ready");
		ds.receive(dp);
		
		
		String str=new String(dp.getData()).trim();
		String data="";
		if(str.equals("time")){
			SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			data=format.format(new Date());
		}else if(str.equals("date")){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			data=format.format(new Date());
		}else if(str.equals("datetime")){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			data=format.format(new Date());
		}else{
			data="잘못된 옵션입니다.";
		}
		
		dp=new DatagramPacket(data.getBytes(),data.getBytes().length,dp.getAddress(),32111); // 상자 상자크기 받는놈 ip 주소 받는놈 포트주소
		ds.send(dp);
		ds.close();
	}
}
