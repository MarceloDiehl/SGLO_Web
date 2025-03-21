_____________________________________
**Sistema de Gestão de Loja Orion - SGLO**
______________________________________

* Título: Sistema de Gestão de Loja Orion - SGLO;
* Tecnologias empregadas: Linguagem de Programação Java (desenvolvimento desktop) - Banco de Dados Relacionais: MySQL;
* Desenvolvedores: Marcelo Diehl (autor);
* Objetivo do software: Sistema de gestão de uma loja de discos (loja Orion - Venda de Artigos Musicais). O projeto foi pensado para otimizar o fluxo de trabalho da loja, permitindo o cadastro e gerenciamento de produtos, controle de estoque, registro de vendas e acompanhamento de clientes de forma intuitiva e eficiente. A interface prioriza a usabilidade, com navegação simplificada e organização clara das informações, garantindo uma experiência fluida para os usuários do sistema;
* Funcionalidades do sistema:

**REQUISITOS FUNCIONAIS**

[RF001] - Autenticação de Usuário do Sistema
Ator: todos os funcionários da empresa. 
Descrição: Tela inicial do software, para controle de acesso ao sistema com utilização de login e senha, para ativar, inclusive, as restrições específicas no software.

[RF002] - Catálogo de clientes
Ator: gerente
Descrição: Tela com as informações detalhadas de todos os clientes da loja. Deverá ter campos para preenchimento de: nome, sobrenome, data de nascimento, data de inscrição do cliente na loja (cliente desde), CPF, RG, telefone e endereço completo (rua, bairro, cidade, estado).

[RF003] - Controle de produtos
Ator: gerente, estoquista.
Descrição: Tela com informações detalhadas de produtos vendidos na loja. Deverá incluir: nome do álbum, data de entrada na loja, número de unidades no estoque, ano de lançamento do produto, estado de conservação, condições do produto (novo ou usado), valor unitário, foto de capa e verso e campo para incluir observações importantes caso seja necessário.

[RF004] - Controle de vendas
Ator: gerente.
Descrição: Tela com informações detalhadas da venda de produtos. A tela deverá fornecer campo de preenchimento de: identificação de cliente, identificação do produto, valor unitário, valor total (ao final da venda), desconto (caso seja aplicável), registro de forma de pagamento, data da venda.

[RF005] - Visualização de produtos
Ator: gerente, vendedores
Descrição: Tela com informações detalhadas de produtos de estoque. Poderá utilizar tanto código de barra com uso de scanner, digitar o número de cadastro do produto ou buscar por nome ou tag. A tela fornecerá todas as informações do produto como valor unitário, foto frente e verso, número de unidades no estoque, estado de conservação, condições do produto (no ou usado) e observações importantes sobre o produto (também para auxiliar os vendedores sobre as informações relevantes dos produtos). 
[RF006] - Sistema para venda de produtos
Ator: todos os funcionários da empresa.
Descrição: Tela com informações detalhadas de produtos a serem vendidos, os produtos podem ser lidos por código de barras ou incluidos por códigos manualmente, nessa tela terá uma lista de produtos a serem vendidos bem como valor total da venda. Após a finalização de leitura dos produtos será finalizada a venda e será gerado dados para controle das vendas.


**REQUISITOS NÃO FUNCIONAIS**

[RNF001] - Dispositivos de software compatível.
	O software será do tipo desktop, sem necessidade de utilização de internet (totalmente off-line), será utilizado sistema de Banco de Dados do tipo SQL local, sem acesso a internet. O sistema operacional será Windows (versão 8 em diante), a linguagem de programação a ser utilizada será o Java.  

[RNF002] - Sistema offline, simples e prático.
	O sistema deverá funcionar off-line, sem necessidade do uso de internet, devido às características geográficas locais. O sistema deverá ser simples mas completo e fácil de utilizar, devido à baixa capacitação da equipe. 

**TECNOLOGIAS PREVISTAS**

Deverão ser utilizados computadores do tipo PC (arquitetura x86 - x64), impressora em rede para emissão de notas fiscais, com portas do tipo USB para conexão de periféricos de impressora, scanner de código de barras, teclado, mouse e máquinas de leitura de cartão de crédito (caso seja o caso). Monitor com resolução mínima de 1920x1080 pixels. Também deverá ser previsto sistema de rede do tipo LAN, com uso de placas de rede, cabos RJ45, switch ou roteador. Os dados de registros de Banco de Dados SQL deverão ser armazenados em sistema local e off-line, em servidor localizado no estoque da loja, com conexão em LAN para todos os computadores da loja que possuam o software instalado. O servidor deverá ter sistema de proteção contra queda de energia elétrica e sistema de no-break.  Deverá ser utilizada a linguagem de programação Java para desenvolvimento de sistema desktop.
