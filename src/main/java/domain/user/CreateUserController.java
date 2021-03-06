package domain.user;

import db.DataBase;
import webserver.controller.AbstractController;
import webserver.http.request.Request;
import webserver.http.response.Response;

public class CreateUserController extends AbstractController {

    public static final String PATH = "/user/create";

    @Override
    protected void doPost(final Request request,
                          final Response response) {
        final String userId = request.getParameter("userId");
        final String password = request.getParameter("password");
        final String name = request.getParameter("name");
        final String email = request.getParameter("email");

        final User user = new User(userId, password, name, email);
        DataBase.addUser(user);

        response.sendRedirect("/index.html");
    }
}
