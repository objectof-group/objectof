
create table chars
(
  id bigint not null,
  hash integer not null,
  chars text not null,
  constraint chars_pk primary key (id)
);

create index chars_hash_ix
  on chars 
  /*using btree --SQLite doesn't seem to support this syntax*/
  (hash);

create table blobs
(
	id bigint not null,
	hash integer not null,
	bytes blob not null,
	constraint blobs_pk primary key (id)
);
  
create table datatypes
(
  stereotype text not null,
  category text not null,
  constraint datatypes_pk primary key (stereotype)
);

create index datatypes_category_ix
  on datatypes 
  /*using btree --SQLite doesn't seem to support this syntax*/
  (category);

insert into datatypes values ('COMPOSED', 'INSTANCE');
insert into datatypes values ('INDEXED', 'INSTANCE');
insert into datatypes values ('MAPPED', 'INSTANCE');
insert into datatypes values ('INT', 'SCALAR');
insert into datatypes values ('NUM', 'SCALAR');
insert into datatypes values ('MOMENT', 'SCALAR');
insert into datatypes values ('BN', 'SCALAR');
insert into datatypes values ('TEXT', 'TXT');
insert into datatypes values ('MEDIA', 'BIN');
insert into datatypes values ('REF', 'REF');


create table repositories
(
  uniform_name_txt bigint not null,
  impl_txt bigint not null,
  schema_name text,
  schema_version text,
  schema_impl text,
  schema_metadata text,
  constraint repositories_pk primary key (uniform_name_txt)
);

create table types
(
  id smallint not null,
  repository bigint not null,
  path text not null,
  stereotype text not null,
  target smallint,
  constraint types_pk 
  primary key (id)
  foreign key (target) references types(id)
);

create index types_stereotype_ix
  on types 
  /*using btree --SQLite doesn't seem to support this syntax*/
  (stereotype);

create index types_repository_ix
  on types 
  /*using btree --SQLite doesn't seem to support this syntax*/
  (repository);

create index types_path_ix
  on types 
  /*using btree --SQLite doesn't seem to support this syntax*/
  (path);