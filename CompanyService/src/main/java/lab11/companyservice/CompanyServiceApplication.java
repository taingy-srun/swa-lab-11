package lab11.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@SpringBootApplication
public class CompanyServiceApplication implements CommandLineRunner {



    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(@Qualifier("oauth2ClientContext") OAuth2ClientContext oAuth2ClientContext,
                                                 OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oAuth2ClientContext);
    }

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }


}
