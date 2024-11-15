import java.util.Scanner;

public class ContaTerminal {
    // Atributos da classe
    private String titular;
    private double saldo;
    private String numeroConta;
    private String agencia;

    // Construtor
    public ContaTerminal(String titular, String numeroConta, String agencia, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldoInicial;
    }

    // Métodos
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque!");
        } else {
            System.out.println("Valor inválido para saque!");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void exibirDetalhesConta() {
        System.out.println("\n=== Detalhes da Conta ===");
        System.out.println("Titular: " + titular);
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }

    // Método principal para execução
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletando os dados da conta bancária
        System.out.println("Bem-vindo ao Banco Simulado!");
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite o número da agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        // Criando a conta bancária
        ContaTerminal conta = new ContaTerminal(titular, numeroConta, agencia, saldoInicial);

        // Exibindo os detalhes da conta após a criação
        conta.exibirDetalhesConta();

        // Menu de opções
        int opcao;
        do {
            System.out.println("\n==== MENU BANCO ====");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Exibir Detalhes da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    conta.exibirDetalhesConta();
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar o Banco Simulado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
