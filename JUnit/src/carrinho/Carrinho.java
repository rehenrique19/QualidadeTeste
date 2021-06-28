package carrinho;

import java.util.ArrayList;
import java.util.Iterator;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class Carrinho {
	
	@SuppressWarnings("rawtypes")
	private ArrayList items;
	
	@SuppressWarnings("rawtypes")
	public Carrinho() {
		items = new ArrayList();
	}
	
	@SuppressWarnings("rawtypes")
	public double getValorTotal() {
		double valorTotal = 0.0;
		
		for (Iterator i = items.iterator(); i.hasNext();) {
			Produto item = (Produto) i.next();
			valorTotal += item.getPreco();
		}
		
		return valorTotal;
	}
	
	@SuppressWarnings("unchecked")
	public void addItem(Produto item) {
		items.add(item);
	}
	
	public void removeItem(Produto item) throws ProdutoNaoEncontradoException {
		if (!items.remove(item)) {
			throw new ProdutoNaoEncontradoException();
		}
	}
	
	public int getQtdeItems() {
		return items.size();
	}
	
	public void esvazia() {
		items.clear();
	}
	
	public Produto ultimoItemAdicionado() {
		return (Produto) items.get(items.size() - 1);
	}
	

	@SuppressWarnings("rawtypes")
	public boolean carrinhoSemAlgumProduto(Produto prod) {
		for(Iterator i = items.iterator(); i.hasNext();) {
			Produto item = (Produto) i.next();
			if (item.getNome() == prod.getNome()) {
				return false;
			}
		}
		return true;
	}
}

