package br.com.dioterminalBanco.Classes;

public class ContaPoupanca extends Conta {

	private static final int AGENCIA_PADRAOCP = 01;
	private static int SEQUENCIAl = 1;

	public int agenciaCP = AGENCIA_PADRAOCP;
	public int numeroCP = SEQUENCIAl++;

	public ContaPoupanca(String nomeCliente, int telefone, int idade, double saldo, double depositar, int agenciaCP,
			int numeroCP) {
		super(nomeCliente, telefone, idade, saldo, sacar);
		this.agenciaCP = agenciaCP;
		this.numeroCP = numeroCP;
	}

}
