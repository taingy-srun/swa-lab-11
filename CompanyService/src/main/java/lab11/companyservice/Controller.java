package lab11.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    OAuth2RestTemplate restTemplate;

    @GetMapping("/product")
    public String getProduct() {
        return "Product data";
    }

    @GetMapping("/salary")
    public String getSalary() {
        return restTemplate.getForObject("http://localhost:8081/salary", String.class);
    }

    @GetMapping("/contact")
    public String getContact() {
        return restTemplate.getForObject("http://localhost:8082/contact", String.class);
    }
}
