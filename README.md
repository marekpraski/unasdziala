# Pracownia Projektowa - U NAS DZIAŁA

Software do raportowania czasu pracy. 

### Dane wejściowe

Wszystkie rzeczy jakie potrzebujesz do odpalenia software'u to:

```
CMD
Dane w formacie XLS
Odpowiednia struktura folderów, w których znajdują się dane XLS - ROK/MIESIĄC np. 2010/01
Odpowiednia nazwa plików XLS - imie i nazwisko pracownika np. Kowalski_Jan
Odpowiednią strukturę plików XLS - nazwy projektów muszą być zakładkami a poszczególny plik XML musi mieć kolumny: Data/ Zadanie / Czas 


```

## Odpalenie testów

W konsoli CMD wybierz ścieżkę danych w formacie XLS.
.
.
.


### Raporty

Jako dane wyjściowe wybierz jakie raporty chcesz aby zostały wygenerowane.

```
Raport informujący o ilości godzin przepracowanych przez konkretnych pracowników - parametr w konsoli r1, 
Raport informujący o ile godzin zostało przepracowanych w danych projekcie - parametr w konsoli r2,

Następnie po parametrze raportu należy podać: 
- date początkową,

oraz opcjonalnie:
- date końcową,

Komenta powinna wyglądać następująco: 
- raport o ilości godzin przepracowanych przez pracowników w danym roku 
r1 2010
- raport informujący ile godzin zostało przepracowanych w danym projekcie
r2 2010


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

