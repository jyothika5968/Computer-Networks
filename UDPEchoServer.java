
import java.net.*;

public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5002);
        byte[] buffer = new byte[1024];

        System.out.println("UDP Echo Server is running...");

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);
            String received = new String(request.getData(), 0, request.getLength());

            if (received.equalsIgnoreCase("bye")) break;

            System.out.println("Received: " + received);

            DatagramPacket response = new DatagramPacket(request.getData(), request.getLength(),
                    request.getAddress(), request.getPort());
            socket.send(response);
        }

        socket.close();
    }
}
