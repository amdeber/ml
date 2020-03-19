# Release notes - ml - URL Shortener
## Tag 2.1.0
- Se agrega contador y redirect. En la petición de una url larga a partir de una corta (http://localhost:8081/url/long/), se agrego el atributo clic, con el número de peticiones al mismo. 

## Tag 2.0.0
- Versión inicial del ejercicio.
- Para llamar al servicio de obtener una url corta: http://clima-251003.appspot.com/url/short/ (POST - BODY(raw)-> Por ejemplo: https://listado.mercadolibre.com.ar/bicicleta-giant-marin#D[A:bicicleta%20giant%20marin,L:undefined] )
- Para llamar al servicio de obtener una url larga a partir de una corta: http://clima-251003.appspot.com/url/long/ (POST - BODY(raw) -> Por ejemplo: https://me.li/f18eccd8 o la creada anteriormente)
- Para llamar el servicio de eliminar url corta: http://clima-251003.appspot.com/url/delete/ (POST - BODY(raw) -> Por ejemplo: https://me.li/f18eccd8 o la creada anteriormente)

## Arquitectura y tecnología utilizada
- ApiRest
- Spring boot 
- H2SQL
- App Engine

## Análisis y desarrollo
- Se realizaron los servicios básicos de recupero de url corta y larga, como tambien su eliminación.
- Para la conversión de la url, se utiliza la libreria de google common, con sus funcionalidades de Hashing. Se deberia hacer mas pruebas para evitar cual es numero de urls que soporta antes de superponer las ulrs cortas creadas.  
- La tecnologia utilizada permitiria un escalabilidad horizontal con imagenes docker con un balanceador de carga, el cual permitiria cubrir los RNF de volumenes de peticiones. Para ello se recomiendo obtener la unidad minima por nodo a través de distintas pruebas. 

# Release notes - ml - clima

## Tag 1.0.0
- Versión inicial del ejercicio.
- Para llamar al servicio por dia: http://clima-251003.appspot.com/clima/360
- Para llamar al servicio con los resultados: http://clima-251003.appspot.com/clima/result

## Arquitectura y tecnología utilizada
- ApiRest
- Spring boot 
- H2SQL
- App Engine

## Análisis y desarrollo
- Se tuvo en cuenta la rotación de los planetas como en un eje cartesiano, representando un punto x, y en el plano, el cual se movia por dia de acuerdo a su velocidad angular.
- Ni bien comienza la aplicación se inicializa la base de datos en memoria (H2SQL) con todos los 3 planetas, los dias y planetas, para los proximos 10 años. 
- Luego se calcula en pase a la posición de cada uno de los planetas si se van a encontrar alineados entres si y con el sol. No se obtuvo si quedan dentro de la zona del sol (TODO).
- Con un job se obtiene el ultimo día y se calcula el nuevo clima para ese dia. 