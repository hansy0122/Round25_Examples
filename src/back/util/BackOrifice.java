
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
	//현재 서버의 루트를 얻어내는 Method (ex: c:\, d:\)
	public Vector getRoots() throws RemoteException;
	//현재 path속에 있는 폴더들을 얻어내는 Method
	public Vector getFolders(String path) throws RemoteException;
	//현재 path속에 있는 파일들을 얻어내는 Method 
	public Vector getFiles(String path) throws RemoteException;
	//현재 path상의 filename의 파일을 읽어 내용을 얻어내는 Method
	public String getContents(String path, 
				String filename) throws RemoteException;
	//현재 path상의 filename의 파일 내용을 설정하는 Method
	public boolean setContents(String path, 
		String filename, String contents) throws RemoteException;
	//현재 path상의 filename의 파일을 삭제하는 Method
	public boolean delFile(String path, String filename) throws RemoteException;
	//현재 path상의 filename의 파일을 다운로드 시켜주는 Method
	public StringBuffer getData(String path, 
				String filename) throws RemoteException;
}
