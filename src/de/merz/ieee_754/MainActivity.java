package de.merz.ieee_754;


import de.merz.ieee_754.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * Eine App zum Anzeigen des Binaercodes eines Float/Single und Double Wertes
 * @author Niklas Merz
 * @version 1.5

 */


public class MainActivity extends Activity{

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
		RadioButton rSingle = (RadioButton)findViewById(R.id.radioS);
		
		String value = nField.getText().toString();		
		
		//Wenn das Feld leer ist wird eine Fehlermeldung in das Feld gesetzt und das Umwandeln wird abgebrochen
		if(CheckFieldEmpty(nField)) return;
		//Wechsel auf 2. Seite
		setContentView(R.layout.second);
		TextView shownumber = (TextView)findViewById(R.id.tvNumber);
		shownumber.setText("Dezimalwert: " + value);
		
		//In Single oder Double umwandeln und Binärcode setzten
		if(rSingle.isChecked()){
			ConvertToSingle(value);
		}else{
			ConvertToDouble(value);
		}
	}


	/**
	 * Wandelt eingegebene Zahl in Binaercode in Single Format um und setzt das Ergebniss in Farben formatiert
	 * 
	 * @param value Zahl die umgewandelt werden soll
	 * @param text1 TextView in die das Ergebnis gesetzt werden soll
	 */
	private void ConvertToSingle(String value){

		TextView text1=(TextView)findViewById(R.id.textView1);
		
		int i;
		float number;
		Integer bits;
		String result, show, check;
		String vorzeichen, charakteristik = "", mantisse = "";

		number = Float.valueOf(value);
		bits = Float.floatToRawIntBits(number);
		result = Integer.toBinaryString(bits);

		//Führende Nullen
		for(i = result.length(); i < 32; i++){
			result = "0" + result; 
		}

		char[] chars = result.toCharArray();

		//String in Bestandteile zerlegen um Farben für die einzelnen Komponenten setzten zu können
		vorzeichen = Character.toString(chars[0]);

		for(i = 1; i <= 8; i++){
			charakteristik = charakteristik + Character.toString(chars[i]);			
		}

		for(i = 9; i <= 31; i++){
			mantisse = mantisse + Character.toString(chars[i]);			
		}



		show = "<font color='red'>" + vorzeichen + "</font>" + "<font color='yellow'>" + charakteristik + "</font>" + "<font color='green'>" + mantisse + "</font>";		

		text1.setText(Html.fromHtml(show), TextView.BufferType.SPANNABLE);

		//Nur zum testen
		check = vorzeichen + charakteristik + mantisse;
		ShowDebuggString((TextView)findViewById(R.id.textView4), false, chars, result, check);

	}

	/**
	 * Wandelt eingegebene Zahl in Binaercode in Double Format um und setzt das Ergebniss in Farben formatiert
	 * 
	 * @param value Zahl die umgewandelt werden soll
	 * @param text1 TextView in die das Ergebnis gesetzt werden soll
	 * @see ConvertToSingle
	 */
	private void ConvertToDouble(String value){

		TextView text1=(TextView)findViewById(R.id.textView1);
		
		int i;
		double number;
		long bits;
		String result, show, check;
		String vorzeichen, charakteristik = "", mantisse = "";

		number = Float.valueOf(value);
		bits = Double.doubleToLongBits(number);
		result = Long.toBinaryString(bits);

		//Führende Nullen
		for(i = result.length(); i < 64; i++){
			result = "0" + result; 
		}

		char[] chars = result.toCharArray();

		//String zerlegen
		vorzeichen = Character.toString(chars[0]);

		for(i = 1; i <= 11; i++){
			charakteristik = charakteristik + Character.toString(chars[i]);			
		}

		for(i = 12; i <= 63; i++){
			mantisse = mantisse + Character.toString(chars[i]);			
		}


		show = "<font color='red'>" + vorzeichen + "</font>" + "<font color='yellow'>" + charakteristik + "</font>" + "<font color='green'>" + mantisse + "</font>";		
		text1.setText(Html.fromHtml(show), TextView.BufferType.SPANNABLE);

		//Nur zum testen
		check = vorzeichen + charakteristik + mantisse;
		ShowDebuggString((TextView)findViewById(R.id.textView4), false, chars, result, check);

	}


	/**
	 * Funktion zum Ueberpruefen von Feldern, Setzt einen Fehlertext in das Feld, wenn es leer ist.

	 * @param field Feld das ueberprueft wird
	 * @return true wenn das Feld leer ist, false wenn das Feld einen Wert enthaelt
	 */
	public boolean CheckFieldEmpty(EditText field){

		if(field.getText().toString().length()  == 0){
			field.requestFocus();
			field.setError("Bitte eine Zahl eingeben");
			return true;
		}else{
			return false;
		}
	}


	/**
	 * Setzt die Startseite
	 * @param view
	 */
	public void Back(View view){
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * Setzt Startseite bei Druck auf Zurueck Knopf
	 */
	public boolean onKeyDown(int keyCode,KeyEvent event ){

		if(keyCode == KeyEvent.KEYCODE_BACK){

			setContentView(R.layout.activity_main);
		}
		return false;
	}

	/**
	 * Zeigt einen String zum Analysieren von Fehlern an
	 * @param text Textview in die der Debugstring geschrieben werden soll
	 * @param showalways true setzt den Debugstring immer, false nur wenn sich der zusammengesetzte Wert unterscheidet
	 * @param chars Array-Laenge des Binaercodes
	 * @param result Ganzes Ergebnis
	 * @param check	Zusammengeseztes Ergebnis	
	 */
	protected void ShowDebuggString(TextView text, Boolean showalways, char chars[], String result, String check){

		if(result.equals(check) & showalways == false){
			text.setText("");
		}else{
			text.setText(result + "/" + System.getProperty ("line.separator") + check + "//" + chars.length);
		}

		if(showalways == true) text.setText(result + "/" + System.getProperty ("line.separator") + check + "//" + chars.length + "v" + check.length());;
	}

}
