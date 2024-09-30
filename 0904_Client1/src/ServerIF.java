import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIF extends Remote {

    void saveName(String name) throws RemoteException;
    String getName() throws RemoteException;
}
