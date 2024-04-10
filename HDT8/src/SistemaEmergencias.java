import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SistemaEmergencias {

    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();

        // Cargar pacientes desde archivo (creando uno si no existe)
        cargarPacientesDesdeArchivo(colaEmergencias);

        // Atender pacientes en orden de prioridad
        while (!colaEmergencias.isEmpty()) {
            Paciente paciente = colaEmergencias.remove();
            System.out.println("Siguiente paciente:");
            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("Síntoma: " + paciente.getSintoma());
            System.out.println("Prioridad: " + paciente.getCodigoEmergencia());
            System.out.println();
        }
    }

    private static void cargarPacientesDesdeArchivo(VectorHeap<Paciente> cola) {
        File archivo = new File("pacientes.txt");

        try {
            if (!archivo.exists()) {
                // Si el archivo no existe, crearlo y agregar datos de ejemplo
                archivo.createNewFile();
                FileWriter writer = new FileWriter(archivo);
                writer.write("Juan Perez, fractura de pierna, C\n");
                writer.write("Maria Ramirez, apendicitis, A\n");
                writer.write("Lorenzo Toledo, chikungunya, E\n");
                writer.write("Carmen Sarmientos, dolores de parto, B\n");
                writer.close();
                System.out.println("Archivo pacientes.txt creado con datos de ejemplo.");
            }

            // Leer pacientes desde el archivo
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(", ");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    String sintoma = datos[1];
                    char codigoEmergencia = datos[2].charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    cola.add(paciente);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo.");
            e.printStackTrace();
        }
    }
}
