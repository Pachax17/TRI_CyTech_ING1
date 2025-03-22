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

-Commerce me semble fonctionnelle niveau méthodes.
-Depot aussi, mais je comprends pas la methode ajouterDechet: erreur? (je crois je comprends juste pas bien)Si il n'y a pas d autres methodes a ajt, ca me parait ok.
-BonAchat me parait ok aussi.
-Contrat aussi, méthode renouveler ajt que sur ton pc mais je crois qu elle est fonctionnelle.
-CatProduit: on a mis une methode qui a l air fonctionnelle.
-Centre de tri: c'est fonctionnel, juste a rajt genStats et collecterDechet.
-
