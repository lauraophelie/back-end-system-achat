CREATE USER commerce LOGIN PASSWORD 'commerce';
CREATE DATABASE systeme_commercial;

ALTER DATABASE systeme_commercial OWNER TO achat;

\c systeme_commercial commerce;

CREATE SEQUENCE article_id_seq;

CREATE SEQUENCE besoin_id_seq;

CREATE SEQUENCE categorie_article_id_seq;

CREATE SEQUENCE role_id_seq;

CREATE SEQUENCE service_id_seq;

CREATE SEQUENCE utilisateur_id_seq;

CREATE  TABLE categorie_article ( 
	id                   varchar(8) DEFAULT CONCAT('CAT', nextval('categorie_article_id_seq')) NOT NULL ,
	nom_categorie        text   ,
	CONSTRAINT pk_categorie_article_id PRIMARY KEY ( id )
 );

CREATE  TABLE roles ( 
	id                   varchar(8) DEFAULT CONCAT('ROL', nextval('role_id_seq')) NOT NULL ,
	nom                  text   ,
	CONSTRAINT pk_roles_id PRIMARY KEY ( id )
 );

CREATE  TABLE service ( 
	id                   varchar(8) DEFAULT CONCAT('SER', nextval('service_id_seq')) NOT NULL ,
	nom_service          text   ,
	code_service		 varchar(15) NOT NULL,
	CONSTRAINT pk_service_id PRIMARY KEY ( id )
 );

CREATE  TABLE utilisateur ( 
	id                   varchar(8) DEFAULT CONCAT('UTI', nextval('utilisateur_id_seq')) NOT NULL ,
	email                text   ,
	mdp                  varchar(12)  NOT NULL ,
	id_service           varchar(8)   ,
	id_role              varchar(8)   ,
	CONSTRAINT pk_utilisateur_id PRIMARY KEY ( id ),
	CONSTRAINT fk_utilisateur_service FOREIGN KEY ( id_service ) REFERENCES service( id )  ,
	CONSTRAINT fk_utilisateur_roles FOREIGN KEY ( id_role ) REFERENCES roles( id )  
 );

ALTER TABLE service ADD CONSTRAINT cns_code_service UNIQUE(code_service);

ALTER TABLE utilisateur ADD CONSTRAINT cns_email_utilisateur UNIQUE(email);

CREATE  TABLE article ( 
	id                   varchar(8) DEFAULT CONCAT('ART', nextval('article_id_seq')) NOT NULL ,
	nom                  text   ,
	categorie            varchar(8)   ,
	CONSTRAINT pk_article_id PRIMARY KEY ( id ),
	CONSTRAINT fk_article_categorie_article FOREIGN KEY ( categorie ) REFERENCES categorie_article( id )  
 );

CREATE  TABLE article_service ( 
	id_service           varchar(8)   ,
	id_article           varchar(8)   ,
	CONSTRAINT fk_article_service_service FOREIGN KEY ( id_service ) REFERENCES service( id )  ,
	CONSTRAINT fk_article_service_article FOREIGN KEY ( id_article ) REFERENCES article( id )  
 );

CREATE  TABLE besoin ( 
	id                   SERIAL PRIMARY KEY ,
	id_service           varchar(8)   ,
	date_besoin          date DEFAULT now()  ,
	date_limite          date   ,
	etat                 integer DEFAULT 0  ,
	CONSTRAINT fk_besoin_service FOREIGN KEY ( id_service ) REFERENCES service( id )  
 );

ALTER table besoin ADD column etatEmail int DEFAULT 0;

CREATE  TABLE besoin_article ( 
	id_besoin            integer ,
	id_article           varchar(8)   ,
	quantite             integer   ,
	CONSTRAINT fk_besoin_article_article FOREIGN KEY ( id_article ) REFERENCES article( id )  ,
	CONSTRAINT fk_besoin_article_besoin FOREIGN KEY ( id_besoin ) REFERENCES besoin( id )  
 );

 insert into service(nom_service) values('Ressources Humaines');
 insert into service(nom_service) values('Systeme d information');


 insert into roles(nom) values ('DRH');
 insert into roles(nom) values ('DSI');

 insert into utilisateur(email,mdp,id_service,id_role) values('dsi@gmail.com','dsi','SER2','ROL2');
 insert into utilisateur(email,mdp,id_service,id_role) values('drh@gmail.com','drh','SER1','ROL1');


insert into categorie_article(nom_categorie) values('fournitures de bureau');
insert into categorie_article(nom_categorie) values('informatique');


insert into article(nom,categorie) values('stylo','CAT1');
insert into article(nom,categorie) values('cahier','CAT1');
insert into article(nom,categorie) values('ordinateur','CAT2');

insert into article_service(id_article,id_service) values('ART1','SER1');
insert into article_service(id_article,id_service) values('ART3','SER2');


insert into besoin(id_service,date_besoin,date_limite,etat) values('SER1','2023-10-02','2023-11-20',0);

insert into besoin_article values(1,'ART1',10);
insert into besoin_article values(1,'ART2',5);


select u1_0.id,u1_0.email,u1_0.mdp,u1_0.id_role,u1_0.id_service from utilisateur u1_0 where u1_0.email='dsi@gmail.com' and u1_0.mdp='dsi'


create table validation_besoin(
	id_besoin int not null,
	date_validation date DEFAULT now(),
	FOREIGN KEY(id_besoin) REFERENCES besoin(id)
);

select
	ba.*,
	b.id_service,
	b.date_besoin,
	b.date_limite,
	b.etat_email,
	b.date_validation,
	b.semaine
from besoin_article AS ba
JOIN v_besoin_valide AS b ON ba.id_besoin = b.id
WHERE b.etat_email = 0;

create view v_besoin_valide_with_article as (
	select
		ba.*,
		b.id_service,
		b.date_besoin,
		b.date_limite,
		b.etatemail,
		b.date_validation,
		b.semaine
	from besoin_article AS ba
	JOIN v_besoin_valide AS b ON ba.id_besoin = b.id
	WHERE b.etatemail = 0
);

select * from v_besoin_valide_with_article;

select 
	semaine,
	id_article,
	sum(quantite) as quantite,
from v_besoin_valide_with_article
group by semaine, id_article;

create view v_besoins_global as(
	select 
		semaine,
		id_article,
		sum(quantite) as quantite
	from v_besoin_valide_with_article
	group by semaine, id_article
);

select 
		semaine,
		id_article,
		sum(quantite) as quantite,
		id_service
	from v_besoin_valide_with_article
	group by semaine, id_article,id_service

select 
	b.*,
	vb.*,
	extract(week from vb.date_validation) AS semaine
from validation_besoin AS vb
JOIN besoin AS b ON vb.id_besoin = b.id;

create view v_besoin_valide as (select b.*,
	vb.*,
	extract(week from vb.date_validation) AS semaine
from validation_besoin AS vb
JOIN besoin AS b ON vb.id_besoin = b.id);

create view v_besoin_global_ByService as (
	select 
		semaine,
		id_article,
		sum(quantite) as quantite,
		id_service
	from v_besoin_valide_with_article
<<<<<<< HEAD
	group by id_service, semaine, id_article
);
=======
	group by semaine, id_article,id_service);

CREATE SEQUENCE fornisseur_id_seq;

CREATE table fournisseur(
	id                   varchar(8) DEFAULT CONCAT('FRN', nextval('fornisseur_id_seq')) NOT NULL ,
	nom varchar(50),
	adresse varchar(50),
	responsable varchar(80),
	CONSTRAINT pk_fournisseur_id PRIMARY KEY ( id )

);

create table proforma(
	id SERIAL PRIMARY key,
	id_article varchar(8),
	quantite int,
	prixUnitaire decimal,
	id_fournisseur varchar(8),
	dateProforma date,
	CONSTRAINT fk_proforma_article FOREIGN KEY ( id_article ) REFERENCES article( id )  ,
	CONSTRAINT fk_proforma_fournisseur FOREIGN KEY ( id_fournisseur ) REFERENCES fournisseur( id )  
);


ALTER table proforma add column etat int DEFAULT 0;
ALTER table proforma add column id SERIAL PRIMARY key;



insert into fournisseur(nom,adresse,responsable) values('Jumbo Score','Ankorondrano','Reponsable Jumbo');
insert into fournisseur(nom,adresse,responsable) values('Supermaki','Andoharanofotsy','Reponsable Supermaki');
insert into fournisseur(nom,adresse,responsable) values('Super U','Analakely','Reponsable Super U');

CREATE VIEW vue_prix_minimum_par_article_et_date AS
SELECT
    p.id_article,
    a.nom AS nomArticle,
	p.id ,
    p.dateProforma,
    p.prixUnitaire * p.quantite AS prixTotal,
    f.nom AS nomFournisseur,
    p.etat
FROM
    proforma p
JOIN
    fournisseur f ON p.id_fournisseur = f.id
JOIN
    article a ON p.id_article = a.id
WHERE
    (p.id_article, p.dateProforma, p.prixUnitaire * p.quantite) IN (
        SELECT
            id_article,
            dateProforma,
            MIN(prixUnitaire * quantite) AS prixMinimum
        FROM
            proforma
        GROUP BY
            id_article,
            dateProforma
    )
AND
    p.etat = 0;

create table bon_commande(
	id SERIAL PRIMARY key,
	dateTirage date,
	numero varchar(50),
	delaiLivraison date,
	partiel boolean,
	paiement varchar(50),
	id_proforma int,
	FOREIGN key(id_proforma) REFERENCES proforma(id)
);
CREATE VIEW v_bon_commande_article AS
SELECT
    b.id AS id_bon_commande,
    b.dateTirage,
    b.numero,
    b.delaiLivraison,
    b.partiel,
    b.paiement,
    p.id AS id_proforma,
    a.nom AS nom_article,
    ca.nom_categorie AS nom_categorie_article,
    f.nom AS nom_fournisseur
FROM
    bon_commande b
JOIN
    proforma p ON b.id_proforma = p.id
JOIN
    article a ON p.id_article = a.id
JOIN
    categorie_article ca ON a.categorie = ca.id
JOIN
    fournisseur f ON p.id_fournisseur = f.id;


-- 0=>fifo  1=>lifo
alter table article add column typeArticle int;
alter table article add column idunite int references unite(id);


create table unite(
	id SERIAL PRIMARY key,
	typeUnite varchar(20)
);

insert into unite(typeUnite) values('kg');
insert into unite(typeUnite) values('l');


create table entree(
    id SERIAL PRIMARY KEY,
    dateEntree date,
    idArticle VARCHAR(50),
    prix decimal,
    qteEntree decimal,
    foreign key(idArticle) references article(id)
);
