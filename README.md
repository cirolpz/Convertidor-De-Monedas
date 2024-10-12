# Currency Converter API

Este proyecto es una aplicación que permite la conversión de distintas monedas utilizando un servicio externo para obtener las tasas de cambio actuales. Está desarrollado en Java y utiliza el framework **Jackson** para la deserialización de datos en formato JSON.

## Características

- Conversión de múltiples monedas.
- Integración con un servicio externo para obtener las tasas de cambio.
- Manejo de excepciones para asegurar robustez en la conversión de monedas.
- Validación de entradas de usuario.
- Documentación y estructura clara del código.

## Requisitos

- **Java 11** o superior
- **Maven** para la gestión de dependencias

### Dependencias principales

- `com.fasterxml.jackson.core:jackson-databind` - Para manejar la conversión entre JSON y objetos Java.
- `java.net.http.HttpClient` - Para realizar las peticiones HTTP y obtener las tasas de conversión.

## Instalación y Ejecución

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/currency-converter.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd currency-converter
    ```

3. Compila el proyecto usando Maven:
    ```bash
    mvn clean install
    ```

4. Ejecuta el programa:
    ```bash
    java -jar target/currency-converter.jar
    ```

## Uso

Al ejecutar el programa, podrás seleccionar entre distintas opciones para convertir monedas. Algunas de las conversiones soportadas son:

- ARS a USD
- USD a ARS
- EUR a ARS
- COP a ARS
- MXN a ARS, entre otras.

Solo necesitas ingresar la moneda base, la moneda de destino y la cantidad que deseas convertir.

## Estructura del Código

### Clases principales

- `ConversionRates`: Se encarga de manejar las tasas de conversión entre monedas.
- `CurrencyConvert`: Contiene la lógica de conversión de las divisas y el manejo de las tasas obtenidas del servicio externo.
- `Connection`: Gestiona las conexiones HTTP para recuperar los datos de las tasas de cambio.

## Problemas encontrados y soluciones

### 1. Uso de `record` en vez de clases

Al principio, utilicé `record` para definir las tasas de conversión, pero me encontré con un problema al usar **Gson**, ya que no maneja correctamente los `record`. La solución fue cambiar a clases convencionales con métodos `getter` y `setter`. Posteriormente, decidí utilizar **Jackson** para la deserialización de JSON, lo que resultó en un manejo más adecuado para la estructura de datos del API.

### 2. Manejo de las monedas con `ArrayList`

Inicialmente consideré usar otras estructuras, pero debido a la cantidad de monedas soportadas, fue más conveniente usar un `ArrayList`. Esto permite agregar y quitar monedas con mayor facilidad, y manejar listas de monedas dinámicamente.

### 3. Manejo de excepciones y validaciones

Tuve que agregar un control robusto de errores para asegurar que las peticiones al servicio externo y la conversión de monedas no fallaran en caso de recibir datos nulos o respuestas incorrectas del servidor. Implementamos validaciones en el input del usuario para evitar errores en tiempo de ejecución.

## Lecciones aprendidas

Este proyecto fue un excelente ejercicio en la manipulación de datos JSON, uso de APIs externas y control de excepciones. A través del proceso, aprendí la importancia de:

- Elegir la estructura de datos adecuada para el manejo de grandes cantidades de información (ArrayList para monedas).
- Controlar adecuadamente las excepciones y validar datos de entrada para evitar fallos inesperados.
- Usar **Jackson** en lugar de **Gson** para deserialización cuando se trabaja con clases complejas.
- Estructurar y documentar el código para facilitar el mantenimiento y la comprensión del proyecto.


