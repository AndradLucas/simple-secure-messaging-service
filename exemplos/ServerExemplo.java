/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplos;

import protocols.RunProtocol;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Servidor simples, apenas 1 conex�o atrav�s do ProtocoloExemplo
 * @author yeda
 */
public class ServerExemplo {
    public static void main(String[] args){
    	int a;
        // Instancia protocolo no modo servidor
        ProtocoloSmss prot = new ProtocoloSmss(ProtocoloSmss.SERVER);
        // Referencia para socket TCP
        ServerSocket ssk = null;
        Socket sk = null;
        // Referencia para executor do protocolo implementado com ProtocolModel
        RunProtocol run = null;
        
        try {
            // Cria socket servidor, que escuta requisi��o de conex�o
            ssk = new ServerSocket(50000);
            System.out.println("Aguardando conexao");
            // Aguarda requisi��o de conex�o
            sk = ssk.accept();
            System.out.println("Conexao aceita");
            run = new RunProtocol(sk);
            // Chama o método que roda o protocolo do tipo ProtocolModel
            run.runProtocol(prot);
            if (prot.errorStatus()){
                System.out.println("ERRO CÓDIGO: " + prot.getErrorCode());
            } else {
                System.out.println("\n**** MENSAGEM RECEBIDA ****\n" + prot.getMensagem() + "\n**********\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
