import java.net.*;
import java.util.Scanner;

public class UDPEchoClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            byte[] buffer = message.getBytes();

            DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, 5002);
            socket.send(request);

            if (message.equalsIgnoreCase("bye")) break;

            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(response);

            System.out.println("Server: " + new String(response.getData(), 0, response.getLength()));
        }

        socket.close();
    }
}

