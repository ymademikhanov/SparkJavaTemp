package apis;

import java.util.ArrayList;
import java.util.List;

public class EmailApi {

    private List<String> emails;

    public EmailApi() {
        emails = new ArrayList<>();
    }

    public void addEmail(String email) {
        emails.add(email);
    }
}
