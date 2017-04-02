package next.controller;

import core.db.DataBase;
import next.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by young-seok on 2017. 4. 2..
 */
public class ForwardingController implements Controller {
    private String forwardUrl;

    public ForwardingController(String forwadUrl) {
        this.forwardUrl = forwadUrl;
        if(StringUtils.isEmpty(forwadUrl)){
            throw new NullPointerException("forwardUrl is empty");
        }
    }

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwardUrl;
    }
}
