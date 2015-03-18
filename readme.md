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

# IEE 754 Rechner Android Dokumentation

## Aufgabe

Aufgabe für dieses Projekt ist die Erstellung eines Programmes, das eine Gleitkommazahl in Dezimalschreibweise in den Binärcode der Datentypen Single/Float und Double nach IEEE 754 umwandelt.


## Projektziel
Die Anwendung soll ein Feld zur Eingabe, eine Auswahlmöglichkeit zwischen Single und Double und eine Ausgabe des Binärcodes haben. Der Binärcode soll farblich, für die Teile Vorzeichen, Charakteristik und Mantisse, formatiert werden.
Die Oberfläche soll einen Tutorialcharakter haben.

## Projektablauf
Das Programm wird als Android App erstellt. Als IDE (=Entwicklungsumgebung) wird Eclipse mit den Android Plug-ins und dem Android SDK genutzt. Die Oberfläche soll ein Feld zu Eingabe einer Dezimalzahl, eine Auswahl des Datentyps, und eine Legende der Farben haben. Die Schaltflächen zum Umwandel wird eine Java Methode ausführen, die Zahl in Binärcode umandelt, den String aufteilt und farbig darstellt.

Der Algorithmus zur Umwandlung soll mit Java umgesetzt werden: <br>
Das Programm hat eine Klasse mit allen Methoden die für die Oberfläche und die Umwandlung notwendig sind. Eineder wichtigsten Methoden ist die Methode "Calculate", die ausgeführt wird wenn der Knopf zum umwandeln gedrückt wird. Diese Methode führt je nach gewähltem Datentyp dann die Methode ConvertToSingle bzw. ConvertToDouble aus. Diese Methoden wandeln mit Java Methoden, die die Datentype Float bzw. Double von Haus aus besitzen die eingegebene Dezimalzahl in Binärcode nach IEEE 754 um.
Dieser Binärcode wird dann um vorangestellte Nullen ergänzt und entsprechend der Bestandteile farblich geteilt ausgegeben.

->IEEE754   







