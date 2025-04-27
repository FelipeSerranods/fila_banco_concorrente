import java.util.ArrayList;
import java.util.List;

public class Estatisticas {
    private final List<Cliente> clientesAtendidos = new ArrayList<>();

    public synchronized void registrarCliente(Cliente cliente) {
        clientesAtendidos.add(cliente);
    }

    public void imprimirRelatorio() {
        if (clientesAtendidos.isEmpty()) {
            System.out.println("Nenhum cliente atendido.");
            return;
        }
    
        long maxEsperaMs = 0;
        long maxAtendimentoMs = 0;
        long somaTempoTotalMs = 0;
        long somaEsperaMs = 0;
    
        for (Cliente cliente : clientesAtendidos) {
            long esperaMs = cliente.getTempoDeEspera();
            long atendimentoMs = cliente.getTempoDeAtendimento();
            long totalMs = cliente.getTempoTotalNoBanco();
    
            if (esperaMs > maxEsperaMs)
                maxEsperaMs = esperaMs;
            if (atendimentoMs > maxAtendimentoMs)
                maxAtendimentoMs = atendimentoMs;
    
            somaTempoTotalMs += totalMs;
            somaEsperaMs += esperaMs;
        }

        double mediaTempoTotalSegundos = (double) somaTempoTotalMs / clientesAtendidos.size() / 1000;
        double mediaEsperaSegundosSimulados = (double) somaEsperaMs / clientesAtendidos.size() / 1000;

        double mediaEsperaSegundosReais = mediaEsperaSegundosSimulados * 10;
        double maxEsperaSegundos = (double) maxEsperaMs / 1000;
        double maxAtendimentoSegundos = (double) maxAtendimentoMs / 1000;
    
        System.out.println("\n---- Relatório ----");
        System.out.println("Clientes atendidos: " + clientesAtendidos.size());
        System.out.println("Tempo máximo de espera: " + maxEsperaSegundos + " segundos");
        System.out.println("Tempo máximo de atendimento: " + String.format("%.1f", maxAtendimentoSegundos) + " segundos");
        System.out.println("Tempo médio total no banco: " + String.format("%.1f", mediaTempoTotalSegundos) + " segundos");
        System.out.println("Tempo médio de espera: " + String.format("%.1f", mediaEsperaSegundosReais) + " segundos");
    
        if (mediaEsperaSegundosReais <= 120) {
            System.out.println("Objetivo atingido: média de espera menor ou igual a 2 minutos!");
        } else {
            System.out.println("Objetivo não atingido: média de espera maior que 2 minutos.");
        }
    }
}

