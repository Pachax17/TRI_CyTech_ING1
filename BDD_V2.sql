CREATE DATABASE tri_selectif;

USE tri_selectif;

CREATE TABLE menage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(255),
    motDePasse VARCHAR(255),
    pointsFidelite INT DEFAULT 0,
    UNIQUE KEY (email(191)) -- Limite l'index à 191 caractères
);


CREATE TABLE poubelle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    typePoubelle ENUM('Verre', 'Plastique', 'Carton', 'Métal', 'Classique'),
    capaciteMax FLOAT,
    remplissage FLOAT DEFAULT 0,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

CREATE TABLE depot (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idMenage INT,
    idPoubelle INT,
    dateDepot TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    typeDechet ENUM('Plastique', 'Verre', 'Carton', 'Métal'),
    quantite FLOAT,
    pointsGagnes INT,
    FOREIGN KEY (idMenage) REFERENCES menage(id),
    FOREIGN KEY (idPoubelle) REFERENCES poubelle(id)
);
