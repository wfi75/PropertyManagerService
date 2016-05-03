--<ScriptOptions statementTerminator=";"/>

CREATE TABLE owner (
	ownerid INT NOT NULL,
	firstname VARCHAR(45) NOT NULL,
	lastname VARCHAR(45) NOT NULL,
	mobile VARCHAR(17) NOT NULL,
	email VARCHAR(80) NOT NULL,
	PRIMARY KEY (ownerid)
);

CREATE TABLE property (
	id INT NOT NULL,
	discreption VARCHAR(145) NOT NULL,
	zipcode INT DEFAULT 0 NOT NULL,
	address VARCHAR(145) DEFAULT budapest NOT NULL,
	rooms INT DEFAULT 1 NOT NULL,
	area INT DEFAULT 30 NOT NULL,
	baths INT DEFAULT 1 NOT NULL,
	garden VARCHAR(8) DEFAULT no NOT NULL,
	pool VARCHAR(8) DEFAULT no NOT NULL,
	alarm VARCHAR(3) DEFAULT no NOT NULL,
	security VARCHAR(3) DEFAULT no NOT NULL,
	floor INT DEFAULT 0 NOT NULL,
	door INT DEFAULT 0 NOT NULL,
	ownerid INT NOT NULL,
	offertype VARCHAR(45) DEFAULT rent NOT NULL,
	rentprice INT DEFAULT 0 NOT NULL,
	sealprice INT DEFAULT 0 NOT NULL,
	availabel VARCHAR(45) DEFAULT no NOT NULL,
	kitchen VARCHAR(45) DEFAULT open NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE users (
	userid VARCHAR(15) NOT NULL,
	password VARCHAR(45) DEFAULT 123456 NOT NULL,
	firstname VARCHAR(45) NOT NULL,
	lastname VARCHAR(45) NOT NULL,
	emai VARCHAR(80) NOT NULL,
	mobile VARCHAR(45) NOT NULL,
	accesslevel INT DEFAULT 0,
	PRIMARY KEY (userid)
);

CREATE TABLE media (
	id INT NOT NULL,
	icon VARCHAR(150) DEFAULT null NOT NULL,
	picture1 VARCHAR(150) DEFAULT null NOT NULL,
	picture2 VARCHAR(150) DEFAULT null NOT NULL,
	picture3 VARCHAR(150) DEFAULT null NOT NULL,
	picture4 VARCHAR(150) DEFAULT null NOT NULL,
	PRIMARY KEY (id)
);

CREATE INDEX ownerid_idx ON property (ownerid ASC);

CREATE UNIQUE INDEX mobile_UNIQUE ON users (mobile ASC);

CREATE UNIQUE INDEX id_UNIQUE ON users (userid ASC);

CREATE UNIQUE INDEX email_UNIQUE ON owner (email ASC);

CREATE UNIQUE INDEX mobile_UNIQUE ON owner (mobile ASC);

CREATE UNIQUE INDEX emai_UNIQUE ON users (emai ASC);

