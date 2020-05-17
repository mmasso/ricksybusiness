package edu.elsmancs.ricksybusiness;

/**
 * La clase CreditCard se usa para identificar a cada usuario y su saldo monetario
 * @author Mateu Massó
 */
public class CreditCard {
    private String owner = null;
    private String number = null;
    private double credit = 3000;
    private static final String SYMBOL = "EZI";

    /**
     * Constructor de la credit card donde le pasamos dos parametros
     * @param owner El nombre del usuario de la tarjeta
     * @param number El numero de la tarjeta de credito
     */
    CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
    }

    /**
     * Constructor por defecto
     */
    public CreditCard() {
	}

    /**
     * Override del string por defecto para imprimir nuestras necesidades
     */
	@Override
    public String toString() {
        return "owner: " + owner + "\n" +
            "number: " + number + "\n" + 
            "credit: " + credit + SYMBOL + "\n";
    }

    /**
     * @return el numero de la tarjeta
     */
    public String number() {
        return number;
    }

    /**
     * @return el credito de la tarjeta monetario
     */
    public double credit() {
        return credit;
    }
    
    /**
     * Metodo para cobrar a la tarjeta el dinero que le pedimos si esta tiene saldo
     * @param fee El dinero que se debe cobrar a la tarjeta.
     */
	public void pay(double fee) {
        if (this.credit > 0.0){
            this.credit -= fee;}
    }
    
    /**
     * @return el nombre del usuario de la tarjeta
     */
    public String getOwner() {
        return owner;
    }
}
