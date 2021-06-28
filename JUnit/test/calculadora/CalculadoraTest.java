package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Compara��o de numero maior")
	@Test
	public void comparaMaior() {
		int comp = calc.compara(8, 5);
		Assert.assertEquals(1, comp);
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Compara��o de numero menor")
	@Test
	public void comparaMenor() {
		int comp = calc.compara(5, 10);
		Assert.assertEquals(-1, comp);
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Compara��o de numero menor")
	@Test
	public void comparaIgual() {
		int comp = calc.compara(5, 5);
		Assert.assertEquals(0, comp);
	}

	@SuppressWarnings("deprecation")
	@DisplayName("Verifica numero positivo")
	@Test
	public void positivo() {
		boolean comp = calc.ehPositivo(5);
		Assert.assertEquals(true, comp);
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Verifica numero negativo")
	@Test
	public void negativo() {
		boolean comp = calc.ehPositivo(-5);
		Assert.assertEquals(false, comp);
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Verifica somatoria de um numero")
	@Test
	public void somatorio() {
		int comp = calc.somatoria(13);
		Assert.assertEquals(91, comp);
	}
}


