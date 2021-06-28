package fatura;

import java.util.Date;

public class Fatura {

	private String nomeCliente;
	private Date data;
	private double valorTotal;
	private boolean pago;
	
	public Fatura(String nomeCliente, Date data, double valorTotal) {
		super();
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.valorTotal = valorTotal;
		this.pago = false;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public boolean getPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
}
