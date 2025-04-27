public class Cliente {
    private final long chegadaTimestamp;
    private long inicioAtendimentoTimestamp;
    private long fimAtendimentoTimestamp;

    public Cliente() {
        this.chegadaTimestamp = System.currentTimeMillis();
    }

    public void iniciarAtendimento() {
        this.inicioAtendimentoTimestamp = System.currentTimeMillis();
    }

    public void finalizarAtendimento() {
        this.fimAtendimentoTimestamp = System.currentTimeMillis();
    }

    public long getTempoDeEspera() {
        return inicioAtendimentoTimestamp - chegadaTimestamp;
    }

    public long getTempoDeAtendimento() {
        return fimAtendimentoTimestamp - inicioAtendimentoTimestamp;
    }

    public long getTempoTotalNoBanco() {
        return fimAtendimentoTimestamp - chegadaTimestamp;
    }
}
