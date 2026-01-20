package se.iths.sofia;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        // Starta webbservern på port 8080
        Server server = new Server(8080);

        // Context för servlets
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Registrera servlets
        context.addServlet(RootServlet.class, "/");
        context.addServlet(HelloServlet.class, "/hello");
        context.addServlet(HelloServlet.class, "/hello/*");

        server.setHandler(context);

        // Starta servern
        server.start();
        server.join();
    }
}
