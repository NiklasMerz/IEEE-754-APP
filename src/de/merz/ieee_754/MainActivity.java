package de.merz.ieee_754;


import de.merz.ieee_754.R;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("unused")
public class MainActivity extends Activity{

	int i;
	float number;
	Integer bits;
	String result, check;
	String vorzeichen, charakteristik, mantisse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Calculate(View view){

		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text1=(TextView)findViewById(R.id.textView1);
		TextView text2=(TextView)findViewById(R.id.textView2);
		TextView text3=(TextView)findViewById(R.id.textView3);
		TextView text4=(TextView)findViewById(R.id.textView4);

		Delete();

		number = Float.valueOf(nField.getText().toString());
		bits = Float.floatToRawIntBits(number);
		result = "0" + Integer.toBinaryString(bits); //Negative Werte

		char[] chars = result.toCharArray();

		vorzeichen = Character.toString(chars[0]);

		for(i = 1; i <= 8; i++){
			charakteristik = charakteristik + Character.toString(chars[i]);			
		}

		for(i = 9; i <= 31; i++){
			mantisse = mantisse + Character.toString(chars[i]);			
		}

		text1.setText(vorzeichen);
		text1.setTextColor(Color.RED);

		text2.setText(charakteristik);
		text2.setTextColor(Color.YELLOW);

		text3.setText(mantisse);
		text3.setTextColor(Color.GREEN);
		
		check = vorzeichen + charakteristik + mantisse;

		if(result.equals(check)){
			text4.setText("true");
		}else{
			text4.setText(result + "/" + System.getProperty ("line.separator") + check + "//" + chars.length);
		}

	}

	private void Delete(){

		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text1=(TextView)findViewById(R.id.textView1);
		TextView text2=(TextView)findViewById(R.id.textView2);
		TextView text3=(TextView)findViewById(R.id.textView3);
		TextView text4=(TextView)findViewById(R.id.textView4);

		text1.setText(vorzeichen);
		text2.setText(charakteristik);
		text3.setText(mantisse);
		text4.setText(result);

		number = 0;
		bits = 0;
		result = "";
		vorzeichen = "";
		charakteristik = "";
		mantisse = "";
	}



}
