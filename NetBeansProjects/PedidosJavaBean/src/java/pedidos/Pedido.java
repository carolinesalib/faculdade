package pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        
        if (this.produtos == null) {
            this.produtos = new ArrayList<Produto>();
        }
        this.produtos = produtos;
    }
    
    public void addProduto(Produto produto){
        if (this.produtos == null) {
            this.produtos = new ArrayList<Produto>();
        }
        this.produtos.add(produto);
    }
    
}
