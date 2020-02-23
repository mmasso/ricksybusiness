package edu.elsmancs.ricksybusiness;

public class CreditCard {
    private String owner = null;
    private String number = null;
    private double credit = 3000;
    private final String SYMBOL = "EZI";

    CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
    }

    public CreditCard() {
	}

	@Override
    public String toString() {
        return "owner: " + owner + "\n" +
            "number: " + number + "\n" + 
            "credit: " + credit + SYMBOL + "\n";
    }

    // TESTEAR //
    /**
     * @return the number
     */
    public String number() {
        return number;
    }

    /**
     * @return the credit
     */
    public double credit() {
        return credit;
    }
    
	public void pay(double fee) {
        this.credit -= fee;
	}
}
