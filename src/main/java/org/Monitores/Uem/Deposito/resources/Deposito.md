# Simulación de un Depósito de Agua con Monitores

## Descripción del Proceso
- **Llenado Inicial**:
    - Un depósito de agua se llena a un ritmo de **10 litros por segundo**.
- **Activación del Vaciado**:
    - Al alcanzar los **900 litros**, se inicia un proceso de vaciado a razón de **5 litros por segundo**.
- **Llenado Detenido**:
    - Cuando el depósito llega a **1000 litros**, el proceso de llenado se detiene y el ritmo de vaciado se incrementa a **10 litros por segundo**.
- **Reinicio del Llenado**:
    - Al reducirse a **100 litros** durante el vaciado, se reactiva el llenado a un ritmo de **5 litros por segundo**.
- **Detención del Vaciado**:
    - Una vez vaciado completamente (**0 litros**), el proceso de vaciado se detiene y el llenado se incrementa nuevamente a **10 litros por segundo**.

## Objetivo de la Simulación
- Implementar un sistema que simule los procesos de llenado y vaciado del depósito utilizando **monitores**.
- Representar en pantalla las acciones tomadas durante la simulación, mostrando el estado actual del depósito y las transiciones entre los distintos ritmos de llenado y vaciado.
