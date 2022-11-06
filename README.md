# Discount App
En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

## TABLA PRICES
| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR |
|----------|----------------------|----------------------|------------|------------|----------|--------|------|
| 1        | 2020-06-14-00.00.00  | 2020-12-31-23.59.59  | 1          | 35455      | 0        | 35.50  | EUR  |
| 1        | 2020-06-14-15.00.00  | 2020-06-14-18.30.00  | 2          | 35455      | 1        | 25.45  | EUR  |
| 1        | 2020-06-15-00.00.00  | 2020-06-15-11.00.00  | 3          | 35455      | 1        | 30.50  | EUR  |
| 1        | 2020-06-15-16.00.00  | 2020-12-31-23.59.59  | 4          | 35455      | 1        | 38.95  | EUR  | 


Campos:
- **BRAND_ID**: Foreign key de la cadena del grupo.
- **START_DATE , END_DATE**: Rango de fechas en el que aplica el precio tarifa indicado.
- **PRICE_LIST**: Identificador de la tarifa de precios aplicable.
- **PRODUCT_ID**: Identificador código de producto. 
- **PRIORITY**: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas se aplica la de mayor prioridad (mayor valor numérico).
- **PRICE**: Precio final de venta.
- **CURR**: ISO de la moneda.

Se pide: <br>
Construir una aplicación/servicio en SpringBoot que provea una endpoint REST de consulta  tal que:

Acepte como parámetros de entrada:
- Fecha de aplicación
- Identificador de producto
- Identificador de cadena

Devuelva como datos de salida: 
- Identificador de producto, 
- Identificador de cadena, 
- Tarifa a aplicar, 
- Fechas de aplicación
- Precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo.

Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

- Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
- Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
- Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
- Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
- Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
