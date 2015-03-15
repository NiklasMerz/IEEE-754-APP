# IEEE-754-APP

Android App zum Anzeigen von Gleitkommazahlen nach IEE 754

<a href="https://play.google.com/store/apps/details?id=de.merz.ieee_754">
  <img alt="Android app on Google Play"
       src="https://developer.android.com/images/brand/de_app_rgb_wo_60.png" />
</a>

Der Nutzer gibt eine Gleitkommazahl ein und bekommt den Binärcode.

<pre><code>
number = Float.valueOf(nField.getText().toString());
bits = Float.floatToRawIntBits(number);
result = "0" + Integer.toBinaryString(bits); //Negative Werte
</code></pre>