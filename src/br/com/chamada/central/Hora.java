package br.com.chamada.central;

import java.util.Calendar;

public class Hora {

	Calendar mData;

	public Hora() {

		System.out.println("Criando o Bean =" + Hora.class.getName());
		mData = Calendar.getInstance();
	}

	public int getHora() {

		return mData.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinuto() {
		return mData.get(Calendar.MINUTE);
	}

	public int getSegundo() {
		return mData.get(Calendar.SECOND);
	}
}
