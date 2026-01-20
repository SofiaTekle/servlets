
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

        String path = req.getPathInfo();
        String name = (path != null && path.length() > 1) ? path.substring(1) : "världen";

        WebContext ctx = new WebContext(req, resp, req.getServletContext());
        ctx.setVariable("name", name);

        ThymeleafConfig.getEngine().process("hello", ctx, resp.getWriter());



        // Två sätt att ta emot "name" från URL:
        // 1) Query parameter: /hello?name=Sofia

        //  String name = req.getParameter("name");
        //  resp.getWriter().println("Hej " + name);

        // 2) Path-parameter:   /hello/Sofia (utan ?)
        // kolla om värdet finns och ta bort / från värdet
//        String path = req.getPathInfo();
//        String name = (path != null && path.length() > 1) ? path.substring(1) : "";
//
//        resp.getWriter().println("Hej " + name);
    }
}
