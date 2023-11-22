INSERT INTO service(nom_service, code_service) VALUES
                    ('Ressources Humaines', 'RH'),
                    ('Finance', 'FI'),
                    ('Informatique', 'IT'),
                    ('Achat', 'SA');

INSERT INTO roles(nom) VALUES('Chef de service'),
                            ('Directeur'),
                            ('Secrétaire'),
                            ('Admin');

INSERT INTO roles(nom) VALUES('Utilisateur');

INSERT INTO utilisateur(email, mdp, id_service, id_role) VALUES
                        ('user1@gmail.com', 'achat', 'SER4', 'ROL1'),
                        ('user2@gmail.com', 'rh', 'SER1', 'ROL5'),
                        ('user3@gmail.com', 'finance', 'SER2', 'ROL5');


INSERT INTO categorie_article(nom_categorie) VALUES
                            ('Fourniture de Bureau'),
                            ('Matériel Informatique'),
                            ('Mobilier de Bureau');

INSERT INTO article(nom, categorie) VALUES('Stylo', 'CAT1'),
                                        ('Cahier', 'CAT1'),
                                        ('Bloc Note', 'CAT1'),
                                        ('Disque dur', 'CAT2'),
                                        ('Cle USB', 'CAT2'),
                                        ('Lampe', 'CAT3');