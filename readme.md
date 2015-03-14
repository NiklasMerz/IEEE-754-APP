# IEEE-754-APP

Android App zum Anzeigen von Gleitkommazahlen nach IEE 754

Der Nutzer gibt eine Gleitkommazahl ein und bekommt den Binärcode.

<pre><code>
number = Float.valueOf(nField.getText().toString());
bits = Float.floatToRawIntBits(number);
result = "0" + Integer.toBinaryString(bits); //Negative Werte
</code></pre>