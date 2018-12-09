create table users
(
	id serial not null
		constraint users_pkey
			primary key,
	name varchar not null
)
;

alter table users owner to postgres
;

create unique index users_name_uindex
	on users (name)
;

create table questions
(
	id serial not null
		constraint questions_pkey
			primary key,
	question varchar not null
)
;

alter table questions owner to postgres
;

create table answers
(
	id serial not null
		constraint answers_pkey
			primary key,
	answer varchar not null
)
;

alter table answers owner to postgres
;

create table links
(
	id serial not null
		constraint links_pkey
			primary key,
	user_id integer not null
		constraint links_users_id_fk
			references users,
	question_id integer not null
		constraint links_questions_id_fk
			references questions,
	answer_id integer
		constraint links_answers_id_fk
			references answers
)
;

alter table links owner to postgres
;

