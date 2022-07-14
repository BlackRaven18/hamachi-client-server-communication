import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try {
            final Socket socket = new Socket("25.66.173.209", 5555);
            final DataInputStream input = new DataInputStream(socket.getInputStream());
            final DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("Witaj świecie!"); System.out.println("Otrzymano od serwera wiadomość: " + input.readUTF());
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            System.err.println(Arrays.toString(exception.getStackTrace())); }
         }
}
