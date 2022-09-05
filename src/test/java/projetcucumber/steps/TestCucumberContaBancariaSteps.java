package projetcucumber.steps;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import projetcucumber.contabancaria.ContaBancaria;
import projetcucumber.contabancaria.ContaPoupanca;

public class TestCucumberContaBancariaSteps {
	
	private ContaBancaria conta;
	private ContaPoupanca contaPoupanca;
	
	

	// Teste quando cliente efetua um deposito
	
	@Dado("cliente tem um saldo R${int}")
	public void cliente_tem_um_saldo_r$(Integer saldoConta){
        
		conta = new ContaBancaria ();
		conta.setSaldo(saldoConta);
	  
	}
	
	@Quando("deposita R${int}")
	public void deposita_r$(Integer valor) {
		 
		 
		 if (conta.depositar(valor)) {
			 
				conta.getSaldo();
				
			}else {
				 conta.equals(null);
			}
	  
	}

	@Entao("o saldo e alterado R${double}")
	public void o_saldo_e_alterado_r$(Double saldoBancaria){
	 
	assertThat(conta.getSaldo(),is(saldoBancaria));
	}
	
	
	

	// Teste quando cliente efetua um saque
	
	
	@Dado("que cliente possui o saldo R${int}")
	public void que_cliente_possui_o_saldo_r$(Integer saldoConta) {
		conta = new ContaBancaria ();
		conta.setSaldo(saldoConta);
	   
	}

	@Quando("efetua um saque R${int}")
	public void efetua_um_saque_r$(Integer valor) {
	 
		 if (conta.sacar(valor)) {
			 
			 conta.getSaldo();
				
			}else {
				 conta.equals(null);
			}
	}

	@Entao("o saldo da conta reduz R${double}")
	public void o_saldo_da_conta_reduz_r$(Double saldoBancario) {
	   
		
		assertThat(conta.getSaldo(),is(saldoBancario));
		
	}
	
	
	// Teste de deposito em conta poupança e tem rendimento 
	
	@Dado("que cliente")
	public void que() {
		contaPoupanca = new ContaPoupanca();
		
	    
	}
	@Quando("deposita R${int}  no {int} é aplicado o rendimento {double}")
	public void deposita_r$_no_é_aplicado_o_rendimento(Integer valor, Integer diaRendiment, Double txRendiment) {
		contaPoupanca.depositar(valor);
		contaPoupanca.setDiaRendimento(diaRendiment);
		
		if(contaPoupanca.calcularNovoSaldo(txRendiment)) {
		     contaPoupanca.getSaldo();
			
		}else {
			
			contaPoupanca.equals(null);
		}
	
		
	}
	@Então("o saldo  vai para R${double}")
	public void o_saldo_vai_para_r$(Double saldoPoupanca)  {
	    
		assertThat(contaPoupanca.getSaldo(),is(saldoPoupanca));
		
	}
	

	






   
	
}
