﻿--drop table elements;
create table elements
(
  aid bigint not null,
  k bigint not null,
  v bigint not null,
  constraint elements_pk primary key (aid, k)
);

create index elements_v_ix
  on elements
  using btree
  (v);

create view parts as 
select 
 aid,
 types.id as kid,
 types.path,
 types.stereotype,
 elements.aid::bigint & x'FFFFFFFFFFFF'::bigint as num,
 elements.k,
 elements.v
from
 elements,
 types
where
 aid::bigint >> 48 = types.id;

create view members as
select 
 aid,
 types.path as member,
 v
from
 parts,
 types
where 
 parts.stereotype = 'COMPOSED' and k = types.id;

 create view fields as
 select 
  parts.path as kind, 
  parts.num as label, 
  types.path as member, 
  chars.chars as value 
 from 
  parts 
  inner join chars on parts.v = chars.id 
  inner join types on types.id = parts.k
 where
  parts.stereotype = 'COMPOSED';
 
--drop table versions;

create table versions
(
  id integer not null,
  time_stamp bigint not null,
  user_txt bigint not null,
  constraint tx_pk primary key (id)
);

create index versions_time_ix
  on versions
  using btree
  (time_stamp);

create index versions_user_ix
  on versions
  using btree
  (user_txt);

--drop table version_elements;

create table version_elements
(
  tx integer not null,
  op character(1) not null,
  aid bigint not null,
  k bigint not null,
  v bigint not null,
  constraint version_elements_pk primary key (aid, k, tx)
);