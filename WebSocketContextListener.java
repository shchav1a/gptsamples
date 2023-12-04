import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ServerEndpoint("/your-websocket-endpoint")
@WebListener
public class WebSocketContextListener implements ServletContextListener {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        startPingTask();
        // Initialization logic if needed
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        stopPingTask();
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

    private void startPingTask() {
        executorService.scheduleAtFixedRate(() -> {
            try {
                sendPingMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS); // send ping every 5 seconds
    }

    private void stopPingTask() {
        executorService.shutdown();
    }

    private void sendPingMessage() throws IOException {
        // Send a ping message to the client
        // Note: You might want to implement your ping/pong mechanism
        // For simplicity, this example sends a simple text message
        // You may need to adapt this based on your WebSocket protocol
        // For example, you might want to use the session's `getBasicRemote().sendPing()` method
        // for a proper ping/pong mechanism.
        for (Session session : this.session.getOpenSessions()) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText("ping");
            }
        }
    }
}
