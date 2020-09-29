# Desafio Codar - Processador de Produtos

Você foi encarregado de implementar um sistema para processar um cadastro de
produtos de uma loja.

Utilizando os seus conhecimentos de Java e Orientação à Objetos faça a
implementação que atende as regras e ao fluxo do programa abaixo:

**OBS:** Consideramos aqui que você já possui o Java instalado corretamente na sua máquina
e também já está familiarizado com a utilização de uma IDE.

## Criando o projeto

Crie um novo projeto Java utilizando a sua IDE com o nome de
“processador-produto”.

No diretório src crie o pacote “br.com.codar.processador”.

Crie nesse pacote a classe “ProcessadorProduto” com o método main.

Crie novos pacotes, conforme a necessidade, para manter seu código organizado.

## Fluxo do programa

A entrada de dados do seu programa será realizada através de leitura de arquivos
csv.

No arquivo **fornecedores.csv** cada linha corresponde a um fornecedor de produtos.
O formato da linha é o seguinte:

> CODIGO_FORNECEDOR;DESCRICAO_FORNECEDOR;

**Por exemplo:**

>1;Super Limpeza

>2;Molhos Saborosos

>3;Produtos da Fazenda

No arquivo **produtos.csv** cada linha é a representação de um produto. O formato da
linha é o seguinte:

> CODIGO;DESCRICAO;QUANTIDADE;VALOR;CODIGO_FORNECEDOR;DIAS_VALIDADE

**Por exemplo:**

>1122;Detergente;30;2.20;1;

>1133;Molho;55;1.50;2;100

>1144;Alface;48;3.50;3;60

A saída de dados deve ser realizada com o **System.out.println**.

Crie os arquivos **fornecedores.csv** e **produtos.csv** e os coloque na raiz do seu
projeto. Preencha esses arquivos com dados de teste seguindo os formatos descritos.

## Regras do sistema
- Processe os arquivos de fornecedores e produtos. Crie classes para representar as
informações e transforme cada uma das linhas em objetos.
- Um fornecedor para ser válido deve ter:
  - Um código numérico entre 1 e 9999 (número inteiro)
  - Uma descrição
  - Não devem existir fornecedores com código repetido
- Um produto para ser válido deve ter:
  - Um código numérico entre 1 e 9999 (número inteiro)
  - Uma descrição não vazia
  - Uma quantidade entre 1 e 9999 (número inteiro)
  - Um valor entre 0.01 e 9999.99
  - Quando possuir a quantidade de dias de validade, deve ser entre 1 e 999
  - Não devem existir produtos com código repetido
- Caso uma das regras não seja respeitada utilize uma exceção que represente e
descreva o erro específico.
- Os produtos podem ser divididos em perecíveis e não perecíveis de acordo com o
campo DIAS_VALIDADE do arquivo. Se o produto não tem DIAS_VALIDADE ele
não é perecível.
- Cada produto tem impostos de acordo com as regras:
  - Se o produto for perecível e a quantidade for maior que 50 o valor do imposto é
10% sobre o valor total (quantidade * valor)
  - Se o produto for perecível e a quantidade for menor ou igual a 50 não possui
imposto
  - Se o produto não for perecível o valor do imposto é de 20% sobre o valor total
(quantidade * valor)
- A saída deve ser na seguinte ordem:
  - Todos os produtos perecíveis por ordem alfabética da descrição
  - Todos os produtos não perecíveis por ordem alfabética da descrição
  - Todos os fornecedores
- A saída deve ser no seguinte formato:

>PRODUTOS PERECÍVEIS

>Código: 1144 - Descrição: Alface - Fornecedor: Produtos da Fazenda - Valor Total: 168.00 -
Sem impostos - 60 dias de validade

>Código: 1133 - Descrição: Molho - Fornecedor: Molhos Saborosos - Valor Total: 82,50 -
Impostos: 8.25 - 100 dias de validade

>PRODUTOS NÃO PERECÍVEIS

>Código: 1122 - Descrição: Detergente - Fornecedor: Super Limpeza - Valor Total: 66.00 -
Impostos: 13.20

>FORNECEDORES

>Código: 1 - Descrição: Super Limpeza

>Código: 2 - Descrição: Molhos Saborosos

>Código: 3 - Descrição: Produtos da Fazenda





# Solicitação de modificação

Um tempo depois de concluir o sistema você recebeu uma tarefa para uma nova
modificação.

Agora podem existir também produtos importados.

O produto é importado se o código do seu fornecedor estiver entre 900 e 920.

O imposto de um produto importado é de 30% do valor total somado com o imposto
aplicável às regras já existentes.

A linha de um produto importado segue as mesmas regras anteriores, mas sempre
começa com “*IMPORTADO*”. Exemplo:

>*IMPORTADO* Código: 1133 - Descrição: Molho - Fornecedor: Molhos Saborosos - Valor
Total: 82,50 - Impostos: 33.00 - 100 dias de validade
