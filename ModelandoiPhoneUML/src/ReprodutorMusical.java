// Interface para Reprodutor Musical
// Esta interface define os métodos relacionados à reprodução de músicas.
public interface ReprodutorMusical {
    void tocar(); // Inicia a reprodução da música
    void pausar(); // Pausa a música em reprodução
    void selecionarMusica(String musica); // Seleciona uma música específica pelo nome
}
