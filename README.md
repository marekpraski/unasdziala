# Pracownia Projektowa - U NAS DZIAŁA

Software do raportowania czasu pracy. 
Format Runnable JAR.

### Dane wejściowe

Wszystkie rzeczy jakie potrzebujesz do odpalenia software'u to:

```
unasdziala.jar
CMD,
Dane w formacie XLS,
Odpowiednia struktura folderów, w których znajdują się dane w formacie XLS - ROK/MIESIĄC np. 2010/01,
Odpowiednia nazwa plików XLS - imie i nazwisko pracownika np. Kowalski_Jan, muszą znajdować się w folderze MIESIĄC, 
Odpowiednią strukturę plików XLS - nazwy projektów muszą być zakładkami a poszczególny plik XML musi mieć kolumny: Data/ Zadanie / Czas 


```

## Odpalenie testów

W uruchom CMD w lokalizacji w której znajduje się unasdziala.jar poprzez komende: 

java -jar unasdziala.jar 
.
.
.


### Raporty

Jako dane wyjściowe wybierz jakie raporty chcesz aby zostały wygenerowane.

```
Raport informujący o ilości godzin przepracowanych przez konkretnych pracowników - parametr w konsoli -r1 -path<arg>, 
Czas pracy dla danego pracownika w raporcie r1 jest procentowo podzielony na projekty, w których uczestniczył.  
Raport informujący o ile godzin zostało przepracowanych w danych projektach - parametr w konsoli -r2 -path<arg>,

Następnie po parametrze raportu należy podać opcjonalnie: 
- date początkową oraz date końcową,

Komenta powinna wyglądać następująco: 
- raport o ilości godzin przepracowanych przez pracowników (dla wszystkich lat - folderów ROK),
                                    -r1 -path "C:\Users\Student12\Desktop\reporter-dane"
- raport informujący ile godzin zostało przepracowanych w danym projekcie (dla wszystkich lat - folderów ROK),
                                    -r2 -path "C:\Users\Student12\Desktop\reporter-dane"
- raport o ilości godzin przepracowanych przez pracowników w danym roku,
r11, np. 
                                    -r11 -path "C:\Users\Student12\Desktop\reporter-dane" -from 2010 -to 2012
- raport informujący ile godzin zostało przepracowanych w danym projekcie w danym roku,
r22, np. 
                                    -r22 -path "C:\Users\Student12\Desktop\reporter-dane" -from 2010 to 2012
```

### Przykładowe wyniki dla raportów: 

```
Raport r1:

This is raport number 1
Name and surname: Jan Kowalski
Amount of hours worked: 46.0 100%
Projects participated: 
Project name: Projekt1 hours: 28.0 percent of all time spent: 60.869564%
Project name: Projekt2 hours: 18.0 percent of all time spent: 39.130436%
List of files: 

Raport r2: 


```

### Wykrycie błędów z niepoprawnymi danymi

Błędne dane zostają wykryte oraz wypisane jak poniżej:

```
Plik: unasdziala/res/reporter-dane/2013/04/Sprawny_Eugeniusz-wielebledow.xls
Projekt 1
Line 24
Incorrect date: 35.13.1564
```

## Wersja

Alfa.

## Autorzy

* **U NAS DZIAŁA - TEAM** 

## Licencja

Projekt ten jest na licencji U NAS DZIAŁA - TEAM.


	

