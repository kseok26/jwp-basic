package next.web;

import next.controller.CreateUserController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by young-seok on 2017. 4. 2..
 */
@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DIspatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);
    private static final String PREFIX_REDIRECT = "redirect:";
    private RequestMapping mapping;

    @Override
    public void init() throws ServletException {
        mapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String url;
        try {
            url = mapping.getController().get(req.getRequestURI()).excute(req, resp);
            moveUrl(url, req, resp);
        } catch (Exception e) {
            log.debug("mapping Error : {} ", e);
        }
    }

    private void moveUrl(String url, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtils.startsWith(url, PREFIX_REDIRECT)) {
            response.sendRedirect(StringUtils.substring(url, PREFIX_REDIRECT.length()));
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}
