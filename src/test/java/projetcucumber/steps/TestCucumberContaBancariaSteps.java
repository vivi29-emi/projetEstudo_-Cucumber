package projetcucumber.steps;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import projetcucumber.contabancaria.ContaBancaria;

public class TestCucumberContaBancariaSteps {
	
	private ContaBancaria conta;

	
	@Dado("cliente {string} tem de saldo R$ {double}")
	public void cliente_tem_de_saldo_r$(String cliente, Double saldoConta) {
        
		conta = new ContaBancaria ();
		conta.setNomeCliente(cliente);
		conta.setSaldo(saldoConta);
	  
	}
	
	@Quando("deposita um valor R$ {double}")
	public void deposita_um_valor_r$(Double valor) {
		 
		 
		 if (conta.depositar(valor)) {
				conta.getSaldo();
				
				System.out.println("Valor depositado com sucesso! saldo atual " + conta.getSaldo());
			
				
			}else {
				System.out.println(" O valor não foi depositado" + conta.getSaldo());
			}
	  
	}


	@Entao("o valor é depositado e multiplicado tendo o total de R$ {double} na sua conta com sucesso")
	public void o_valor_é_depositado_e_multiplicado_tendo_o_total_de_r$_na_sua_conta_com_sucesso(Double saldoBancaria) {
	 
	assertThat(conta.getSaldo(),is(saldoBancaria));
	}

	@Dado("que cliente {string} tem de saldo R$ {double}")
	public void que_cliente_tem_de_saldo_r$(String cliente, Double saldoConta) {
		conta = new ContaBancaria ();
		conta.setNomeCliente(cliente);
		conta.setSaldo(saldoConta);
	   
	}

	@Quando("efetua um saque no valor R$ {double}")
	public void efetua_um_saque_no_valor_r$(Double valor) {
	 
		 if (conta.sacar(valor)) {
			 conta.getSaldo();
				
				System.out.println("saque efetuado com sucesso! saldo atual " + conta.getSaldo());
			
				
			}else {
				System.out.println(" saldo indisponível " + valor);
			}
	}

	@Entao("o valor é  subtraido tendo um total de R$ {double} na sua conta com sucesso")
	public void o_valor_é_subtraido_tendo_um_total_de_r$_na_sua_conta_com_sucesso(Double saldoBancario) {
	   
		
		assertThat(conta.getSaldo(),is(saldoBancario));
		
	}
	



   
	
}
