package com.kyy.java.chapter02;

import javax.swing.text.BadLocationException;
import java.util.Scanner;

public class Chapter02 {
    public static void main(String[] args) {
        BankAccount bankAccount1 = BankAccount.createBankAccount("홍길동", "123456", 1000);
        bankAccount1.deposit(100);
        bankAccount1.getAccountInfo();
        bankAccount1.withdraw(100);
        bankAccount1.getAccountInfo();

        BankAccount bankAccount2 = BankAccount.createBankAccount("홍길순", "123457", 1000);
        bankAccount2.deposit(100);
        bankAccount2.getAccountInfo();
        bankAccount2.withdraw(100);
        bankAccount2.getAccountInfo();

        throw new CustomException("Custom Exception Test");

    }
}
