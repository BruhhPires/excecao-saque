package model.entities;

import model.excepitions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdraw;
	
	public Account() {
		}

	public Account(Integer number, String holder, Double balance, Double withdraw) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdraw = withdraw;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw (Double amount) {
		validationWithdraw(amount);
		balance -= amount;
	}
	
	private void validationWithdraw (double amount) {
		if(amount > getBalance()) {
			throw new DomainException("Withdraw error: Not enough balance");
		} else if(amount > getWithdraw() ) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limits");
		} 		
	}
	
	@Override
	public String toString() {
		return "New balance: "
				+ String.format("%.2f", getBalance());
	}
}