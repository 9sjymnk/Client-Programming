import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);         
            ServerIF nameService = (ServerIF) registry.lookup("ServerIF");
            String name = nameService.getName();
            
            System.out.println("Client 2: 서버에서 읽은 이름: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
