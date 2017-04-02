package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by young-seok on 2017. 4. 2..
 */
public interface Controller {
    String excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
