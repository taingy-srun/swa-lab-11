package lab11.salaryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/salary")
    public String getSalary() {
        return "Salary data";
    }

}
