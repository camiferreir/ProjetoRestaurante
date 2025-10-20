# ProjetoRestaurante

🍽️ Sistema de Restaurante

Este projeto é um sistema desenvolvido em Java com integração ao banco de dados MySQL, criado com o objetivo de gerenciar o funcionamento de um restaurante, permitindo o controle de mesas, pedidos, clientes, cardápio e usuários.
O sistema possui telas interativas desenvolvidas em Swing, ícones personalizados e conexão direta com o banco de dados para manipulação das informações.

🚀 Funcionalidades

Cadastro de clientes, com informações pessoais e de contato.
Gerenciamento de mesas, com número, status (ocupada/livre) e controle visual.
Controle do cardápio, incluindo pratos, descrições, categorias e preços.
Registro de pedidos, associando clientes, mesas e pratos do cardápio.
Gerenciamento de usuários, com login e autenticação no sistema.
Interface amigável e intuitiva, com ícones representativos em cada tela.
Operações completas de CRUD (Create, Read, Update e Delete) em todas as entidades do sistema.

🛠️ Tecnologias Utilizadas

Java SE 17
Swing para interface gráfica
MySQL (banco de dados: revisaobanco)
JDBC para conexão com o banco de dados

📂 Estrutura do Projeto
src/
├── dao/         # Classes responsáveis pela comunicação com o banco de dados
├── dto/         # Classes com atributos, getters e setters
├── view/        # Telas gráficas (interfaces feitas em Swing)
├── icones/      # Ícones utilizados nas interfaces gráficas
└── main/        # Classe principal para execução do sistema

🗃️ Banco de Dados

Nome do banco: revisaobanco

Tabelas:
tb_cardapio – Armazena pratos, categorias e preços.
tb_cliente – Contém os dados dos clientes.
tb_mesa – Controla as mesas e seus status (livre/ocupada).
tb_pedidos – Registra os pedidos realizados pelos clientes.
tb_usuarios – Armazena os dados de login e senha dos usuários do sistema.

⚙️ Operações CRUD
O sistema implementa as quatro operações básicas de manipulação de dados:

Create – Cadastra novos registros (clientes, mesas, pratos, pedidos e usuários).
Read – Exibe e consulta informações salvas no banco de dados.
Update – Permite editar e atualizar dados existentes.
Delete – Exclui registros selecionados de forma segura.
Essas operações garantem o funcionamento completo e dinâmico do sistema, permitindo o gerenciamento eficiente de todas as informações do restaurante.

📅 Histórico de Atualizações
v1.0.0 – (20/10/2025)
Versão estável e funcional.
CRUD completo implementado em todas as tabelas.
Conexão MySQL configurada e totalmente funcional.

v0.2.0 – (10/10/2025)
Criação das telas VIEW e integração com o banco.

v0.1.0 – (01/10/2025)
Estrutura inicial do projeto e banco de dados criada.

👨‍💻 Desenvolvedores

Este projeto foi idealizado e desenvolvido por:
Camille Ferreira

📜 Licença

Este projeto está licenciado sob a licença MIT – veja o arquivo LICENSE
 para mais detalhes.
