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
	
	float number;
	Integer bits;
	String result; 
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void Calculate(View view){
		
		EditText nField = (EditText)findViewById(R.id.editText1);
		TextView text=(TextView)findViewById(R.id.textView1);
		
		number = Float.valueOf(nField.getText().toString());
		bits = Float.floatToRawIntBits(number);
		result = Integer.toBinaryString(bits);
		
		text.setText(result);
		
	}
	
	
	
	

	}
