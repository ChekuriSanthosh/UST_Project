create table tasks (
        id integer not null,
        completed enum ('COMPLETED','PENDING'),
        date date,
        delete_status enum ('DELETED','NOT_DELETED'),
        description varchar(255),
        name varchar(255),
        primary key (id)
    )


insert
    into
        tasks
        (completed, date, delete_status, description, name, id)
    values
        ('COMPLETED','2022-10-10','DELETED','Hi all' , 'Santhosh', 1)


insert
    into
        tasks
        (completed, date, delete_status, description, name, id)
    values
        ( 'COMPLETED','2022-11-09','DELETED','This is Cool' , 'Pranith', 2)


insert
    into
        tasks
        (completed, date, delete_status, description, name, id)
    values
        ('PENDING','2022-11-09','DELETED','This is Irritating' , 'Kodi', 3)
