# Sistema de Atención de Pacientes en Emergencias

Este programa implementa un sistema de atención de pacientes en la sección de Emergencias de un hospital, utilizando una cola con prioridad basada en un heap.

## Descripción

Al iniciar el programa, se carga una lista de pacientes desde un archivo de texto (`pacientes.txt`). Cada paciente tiene un nombre, un síntoma y un código de emergencia que indica la prioridad de atención (de la A a la E, donde A es la más alta y E la más baja).

El programa utiliza las siguientes clases:

- `Paciente`: Representa la información de un paciente y permite comparar pacientes por su código de emergencia.
- `VectorHeap`: Implementa una cola con prioridad basada en un heap, utilizando `PriorityQueue` de Java.

## Uso

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
