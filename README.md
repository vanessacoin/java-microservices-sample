# [PT-BR]

## Exemplo de microserviços Java

Neste repositório é demonstrado o funcionamento de microsserviços em linguagem Java. 


# Estrutura de Classes:

## UserService:
- UserServiceApplication: Classe principal para iniciar o serviço.
- UserController: Classe responsável por gerenciar as requisições HTTP relacionadas aos usuários.
- User: Classe que representa a entidade Usuário.

## OrderService:
- OrderServiceApplication: Classe principal para iniciar o serviço.
- OrderController: Classe responsável por gerenciar as requisições HTTP relacionadas aos pedidos.
- Order: Classe que representa a entidade Pedido.

## ConfigServer:
- ConfigServerApplication: Classe principal para iniciar o servidor de configuração.
- application.properties ou application.yml: Arquivo de configuração onde você pode definir as propriedades do servidor de configuração.


# Arquivo de Configuração
Este arquivo será usado para definir as propriedades do seu Config Server, como onde ele deve buscar suas configurações.

- Pode ser utilizado application.properties ou application.yml. A escolha de qual utilizar depende da complexidade do projeto, se você tiver configurações simples, o application.properties pode ser suficiente. Para configurações mais complexas e em formato mais legível, o application.yml é mais indicado.


# Resumo
Cada um dos serviços (UserService e OrderService) possui uma classe principal para iniciar o serviço, controladores para gerenciar as requisições e classes de modelo para representar as entidades.

O Config Server contém uma configuração separada que permitirá que os microsserviços se conectem a ele para obter suas configurações.

Essa estrutura modular permite que você adicione e gerencie serviços de maneira mais eficaz, mantendo o código organizado e fácil de entender.