# Intalación exam-xmen

## 1. Configuracion BBDD

Para instalacion es necesario base de datos se recomienta **POSTGRESQL**

Se recomienda tener encuenta 

* *username*: postgres
* *password*: A12345678
* *port*: 5434
* *database*: xmen


**Nota importante**: Validar o actualizar los datos en el archivo **application.properties**

## 2. Ejecucion MVN 

Es un projecto norma de spring-boot con JPA por lo que se ejecuta 

```
mvn clen install
```

## 3. Visualizacion y ejecucion en IDE

Se puede instalar en eclipse, intelliJ o el de su preferencia como un **projecto mvn** 


## 3. Consumo 

Los dos endpoins ya se encuentran desplegados en heroku (Para local basta cambiar el server por su server y puerto)



** MS - Validate DNA **

```
curl --location --request POST 'https://exercise-xmen.herokuapp.com/api/mutants/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "params": {
        "dna": [
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"
        ]
    }
}'
```

** MS - Status DNA **

```
curl --location --request GET 'https://exercise-xmen.herokuapp.com/api/mutants/stats' \
--data-raw ''
```
