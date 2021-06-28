package processador;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;


class ProcessadorTest {

	Processador processador;
	List<Boleto> boletos;
	Fatura fatura;
	
	@BeforeEach
	public void inicializa() {
		var date = new Date();
		fatura = new Fatura("Renan Henrique", date, 1500.00);
		var boleto1 = new Boleto("123456-1", date, 500.00);
		var boleto2 = new Boleto("123456-2", date, 400.00);
		var boleto3 = new Boleto("123456-3", date, 100.00);
		boletos = new ArrayList<Boleto>();
		boletos.add(boleto1);
		boletos.add(boleto2);
		boletos.add(boleto3);
		processador = new Processador(boletos, fatura);
	}
	
	@Test
	public void testSomaBoletos() {
		var retorno = processador.getValorTotalBoletos();
		Assertions.assertEquals(retorno, 1000.00);
	}
	
	@Test
	public void testProcessaBoletos() {
		var retorno = processador.processaFatura();
		System.out.print(retorno);
		Assertions.assertEquals(retorno.size(), 3);
		for (Iterator i = retorno.iterator(); i.hasNext();) {
			Pagamento pagItem = (Pagamento) i.next();
			Assertions.assertEquals("BOLETO",pagItem.getTipoPagamento()); 
		}
		Assertions.assertEquals(false,this.fatura.getPago());
		 
	}
}
