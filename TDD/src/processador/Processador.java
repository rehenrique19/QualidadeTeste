package processador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	private List<Boleto> boletos;
	private Fatura fatura;
	
	public Processador(List<Boleto> boletos, Fatura fatura) {
		this.boletos = boletos;
		this.fatura = fatura;
	}
	
	public double getValorTotalBoletos() {
		double valorTotal = 0.0;
		
		for (Iterator i = this.boletos.iterator(); i.hasNext();) {
			Boleto item = (Boleto) i.next();
			valorTotal += item.getValorPago();
		}
		return valorTotal;
	}
	
	public List<Pagamento> processaFatura() {
		List<Pagamento> pagamentos = new ArrayList<Pagamento>();
		for (Iterator i = this.boletos.iterator(); i.hasNext();) {
			Boleto item = (Boleto) i.next();
			Date date = new Date();
			Pagamento pagamento = new Pagamento("BOLETO", date, item.getValorPago());
			pagamentos.add(pagamento);
		}
		var totalBoleto = this.getValorTotalBoletos();
		if (totalBoleto >= this.fatura.getValorTotal()) {
			this.fatura.setPago(true);
		}
		else {
			this.fatura.setPago(false);
		}
		return pagamentos;
	}
}
