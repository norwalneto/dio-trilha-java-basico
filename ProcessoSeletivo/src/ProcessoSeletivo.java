import java.util.*;

public class ProcessoSeletivo {
    // Atributos do candidato
    private String nome;
    private int idade;
    private double notaProva;
    private boolean experiencia;
    private double salarioPretendido;

    // Configuração de critérios do RH
    private static int idadeMinima = 18;
    private static double notaMinima = 7.0;
    private static double salarioBase = 3000.0; // Salário base definido pelo RH
    private static int quantidadeMinimaCandidatos = 1; // Quantidade mínima de candidatos necessária

    // Lista de todos os candidatos
    private static List<ProcessoSeletivo> listaCandidatos = new ArrayList<>();
    private static List<ProcessoSeletivo> candidatosAprovados = new ArrayList<>();

    // Construtor
    public ProcessoSeletivo(String nome, int idade, double notaProva, boolean experiencia, double salarioPretendido) {
        this.nome = nome;
        this.idade = idade;
        this.notaProva = notaProva;
        this.experiencia = experiencia;
        this.salarioPretendido = salarioPretendido;
    }

    // Método para validar critérios
    public boolean validarCriterios() {
        boolean aprovado = true;

        if (idade < idadeMinima) {
            aprovado = false;
        }

        if (notaProva < notaMinima) {
            aprovado = false;
        }

        if (salarioPretendido > salarioBase) {
            aprovado = false;
        }

        return aprovado;
    }

    // Método para exibir apenas nome e idade no histórico
    public void exibirResumo() {
        System.out.println("Nome: " + nome + " | Idade: " + idade);
    }

    // Método para exibir informações completas (aprovados)
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nota da Prova: " + notaProva);
        System.out.println("Experiência Prévia: " + (experiencia ? "Sim" : "Não"));
        System.out.println("Salário Pretendido: R$ " + salarioPretendido);
        System.out.println("--------------------------------");
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuração inicial de critérios
        System.out.println("=== Configuração do Processo Seletivo ===");
        System.out.print("Informe a idade mínima exigida: ");
        idadeMinima = scanner.nextInt();
        System.out.print("Informe a nota mínima exigida: ");
        notaMinima = scanner.nextDouble();
        System.out.print("Informe o salário base máximo oferecido: ");
        salarioBase = scanner.nextDouble();
        System.out.print("Informe a quantidade mínima de candidatos necessária: ");
        quantidadeMinimaCandidatos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Entrada de dados dos candidatos
        int candidatosAdicionados = 0;
        while (candidatosAdicionados < quantidadeMinimaCandidatos) {
            System.out.println("\n=== Avaliação de Candidato ===");

            // Entrada de dados do candidato
            System.out.print("Nome do candidato: ");
            String nome = scanner.nextLine();
            System.out.print("Idade do candidato: ");
            int idade = scanner.nextInt();
            System.out.print("Nota da prova do candidato (0 a 10): ");
            double notaProva = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Possui experiência prévia? (sim/não): ");
            String experienciaStr = scanner.nextLine();
            boolean experiencia = experienciaStr.equalsIgnoreCase("sim");

            // Ler salário pretendido com validação
            double salarioPretendido = lerDoubleValido(scanner, "Informe o salário pretendido pelo candidato: ");
            scanner.nextLine(); // Limpar o buffer

            // Criar candidato
            ProcessoSeletivo candidato = new ProcessoSeletivo(nome, idade, notaProva, experiencia, salarioPretendido);
            listaCandidatos.add(candidato); // Adicionar à lista geral

            // Validar critérios
            if (candidato.validarCriterios()) {
                System.out.println("Candidato aprovado!");
                candidatosAprovados.add(candidato); // Adicionar à lista de aprovados
            } else {
                System.out.println("Candidato reprovado.");
            }

            candidatosAdicionados++;
            System.out.println("Candidatos adicionados: " + candidatosAdicionados + " de " + quantidadeMinimaCandidatos);
        }

        // Exibir histórico geral
        System.out.println("\n=== Histórico de Todos os Candidatos ===");
        for (ProcessoSeletivo candidato : listaCandidatos) {
            candidato.exibirResumo(); // Exibe apenas nome e idade
        }

        // Exibir apenas os aprovados
        System.out.println("\n=== Lista de Candidatos Aprovados ===");
        if (candidatosAprovados.isEmpty()) {
            System.out.println("Nenhum candidato foi aprovado.");
        } else {
            for (ProcessoSeletivo aprovado : candidatosAprovados) {
                aprovado.exibirInformacoes();
            }
        }

        scanner.close();
        System.out.println("\nProcesso seletivo encerrado!");
    }

    // Método para ler um valor numérico válido
    public static double lerDoubleValido(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); // Limpar o buffer
            }
        }
    }
}