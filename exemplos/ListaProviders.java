package exemplos;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;
import java.util.Set;

public class ListaProviders {
    
    public static void main(String[] args) {
        int i,j;
        Enumeration en;
        Provider[] prov;
        Provider pr;
        
        prov = Security.getProviders();
        for(i=0;i<prov.length;i++){
            System.out.println(prov[i]);
        }
        Set<String> algs = Security.getAlgorithms("Cipher");
        System.out.println(algs);
        
        pr = Security.getProvider("SunJCE");
        System.out.println(pr.getService("Cipher","AES"));
        
        pr = Security.getProvider("SunJCE");
        System.out.println(pr.getService("Cipher","DES"));
    }
}
