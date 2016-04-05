/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaotopicos2;

/**
 *
 * @author caroline
 */
public class ContaPoupanca {
    
    protected int codigo;
    protected String cliente;
    protected Double saldo;
    
    public String getCliente(){
        return this.cliente;
    }
    
    public double getSaldo(){
        return (this.saldo == null ? 0 : this.saldo);
    }
    
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    
    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
    
    public void depositar(Double valor){
        this.saldo += valor;
    }
    
    public boolean sacar(Double valor){
        
        if (this.saldo-valor < 0) return false;
        
        this.saldo -= valor;
        
        return true;
    } 
}
