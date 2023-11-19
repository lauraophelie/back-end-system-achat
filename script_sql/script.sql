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

ALTER TABLE utilisateur ADD CONSTRAINT cns_email_utilisateur CHECK ( UNIQUE(email) );

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
	id                   varchar(8) DEFAULT CONCAT('BES', nextval('besoin_id_seq')) NOT NULL ,
	id_service           varchar(8)   ,
	date_besoin          date DEFAULT now()  ,
	date_limite          date   ,
	etat                 integer DEFAULT 0  ,
	CONSTRAINT pk_besoin_id PRIMARY KEY ( id ),
	CONSTRAINT fk_besoin_service FOREIGN KEY ( id_service ) REFERENCES service( id )  
 );

CREATE  TABLE besoin_article ( 
	id_besoin            varchar(8)   ,
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

insert into besoin_article values('BES1','ART1',10);
insert into besoin_article values('BES1','ART2',5);


select u1_0.id,u1_0.email,u1_0.mdp,u1_0.id_role,u1_0.id_service from utilisateur u1_0 where u1_0.email='dsi@gmail.com' and u1_0.mdp='dsi'
