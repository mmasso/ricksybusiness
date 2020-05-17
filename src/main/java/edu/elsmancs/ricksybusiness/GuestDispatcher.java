package edu.elsmancs.ricksybusiness;


/**
 * Interfaz para que todas las classes de la cual heredan incluyan el metodo dispatch
 * @author Mateu Massó
 */
public interface GuestDispatcher {

   /**
    * El metodo dispatch es usado para poder aplicar cargos de un determinado producto a una creditCard dada
    * @param creditCard Tarjeta de credito que contiene el dinero de un cliente particular.
    */
   public void dispatch(CreditCard creditCard);

}
