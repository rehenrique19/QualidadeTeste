package processador;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
		fatura = new Fatura("Renan Henrique", new Date(), 1500.00);
		var boleto1 = new Boleto("123456-1", new Date(), 500.00);
		var boleto2 = new Boleto("123456-2", new Date(), 400.00);
		var boleto3 = new Boleto("123456-3", new Date(), 100.00);
		boletos.add(boleto1);
		boletos.add(boleto2);
		boletos.add(boleto3);
		processador = new Processador(boletos, fatura);
	}
	
	@Test
	public void testProcessaBoletos() {
		var retorno = processador.processaFatura();
		System.out.print(retorno);
		Assertions.assertEquals(retorno.size(), 3);
		for (Iterator i = retorno.iterator(); i.hasNext();) {
			Pagamento pagItem = (Pagamento) i.next();
			Assertions.assertEquals("BOLETO", pagItem.getTipoPagamento());
		}
		Assertions.assertEquals(false, this.fatura.getPago());
	}
}
