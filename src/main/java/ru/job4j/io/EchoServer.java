package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean serverWorks = true;
            while (serverWorks) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String message = "What?";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("msg=Exit")) {
                            serverWorks = false;
                            message = "Server is turned off";
                        }
                        if (str.contains("msg=Hello")) {
                            message = "Hello";
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(message.getBytes());
                    if (!serverWorks) {
                        server.close();
                    }
                }
            }
        }
    }
}
