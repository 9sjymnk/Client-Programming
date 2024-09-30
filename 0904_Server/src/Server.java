import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server extends UnicastRemoteObject implements ServerIF {
    private String name;

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public void saveName(String name) throws RemoteException {
        this.name = name;
        System.out.println("Name saved: " + name);
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    public static void main(String[] args) {
        try {
        	ServerIF serverIF = new Server();
            
            // RMI 레지스트리 생성 및 바인딩: Naming 클래스 사용시 기본적으로 1099포트 설정 / 임의 설정(기본은 1099)
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ServerIF", serverIF);          
            System.out.println("RMI Server is running...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
