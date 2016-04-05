/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaotopicos2;

/**
 *
 * @author caroline
 */
public class ContaCorrente extends ContaPoupanca {
   
    @Override
    public boolean sacar(Double valor){
        
        Double saque = valor*0.1;
                
        saque = saque + valor;
        
        if (this.saldo-saque < 0) return false;
        
        this.saldo -= saque;
        
        return true;
    } 
}
