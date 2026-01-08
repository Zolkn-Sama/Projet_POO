package Projet_POO.Domain.Entity;

public class Money {

    private double amount;
    private String currency;

    public Money() {
        this.currency = "EUR";
    }

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
