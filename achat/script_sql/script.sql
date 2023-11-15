CREATE USER achat LOGIN PASSWORD 'achat';
CREATE DATABASE systeme_achat;

ALTER DATABASE systeme_achat OWNER TO achat;

\c systeme_achat achat;