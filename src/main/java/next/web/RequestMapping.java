package next.web;

import lombok.Data;
import next.controller.*;

import java.util.Map;

/**
 * Created by young-seok on 2017. 4. 2..
 */
@Data
public class RequestMapping {
    private Map<String, Controller> mappingUrl;

    RequestMapping(){
        mappingUrl.put("", new HomeController());
        mappingUrl.put("/users", new ListUserController());
        mappingUrl.put("/users/logout", new LogoutController());
        mappingUrl.put("/users/profile", new ProfileController());
        mappingUrl.put("/users/form", new ForwardingController("/users/form.jsp"));
        mappingUrl.put("/users/create", new CreateUserController());
        mappingUrl.put("/users/login", new LoginController());
        mappingUrl.put("/users/updateForm", new ForwardingController("/user/updateForm.jsp"));
        mappingUrl.put("/users/update", new UpdateUserController());
    }
}
