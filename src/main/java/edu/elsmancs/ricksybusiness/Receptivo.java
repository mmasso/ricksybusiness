package edu.elsmancs.ricksybusiness;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {

	List<GuestDispatcher> dispatches = new ArrayList<>();

    Receptivo(){};

	public void registra(GuestDispatcher dispatch) {
		this.dispatches.add(dispatch) ;
	}

	public void dispatch(CreditCard user) {
		dispatches.forEach( type -> type.dispatch(user)) ;
	}
}
