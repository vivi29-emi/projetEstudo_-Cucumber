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

	
	@Dado("{string} tem o saldo R$ {double}")
	public void cliente_tem_de_saldo_r$(String cliente, Double saldoConta) {
        
		conta = new ContaBancaria ();
		conta.setNomeCliente(cliente);
		conta.setSaldo(saldoConta);
	  
	}
	
	@Quando("deposita R$ {double}")
	public void deposita_r$(Double valor) {
		 
		 
		 if (conta.depositar(valor)) {
			 
				conta.getSaldo();
				
			}else {
				 conta.equals(null);
			}
	  
	}


	@Entao("o saldo e alterado R$ {double}")
	public void o_saldo_e_alterado(Double saldoBancaria) {
	 
	assertThat(conta.getSaldo(),is(saldoBancaria));
	}

	@Dado("que {string} possui o saldo R$ {double}")
	public void que_possui_o_saldo_r$(String cliente, Double saldoConta) {
		conta = new ContaBancaria ();
		conta.setNomeCliente(cliente);
		conta.setSaldo(saldoConta);
	   
	}

	@Quando("efetua um saque R$ {double}")
	public void efetua_um_saque_r$(Double valor) {
	 
		 if (conta.sacar(valor)) {
			 
			 conta.getSaldo();
				
			}else {
				 conta.equals(null);
			}
	}

	@Entao("o saldo da conta reduz R$ {double}")
	public void o_saldo_da_conta_reduz(Double saldoBancario) {
	   
		
		assertThat(conta.getSaldo(),is(saldoBancario));
		
	}
	
	// Teste de deposito em conta poupança e tem rendimento 
	
	@Dado("que {string}")
	public void que(String cliente) {
		contaPoupanca = new ContaPoupanca();
		contaPoupanca.setNomeCliente(cliente);
	    
	}
	@Quando("deposita R$ {int} no dia {int} é aplicado o rendimento {double} porcento")
	public void deposita_R$_no_dia_e_aplicado_o_rendimento_porcento(Integer valor, Integer diaRendiment, Double txRendiment) {
		contaPoupanca.depositar(valor);
		contaPoupanca.setDiaRendimento(diaRendiment);
		
		if(contaPoupanca.calcularNovoSaldo(txRendiment)) {
		     contaPoupanca.getSaldo();
			
		}else {
			
			contaPoupanca.equals(null);
		}
	
		
	}
	@Então("o saldo  vai para R$ {double}")
	public void o_saldo_vai_para_R$(Double saldoPoupanca) {
	    
		assertThat(contaPoupanca.getSaldo(),is(saldoPoupanca));
		
	}




   
	
}
