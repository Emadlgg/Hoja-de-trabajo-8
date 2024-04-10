import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {
    private VectorHeap<Paciente> heap;

    @BeforeEach
    public void setUp() {
        heap = new VectorHeap<>();
        // Agregar pacientes de prueba al heap
        heap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        heap.add(new Paciente("Lorenzo Toledo", "chikungunya", 'E'));
        heap.add(new Paciente("Carmen Sarmientos", "dolores de parto", 'B'));
    }

    @Test
    public void testAdd() {
        // Verificar que el tamaño del heap aumente después de agregar un paciente
        assertEquals(4, getHeapSize(heap));
        heap.add(new Paciente("Pedro Hernandez", "accidente automovilístico", 'A'));
        assertEquals(5, getHeapSize(heap));
    }

    @Test
    public void testRemove() {
        // Verificar que se elimine el paciente con mayor prioridad (código 'A')
        Paciente pacienteRemovido = heap.remove();
        assertEquals("Maria Ramirez", pacienteRemovido.getNombre());
        assertEquals(3, getHeapSize(heap));

        // Verificar que se eliminen los pacientes en orden de prioridad
        assertEquals("Carmen Sarmientos", heap.remove().getNombre());
        assertEquals("Juan Perez", heap.remove().getNombre());
        assertEquals("Lorenzo Toledo", heap.remove().getNombre());
        assertTrue(heap.isEmpty());
    }

    // Método auxiliar para obtener el tamaño de la PriorityQueue dentro de VectorHeap
    private int getHeapSize(VectorHeap<Paciente> vectorHeap) {
        try {
            // Uso de reflexión para obtener el tamaño de la cola subyacente
            PriorityQueue<Paciente> queue = (PriorityQueue<Paciente>) vectorHeap.getClass()
                    .getDeclaredField("heap").get(vectorHeap);
            return queue.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
