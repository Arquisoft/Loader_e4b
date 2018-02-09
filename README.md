# Loader e4b

[![Join the chat at https://gitter.im/Arquisoft/citizensLoader1a](https://badges.gitter.im/Arquisoft/citizensLoader1a.svg)](https://gitter.im/Arquisoft/citizensLoader1a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/Arquisoft/citizensLoader1a.svg?branch=master)](https://travis-ci.org/Arquisoft/citizensLoader1a)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/citizensLoader1a?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/citizensLoader1a&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/citizensLoader1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/citizensLoader1a)

Este módulo se encarga de cargar los datos de los agentes que podrán enviar incidencias al sistema, analiza sus datos y crea un informe de errores, si se producen. <br>
Por cada agente, se almacena la información proporcionada, junto con una clave de acceso que se genera
aleatoriamente. <br>
Toda esa información es almacenada en una base de datos que será utilizada por el otro módulo (Agents).
Además, se crea una lista de cartas personalizadas para informar del usuario y clave introducido en el sistema y que se enviarán a los correos electrónicos que se han indicado. 

# Como ejecutar
Para ejecutar la aplicación hace falta tener maven correctamente instalado, se puede instalar siguiendo estas instrucciones en caso de no tenerlo: https://www.mkyong.com/maven/how-to-install-maven-in-windows/ <br>
Una vez instalado y en la raiz del proyecto, es decir donde se pueden ver las carpetas src, cartas, bin... podemos ejecutar el siguiente comando para compilar la aplicación: mvn compile y después de esto, con la aplicación ya compilada, podemos ejecutar el programa principal con: mvn exec:java -Dexec.mainClass="main.LoadUsers", este comando ejecutará la aplicación sin argumentos, pero la aplicación tiene varios argumentos para funcionar:<br>
<br>
<b>--help</b>: nos mostrará una ayuda sobre la aplicación, para ejecutar este comando ejecutaremos el siguiente comando:<br>
mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="--help"<br>
<br>
<b>info</b>: nos mostrará iformación acerca de la aplicación, para ejecutar este comando ejecutaremos el siguiente comando:<br>
mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="info"<br>
<br>
<b>load</b>: nos permite cargar un fichero maestro de tipos y unos usuarios a la base de datos, ambos vienen dados en ficheros, el fichero maestro está en la raiz de la aplicación y se llama master.csv, el estilo para es código,tipo es decir un tipo de usuario tiene un código y el nombre de este tipo, por ejemplo: 1,Usuario o 2,Sensor.<br>
El fichero que cargaremos para los usuarios se la pasa como parametro a load, es decir este puede estar en cualquier parte del ordenador, para ejecutar este comando usaremos lo siguiente:<br>
mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="load fichero.xlsx"

# Authors 2017-2018  
Óscar Marín Iglesias (UO251857)<br>
Ángela María Val Cadena (UO250972)<br>
Alejandro García Parrondo (UO253144)<br>
Samuel Steven Ludeña Vela (UO251461)<br>
Juan Granda Molaguero (UO244759)<br>

# Authors
Daniel Alba Muñiz (UO245188)<br>
José Luis Bugallo González (UO244702)<br>
Ignacio Escribano Burgos (UO227766)<br>
Daniel Duque Barrientos (UO245553)<br>
Rubén de la Varga Cabero (UO246977)<br>
