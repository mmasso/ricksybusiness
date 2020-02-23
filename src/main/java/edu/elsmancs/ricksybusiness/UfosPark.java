package edu.elsmancs.ricksybusiness;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private final double fee = 500.0;
    private Map<String, CreditCard> flota = new HashMap<>();

    UfosPark() {
    };

    void add(String ufoID) {
        this.flota.put(ufoID, null);
    }

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

    private void require(Boolean holds) throws Exception {
        if (!holds) {
            throw new Exception();
        }
    }

    // metodo para comprovar si hay algun ufo sin CreditCard asignada //

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

    private boolean isTarjetaNoAsignada(CreditCard creditCard){
        for (String ufoID : flota.keySet()) {
            if (flota.get(ufoID) == creditCard) {
                return false;
            }
        }
        return true;
    }
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

    @Override
    public String toString() {
        return flota.keySet().toString();
    }
}
