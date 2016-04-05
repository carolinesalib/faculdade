/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaotopicos2;

/**
 *
 * @author caroline
 */
public class RevisaoTopicos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ContaPoupanca conta = new ContaCorrente();
        
        conta.setSaldo(100.0);
        
        conta.sacar(10.0);
        
        System.out.println(conta.getSaldo());
    }
}
