#language:pt


Funcionalidade: Teste Conta Bancaria

Esquema do Cenário: Faz um deposito

Dado cliente tem um saldo R$<Saldo>
Quando deposita R$<Deposito>
Entao o saldo e alterado R$<saldoFinal>

Exemplos:
|  Saldo   |   Deposito  |saldoFinal|
|   200    |      200    |     400  |


Esquema do Cenário: Faz um saque


Dado que cliente possui o saldo R$<valorSaldo>
Quando efetua um saque R$<valorSaque>
Entao o saldo da conta reduz R$<valorFinal>

Exemplos: 

|valorSaldo| valorSaque  | valorFinal |
|   400    |     100     |  300       |   


Esquema do Cenário: Faz deposito e tem rendimento na conta Poupança

Dado que cliente
Quando deposita R$<vlDeposito>  no <dataRendimento> é aplicado o rendimento <taxRendimento>
Então o saldo  vai para R$<vlFinalRend>

Exemplos:

|  vlDeposito  | dataRendimento |taxRendimento|vlFinalRend|
|    100       |      5         |     0,5     |      150  | 




 