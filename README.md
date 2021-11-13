# Propuesta de solución para Hackathon Ceiba 2021

## Descripción de la solución
Observando el comportamiento del servicio que vamos  consumir  se implementa   una solución  basada en  el patrón Circuit Breaker. 
Este  nos brinda   la facilidad de   manejar las  fallas  ocasionadas  por la  falta de disponibilidad en la  comunicación entre servicios   esto  lo hace simulando  un interruptor  eléctrico, el  flujo  parte de tres  estados:

<b>Closed:</b> El circuito está cerrado y el flujo fluye ininterrumpidamente estado inicial.

<b>Open:</b> El circuito está abierto y el flujo interrumpido devolviendo la ultima excepción.

</b>Half-Open:</b> El circuito está medio abierto (o medio cerrado) dando una oportunidad al flujo para su restauración

![Diagrama componentes!](./patron-circuit-breck-diagrama-flujo.svg "Diagrama de Solución")

## Drivers que orientan la toma de decisiones para la solución propuesta

Enumere los drivers de arquitectura (requisitos no funcionales) que su equipo tuvo en cuenta en la solución propuesta. P.ej: Seguridad, Usabilidad, etc.

## Diagrama de solución

| Elemento | Descripción |
| :----    | :---        | 
| DB | Guardar datos |    
