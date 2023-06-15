package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.excepitions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account Data: ");
		System.out.printf("Number: ");
		Integer number = sc.nextInt();
		System.out.printf("Holder: ");
		String holder = sc.next();
		sc.nextLine();
		System.out.printf("Initial Balance: ");
		Double balance = sc.nextDouble();
		System.out.printf("Withdraw Limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		
		System.out.printf("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		account.withdraw(amount);
		System.out.println(account);
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
			}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
