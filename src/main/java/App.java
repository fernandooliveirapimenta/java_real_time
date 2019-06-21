import br.com.fernando.WebSocketServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class App {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ResourceHandler rh = new ResourceHandler();
        rh.setResourceBase(App.class.getClassLoader()
                .getResource("html").toExternalForm());

        WebSocketServlet webSocket = new WebSocketServlet();
        ServletHolder sh = new ServletHolder(webSocket);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(sh, "/chat/*");

        HandlerList list = new HandlerList();
        list.setHandlers(new Handler[]{rh, handler});
        server.setHandler(list);
        server.start();
    }
}
