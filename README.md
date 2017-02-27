# G1-DS-Java

Detta är första push till vårt gemensamma rep!

Philip: 

Jag har granskat hur man kan strukturera uppgifterna såväl som alla krav på den här uppgiften. Jag tar tagit dem från PDF-en och skrivit till nedanför:

##Systemet i allmänhet

>Ett Media-objekt ska kunna lånas ut. En låntagare med visst id (personnummer) lånar ett Media-objekt med visst id. Utlåningen ska endast genomföras om:
o Media-objektet inte redan är utlånat. o Media-objektet finns på biblioteket. o Låntagaren är känd på biblioteket.

Vi kan ha en förhandsruta där man matar in personnr. En simpel validering görs av personnr för att säkerställa att formatet på det är korrekt

>En låntagare ska kunna få se en lista över de Media-objekt som just nu är utlånade till henne. Använd en JTextArea för att visa de utlånade objekten.

Detta kan lösas med hjälp av två fönster: Ett mindre fönster där ens lånade grejer ligger listade, och ett huvudfönster där man kan låna saker, sedan knappar därtill för att få allt att fungera.

>5. Närprogrammetstartasskaföljandefilerläsasin:
2.2
o o
Media.txt
Lantagare.txt
Se bilaga 2 för specifikation av filernas innehåll

Löses med hjälp av streams för att skriva/läsa filer.

##Implementation av systemet

Mediaobjekten måste lagras på ett effektivt sätt, jag skulle säga AVL-träd eller hashtabell är vägen att gå på den.

Personnr måste också lagras effektivt och vara sorterade.

Utlåningar måste också vara sorterade, där tidigare utlåningar är först upp.

Slutligen ska systemet byggas enligt MVC-riktlinjer (Model View Controller)

##Kraven på design hos systemet

1. Klassdiagram som visar alla klasser i systemet, med associationer, hjälpklasser som anses visentliga för systemet bör också listas. Associationer ska vara så förtydligade som möjligt (multiplicitet, namn mm.). Alla klasser ska vara någon form av MVC. Operationer/Attribut ska bara finnas med om de är förtydligande, annars ska skippas.

2. Var person i gruppen ritar ett sekvensdiagram var. Notera att sekvensdiagram 1-4 listade i uppgiften måste finnas med som minimum. Alla meddelanden/iterationer/selektioner i kod måste finnas med i sekvensdiagrammen.


En ändring






