import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@ServerEndpoint("/your-websocket-endpoint")
@WebListener
public class WebSocketContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialization logic if needed
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup logic if needed
    }

    @OnOpen
    public void onOpen(Session session) {
        // Handle connection opening
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle incoming messages
    }

    @OnClose
    public void onClose(Session session) {
        // Handle connection closing
    }

    @OnError
    public void onError(Throwable error) {
        // Handle errors
    }
}
