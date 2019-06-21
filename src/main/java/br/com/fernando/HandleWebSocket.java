package br.com.fernando;

import org.eclipse.jetty.websocket.WebSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HandleWebSocket implements WebSocket.OnTextMessage {

    Connection con;
    private  static List<HandleWebSocket> list = new ArrayList<>();
    @Override
    public void onMessage(String data) {


        for (HandleWebSocket hd: list) {
            try {
                hd.con.sendMessage(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("mensagem: " + data);
    }

    @Override
    public void onOpen(Connection connection) {

        this.con = connection;

        list.add(this);

        System.out.println("conectado...");

    }

    @Override
    public void onClose(int closeCode, String message) {

        list.remove(this);
        System.out.println("fechado");
    }
}
