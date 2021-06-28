package carrinho;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Teste de classe Carrinho")
public class CarrinhoTest {

	private ArrayList items;
	private Carrinho car;
	
	@BeforeEach
	public void inicializa() {
		car = new Carrinho();
	}
	
	
	@DisplayName("Teste adição no Carrinho")
	@Test public void adiciona() {
		var prod = new Produto("Azeitona", 5.00);
		car.addItem(prod);
		Assert.assertEquals(prod, car.ultimoItemAdicionado()); 
	}	
	
	@DisplayName("Teste remoção no Carrinho")
	@Test public void remove() throws ProdutoNaoEncontradoException {
		var prod = new Produto("Azeitona", 5.00);
		car.addItem(prod);
		car.removeItem(prod);
		Assert.assertEquals(true, car.carrinhoSemAlgumProduto(prod)); 
	}
	
	@DisplayName("Teste valor total do Carrinho")
	@Test public void total() {
		var prod = new Produto("Azeitona", 5.00);
		var prod2 = new Produto("Creme de Leite", 2.30);
		var prod3 = new Produto("Margarina", 4.50);
		car.addItem(prod);
		car.addItem(prod2);
		car.addItem(prod3);
		Assert.assertEquals(11.80, car.getValorTotal(), 2);
	}	
}

