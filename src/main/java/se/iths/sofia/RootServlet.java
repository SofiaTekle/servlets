package se.iths.sofia;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.WebContext;

import java.io.IOException;

public class RootServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        WebContext ctx = new WebContext(req, resp, req.getServletContext());
        ThymeleafConfig.getEngine().process("index", ctx, resp.getWriter());
    }
}
