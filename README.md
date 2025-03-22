NOTE : connexion MySQL a été mise en place via JDBC (ConnexionBDD.java), MAIS elle pose problème. Tant que ce n’est pas résolu, les tests en base sont incertains.Je retesterai avc un autre serveur

dans src\ : J'ai mis en place les divers classes qu'on avait établit en Java (j'ai fais leur get/set) je les ai potentellement mal implémanté et la pluspart des méthodes, j'en ai peut être oublié

BBD_V2.sql : J'ai rédigé une BDD MySQL via l'UML qu'on avait fait auparavant, y'a des classe où je me suis peut etre Br genre commerce par exemple 

Sinon pour l'orga du repertoire: 
projet est structuré en plusieurs répertoires pour assurer une bonne séparation des responsabilités :

- modele/ : Contient les classes représentant les entités du projet (ex : Menage.java, Poubelle.java, Depot.java).

- dao/ : Contient les classes gérant l’accès aux données via MySQL (ex : DepotDAO.java, MenageDAO.java).

- test/ : Contient les classes de test pour vérifier le bon fonctionnement des méthodes (ex : MainTest.java).



y'a 2/3 fichier superflus, c'est les 1er rendus qu'on avait fait


//


-->Test+dao fait:


-Commerce me semble fonctionnelle niveau méthodes.

-Menage a l'air en place.

-Depot aussi, mais je comprends pas la methode ajouterDechet:Si il n'y a pas d autres methodes a ajt, ca me parait ok.

-BonAchat me parait ok aussi.

-CatProduit: on a mis une methode qui a l air fonctionnelle.

-Poubelle probleme: ok j espere.

-->Test+dao a faire:


-Centre de tri: c'est fonctionnel, juste a rajt genStats et collecterDechet.

-Contrat aussi, méthode renouveler ajt que sur ton pc mais je crois qu elle est fonctionnelle.

-Poubelle probleme: t'as fait une fonction verifContrainte alors que c'est verifComformité.


Du coup j espere toutes les methodes de ceux que j ai fait sont fonctionnelles, que les tests et les dao englobent bien tout, j ai pas teste avec la bdd psk j ai pas reussi a connecter j te laisse faire.
