package ie.atu.accountapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Autowired
    public DataLoader(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Account num1 = new Account("chuka",123000.0);
        Account num2 = new Account("john",321000.0);
        accountRepository.save(num1);
        accountRepository.save(num2);

    }

}
