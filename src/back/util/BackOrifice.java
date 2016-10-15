
/*
 * Created on 2005. 11. 25.
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package back.util;

import java.rmi.Remote;
import java.util.Vector;
import java.rmi.RemoteException;
/**
 * @author kimsh
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface BackOrifice extends Remote {
	//���� ������ ��Ʈ�� ���� Method (ex: c:\, d:\)
	public Vector getRoots() throws RemoteException;
	//���� path�ӿ� �ִ� �������� ���� Method
	public Vector getFolders(String path) throws RemoteException;
	//���� path�ӿ� �ִ� ���ϵ��� ���� Method 
	public Vector getFiles(String path) throws RemoteException;
	//���� path���� filename�� ������ �о� ������ ���� Method
	public String getContents(String path, 
				String filename) throws RemoteException;
	//���� path���� filename�� ���� ������ �����ϴ� Method
	public boolean setContents(String path, 
		String filename, String contents) throws RemoteException;
	//���� path���� filename�� ������ �����ϴ� Method
	public boolean delFile(String path, String filename) throws RemoteException;
	//���� path���� filename�� ������ �ٿ�ε� �����ִ� Method
	public StringBuffer getData(String path, 
				String filename) throws RemoteException;
}
