use personal;
create table huesped(
cedHuesped char(10) primary key,
nombres varchar(30) not null,
apellidos varchar(30) not null,
nacionalidad char(15) not null,
telefono varchar(15),
correo varchar(50)
);

update huesped SET huesped.nombres= ?, huesped.apellidos=?, huesped.nacionalidad=?,huesped.telefono=?,huesped.correo=? where huesped.cedHuesped=?;
select * from huesped;
DELETE FROM huesped WHERE huesped.cedHuesped=?;

create table empleado(
cedEmpleado char(10) primary key,
nombres varchar(30) not null,
apellidos varchar(30) not null,
cargo varchar(50),
tipoEmpleado varchar(50),
salario int,
cedJefe char(10),
foreign key (cedJefe) references empleado(cedEmpleado)
);

select * from huesped;


create table servicio(
idServicio int auto_increment primary key,
horaRealizacion varchar(50),
fecha varchar(50),
tipoServicio varchar(50),
cedHuesped char(10),
cedEmpleado char(10),
FOREIGN KEY (cedEmpleado) references empleado(cedEmpleado),
FOREIGN KEY (cedHuesped) references Huesped(cedHuesped)
);

create table proveedor(
idProveedor int auto_increment primary key,
nombre varchar(30),
telefono varchar(15),
tipoProveedor varchar(50),
cedEmpleado char(10),
foreign key (cedEmpleado) references empleado(cedEmpleado)
);

create table inventarioProducto(
idInventario int auto_increment primary key,
nombreProducto varchar(30),
precio varchar(50),
tipoInventario varchar(50),
stock int,
fechaInventario varchar(50),
cedEmpleado char(10),
idProveedor int,
foreign key (cedEmpleado) references empleado(cedEmpleado),
foreign key (idProveedor) references proveedor(idProveedor)
);

create table habitacion(
nroHabitacion varchar(50) primary key,
precioxHabitacion int not null,
tipoHabitacion varchar(50) not null,
estado varchar(50) not null
);

create table reserva(
codigoUnico int primary key,
horaCheckin varchar(50),
horaCheckout varchar(50),
fechaInicio date not null,
fechaFin date not null,
cedHuesped char(10),
nroHabitacion varchar(50),
foreign key (nroHabitacion) references habitacion(nroHabitacion),
foreign key (cedHuesped) references huesped(cedHuesped)
);


DROP TABLE reserva;
drop table habitacion;
drop table inventarioproducto;
drop table proveedor;
drop table servicio;
drop table empleado;

