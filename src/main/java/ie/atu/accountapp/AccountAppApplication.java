package ie.atu.accountapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountAppApplication.class, args);
    }

}
