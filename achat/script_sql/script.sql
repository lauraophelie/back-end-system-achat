CREATE USER commerce LOGIN PASSWORD 'commerce';
CREATE DATABASE systeme_commercial;

ALTER DATABASE systeme_commercial OWNER TO achat;

\c systeme_commercial commerce;

CREATE SEQUENCE article_id_seq;

CREATE SEQUENCE besoin_id_seq;

CREATE SEQUENCE role_id_seq;

CREATE SEQUENCE service_id_seq;

CREATE SEQUENCE utilisateur_id_seq;

CREATE  TABLE article ( 
	id                   varchar(8) DEFAULT CONCAT('ART', nextval('article_id_seq')) NOT NULL ,
	nom                  text   ,
	CONSTRAINT pk_article_id PRIMARY KEY ( id )
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