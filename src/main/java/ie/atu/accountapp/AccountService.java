package ie.atu.accountapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<Double> getBalance(@PathVariable String accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(account.get().getBalance());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        if (accountRepository.existsById(account.getAccountId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account already exists");
        }
        accountRepository.save(account);
        return ResponseEntity.ok("Account created");
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
        if (!accountRepository.existsById(accountId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        accountRepository.deleteById(accountId);
        return ResponseEntity.ok("Account deleted");
    }

}
