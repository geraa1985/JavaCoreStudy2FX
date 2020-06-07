package Lesson_7.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {
    private final List<ClientHandler> clients;
    private final AuthService authService;

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        ServerSocket server = null;
        Socket socket;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился ");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert server != null;
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void prvtMsg(String name, String msg, ClientHandler sender) {
        boolean prvtClient = false;
        for (ClientHandler c : clients) {
            if (("@" + c.getNick()).equals(name)) {
                c.sendMsg("(Приват)" + sender.getNick() + ":" + msg);
                sender.sendMsg("(Приват)" + sender.getNick() + ":" + msg);
                prvtClient = true;
            }
        }
        if (!prvtClient) {
            sender.sendMsg("Клиента с таким именем в чате нет!");
        }
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
