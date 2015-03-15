package de.merz.ieee_754;


import de.merz.ieee_754.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
	 * Menue initialisieren
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Bundle icicle = null;
		super.onCreate(icicle);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Auswahl im Menue
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		
		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text1=(TextView)findViewById(R.id.textView1);
		
		switch (item.getItemId()) {
		case R.id.reset:
			Reset(text1, nField);
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	/**
	 * Hauptmethode fuer den Button zum Umwandeln.
	 */
	public void Calculate(View view){

		
		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text1=(TextView)findViewById(R.id.textView1);
		
		RadioButton rSingle = (RadioButton)findViewById(R.id.radioS);
		
		//Wenn das Feld leer ist wird eine Fehlermeldung in das Feld gesetzt und das Umwandeln wird abgebrochen
		if(CheckFieldEmpty(nField)) return;

		if(rSingle.isChecked()){
			ConvertToSingle(nField,text1);
		}else{
			ConvertToDouble(nField,text1);
		}
		

	}
		
	
	/**
	 * Wandelt eingegebene Zahl in Binaercode in Single Format um und setzt das Ergebniss in Farben formatiert
	 * 
	 * @param fieldToRead EditText mit Zahl die umgewandelt werden soll
	 * @param text1 TextView in die das Ergebnis gesetzt werden soll
	 */
	private void ConvertToSingle(EditText fieldToRead, TextView text1){
		
		int i;
		float number;
		Integer bits;
		String result, show, check;
		String vorzeichen, charakteristik = "", mantisse = "";
		
		number = Float.valueOf(fieldToRead.getText().toString());
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
	 * @param fieldToRead EditText mit Zahl die umgewandelt werden soll
	 * @param text1 TextView in die das Ergebnis gesetzt werden soll
	 * @see ConvertToSingle
	 */
	private void ConvertToDouble(EditText fieldToRead, TextView text1){
		
		int i;
		double number;
		long bits;
		String result, show, check;
		String vorzeichen, charakteristik = "", mantisse = "";
		
		number = Float.valueOf(fieldToRead.getText().toString());
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
	 * Setzt Text und Feld leer
	 * @param tV1 TextView zum leer setzen
	 * @param eT1 EditText zum leer setzen
	 */
	public void Reset(TextView tV1, EditText eT1){
	tV1.setText("");
	tV1.setTextColor(Color.BLACK);
	
	eT1.setText("");
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
