package com.card.forexapp.dto;

public class paymentDTO {
	
private Integer amount;
	
	paymentDTO(){
		
	}
	
	paymentDTO( Integer amount){
		this.amount = amount;
	}

	public Integer getMoney() {
		return amount;
	}

	public void setMoney(Integer money) {
		this.amount = money;
	}

}
