import java.io.*;
import java.net.*;

public class IterativeTCPEchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("TCP Iterative Echo Server Started...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String line;

            while ((line = in.readLine()) != null) {
                if (line.equalsIgnoreCase("bye")) break;
                System.out.println("Received: " + line);
                out.println("Echo: " + line);
            }

            clientSocket.close();
        }
    }
}

	
