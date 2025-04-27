public class GeradorDeClientes extends Thread {
    private final FilaClientes fila;
    private final long tempoSimulacaoMillis;

    public GeradorDeClientes(FilaClientes fila, long tempoSimulacaoMillis) {
        this.fila = fila;
        this.tempoSimulacaoMillis = tempoSimulacaoMillis;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        while (System.currentTimeMillis() - inicio < tempoSimulacaoMillis) {
            Cliente cliente = new Cliente();
            fila.adicionarCliente(cliente);
            System.out.println("Cliente gerado: " + cliente);

            long segundosSimulados = 5 + (long)(Math.random() * 45);
            long tempoEntreClientes = (segundosSimulados * 1000) / 10;
            try {
                Thread.sleep(tempoEntreClientes);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}