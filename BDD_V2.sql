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


CREATE TABLE poubelle_intelligente (
    id INT PRIMARY KEY,
    capaciteMax DOUBLE NOT NULL,
    TypePoubelle ENUM('BLEUE', 'JAUNE', 'VERTE', 'CLASSIQUE') NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
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

CREATE TABLE corbeille (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idMenage INT NOT NULL,
    FOREIGN KEY (idMenage) REFERENCES menage(id)
);

CREATE TABLE dechet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idCorbeille INT NOT NULL,
    typeDechet ENUM('Plastique', 'Verre', 'Carton', 'Métal') NOT NULL,
    poids FLOAT NOT NULL,
    FOREIGN KEY (idCorbeille) REFERENCES corbeille(id) ON DELETE CASCADE
);

CREATE TABLE centre_de_tri (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255)
);

CREATE TABLE contrat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idCommerce INT,
    idCentreTri INT,
    dateDebut DATE,
    dateFin DATE,
    FOREIGN KEY (idCommerce) REFERENCES commerce(id),
    FOREIGN KEY (idCentreTri) REFERENCES centre_de_tri(id)
);






