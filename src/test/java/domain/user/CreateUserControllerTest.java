package domain.user;

import db.DataBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webserver.controller.Controller;
import webserver.http.request.HttpRequest;
import webserver.http.response.HttpResponse;
import webserver.http.response.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static support.FileSupporter.read;
import static support.FileSupporter.write;

class CreateUserControllerTest {

    private static final Controller CREATE_USER_CONTROLLER = new CreateUserController();

    @DisplayName("유저 생성에 성공한다.")
    @Test
    void createUserSuccess() throws Exception {
        // when
        createUser();
        final User user = DataBase.findUserById("jaeyeonling");

        // then
        assertThat(user.getUserId()).isEqualTo("jaeyeonling");
    }

    public static void createUser() throws Exception {
        try (final Response response = HttpResponse.of(write("CreateUser_Response.txt"))) {
            CREATE_USER_CONTROLLER.service(HttpRequest.of(read("CreateUser_Request.txt")), response);
        }
    }
}
