package de.merz.ieee_754;


import de.merz.ieee_754.R;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Eine App zum Anzeigen des Binaercodes eines Float/Single Wertes
 * @author Niklas Merz
 * @version 1.0

 */

@SuppressWarnings("unused")
public class MainActivity extends Activity{

	int i;
	float number;
	Integer bits;
	String result, show, check;
	String vorzeichen, charakteristik, mantisse;

	/**
	 * Initialisieren
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * Hauptmethode fuer den Button zum Umwandeln.
	 */
	public void Calculate(View view){

		
		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text1=(TextView)findViewById(R.id.textView1);
		TextView text4=(TextView)findViewById(R.id.textView4);
		
		Delete();
		if(checkFieldEmpty(nField) == true) return;

		number = Float.valueOf(nField.getText().toString());
		bits = Float.floatToRawIntBits(number);
		result = Integer.toBinaryString(bits);
		
		//Führende Nullen
		for(i = result.length(); i < 32; i++){
			result = "0" + result; 
		}

		char[] chars = result.toCharArray();

		vorzeichen = Character.toString(chars[0]);

		for(i = 1; i <= 8; i++){
			charakteristik = charakteristik + Character.toString(chars[i]);			
		}

		for(i = 9; i <= 31; i++){
			mantisse = mantisse + Character.toString(chars[i]);			
		}


		show = "<font color='red'>" + vorzeichen + "</font>" + "<font color='yellow'>" + charakteristik + "</font>" + "<font color='green'>" + mantisse + "</font>";		
		text1.setText(Html.fromHtml(show), TextView.BufferType.SPANNABLE);

		check = vorzeichen + charakteristik + mantisse;
		
		showDebuggString(text4, false, chars);

	}

	/**
	 * Setzt alle Variablen zurueck
	 */
	private void Delete(){

		number = 0;
		bits = 0;
		result = "";
		vorzeichen = "";
		charakteristik = "";
		mantisse = "";
	}

	/**
	 * Funktion zum Ueberpruefen von Feldern

	 * @param field Feld das ueberprueft wird
	 * @return true wenn das Feld leer ist, false wenn das Feld einen Wert enthaelt
	 */
	public boolean checkFieldEmpty(EditText field){

		if(field.getText().toString().length()  == 0){
			field.requestFocus();
			field.setError("Bitte eine Zahl eingeben");
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Zeigt einen String zum Analysieren von Fehlern an
	 * @param text Textview in die der Debugstring geschrieben werden soll
	 * @param showalways true setzt den Debugstring immer, false nur wenn sich der zusammengesetzte Wert unterscheidet
	 * @param chars[] Laenge des Binaercodes 
	 */
	private void showDebuggString(TextView text, Boolean showalways, char chars[]){
		
		if(result.equals(check) & showalways == false){
			text.setText("");
		}else{
			text.setText(result + "/" + System.getProperty ("line.separator") + check + "//" + chars.length);
		}
		
		if(showalways == true) text.setText(result + "/" + System.getProperty ("line.separator") + check + "//" + chars.length);;
	}



}
