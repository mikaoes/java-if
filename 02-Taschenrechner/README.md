# 02-02 Erweiterung (Taschenrechner)

### Aufgabe 1
Methoden schreiben, die die Grundrechenarten (+, -, *, /) sowie Potenz (^) und Modulo (%) ausführen und das Ergebnis zurückgeben oder ausgeben.

siehe 02-01-Methoden

Neben der Unterrichtsaufgabe habe ich hinzugefügt, dass mehr als zwei Zahlen als Parameter übergeben werden können. Dazu habe ich die Methoden mit einem [Varargs-Parameter](https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/) versehen.
Über das entstande Array von Eingaben habe ich mit einem [for-each-Loop](https://www.geeksforgeeks.org/for-each-loop-in-java/) iteriert und die Operationen ausgeführt.

### Aufgabe 2
Mit einem Scanner wird eine Eingabe von der Konsole eingelesen und an die passende Methode übergeben. Die Methode gibt das Ergebnis zurück und wird in der main-Methode ausgegeben.

siehe 02-02-Taschenrechner

Neben der Unterrichtsaufgabe habe ich erweitert, dass eine Rechnung mit mehreren Operationen berechnet werden kann, unter beachtung der Punkt-vor-Strich-Regel. Dazu habe ich zuerst Potenz- und Wurzelrechnung implementiert um die Rechnung anschließend an den Grenzen der + und - Zeichen aufzuspalten. Die darinliegenden Punkt-Operationen werden zuerst Berechnet und anschließend die Strich-Operationen. Die Rechnung wird in der main-Methode eingelesen und an die Methode übergeben. Das Ergebnis wird anschließend ausgegeben.

So können auch komplexere Rechnungen wie `2^4+7+3/5*4^2` berechnet werden.