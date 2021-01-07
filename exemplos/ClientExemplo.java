package exemplos;

import protocols.RunProtocol;
import java.net.Socket;

/*
 * Cliente simples
 */
public class ClientExemplo {
    public static void main(String[] args){
        // Instancia protocolo no modo cliente
    	ProtocoloSmss smss = new ProtocoloSmss(ProtocoloSmss.CLIENT);
        // Referencia para socket TCP
        Socket sk = null;
        // Referencia para executor do protocolo implementado com ProtocolModel
        RunProtocol run = null;
        
        // entradas algoritmo:
        int origem = 43542;
        int destino = 43563;
        
        /* ALGORITMO: AES128 - CÓDIGO 0 */
    	byte algoritmo = 0;
    	
    	/* PADDING: NO PADDING - CÓDIGO 0 */
    	byte padding = 0;
    	
    	/* MODO: CFB128 - C�DIGO 5 */
    	int modo = 5;
        
    	try {
            sk = new Socket("localhost", 50000);
            run = new RunProtocol(sk);
            // Define mensagem
            smss.setMensagem("Teste simples de mensagem...");
            
            // setando valores do protocolo smss:
            smss.setAlgoritmo(algoritmo);
            smss.setPadding(padding);
            smss.setModo(modo);
            
            System.out.println("Executando protocolo ...");
            // Chama o método que roda o protocolo do tipo ProtocolModel
            run.runProtocol(smss);
            if (smss.errorStatus()){
                System.out.println("CODIGO DE ERRO: " + smss.getErrorCode() + "\n");
            } else {
                System.out.println("Mensagem enviada com sucesso ...");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
