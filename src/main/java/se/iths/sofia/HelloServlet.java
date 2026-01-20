
package se.iths.sofia;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.WebContext;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");


        /*
         * 1) Försök hämta namn från query parameter
         *    Ex: /hello?name=Sofia
         */
        String name = req.getParameter("name");

        /*
         * 2) Om inget namn skickats via formulär:
         *    försök hämta från URL-path
         *    Ex: /hello/Sofia
         */
        if (name == null || name.isBlank()) {
            String path = req.getPathInfo();
            if (path != null && path.length() > 1) {
                name = path.substring(1); // ta bort "/"
            } else {
                name = "världen"; // default
            }
        }

        // Skapa Thymeleaf-context och skicka med variabeln
        WebContext ctx = new WebContext(req, resp, req.getServletContext());
        ctx.setVariable("name", name);

        // Rendera hello.html
        ThymeleafConfig.getEngine().process("hello", ctx, resp.getWriter());



    }
}
