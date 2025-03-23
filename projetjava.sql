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
CREATE TABLE categorie_produit (
    nom VARCHAR(250) PRIMARY KEY
);

CREATE TABLE reduction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categorie_nom VARCHAR(255),
    points INT NOT NULL,
    pourcentage DOUBLE NOT NULL,
    FOREIGN KEY (categorie_nom) REFERENCES categorie_produit(nom) ON DELETE CASCADE
);

-- Table Bon d'Achat
CREATE TABLE bon_achat (
    id INT AUTO_INCREMENT PRIMARY KEY, -- ID auto-incrémenté
    valeur INT NOT NULL,
    id_menage INT NOT NULL, -- Référence au ménage
    FOREIGN KEY (id_menage) REFERENCES menage(id) ON DELETE CASCADE
);

-- Table Contrat de Partenariat
CREATE TABLE IF NOT EXISTS contrat_partenariat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    regles_utilisation TEXT NOT NULL
);



CREATE TABLE IF NOT EXISTS commerce (
    id INT AUTO_INCREMENT PRIMARY KEY, -- ID auto-incrémenté
    nom VARCHAR(255) NOT NULL,
    id_contrat INT NOT NULL, -- Référence vers la table contrat
    FOREIGN KEY (id_contrat) REFERENCES contrat(id) ON DELETE CASCADE
);





