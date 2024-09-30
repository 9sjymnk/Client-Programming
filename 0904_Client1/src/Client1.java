import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class Client1 {
    public static void main(String[] args) {
        try {
            // Naming.lookup()으로 RMI 레지스트리에서 객체 가져오기 (기본 포트 1099)
            ServerIF server = (ServerIF) Naming.lookup("rmi://localhost/ServerIF");

            // 서버에 이름 저장
            server.saveName("김정호");

            System.out.println("Name saved to server.");

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}