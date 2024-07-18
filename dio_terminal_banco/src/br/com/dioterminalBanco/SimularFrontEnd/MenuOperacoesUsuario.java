package br.com.dioterminalBanco.SimularFrontEnd;

import javax.swing.JOptionPane;

import br.com.dioterminalBanco.MetodosComerciais.MetodosComerciais;

public class MenuOperacoesUsuario {

    public static void main(String[] args) {
        MenuOperacoesUsuario menu = new MenuOperacoesUsuario();
        MetodosComerciais funcionalidades = new MetodosComerciais();
        menu.menuUsuario(funcionalidades);
    }

    public void menuUsuario(MetodosComerciais funcionalidades) {
        String menuUsuarioOPC = "Seja bem-vindo(a) ao nosso sistema bancário.\n"
                + "Digite o número correspondente à opção desejada:\n"
                + "1- Listar contas criadas\n"
                + "2- Listar contas por tipo\n"
                + "3- Adicionar nova conta\n"
                + "4- Realizar operações (Saque, Depósito, Consultar Saldo)\n"
                + "5- Sair do sistema";

        int opcao = 0;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menuUsuarioOPC));

                if (opcao == 1) {
                    funcionalidades.listarContasCriadas();
                } else if (opcao == 2) {
                    funcionalidades.listarPorTipoConta();
                } else if (opcao == 3) {
                    funcionalidades.novaConta();
                } else if (opcao == 4) {
                    funcionalidades.operacoes();
                } else if (opcao == 5) {
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema. Até logo!");
                } else {
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException erroDeInsercaoDeCodigo) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        } while (opcao != 5);
    }
}

