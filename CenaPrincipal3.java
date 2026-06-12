import java.util.*;
 
public class CenaPrincipal3 {
    public static void main(String[] args) {
        HashMap<String, Boolean> itens = new HashMap<>();
        Dice dado = null;
        Scanner scanner = new Scanner(System.in);
 
        //-------------------------------CRIAR OS STAGES
        Stage2 fimPUTAQUEPARIU = new Stage2("puta que pariu!","vc eh um merda kappa kappa kappa","vaidagem");
 
        Stage2 floresta = new Stage2(
            "floresta pog",
            "poggers",
            "Nenhum"
        );
 
        Stage2 caverna = new Stage2(
            "escuro pog",
            "poggers",
            "Lanterna"
        );
 
        Stage2 cabana = new Stage2(
            "cabana pog",
            "poggers",
            "MACHADO FODA"
        );
 
        Stage2 fimMonstro = new Stage2("bruh", "devorado.", "Nenhum");
        Stage2 fimTesouro = new Stage2("nah id win", "vc ganho yay", "vibrava");
 
        // ------------------------------COLOCAR AS FALAS DE CADA CAMINHO
 
        floresta.adicionaCaminho("ir no escurinho ihh", "caverna", "fim_monstro", 20);
        floresta.adicionaCaminho("cabana????", "cabana", "fim_PUTAQUEPARIU", 6);
 
        caverna.adicionaCaminho("tisoro", "fim_tesouro", "fim_monstro", 12);
        caverna.adicionaCaminho("nao vah por aqui meno", "fim_monstro", "fim_monstro", 6);
        caverna.adicionaCaminho("OwO voltar e se cagar", "inicio", "inicio", 6);
 
        cabana.adicionaCaminho("confia vem aqui hihihiih", "fim_monstro", "fim_PUTAQUEPARIU", 20);
        cabana.adicionaCaminho("dar de costas p-p", "inicio", "inicio", 6);
 
        // ---------------------------------COLOCAR NO HASHMAP OS LOCAIS COM O DEVIDO NOME
        HashMap<String, Stage2> stages = new HashMap<>();
 
        //EXEMPLOS
        stages.put("inicio", floresta);
        stages.put("caverna", caverna);
        stages.put("cabana", cabana);
        stages.put("fim_monstro", fimMonstro);
        stages.put("fim_tesouro", fimTesouro);
        stages.put("fim_PUTAQUEPARIU", fimPUTAQUEPARIU);
 
        // ------------------------------SELECAO DE PERSONAGEM COM EXCECAO
        System.out.println("Escolha seu personagem: 1, 2 ou 3:");
        A personagem = null;
        while (personagem == null) {
            try {
                int escolhaPersonagem = Integer.parseInt(scanner.nextLine());
                if (escolhaPersonagem == 1)
                    personagem = new A("Guerreiro", 10, 15, 5, 12);
                else if (escolhaPersonagem == 2)
                    personagem = new A("Mago", 8, 5, 18, 7);
                else if (escolhaPersonagem == 3)
                    personagem = new A("Ladino", 12, 10, 10, 10);
                else
                    throw new PersonagemInvalidoExcecao(escolhaPersonagem);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido!");
            } catch (PersonagemInvalidoExcecao e) {
                System.out.println(e.getMessage());
            }
        }
 
        System.out.println("oi pobrer ksksks, " + personagem.getName() + " lol");
        personagem.showStats();
        System.out.println("------------------------------------------");
 
        // --------------------------------JOGO-------------------------------------------------------------------------------------
        String idStageAtual = "inicio";
        boolean funcionando = true;
 
        while (funcionando) {
            Stage2 stageAtual = stages.get(idStageAtual);
 
            System.out.println("\n==========================================");
            System.out.println(stageAtual.showMessage());
            System.out.println(stageAtual.showMessageLocutor());
            System.out.println("==========================================");
 
            //se comecar com fim a chave o jogo acaba
            if (idStageAtual.startsWith("fim")) {
                funcionando = false;
                break;
            }
 
            System.out.println("escolhi k");
            stageAtual.mostraOpcoes();
 
            // ------------------------------ESCOLHA DO CAMINHO COM EXCECAO
            try {
                int escolha = Integer.parseInt(scanner.nextLine());
 
                if (!stageAtual.temOpcao(escolha)) {
                    throw new EscolhaInvalidaExcecao(escolha);
                }
 
                dado = new Dice(stageAtual.getDado(escolha));
                int resultadoDado = dado.roll();
 
                System.out.println("voce rolou um D" + stageAtual.getDado(escolha) + " e tirou: " + resultadoDado);
 
                boolean vitoria = resultadoDado >= (stageAtual.getDado(escolha) / 2);
 
                if (vitoria) {
                    System.out.println("Sucesso no teste!");
                    idStageAtual = stageAtual.getDestino(escolha);
                } else {
                    System.out.println("Falha no teste...");
                    idStageAtual = stageAtual.getDestinoPerder(escolha);
                }
 
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido!");
            } catch (EscolhaInvalidaExcecao e) {
                System.out.println(e.getMessage());
            }
        }
 
        System.out.println("pog acabo (:");
        scanner.close();
    }
}