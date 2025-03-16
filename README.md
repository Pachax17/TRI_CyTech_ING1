NOTE : connexion MySQL a été mise en place via JDBC (ConnexionBDD.java), MAIS elle pose problème (Access denied). Tant que ce n’est pas résolu, les tests en base sont incertains.

J'ai mis en place les divers classes qu'on avait établit en Java (j'ai fais leur get/set) je les ai potentellement mal implémanté et la pluspart des méthodes, j'en ai peut être oublié
J'ai rédigé une BDD MySQL via l'UML qu'on avait fait auparavant, y'a des classe où je me suis peut etre Br genre commerce par exemple 

projet est structuré en plusieurs répertoires pour assurer une bonne séparation des responsabilités :

modele/ : Contient les classes représentant les entités du projet (ex : Menage.java, Poubelle.java, Depot.java).
dao/ : Contient les classes gérant l’accès aux données via MySQL (ex : DepotDAO.java, MenageDAO.java).
service/ : Contient les classes gérant la logique métier du projet (ex : DepotService.java pour le calcul des points de fidélité).
test/ : Contient les classes de test pour vérifier le bon fonctionnement des méthodes (ex : MainTest.java).
