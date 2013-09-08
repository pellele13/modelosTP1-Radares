modelos7114-tp1
===============

TP 1 de Modelos y Optimización I

Requerimiento:
Dada una lista de países y sus limítrofes, crear un algoritmo que coloque antenas cubriendo en alcance todos los países. Cada antena cubre el país donde se coloca y todos sus limítrofes. Deben utilizarse la menor cantidad de antenas posibles.

Estructuras a utilizar:
- Nodo Pais
    * flag 'cobertura': indica si el pais tiene cobertura
    * int limSinCobertura: indica la cantidad de paises limítrofes que no tienen cobertura
    * lista Pais limitrofes: lista de Paises que son limítrofes

Algoritmo:
- Leo cada entrada, y voy cargando los nodos. Para cada país, voy agregando sus limítrofes e incrementando el contador de los limítrofes sin cobertura, hasta cargar el grafo entero.
- Inicio el ciclo de búsqueda de la solución: comienzo eligiendo el país con mayor limSinCobertura.
- Para cada uno de los paises limítrofes de su lista, hago:
  + marco el flag 'cobertura'.
  + para cada uno de los países limítrofes, disminuyo en 1 el contador limSinCobertura.
  + disminuyo en 1 el contador limSinCobertura.
- Pongo en cero el contador limSinCobertura.
- Sigo con el siguiente país que tenga el valor mayor de limSinCobertura.