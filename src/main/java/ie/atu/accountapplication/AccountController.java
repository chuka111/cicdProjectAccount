package ie.atu.accountapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountNumber) {
        Account account = accountService.getAccount(Long.valueOf(accountNumber));

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 if account not found
        }

        return new ResponseEntity<>(account, HttpStatus.OK);  // Return the account with 200 OK
    }


    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/{accountNumber}")
    public Account updateAccount(@PathVariable Long accountNumber, @RequestBody Account account) {
        Account existingAccount = accountService.getAccount(Long.valueOf(accountNumber));
        existingAccount.setBalance(account.getBalance());
        return accountService.saveAccount(existingAccount);
    }

}