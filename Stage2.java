import java.util.HashMap;
import java.util.Map;

public class Stage2 {
    private String mensagem;
    private String mensagemLocutor;
    private String item;
    
    //map pra juntar as ideias de escolha por numero, 1 2 3... com os nomes dos caminhos ou locais sla
    private Map<Integer, String> caminhos;
	private Map<Integer, String> caminhosPerder;
	private Map<Integer, Integer> dados;
    //guarda os textos, fala do locutor e descricao
    private Map<Integer, String> textosDasOpcoes;
    private int contadorOpcoes = 1;//o contador serve pra numerar as escolhas de 1 pra frente de cada stage

    public Stage2(String mensagem, String mensagemLocutor, String item) {
        this.mensagem = mensagem;
        this.mensagemLocutor = mensagemLocutor;
        this.item = item;
        this.caminhos = new HashMap<>();
		this.caminhosPerder = new HashMap<>();
		this.dados = new HashMap<>();
        this.textosDasOpcoes = new HashMap<>();
    }

    //adicionar um caminho ue kkkkkk
    public void adicionaCaminho(String textoOpcao, String idDestino, String idDestinoPerder, int valorDado) {
        textosDasOpcoes.put(contadorOpcoes, textoOpcao);
        caminhos.put(contadorOpcoes, idDestino);
		caminhosPerder.put(contadorOpcoes, idDestinoPerder);
		dados.put(contadorOpcoes, valorDado);
        contadorOpcoes++;
    }

    public String showMessage() {
        return mensagem;
    }

    public String showMessageLocutor() {
        return mensagemLocutor;
    }

    //mostra as opcoes de locomocao, caminho 1 2 3 etc 
    public void mostraOpcoes() {
        for (Map.Entry<Integer, String> opcao : textosDasOpcoes.entrySet()) {
            System.out.println(opcao.getKey() + " - " + opcao.getValue());
        }
    }

    // Verifica se o número digitado corresponde a uma opção válida
    public boolean temOpcao(int escolha) {
        return caminhos.containsKey(escolha);
    }
	
	public int getDado(int escolha){
		return dados.get(escolha);
	}

    // Retorna o ID do próximo cenário para onde o jogador vai
    public String getDestino(int escolha) {
        return caminhos.get(escolha);
    }
	
	public String getDestinoPerder(int escolha) {
		return caminhosPerder.get(escolha);
	}
}