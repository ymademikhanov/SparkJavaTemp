
import apis.EmailApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Redirect;

import static spark.Spark.*;

public class HelloWorld {

    private static Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        get("/hello", (request, response) -> {
            return "Hello";
        });

        get("/say/*/to/*", (request, response) -> {
            String sentence = "";
            for (int i = 0; i < request.splat().length; i++)
                sentence += request.splat()[i];
            return "Splat is " + sentence;
        });

        redirect.get("/api/email/getit", "/api/email/get", Redirect.Status.MOVED_PERMANENTLY);

        path("/api", () -> {
            before("/*", (q, a) -> log.info("Received api call"));
            path("/email", () -> {
                before("/*", (q, a) -> log.info("Received api call for email"));
                get("/get", (request, response) -> {

                    return "got";
                });
                post("/add", (request, response) -> { return "added"; });
                put("/change", (request, response) -> { return "changed"; });
                delete("/remove", (request, response) -> { return "deleted"; });
            });
        });
    }
}
