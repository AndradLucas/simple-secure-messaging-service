/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplos;

import java.util.Scanner;
import protocols.RunProtocol;
import protocols.SecureSuite;
import java.net.Socket;

/**
 * Cliente simples
 * @author yeda
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
        
        Scanner scan = new Scanner(System.in);
        
        /* ALGORITMO: AES128 - CÓDIGO 0 */
    	byte algoritmo = 0;
    	
    	/* PADDING: NO PADDING - CÓDIGO 0 */
    	byte padding = 0;
    	
    	/* MODO: CFB128 - C�DIGO 5 */
    	int modo = 5;
    	
    	//System.out.println("Código do algoritmo"); 
    	//algoritmo = scan.nextLine();   
        
    	try {
            sk = new Socket("localhost", 50000);
            run = new RunProtocol(sk);
            // Define mensagem e valor inicial
            // limitado ao valor 124 (pois valor maximo positivo de 1 byte
            // com sinal � 127 (124+3)
            smss.setMensagem("Teste simples de mensagem...");
            smss.setValor(17);
            
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
