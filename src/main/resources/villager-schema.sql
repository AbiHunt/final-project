Hibernate: drop table if exists villager CASCADE 
Hibernate: create table villager 
(id integer AUTO_INCREMENT, animal_type varchar(255), height integer not null, name varchar(255), npc boolean not null, personality varchar(255), primary key (id))