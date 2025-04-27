import java.util.ArrayList;
import java.util.List;

public class SimuladorBanco {
    public static void main(String[] args) throws InterruptedException {
        int numeroCaixas = 5;
        long duracaoSimulacaoMillis = 2 * 60 * 1000; // 1 horas simulada = 1 minuto real

        FilaClientes fila = new FilaClientes();
        Estatisticas estatisticas = new Estatisticas();

        GeradorDeClientes gerador = new GeradorDeClientes(fila, duracaoSimulacaoMillis);
        gerador.start();

        List<Caixa> caixas = new ArrayList<>();
        for (int i = 0; i < numeroCaixas; i++) {
            Caixa caixa = new Caixa(fila, estatisticas);
            caixas.add(caixa);
            caixa.start();
        }

        gerador.join();
        Thread.sleep(5000);

        for (Caixa caixa : caixas) {
            caixa.interrupt(); 
            caixa.join();
        }
        estatisticas.imprimirRelatorio();
    }
}
