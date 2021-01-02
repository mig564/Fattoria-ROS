insert into attivita (id_attivita, categoria, nome, max_persone, prezzo)
values(100, 'Visita guidata', 'Cascata della Maronnella', 32, 25);
insert into attivita (id_attivita, categoria, nome, max_persone, prezzo)
values(101, 'Visita guidata', 'Ponte del Somaro', 32, 35);
insert into attivita (id_attivita, categoria, nome, max_persone, prezzo)
values(102, 'Visita guidata', 'Ritrovo dei cacciatori', 32, 35);

insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-02', '09:00:00', 100, 20);
insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-02', '12:00:00', 100, 20);

insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-04', '09:00:00', 101, 20);
insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-04', '12:00:00', 101, 20);
insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-04', '15:00:00', 101, 20);

insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-09', '09:00:00', 102, 20);
insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-09', '12:00:00', 102, 20);
insert into calendario (data, ora, id_attivita, partecipanti)
values ('2020-12-09', '15:00:00', 102, 20);
