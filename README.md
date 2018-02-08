# Loader e4b

[![Join the chat at https://gitter.im/Arquisoft/citizensLoader1a](https://badges.gitter.im/Arquisoft/citizensLoader1a.svg)](https://gitter.im/Arquisoft/citizensLoader1a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/Arquisoft/citizensLoader1a.svg?branch=master)](https://travis-ci.org/Arquisoft/citizensLoader1a)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/citizensLoader1a?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/citizensLoader1a&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/citizensLoader1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/citizensLoader1a)

Skeleton of Loader module

# Como ejecutar
Para ejecutar la aplicación hace falta tener maven correctamente instalado, se puede instalar siguiendo estas instrucciones en caso de no tenerlo: https://www.mkyong.com/maven/how-to-install-maven-in-windows/
Una vez instalado y en la raiz del proyecto, es decir donde se pueden ver las carpetas src, cartas, bin... podemos ejecutar el siguiente comando para ejecutar la aplicación: mvn exec:java -Dexec.mainClass="main.LoadUsers", este comando ejecutará la aplicación sin argumentos, pero la aplicación tiene varios argumentos para funcionar:<br>
	* --help: nos mostrará una ayuda sobre la aplicación, para ejecutar este comando ejecutaremos el siguiente comando:<br>
		mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="--help"<br>
	* info: nos mostrará iformación acerca de la aplicación, para ejecutar este comando ejecutaremos el siguiente comando:<br>
		mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="info"<br>
	* load: nos permite cargar un fichero maestro de tipos y unos usuarios a la base de datos, ambos vienen dados en ficheros, el fichero maestro 			está en la raiz de la aplicación y se llama master.csv, el estilo para es código,tipo es decir un tipo de usuario tiene un código y 			el nombre de este tipo, por ejemplo: 1,Usuario o 2,Sensor.<br>
			El fichero que cargaremos para los usuarios se la pasa como parametro a load, es decir este puede estar en cualquier parte del 			ordenador, para ejecutar este comando usaremos lo siguiente:<br>
			mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="load fichero.xlsx"

# Authors 2017-2018  
Óscar Marín Iglesias (UO251857)
Ángela María Val Cadena (UO250972)
Alejandro García Parrondo (UO253144)
Samuel Steven Ludeña Vela (UO251461)
Juan Granda Molaguero (UO244759)

# Authors

Daniel Alba Muñiz (UO245188)
José Luis Bugallo González (UO244702)
Ignacio Escribano Burgos (UO227766)
Daniel Duque Barrientos (UO245553)
Rubén de la Varga Cabero (UO246977)
