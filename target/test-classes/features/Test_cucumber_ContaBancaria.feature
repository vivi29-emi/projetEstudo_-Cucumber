#language:pt

Funcionalidade: Teste Conta Bancaria

Cenario: Cliente efetua um deposito

Dado "cliente_id" tem o saldo R$ 200
Quando deposita R$ 200
Entao o saldo e alterado R$ 400


Cenario: Cliente efetua um saque

Dado que "clinte_id" possui o saldo R$ 400
Quando efetua um saque R$ 100
Entao o saldo da conta reduz R$ 300


Cenario: Cliente efetua um deposito e tem rendimento na conta Poupança

Dado que "cliente_Id" 
Quando deposita R$ 100 no dia 30 é aplicado o rendimento 0,5 porcento
Então o saldo  vai para R$ 150


 