
package br.com.dioterminalBanco.Classes;

public abstract class Conta {
	private String nomeCliente;
	private int telefone;
	protected int idadeUsuario;
	protected double saldo;
	private double depositar;
	protected static double sacar;

	public Conta(String nomeCliente, int telefone, int idade, double saldo, double depositar) {
		super();
		this.nomeCliente = nomeCliente;
		this.telefone = telefone;
		this.idadeUsuario = idade;
		this.saldo = saldo;
		this.depositar = depositar;
		this.sacar = sacar;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idadeUsuario;
	}

	public void setIdade(int idade) {
		this.idadeUsuario = idade;
	}

	public double getSaldo() {
		return saldo;
	}

	public double consultarSaldo() {
		return saldo;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void sacar(double valor) {
		saldo -= valor;
	}
}