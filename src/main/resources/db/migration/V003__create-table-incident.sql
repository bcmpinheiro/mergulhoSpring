create table incident (
	id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    date_register datetime not null,

    primary key (id)
);

alter table incident add constraint fk_incident_delivery
foreign key (delivery_id) references delivery (id);