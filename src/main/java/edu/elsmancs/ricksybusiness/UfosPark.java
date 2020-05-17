package edu.elsmancs.ricksybusiness;

import java.util.HashMap;
import java.util.Map;

/**
 * Ufos Park representa una flota de ovnis (taxis) esperando a ser despachados hacia un cliente.
 * @author Mateu Massó
 */

public class UfosPark implements GuestDispatcher{
    private final double fee = 500.0;
    private Map<String, CreditCard> flota = new HashMap<>();

    /**
     * El constructor vacio por defecto para iniciar la class UfosPark
     */
    UfosPark() {
    };

    /**
     * Método usado para añadir cada UFO a la flota general.
     * @param ufoID Especifica la Id de cada UFO
     */
    void add(String ufoID) {
        this.flota.put(ufoID, null);
    }

    /**
     * Método usado para assignar a cada nuevo cliente, un UFO.
     * 
     * @throws Exception Cuando la creditCard no cumple los requisitos, no hay UFOS libres o ya estaba asignada.
     * @param creditCard Tarjeta de credito identificativa de cada cliente.
     */
    public void dispatch(CreditCard creditCard) {
        try {
            require(isAlgunoLibre());
            // comprueba si hay credito //
            require(creditCard.credit() >= fee);
            require(isTarjetaNoAsignada(creditCard));
            String ufoLibreId = null;
            for (String ufoID : flota.keySet()) {
                if (flota.get(ufoID) == null) {
                    ufoLibreId = ufoID;
                }
            }
            flota.put(ufoLibreId, creditCard);
            creditCard.pay(fee);
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
     * metodo para comprobar si hay algun ufo libre
     * @return boolean para comprobar si el ufo estaba libre
     */
    private boolean isAlgunoLibre() {
        int ufosOcupados = 0;
        for (CreditCard card : flota.values()) {
            if (card != null) {
                ufosOcupados += 1;
            }
        }
        if (ufosOcupados != flota.size()) {
            return true;
        }
        else { 
            return false;
        }
    }

    /**
     * Metodo para comprobar si la tarjeta de credito del cliente esta asignada ya o no.
     * @param creditCard Tarjeta de credito identificativa de cada cliente.
     * @return boolean que nos dice si la tarjeta tenia ufo asignado
     */
    private boolean isTarjetaNoAsignada(CreditCard creditCard){
        for (String ufoID : flota.keySet()) {
            if (flota.get(ufoID) == creditCard) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para obtener el UFO asignada de una CreditCardNumber dada
     * @param creditCardNumber el numero de la creditcard
     * @return devuelve el ufo asignado o null si no lo tiene
     */
    public String getUfoOf(String creditCardNumber) {
        String ufoOf = "null";
        for (String ufoID : flota.keySet()) {
            CreditCard credit = new CreditCard();
            if (flota.get(ufoID) != null){
                credit = flota.get(ufoID);
                if (credit.number() == creditCardNumber) {
                    ufoOf = ufoID;
                }
            };
        }
		return ufoOf;
    }

    /**
     * @Override del metodo toString() para imprimir la flota de ufos completa.
     */
    @Override
    public String toString() {
        return flota.keySet().toString();
    }
}
