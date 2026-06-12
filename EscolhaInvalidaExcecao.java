public class EscolhaInvalidaExcecao extends Exception {
    private int escolhaFeita;

    public EscolhaInvalidaExcecao(int escolhaFeita) {
        super("Opcao invalida: " + escolhaFeita + ". Tente novamente.");
        this.escolhaFeita = escolhaFeita;
    }

    public int getEscolhaFeita() {
        return escolhaFeita;
    }
}