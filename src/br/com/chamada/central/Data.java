package br.com.chamada.central;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Data {

	Calendar mData;
	Locale   mLocal;
	
	public Data(){
		System.out.println("Criando o Bean =" + Data.class.getName());
		mData = Calendar.getInstance();
		mLocal = Locale.getDefault();
	}
	
	public int getDia(){
		return mData.get(Calendar.DAY_OF_MONTH);
	}
	public String getMes(){
		
		SimpleDateFormat tFormat;
		tFormat = new SimpleDateFormat("MMMM",mLocal);
		return tFormat.format(mData.getTime());
	}
	public int getAno(){
		return mData.get(Calendar.YEAR);
	}
	public String getLocal() {

		return mLocal.getLanguage() + "_" + mLocal.getCountry();
	}
	
	public void setLocal(String pLocale){
		
		String tLingua;
		String tPais;
		StringTokenizer tSep;
		
		tSep = new StringTokenizer(pLocale, ":;;,-_@#$&*+/?");
		tLingua = tSep.nextToken();
		tPais = tSep.nextToken(); 
		
		if(tLingua != null && tPais != null)
			mLocal = new Locale(tLingua,tPais);
	}

	
	
}
