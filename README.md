# Release notes - ml - clima

## Tag 1.0.0
- Versión inicial del ejercicio.
- Para llamar al servicio por dia: 
-- http://clima-251003.appspot.com/clima/360
- Para llamar al servicio con los resultados:
-- http://clima-251003.appspot.com/clima/result

##Arquitectura y tecnología utilizada
- ApiRest
- Spring boot 
- H2SQL
- App Engine

##Análisis y desarrollo
	1. Se tuvo en cuenta la rotación de los planetas como en un eje cartesiano, representando un punto x, y en el plano, el cual se movia por dia de acuerdo a su velocidad angular.
	2. Ni bien comienza la aplicación se inicializa la base de datos en memoria (H2SQL) con todos los 3 planetas, los dias y planetas, para los proximos 10 años. 
	3. Luego se calcula en pase a la posición de cada uno de los planetas si se van a encontrar alineados entres si y con el sol. No se obtuvo si quedan dentro de la zona del sol (TODO).
	3. Con un job se obtiene el ultimo día y se calcula el nuevo clima para ese dia. 
