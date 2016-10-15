
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class SecondRMI extends UnicastRemoteObject implements FirstRMI {
	

	public SecondRMI() throws RemoteException {
		super();
	} // 반드시 이런식으로 예외전가할것

	@Override
	public String sayHello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		printDate();
		String str = name + "님 hi";
		return str;
	}

	@Override
	public void printDate() throws RemoteException {
		// TODO Auto-generated method stub
		Date d=new Date();
		System.out.println("connnet Date"+d.toString());
	}
}
// 서버측 구현 클래스 작성 
//이후 rmic 라는 명령어로 SecondRMI stub 클래스 생성 해줘야함