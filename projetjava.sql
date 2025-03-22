CREATE DATABASE IF NOT EXISTS projetjava;
USE projetjava;

-- Table Menage
CREATE TABLE IF NOT EXISTS menage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code_acces VARCHAR(50) NOT NULL,
    nombre_points_fidelite INT DEFAULT 0
);

-- Table Depot
CREATE TABLE IF NOT EXISTS depot (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_poubelle INT NOT NULL,
    heure_depot TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type_dechet ENUM('PLASTIQUE', 'VERRE', 'CARTON', 'METAL', 'PAPIER', 'AUTRES') NOT NULL,
    quantite_dechets INT NOT NULL,
    points_par_depot INT NOT NULL,
    FOREIGN KEY (id_poubelle) REFERENCES poubelle_intelligente(id) ON DELETE CASCADE
);

-- Table Poubelle Intelligente
CREATE TABLE IF NOT EXISTS poubelle_intelligente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    capaciteMax INT NOT NULL,
    type_poubelle ENUM('BLEUE', 'VERTE', 'JAUNE', 'CLASSIQUE') NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

-- Table Centre de Tri
CREATE TABLE IF NOT EXISTS centre_de_tri (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    rayon_secteur DOUBLE NOT NULL
);

-- Table Categorie Produit
CREATE TABLE IF NOT EXISTS categorie_produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

-- Table Bon d'Achat
CREATE TABLE IF NOT EXISTS bon_achat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valeur INT NOT NULL
);

-- Table Contrat de Partenariat
CREATE TABLE IF NOT EXISTS contrat_partenariat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    regles_utilisation TEXT NOT NULL
);



CREATE TABLE IF NOT EXISTS commerce (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nom VARCHAR(255) NOT NULL,
   FOREIGN KEY (id) REFERENCES contrat_partenariat(id) ON DELETE CASCADE
);




