package edu.elsmancs.ricksybusiness;

/**
 * Clase para vender los cristales a sus compradores
 * @author Mateu Massó
 */
public class CrystalExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemPrice = 0;

    /**
     * Constructor de la clase Crystal expender
     * @param stock le indicamos la cantidad de cristales que la tienda podra vender
     * @param price le indicamos el precio unitario del cristal
     */
	public CrystalExpender(int stock, double price) {
        this.stock = stock;
        this.itemPrice = price;
	}

    /**
     * Método usado para assignar a cada nuevo cliente, un cristal.
     * 
     * captura exception cuando la creditCard no cumple los requisitos lanza exception
     * @param creditCard Tarjeta de credito identificativa de cada cliente.
     */
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

    /**
     * Método requerido para controlar las excepciones que pueda lanzar el método dispatch
     * @param holds boolean para comprobar lanzar la excepción
     * @throws Exception
     */
    private void require(Boolean holds) throws Exception {
        if (!holds) {
            throw new Exception();
        }
    }

    /**
     * @return devuelve el stock de cristales
     */
    public int stock() {
        return stock;
    }

    /**
     * Overdrive del toString() base para imprimir el stock y el precio unitario de los cristales
     */
    @Override
    public String toString() {
        return "stock: " + stock + "\n" +
            "cost: " + itemPrice + "\n";
    }
	

}
