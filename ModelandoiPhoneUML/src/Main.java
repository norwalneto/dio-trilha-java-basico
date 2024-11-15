public class Main {
    public static void main(String[] args) {
        // Criando um objeto do tipo IPhone
        IPhone iphone = new IPhone();

        // Testando funcionalidades do Reprodutor Musical
        System.out.println("=== Testando Reprodutor Musical ===");
        iphone.tocar(); // Teste para iniciar a música
        iphone.selecionarMusica("Imagine - John Lennon"); // Teste para selecionar uma música
        iphone.pausar(); // Teste para pausar a música

        // Testando funcionalidades do Aparelho Telefônico
        System.out.println("\n=== Testando Aparelho Telefônico ===");
        iphone.ligar("123456789"); // Teste para realizar uma ligação
        iphone.atender(); // Teste para atender uma chamada
        iphone.iniciarCorreioVoz(); // Teste para iniciar o correio de voz

        // Testando funcionalidades do Navegador na Internet
        System.out.println("\n=== Testando Navegador na Internet ===");
        iphone.exibirPagina("https://www.apple.com"); // Teste para exibir uma página
        iphone.adicionarNovaAba(); // Teste para adicionar uma nova aba
        iphone.atualizarPagina(); // Teste para atualizar a página
    }
}