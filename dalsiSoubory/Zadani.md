# Zadani semstralni prace z insisu

### Povinný úkol - Zadání semestrální práce:

Popište mi vymyšlené zadání pro adventuru hry.

Popis bude obsahovat příběh ke hře. Zároveň bude obsahovat scénář minimálně 18 kroků, které povedou k výhře hráče. Zároveň vytvořte k adventuře i mapu hry.

Tento scénář bude popsán formou:

Povinná část jednotlivých výpisů - toto bude součástí vašeho testu hry
Textace - to co se vypíše hráči. Může obsahovat výpis předmětů či východů. V tom případě není třeba to následně vypisovat v následujících řádcích.

Dobrovolná v případě, že je obsažená v povinné části výpisu
"Aktuální prostor" - jméno aktuálního prostoru
"Aktuální předměty v místnosti" - jaké předměty se nacházejí v aktuálním prostoru
"Aktuální východy" - Východy kam se dá jít z daného prostoru
"Aktuální předměty v batohu" - Věci, které má hráč v batohu

Úvod
"Textace"
"Aktuální prostor"
"Aktuální předměty v místnosti"
"Aktuální východy"
"Aktuální předměty v batohu"

--------------------------------

1. krok
- "Příkaz" 
- "Textace"
- "Aktuální prostor"
- "Aktuální předměty v místnosti"
-  "Aktuální východy"
- "Aktuální předměty v batohu"

--------------------------------

2. krok
- "Příkaz"
- "Textace"
- "Aktuální prostor"
- "Aktuální předměty v místnosti"
- "Aktuální východy"
- "Aktuální předměty v batohu"

--------------------------------



Základní funkcionalita hry, kterou musíte implementovat.

1. Hra má několik prostorů/místností.
2. Hráč může procházet jednotlivými prostory
3. V některých prostorech mohou být různé věci.
4. V jednom prostoru (místnosti) může být více předmětů.
5. Některé věci si může hráč z místnosti odnést jiné ne.
6. Hráč může přenášet jen omezený počet předmětů.
7. Hráči musí být umožněno předměty brát a pokládat
8. Hra musí mít možnost vyhrát.
9. Přidejte nejméně čtyři nové příkazy (kromě jdi, konec, pomoc, napoveda, seber a polož).
10. Věc i "batoh" (tj. kam se umísťují přenášené věci) budou relizovány přes třídy.

Zadání bude po odevzdání neměné. Dbejte na to, aby textace k příkazům měli stejnou strukturu tedy:
aby jednou příkaz jdi nevypsal dle vašeho zadání "šel jsi do místnostiA" a po druhé "šel jste do místnostiA" - realizace by byla velice obtížná.