package ie.atu.accountapplication;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {
    private final Map<String, Account> accounts = new HashMap<>();
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account getAccount(Long accountNumber) {
        return accountRepository.findById(Long.valueOf(accountNumber))
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }


    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
