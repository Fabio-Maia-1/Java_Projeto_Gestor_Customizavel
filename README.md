# Java_Projeto_Gestor_Customizavel

Custom Manager

Descrição do problema:

O Custom Manager é uma aplicação desenvolvida em Java com interface gráfica, cujo objetivo é permitir a criação e gestão de tabelas personalizadas. Serve para organizar e guardar dados personalizados de forma simples e intuítiva. 
O utilizador pode criar as suas próprias tabelas, definindo colunas customizadas para armazenar dados numa base de dados de acordo com as suas necessidades.


Lista de funcionalidades:

Gestão de tabelas (Form inicial)
- Criar novas tabelas, dando-lhes um nome e opcionalmente uma descrição;
- Definir até 8 colunas personalizadas para cada nova tabela;
- Editar tabelas existentes (não é permitido alterar o número de colunas);
- Abrir uma tabela para iniciar a gestão dos seus elementos;
- Remover tabelas;
- Adicionar tabelas aos favoritos;
- Remover tabelas dos favoritos;
- Filtrar tabelas a partir da lista de favoritos;
- Abrir um painel de instruções para gestão de tabelas.

Gestão de elementos de uma tabela (Form secundário)
- Regressar à página anterior;
- Adicinar elementos, preenchendo as colunas definidas na criação da tabela;
- Editar elementos existentes;
- Agagar elementos;
- Adicionar elementos aos favoritos;
- Remover elementos dos favoritos;
- Filtrar elementos a partir da lista de favoritos;
- Abrir um painel de instruções para gestão de elementos de uma tabela.

Tratamento de exceções
- Prevenção de caracteres inválidos na criação de uma tabela
- Verificação de nomes iniciados por números
- Prevenção de nomes vazios


Instuções de utilização da aplicação:

Assomindo que está a ser usada a base de dados pré-configurada para esta aplicação, ao compilar o projeto será apresentada uma página inicial com uma tabela contendo uma lista de outras tabelas. Aqui, o utilizador pode interagir com diversas funcionalidades:
Na barra menu superior, o utilizador pode selecionar "Main" e depois "Encerrar Aplicação" para terminar o programa. Pode interagir com "Manage" para aceder a uma lista de funcionalidades básicas de gestão (que seram descritas brevemente) e por fim, pode clicar em "Help" e selecionar "Instuções de Utilização" para abrir um painel com instruções e descrições de funcionalidades relevantes.
No canto inferior direito estão 4 butões designados "Abrir", "Adicinar", "Editar" e "Apagar". Estas funcionalidades básicas também podem ser utilizadas a partir da tecla de atalho associada ou pelo menu "Manage". 
- Adicionar (Tecla N): Permite criar tabelas novas que serão adicionadas à lista do programa e integradas na base de dados. O utilizador deve definir um nome para a tabela e uma descrição opcionalmente. Existe um sistema de excessões robusto para prevenir erros que podem surgir na escolha de um nome. Cada tabela pode ter entre 1 e 8 colunas distintas que devem ser definidas pelo utilizador. O número de colunas é controlada a partir dos butões "+" e "-".
- Editar (Tecla E): Permite editar a descrição e designação de uma tabela e das suas colunas. O número de colunas não pode ser modificado.
- Apagar (Tecla D): Remove a tabela selecionada do programa e da base de dados.
- Abrir (Tecla A): Abre a tabela selecionada, permitindo a visualização e gestão dos elementos dessa tabela. A estrutora da tabela depende daquilo que o utlilizador introduziu quando a criou.
Se o utilizador clicar numa tabela com o botão direito do rato, será aberto um menu pop-up com a opção "Adicionar aos Favoritos" que a vai marcar como favorita, mas se o utilizador repetir a operação numa tabela que já está marcada como favorita, será aberto um menu com a opção "Remover dos Favoritos".
No canto superior direito da aplicação estão mais 2 botões. O botão "Favoritos" filtra a lista de tabelas para que apenas as tabelas marcadas como favoritas são exividas. O botão "Todos" volta a exivir todas as tabelas guardadas na base de dados.


-----------------------
Projeto de java. O objetivo é permitir que o utilizador crie tabelas personalizadas, organizadas numa tabela principal e com dados armazenados numa base de dados.

Ajustes para fazer:
- Painel de instruções de utilização
- Organizar IDs
- Acrescentar tabela de favoritos em todas as tabelas
