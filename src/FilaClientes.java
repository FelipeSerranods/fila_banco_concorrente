import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FilaClientes {
    private final BlockingQueue<Cliente> fila = new LinkedBlockingQueue<>();

    public void adicionarCliente(Cliente cliente) {
        fila.add(cliente);
    }

    public Cliente pegarProximoCliente() throws InterruptedException {
        return fila.take();
    }
}
