package edu.elsmancs.ricksybusiness;

import java.util.ArrayList;
import java.util.List;

public class RickMenu implements GuestDispatcher {

    private int stock = 0;
    private double itemPrice = 0;
    List<String> buyers = new ArrayList<>();

	public RickMenu(int stock, double price) {
        this.stock = stock;
        this.itemPrice = price;
	}

    public void dispatch(CreditCard creditCard) {
        try {
            // comprueba si hay credito //
            require(creditCard.credit() >= itemPrice);
            require(stock > 0);
            creditCard.pay(itemPrice);
            this.stock -= 1;

        } catch (Exception e) {
            /* pues nada */
        }
    }

    private void require(Boolean holds) throws Exception {
        if (!holds) {
            throw new Exception();
        }
    }

    /**
     * @return the stock
     */
    public int stock() {
        return stock;
    }

    @Override
    public String toString() {
        return "stock: " + stock + "\n" +
            "cost: " + itemPrice + "\n";
    }
    
    void addBuyer(CreditCard creditCard){
        buyers.add(creditCard.getOwner());
    }

    String getAllBuyers(){
        return buyers.toString();
    }
}