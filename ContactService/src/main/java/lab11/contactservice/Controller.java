package lab11.contactservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/contact")
    public String getContact() {
        return "Contact data";
    }
}
