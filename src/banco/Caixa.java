package banco;

import Entidades.Conta;
import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
	
	static private ArrayList<Conta> contas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	static Conta login;

	public static void main(String[] args) {
		boolean a = true;
		Conta conta1 = new Conta("1231", "Rafael");
		contas.add(conta1);
		Conta conta2 = new Conta("3465", "Carlos");
		contas.add(conta2);
		
		while (a) {
			
			System.out.print("Bem- vindo ao Banco\nDigite o numero da conta: ");
			String numConta = sc.nextLine();
			login = buscarConta(numConta) ;
			if (login != null) {
				numConta = "";
				menu(login);
			} else {
				System.out.println("Conta inexistente...... tente novamente");
			}

		}

	}
	 public static Conta buscarConta(String numeroConta) { 
		 // função para buscar a conta no Array
	        for (Conta c : contas) {
	            if (c.getNumConta().equals(numeroConta)) {
	                return c;
	            }
	        }
	        return null; // caso não ache
	    }

	 public static void menu(Conta login) {
		boolean b = true;

		while (b) {
			System.out.println(login.getTitular() + " o que gostária de fazer?");
			System.out.print("1 - Depositar\n" + "2 -Sacar\n" + "3 - Transferir\n" + "4 - Exibir Saldo\n"
					+ "5 - Sair \n" + "[apenas numero]: ");
			int op = sc.nextInt();
			sc.nextLine(); 
			
			switch (op) {

				case 1:
					
					System.out.println("Qual é o valor que deseja depositar:");
					login.depositar(sc.nextFloat());
					break;
					
				case 2:
					
					System.out.println("Qual é o valor que deseja sacar:");
					login.sacar(sc.nextFloat());
					break;
					
				case 3:
					
					System.out.println("Qual é o valor que deseja transferir:");
					float valor = sc.nextFloat();
					sc.nextLine();
					
					System.out.println("Qual é o numero da conta para qual deseja transferir ");
					String numConta = sc.nextLine();
					
					Conta destino = buscarConta(numConta) ;
					
						if (destino != null) {
							login.transferir(valor, destino);
							
						} else {
							System.out.println("Conta inexistente...... \noperação cancelada");
						};
						break;
				case 4:
					login.exibirSaldo();
					break;
				case 5:
					b = false;   // sai do menu
				    login = null; // desloga
				return;

			}
		}
	}

}
