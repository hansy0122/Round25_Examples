import java.io.*;
import java.net.*;

public class FileGetter {
	public static void main(String ar[])throws IOException{
	DatagramSocket ds=new DatagramSocket(8888);
	
	
	System.out.println("���� ���� �غ� �Ϸ�");
	File file=null;
	DataOutputStream dos=null;
	while(true){
	
		byte[] by=new byte[512];
		DatagramPacket dp=new DatagramPacket(by,by.length);
		ds.receive(dp);
		
		System.out.println(new String(dp.getData()).trim());
		
		if(file!=null){
			dos.write(dp.getData(),0,dp.getData().length);	
		//�� �����ϰ� �ϸ� �۵��ϴµ� ��..
			
			if(dp.getData()==null){
				dos.close();
				ds.close();
				System.out.println("���� ����");
				break;
			}
			dos.flush();	
		}
		else if(dp.getData().length!=0){
			System.out.println("���� ����");
			file=new File("imsi.hsy");
			dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			System.out.println("������");
			dos.write(dp.getData(),0,dp.getData().length);
			dos.flush();
			
		} 
		else if(dp.getData()==null){
			System.err.println("���� ������ ���۵˴ϴ�.");
		}
		
	}
	}	
}
