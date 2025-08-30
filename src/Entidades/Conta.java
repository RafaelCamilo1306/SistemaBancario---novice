package Entidades;

public class Conta{
	private String numConta;
	private String titular;
	private float saldo;
	private float credito;

	
	public Conta(String numConta, String titular) {
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = 0;
		this.credito = 0;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	

	public String getNumConta() {
		return numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public float getCredito() {
		return credito;
	}
	
	
	public void depositar(float valor) {
		this.saldo+= valor;
	}
	public void sacar(float valor) {
		if(this.saldo > valor) {
			this.saldo-=valor;
			System.out.println("Transação realizada, R$"+valor+" foram retirados da sua conta");
		}else {
			System.out.println("Saldo indisponivel....\nTransação cancelada");
		}
			
	}
	
	public void transferir(float valor, Conta contaDestino){
		if(this.saldo > valor) {
			this.saldo-=valor;
			contaDestino.depositar(valor);
			System.out.println("Transação realizada, R$"+valor+" foram transferidos da sua conta para " + contaDestino.getTitular());
		}else {
			System.out.println("Saldo indisponivel....\nTransação cancelada");
		}
			
	}
	
	public void exibirSaldo() {
		System.out.println("======= Extrato =======");
		System.out.println("Titular: "+ titular);
		System.out.println("Numero da conta: "+ numConta);
		System.out.println("Saldo: R$"+ saldo );
		
	}
}
