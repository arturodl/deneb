create database parking;

use parking;

create table vehiculo(
	idVehiculo int not null auto_increment,
    modelo varchar(25) not null,
    marca varchar(25) not null,
    noPlaca varchar(20) not null,
    tipoVehiculo varchar(2) not null,
    fechaAlta date not null,
    primary key (idVehiculo)    
);

create table registro(
	idRegistro int not null auto_increment,
    fechaEntrada date not null,
    fechaSalida date null,
    horaEntrada varchar(10) not null,
    horaSalida varchar(10) null,
    idVehiculo int not null,
    primary key (idRegistro),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo)
);


insert into registro(fechaEntrada, horaEntrada, idVehiculo)
	 values(current_date(), current_date(), 1);

insert into vehiculo(modelo, marca, noPlaca, tipoVehiculo, fechaAlta)
	values('Jetta','VW','XFG-9878','R', current_date());

