import java.io.*;
import java.net.*;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to TCP Echo Server");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String userInput;
        System.out.print("Type messages (type 'bye' to exit):");
        while ((userInput = input.readLine()) != null) {
            out.println(userInput);
            System.out.println("Server: " + in.readLine());
            if (userInput.equalsIgnoreCase("bye")) break;
        }

        socket.close();
    }
}
