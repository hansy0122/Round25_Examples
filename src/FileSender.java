import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileSender {
	public static void main(String ar[]) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("전송 대상");
		String ip=sc.next();
		InetAddress ia=InetAddress.getByName(ip);
		System.out.println("전송 파일");
		String filename=sc.next();
		
		File file=new File(filename);
		if(!file.exists()){
			System.err.println("파일이 존재하지않습니다");
			System.exit(-1);
		}
		DatagramSocket ds=new DatagramSocket();
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
	
		while(true){
			byte[] by=new byte[512];
			int x=dis.read(by, 0, by.length);  //1byte 형태로 읽어와 저장. 
			if(x==-1)break;
			DatagramPacket dp=new DatagramPacket(by,x,ia,8888);
			ds.send(dp);
		}
		ds.close();
		System.out.println("전송 완료");
		
		
		
	}
}
