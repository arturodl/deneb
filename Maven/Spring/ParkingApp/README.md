# Bienvenidos a ParkingApp

ParkingApp es una Aplicacion para gestionar la entrada y salida de vehiculos, enfocado principalmente para estacionamientos.

## Acerca de las Tecnologias usadas en esta Aplicacion
Esta pequeña aplicacion esta en su primera fase, como tal no cuenta con algunas funcionalidades, de momento solo te permite dar de alta y modificar entradas 
y salidas de un mismo vehiculo.

Las tecnologias usadas aqui las puedes ver en el POM.xml ya que es un proyecto maven, pero si quieres algo resumido y rapido aqui esta la lista.

* Html
* Bootstrap
* Spring MVC
* Spring Core
* Spring AOP
* Hibernate
* Apache DBCP para DataSources
* MySQL
* Jetty
* Maven

Algunos patrones de diseño 
* DTOs
* DAOs

## Como correr esta aplicación? 
La app tiene incrustado un servidor jetty, este esta declarado en el POM.xml, lo unico que tienes que hacer es descargar la aplicacion a tu maquina,
una vez que esta haya sido descargada entonces usa el cmd para acceder a la carpeta de esta aplicacion y usa el siguiente comando:

1 mvn jetty:run

Para dar de alta la base de datos vas a necesitar MySQL, usa el workbench para dar de alta la base de datos con un usuario root y contrasena 123456,
los scripts de la base de datos son los siguientes o buscalos dentro de la carpeta bdscripts de este proyecto:

![ bdscript ](https://github.com/arturodl/backend-test/blob/arturolinares/ParkingApp/bdscripts/parkingdb.sql)

# Usar siempre el happy path
Al ser una aplicacion en su primera fase te recomendamos siempre usar el happy path ya que de momento la app no cuenta con validaciones a nivel de vista
ni a nivel de base de datos. Un happy path seria el siguiente:

* Acceder a la aplicacion.
* Seleccionar Registrar Entrada
* Capturar la fecha de entrada en el siguiente formato dd-MM-yyyy
* Capturar la hora de entrada en el siguiente formato hh:mm
* Hacer click en el boton Agregar para dar de alta el registro 
* Hacer click en el boton Ver Listado para ver todos los registros disponibles

### Algunas imagenes de la aplicacion corriendo
![ Img1 ](https://github.com/arturodl/backend-test/blob/arturolinares/ParkingApp/img/Parking-app-arcts-01.jpg)
![ Img2 ](https://github.com/arturodl/backend-test/blob/arturolinares/ParkingApp/img/Parking-app-arcts-02.jpg)
![ Img3 ](https://github.com/arturodl/backend-test/blob/arturolinares/ParkingApp/img/Parking-app-arcts-03.jpg)
![ Img4 ](https://github.com/arturodl/backend-test/blob/arturolinares/ParkingApp/img/Parking-app-arcts-04.jpg)