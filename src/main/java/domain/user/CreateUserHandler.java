package domain.user;

import db.DataBase;
import model.User;
import webserver.handler.Handler;
import webserver.http.request.Request;
import webserver.http.response.Response;

public class CreateUserHandler implements Handler {

    @Override
    public void handle(final Request request,
                       final Response response) {
        final String userId = request.getBody("userId");
        final String password = request.getBody("password");
        final String name = request.getBody("name");
        final String email = request.getBody("email");

        final User user = new User(userId, password, name, email);
        DataBase.addUser(user);

        response.redirect("/index.html");
    }
}
