package br.com.fernando;

import org.eclipse.jetty.websocket.WebSocket;

import javax.servlet.http.HttpServletRequest;

public class WebSocketServlet extends org.eclipse.jetty.websocket.WebSocketServlet {

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        return new HandleWebSocket();
    }
}
