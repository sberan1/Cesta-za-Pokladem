# Jak hrát hru
Cílem hry je nalézt cestu k Čarodějově věži, kde čaroděj zloděj ukrývá 
všechno ukradené zlato z města kde začínáš, doporučuji si cestou nasbírat 
co nejvíce předmětů, mohli by se později hodit, tajemství a mapa k věži 
se však ukrývá v jednom z prostorů, kde ji dostaneš výměnou za jiné věci.
nebudu ti ale prozrazovat kde a co pro to musíš udělat, aby sis hru alespoň trochu užil 
tato příručka obsahuje mapu, seznam příkazů a návod jak hru spustit.
Děkuji pokud si hru zahraješ. <br>
Autor hry: Štěpán Beran
### Jak hru spustit
Hru je mozne spustit po stazeni tohoto archivu
jako zip, rozbalit ho do slozky a pote spustit
prikazovy radek do ktereho je treba napsat tyto dva prikazy.

> cd [cesta do slozky jar] <br>
> java --jar cestaZaPokladem.jar

Je mozne, ze vam v cmd vyskoci chyba s nespolupracujicimi verzemi
Javy, pote doporucuji navod tady. <br>
https://www.java.com/en/download/help/update_runtime_settings.html <br>

Je potreba nainstalovat si JDK 19 a podle navodu si ho pridat a restartovat pocitac.
Odkaz ke stahnuti: https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html

### Mapa hry
![mapa](Mapa.jpeg)
### Příkazy
- prozkoumej - Když v místnosti použiješ tento příkaz, tak možná najdeš nějaké věci nebo východy, které jsi předtím neviděl
- odemkni - Zadáním příkazu `odemkni [nazev mistnosti]` se ti odemkne zamčený východ, ale pouze jestli budeš mít klíč
- nápověda - příkaz `nápověda` ti vrátí dostupné příkazy přímo ve hře a řekne cíl hry
- vymen - pokud místnost obsahuje výměnu, tak pomocí tohoto příkazu: `vymen [nazev vymeny]` můžeš výměnu spustit 
- pouzij - pokud máš v batohu použitelný předmět, tak ho můžeš použít příkazem `pouzij [nazev predmetu]`
- poloz - zadanim toho prikazu muzes z batohu vyndat libovolny predmet `poloz [nazev predmetu]`
- vymena - prikaz vrátí informace o výměně v momentální místnosti
- jdi - pokud vidíš místnost, která s místností, ve které jsi, sousedí, tak do ní můžeš jít zadáním příkazu `jdi [nazev mistnosti]`
- seber - pokud vidíš v místnosti předmět co by se ti líbil, tak ho můžeš sebrat zadáním příkazu `seber [nazev predmetu]`
- konec - jestli tě už hra nebaví, tak ji tímto příkazem ukončíš