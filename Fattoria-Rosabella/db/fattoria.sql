DROP DATABASE IF EXISTS fattoria;
CREATE DATABASE fattoria;
/*
DROP USER IF EXISTS 'panica'@'localhost';
CREATE USER 'panica'@'localhost' IDENTIFIED BY 'panica';
*/
GRANT ALL ON fattoria.* TO 'panica'@'localhost';

USE fattoria;

DROP TABLE IF EXISTS attivita;
CREATE TABLE attivita (
	id_attivita INT NOT NULL,
	categoria VARCHAR(256),
	nome VARCHAR(256),
	descrizione VARCHAR(256),
	max_persone INT,
	prezzo INT,
	PRIMARY KEY(id_attivita));

DROP TABLE IF EXISTS calendario;
CREATE TABLE calendario (
	data DATE,
	ora TIME,
	id_attivita INT,
	partecipanti INT,
	PRIMARY KEY(data, ora, id_attivita),
	FOREIGN KEY(id_attivita) REFERENCES attivita(id_attivita) ON UPDATE CASCADE ON DELETE CASCADE);

DROP TABLE IF EXISTS riepilogoOrdine;
CREATE TABLE riepilogoOrdine (
	id_riepilogo INT NOT NULL,
	PRIMARY KEY(id_riepilogo));
	
DROP TABLE IF EXISTS formare;
CREATE TABLE formare (
	id_attivita INT NOT NULL,
	id_riepilogo INT NOT NULL,
	data DATE,
	ora TIME,
	PRIMARY KEY(id_attivita, id_riepilogo),
	FOREIGN KEY(id_attivita) REFERENCES attivita(id_attivita) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(id_riepilogo) REFERENCES riepilogoOrdine(id_riepilogo) ON UPDATE CASCADE ON DELETE CASCADE);

DROP TABLE IF EXISTS utente;
CREATE TABLE utente (
	email VARCHAR(256) NOT NULL,
	password VARCHAR(256) NOT NULL,
	nome VARCHAR(256) NOT NULL,
	cognome VARCHAR(256) NOT NULL,
	data_nascita DATE,
    citta VARCHAR(256) NOT NULL,
	indirizzo VARCHAR(256) NOT NULL,
	id_riepilogo INT,
	PRIMARY KEY(email),
	FOREIGN KEY(id_riepilogo) REFERENCES riepilogoOrdine(id_riepilogo) ON UPDATE CASCADE ON DELETE CASCADE);

DROP TABLE IF EXISTS prenotazione;
CREATE TABLE prenotazione (
	id_prenotazione INT NOT NULL,
	prezzo INT,
	id_riepilogo INT,
	PRIMARY KEY(id_prenotazione),
	FOREIGN KEY(id_riepilogo) REFERENCES riepilogoOrdine(id_riepilogo) ON UPDATE CASCADE ON DELETE CASCADE);
	
DROP TABLE IF EXISTS prenotazioneAttivita;
CREATE TABLE prenotazioneAttivita (
	id_prenotazione INT NOT NULL,
	id_attivita INT NOT NULL,
	data DATE,
	ora TIME,
    partecipanti INT NOT NULL,
	PRIMARY KEY(id_prenotazione, id_attivita, data),
	FOREIGN KEY(id_prenotazione) REFERENCES prenotazione(id_prenotazione) ON UPDATE CASCADE ON DELETE CASCADE);
	
DROP TABLE IF EXISTS cartaDiCredito;
CREATE TABLE cartaDiCredito (
	numero VARCHAR(256) NOT NULL,
	intestatario VARCHAR(64) NOT NULL,
	scadenza VARCHAR(256) NOT NULL,
	cvv INT,
	email VARCHAR(256) NOT NULL,
	PRIMARY KEY(numero),
	FOREIGN KEY(email) REFERENCES utente(email) ON UPDATE CASCADE ON DELETE CASCADE);

DROP TABLE IF EXISTS gestore;
CREATE TABLE gestore(
	email VARCHAR(256) NOT NULL,
	password VARCHAR(256) NOT NULL,
	PRIMARY KEY(email));




