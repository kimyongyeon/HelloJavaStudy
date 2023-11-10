package com.kyy.java.chapter02;

import lombok.*;

//@Data
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {

    private String ownerName;

    private String accountNumber;

    private double balance;

//    private BankAccount(String ownerName, String accountNumber, double balance) {
//        this.ownerName = ownerName;
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//    }

    public static BankAccount createBankAccount(String ownerName, String accountNumber, double balance) {
        return new BankAccount(ownerName, accountNumber, balance);
    }

    //    deposit(double amount): 잔액에 금액을 추가합니다.
    public void deposit(double amount) {
        balance += amount;
    }
//
//            withdraw(double amount): 잔액에서 금액을 차감합니다. 잔액이 부족할 경우 출금을 할 수 없습니다.
    public void withdraw(double amount) {
        if (balance >= amount && balance > 0) {
            balance -= amount;
        }
    }
//
//            getBalance(): 현재 잔액을 반환합니다.
    public double getBalance() {
        return balance;
    }
//
//            getAccountInfo(): 계좌의 상세 정보를 출력합니다. (예: "Owner: John Doe, Account Number: 123456, Balance: $1000")
    public void getAccountInfo() {
        System.out.println(String.format("Owner: %s, Account Number: %s, Balance: $%f", ownerName, accountNumber, balance));
    }

}
