




import java.rmi.*;
public interface FirstRMI extends Remote{
	public String sayHello(String name) throws RemoteException;// ���ݿ��� �ݵ�� �����Ұ�
																	//abstract method
	
	public void printDate() throws RemoteException;
	
	
}
// ���� �������̽� �ۼ�