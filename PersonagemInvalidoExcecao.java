public class PersonagemInvalidoExcecao extends Exception {
    private int escolhaFeita;

    public PersonagemInvalidoExcecao(int escolhaFeita) {
        super("Personagem invalido: " + escolhaFeita + ". Escolha 1, 2 ou 3.");
        this.escolhaFeita = escolhaFeita;
    }

    public int getEscolhaFeita() {
        return escolhaFeita;
    }
}