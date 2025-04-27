public class Caixa extends Thread {
    private final FilaClientes fila;
    private final Estatisticas estatisticas;

    public Caixa(FilaClientes fila, Estatisticas estatisticas) {
        this.fila = fila;
        this.estatisticas = estatisticas;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                Cliente cliente = fila.pegarProximoCliente();
                System.out.println("Atendendo cliente: " + cliente);
                cliente.iniciarAtendimento();

                long segundosSimulados = 40  + (long)(Math.random() * 140); // periodo em que o cliente será atendido
                long tempoRealEmMs = (segundosSimulados * 1000) / 10; // acelera a simulação
                Thread.sleep(tempoRealEmMs);

                cliente.finalizarAtendimento();
                estatisticas.registrarCliente(cliente);
            }
        } catch (InterruptedException e) {

        }
    }
}
