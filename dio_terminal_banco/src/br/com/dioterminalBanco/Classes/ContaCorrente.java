package br.com.dioterminalBanco.Classes;

public class ContaCorrente extends Conta {

	private static final int AGENCIA_PADRAOCC = 02;
	private static int SEQUENCIAl = 1;

	public int agenciaCP = AGENCIA_PADRAOCC;
	public int numeroCP = SEQUENCIAl++;

	private double limiteCreditoEspecial;

	public ContaCorrente(String nomeCliente, int telefone, int idade, double saldo, double depositar, int agenciaCP,
			int numeroCP) {
		super(nomeCliente, telefone, idade, saldo, sacar);
		this.agenciaCP = agenciaCP;
		this.numeroCP = numeroCP;
		definirLimiteChequeEspecial();
	}

	public void definirLimiteChequeEspecial() {
		if (idadeUsuario < 18 && idadeUsuario > 65) {
			limiteCreditoEspecial = 0;
		} else if (idadeUsuario >= 18 && idadeUsuario <= 25) {
			limiteCreditoEspecial = 100;
		} else if (idadeUsuario > 25 && idadeUsuario <= 40) {
			limiteCreditoEspecial = 250;
		} else if (idadeUsuario > 40 && idadeUsuario <= 65) {
			limiteCreditoEspecial = 500;
		}
	}

	public double getLimiteChequeEspecial() {
		return limiteCreditoEspecial;
	}
	public static int getSequencial() {
	    return SEQUENCIAl++;
	}

	@Override
	public void sacar(double valor) {
		double limiteTotal = super.getSaldo() + limiteCreditoEspecial;
		if (valor <= limiteTotal) {
			super.sacar(valor);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

}
