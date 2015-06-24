# IEEE-754-APP

<code> Only available in German</code><br>

Ein Beispiel wie man mit Java die Umwandlung in Binärcode darstellen kann. Der Code dient als Beispiel für eine Programmierübung. 
## Android App zum Anzeigen von Gleitkommazahlen nach IEE 754

<a href="https://play.google.com/store/apps/details?id=de.merz.ieee_754">
  <img alt="Android app on Google Play"
       src="https://developer.android.com/images/brand/de_app_rgb_wo_60.png" />
</a>

Links
-------
[Github](https://github.com/NiklasMerz/IEEE-754-APP)
[Google Play Store](https://play.google.com/store/apps/details?id=de.merz.ieee_754")
##[JavaDoc](http://niklasmerz.github.io/IEEE-754-APP/JavaDoc/)

_____________________________________________________________________________________________________________________

# IEEE 754 Rechner Android Dokumentation

## Aufgabe

Aufgabe für dieses Projekt ist die Erstellung eines Programmes, das eine Gleitkommazahl in Dezimalschreibweise in den Binärcode der Datentypen Single/Float und Double nach IEEE 754 umwandelt.


## Projektziel
Die Anwendung soll ein Feld zur Eingabe, eine Auswahlmöglichkeit zwischen Single und Double und eine Ausgabe des Binärcodes haben. Der Binärcode soll farblich, für die Teile Vorzeichen, Charakteristik und Mantisse, formatiert werden.
Die Oberfläche soll einen Tutorialcharakter haben.

## Projektablauf
Das Programm wird als Android App erstellt. Als IDE (=Entwicklungsumgebung) wird Eclipse mit den Android Plug-ins und dem Android SDK genutzt. Die Oberfläche soll ein Feld zu Eingabe einer Dezimalzahl, eine Auswahl des Datentyps, und eine Legende der Farben für die Teile des Binärcodes haben. Die Schaltflächen zum Umwandel wird eine Java Methode ausführen, die Zahl in Binärcode umandelt, den String aufteilt und diesen farbig darstellt.

<u>Der Algorithmus zur Umwandlung soll mit Java umgesetzt werden: </u> <br>
Das Programm hat eine Klasse mit allen Methoden die für die Oberfläche und die Umwandlung notwendig sind. Eine der wichtigsten Methoden ist die Methode "calculate", die ausgeführt wird wenn der Knopf zum Umwandeln gedrückt wird. Diese Methode führt je nach gewähltem Datentyp dann die Methode convertToSingle bzw. convertToDouble aus. Diese Methoden wandeln mit Java Methoden, die die Datentype Float bzw. Double von Haus aus besitzen die eingegebene Dezimalzahl in Binärcode nach IEEE 754 um.
Dieser Binärcode wird dann um vorangestellte Nullen ergänzt und entsprechend der Bestandteile farblich geteilt ausgegeben.

Der wichtigste Teil des Programms sind diese drei Zeilen

<code>
number = Float.valueOf(value); <br>
bits = Float.floatToRawIntBits(number); <br>
result = Integer.toBinaryString(bits);<br>
</code>

Der eingebene Wert wird in das Datenformat Float umgewandelt. Mit der Methode <code>Float.flaotToRawIntBits()</code> kann Java den Binärcode des Floatwertes in einen Integerwert ausgeben, der dann mit <code>Integer.toBinaryString()</code> in einen String umgewandelt wird.

Dieser String wird dann in die drei Bestandteile, die mit der Norm festgelegt wurden, zerlegt. Das erste Bit legt das Vorzeichen fest und wird rot markiert. Eins bedeutet die Zahl ist negativ und ist das Bit Null ist die Zahl positiv. Die nächsten acht bit legen die Charaketistik fest. Die Charakteristik beschreibt den Exponeten zur Basis 2 multiplieziert mit dem Bias (2^n-1 - 1), wobei n die Anzahl der zur Verfügung stehenden Bits ist. Die restlichen Bits nennt man Mantisse, also die Basis.



Das Programm kann zusätzlich noch die Zahl im Format Double darstellen. Der Binärcode hat in diesem Format 64 Bit und kann dementsprechend einen größeren Zahlenbereich abdecken.   
 


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/NiklasMerz/ieee-754-app/trend.png)](https://bitdeli.com/free "Bitdeli Badge")





