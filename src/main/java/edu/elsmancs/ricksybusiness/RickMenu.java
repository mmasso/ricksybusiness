package edu.elsmancs.ricksybusiness;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para vender un menu a sus compradores
 * @author Mateu Massó
 */
public class RickMenu implements GuestDispatcher {

    private int stock = 0;
    private double itemPrice = 0;
    List<String> buyers = new ArrayList<>();

    /**
     * Constructor de la clase rickmenu
     * @param stock le indicamos la cantidad de menus de la que dispondra
     * @param price le indicamos el precio unitario del menu
     */
	public RickMenu(int stock, double price) {
        this.stock = stock;
        this.itemPrice = price;
    }
    
    /**
     * Método usado para assignar a cada nuevo cliente, un menu.
     * 
     * @throws Exception Cuando la creditCard no cumple los requisitos lanza exception
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
     * @return devuelve el stock del que dispone RickMenu
     */
    public int stock() {
        return stock;
    }
    
    /**
     * Overdrive del toString() base para imprimir el stock y el precio unitario del menu
     */
    @Override
    public String toString() {
        return "stock: " + stock + "\n" +
            "cost: " + itemPrice + "\n";
    }
    
    /**
     * Metodo para añadir el nombre de un comprador a la lista de compradores
     * @param creditCard Tarjeta de credito identificativa de cada cliente.
     */
    void addBuyer(CreditCard creditCard){
        buyers.add(creditCard.getOwner());
    }

    /**
     * Metodo para obtener una lista de los nombres de todos los compradores del RickMenu
     * @return devuelve una String con todos los compradores del RickMenu
     */
    String getAllBuyers(){
        return buyers.toString();
    }
}