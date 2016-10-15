




import java.rmi.*;
public interface FirstRMI extends Remote{
	public String sayHello(String name) throws RemoteException;// 원격예외 반드시 전가할것
																	//abstract method
	
	public void printDate() throws RemoteException;
	
	
}
// 원격 인터페이스 작성