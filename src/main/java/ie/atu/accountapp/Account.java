package ie.atu.accountapp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Account {
    @Id
    private String accountId;
    private Double balance;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
