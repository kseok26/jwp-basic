package next.web;

import lombok.Data;
import next.controller.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by young-seok on 2017. 4. 2..
 */
@Data
public class RequestMapping {
    private Map<String, Controller> controller = new HashMap<>();

    RequestMapping() {
        controller.put("/", new HomeController());
        controller.put("/users", new ListUserController());
        controller.put("/users/logout", new LogoutController());
        controller.put("/users/profile", new ProfileController());
        controller.put("/users/form", new ForwardingController("/user/form.jsp"));
        controller.put("/users/create", new CreateUserController());
        controller.put("/users/login", new LoginController());
        controller.put("/users/loginForm", new ForwardingController("/user/login.jsp"));
        controller.put("/users/updateForm", new UpdateUserFormController());
        controller.put("/users/update", new UpdateUserController());
    }

}
