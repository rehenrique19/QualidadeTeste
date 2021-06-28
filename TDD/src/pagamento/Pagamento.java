package pagamento;

import java.util.Date;

public class Pagamento {

	private String tipoPagamento;
	private Date data;
	private double valorPago;
	
	public Pagamento(String tipoPagamento, Date data, double valorPago) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.data = data;
		this.valorPago = valorPago;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
}
