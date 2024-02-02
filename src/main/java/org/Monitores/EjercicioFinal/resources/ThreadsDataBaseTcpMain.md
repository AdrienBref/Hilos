# Diálogo TCP y Base de Datos
## Descripción del Programa

Se desarrolla un programa donde un servidor TCP almacena información sobre el incremento salarial en 2024 de los empleados de una compañía, para ser guardada en una base de datos. Este servidor TCP puede manejar hasta 3 conexiones de clientes de manera simultánea. Por cada solicitud, el servidor proporciona los siguientes datos:

- Nombre del empleado
- Apellidos del empleado
- Sueldo actual
- Porcentaje de aumento

Estos datos se presentan en el siguiente formato: `<stx><coma>nombre<coma>apellidos<coma>sueldo<coma>porcentaje<coma><etx>`

### Ejemplo de Datos: 1,Samuel,Fraisoli,35000,15,3


Para gestionar las conexiones al servidor, se utilizan semáforos.

## Servidor de Base de Datos

Por otro lado, se cuenta con un servidor para acceder a la base de datos. Este servidor:

- Solo acepta una conexión de cliente a la vez.
- Procesa únicamente un parámetro por consulta para almacenar en la tabla `SubidaSueldoEmpleados`.

La gestión de hilos se realiza mediante monitores, asegurando que cada conexión añada un parámetro de forma efectiva.

## Resultado Final

Al concluir el ejercicio, se espera obtener una tabla `SubidaSueldoEmpleados` con información correspondiente a 30 empleados. Los valores específicos de los parámetros son a elección.
