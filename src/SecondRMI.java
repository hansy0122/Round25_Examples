
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class SecondRMI extends UnicastRemoteObject implements FirstRMI {
	

	public SecondRMI() throws RemoteException {
		super();
	} // �ݵ�� �̷������� ���������Ұ�

	@Override
	public String sayHello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		printDate();
		String str = name + "�� hi";
		return str;
	}

	@Override
	public void printDate() throws RemoteException {
		// TODO Auto-generated method stub
		Date d=new Date();
		System.out.println("connnet Date"+d.toString());
	}
}
// ������ ���� Ŭ���� �ۼ� 
//���� rmic ��� ��ɾ�� SecondRMI stub Ŭ���� ���� �������