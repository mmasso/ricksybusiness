package edu.elsmancs.ricksybusiness;

public class CrystalExpender {

    private int stock = 0;
    private double itemPrice = 0;

	public CrystalExpender(int stock, double price) {
        this.stock = stock;
        this.itemPrice = price;
	}

    void dispatch(CreditCard creditCard) {
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
	

}
