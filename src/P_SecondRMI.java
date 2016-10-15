import java.rmi.*;
import javax.rmi.*;

public class P_SecondRMI extends PortableRemoteObject implements P_FirstRMI {

	protected P_SecondRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
		return "Hello"+name+"!";
	}

}
