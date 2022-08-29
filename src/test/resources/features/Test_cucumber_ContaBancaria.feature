#language:pt

Funcionalidade: Teste Conta Bancaria

Cenario: Cliente efetua um deposito

Dado cliente "Maria de Lurdes" tem de saldo R$ 200
Quando deposita um valor R$ 200
Entao o valor é depositado e multiplicado tendo o total de R$ 400 na sua conta com sucesso


Cenario: Cliente efetua um saque

Dado que cliente "Maria de Lurdes" tem de saldo R$ 400
Quando efetua um saque no valor R$ 100
Entao o valor é  subtraido tendo um total de R$ 300 na sua conta com sucesso 


 