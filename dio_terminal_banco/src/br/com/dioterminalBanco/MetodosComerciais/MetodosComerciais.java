package br.com.dioterminalBanco.MetodosComerciais;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.dioterminalBanco.Classes.Conta;
import br.com.dioterminalBanco.Classes.ContaCorrente;
import br.com.dioterminalBanco.Classes.ContaPoupanca;

public class MetodosComerciais {

	private static ArrayList<Conta> contas = new ArrayList<>();

	public void listarContasCriadas() {
		if (!contas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Total de contas criadas: " + contas.size());
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas registradas em nosso sistema");
		}
	}

	public void listarPorTipoConta() {
		while (true) {
			String opcaoStr = JOptionPane
					.showInputDialog("Digite o tipo de conta que deseja listar:\n1- C. Poupança\n2- C. Corrente");
			if (opcaoStr == null) {
				break;
			}

			try {
				int opcao = Integer.parseInt(opcaoStr);

				if (opcao == 1) {
					int countPoupanca = 0;
					for (Conta conta : contas) {
						if (conta instanceof ContaPoupanca) {
							countPoupanca++;
						}
					}
					JOptionPane.showMessageDialog(null, "Temos um total de: " + countPoupanca + " conta(s) poupança.");
				} else if (opcao == 2) {
					int countCorrente = 0;
					for (Conta conta : contas) {
						if (conta instanceof ContaCorrente) {
							countCorrente++;
						}
					}
					JOptionPane.showMessageDialog(null, "Temos um total de: " + countCorrente + " conta(s) corrente.");
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
			}
		}
	}

	public void novaConta() {
		Conta novaConta = null;
		boolean sair = false;

		do {
			String opcaoStr = JOptionPane.showInputDialog(
					"Digite o tipo de conta que deseja criar:\n1 - Conta Poupança\n2 - Conta Corrente\n3 - Sair");
			try {
				int opcao = Integer.parseInt(opcaoStr);

				if (opcao == 1 || opcao == 2) {
					String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
					if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O nome do cliente não pode estar vazio.");
						continue;
					}
					int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do cliente:"));
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente:"));
					double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial:"));

					if (opcao == 1) {
						novaConta = new ContaPoupanca(nomeCliente, telefone, idade, saldo, 0, 1,
								ContaPoupanca.getSequencial());
					} else if (opcao == 2) {
						novaConta = new ContaCorrente(nomeCliente, telefone, idade, saldo, 0, 2,
								ContaCorrente.getSequencial());
					}
				} else if (opcao == 3) {
					sair = true;
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite 1, 2 ou 3.");
				}
			} catch (NumberFormatException inputInvalido) {
				JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
			}
		} while (novaConta == null && !sair);

		if (!sair && novaConta != null) {
			contas.add(novaConta);

			String tipo = novaConta instanceof ContaPoupanca ? "poupança" : "corrente";
			JOptionPane.showMessageDialog(null,
					"Conta " + tipo + " criada com sucesso para " + novaConta.getNomeCliente() + ".");
		} else if (!sair) {
			JOptionPane.showMessageDialog(null, "A criação da conta falhou. Por favor, tente novamente.");
		}
	}

	public void operacoes() {
		while (true) {
			String opcaoStr = JOptionPane.showInputDialog(
					"Digite a operação que deseja realizar:\n1 - Saque\n2 - Depósito\n3 - Consultar Saldo\n4 - Sair");
			if (opcaoStr == null) {
				break;
			}

			try {
				int opcao = Integer.parseInt(opcaoStr);

				if (opcao >= 1 && opcao <= 3) {
					String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
					Conta contaEncontrada = null;
					for (Conta conta : contas) {
						if (conta.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
							contaEncontrada = conta;
							break;
						}
					}

					if (contaEncontrada == null) {
						JOptionPane.showMessageDialog(null, "Conta não encontrada.");
						continue;
					}

					if (opcao == 1) {
						double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
						if (contaEncontrada instanceof ContaCorrente) {
							((ContaCorrente) contaEncontrada).sacar(valorSaque);
						} else if (contaEncontrada instanceof ContaPoupanca) {
							contaEncontrada.sacar(valorSaque);
						}
						JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
					} else if (opcao == 2) {
						double valorDeposito = Double
								.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito:"));
						contaEncontrada.depositar(valorDeposito);
						JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.");
					} else if (opcao == 3) {
						double saldo = contaEncontrada.consultarSaldo();
						JOptionPane.showMessageDialog(null, "Saldo atual: " + saldo);
					}
				} else if (opcao == 4) {
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite 1, 2, 3 ou 4.");
				}
			} catch (NumberFormatException inputInvalido) {
				JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
			}
		}
	}

}
