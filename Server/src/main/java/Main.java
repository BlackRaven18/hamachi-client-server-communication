import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        System.out.println("Urochomienie...");

        try {
            InetAddress address = InetAddress.getByName("25.66.173.209");
            ServerSocket serverSocket = new ServerSocket(5555, 0, address);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
                    output.writeUTF(input.readUTF());
                    System.out.println("Obsluzono klienta");
                } catch (IOException e) {
                    System.err.println("IOException when connected");
                    serverSocket.close();

                }
            }


        } catch(UnknownHostException e){
            System.err.println("UnknowHostException");
        } catch(IOException e){
            System.err.println("IOException");
        }
    }
}
