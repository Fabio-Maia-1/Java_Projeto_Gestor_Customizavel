# Java_Projeto_Gestor_Customizavel


## Custom Manager

### Descrição do problema:
O Custom Manager é uma aplicação desenvolvida em Java com interface gráfica, cujo objetivo é permitir a criação e gestão de tabelas personalizadas. Serve para organizar e guardar dados personalizados de forma simples e intuitiva. O utilizador pode criar as suas próprias tabelas, definindo colunas customizadas para armazenar dados numa base de dados de acordo com as suas necessidades.


### Lista de funcionalidades:
<ins>Gestão de tabelas (Form inicial)</ins>
- Criar novas tabelas, dando-lhes um nome e opcionalmente uma descrição;
- Definir até 8 colunas personalizadas para cada nova tabela;
- Editar tabelas existentes (não é permitido alterar o número de colunas);
- Abrir uma tabela para iniciar a gestão dos seus elementos;
- Remover tabelas;
- Adicionar tabelas aos favoritos;
- Remover tabelas dos favoritos;
- Filtrar tabelas a partir da lista de favoritos;
- Abrir um painel de instruções para gestão de tabelas.

<ins>Gestão de elementos de uma tabela (Form secundário)</ins>
- Regressar à página anterior;
- Adicionar elementos, preenchendo as colunas definidas na criação da tabela;
- Editar elementos existentes;
- Apagar elementos;
- Adicionar elementos aos favoritos;
- Remover elementos dos favoritos;
- Filtrar elementos a partir da lista de favoritos;
- Abrir um painel de instruções para gestão de elementos de uma tabela.

<ins>Tratamento de exceções</ins>
- Prevenção de caracteres inválidos na criação de uma tabela
- Verificação de nomes iniciados por números
- Prevenção de nomes vazios


### Instruções de utilização da aplicação:
<ins>Instruções para a gestão de tabelas:</ins>

Assumindo que está a ser usada a base de dados pré-configurada para esta aplicação, ao compilar o projeto será apresentada uma página inicial com uma tabela contendo uma lista de outras tabelas. Aqui, o utilizador pode interagir com diversas funcionalidades:
Na barra menu superior, o utilizador pode selecionar "Main" e depois "Encerrar Aplicação" para terminar o programa. Pode interagir com "Manage" para aceder a uma lista de funcionalidades básicas de gestão (que seram descritas brevemente) e por fim, pode clicar em "Help" e selecionar "Instruções de Utilização" para abrir um painel com instruções e descrições de funcionalidades relevantes. No canto inferior direito estão 4 botões designados "Abrir", "Adicionar", "Editar" e "Apagar". Estas funcionalidades básicas também podem ser utilizadas a partir da tecla de atalho associada ou pelo menu "Manage".

- Adicionar (Tecla N): Abre um painel que permite criar tabelas novas para adicionar à lista do programa e integrar na base de dados. O utilizador deve definir um nome para a tabela e pode escrever uma descrição opcionalmente. Existe um sistema de exceções robusto para prevenir erros que podem surgir na escolha de um nome. Cada tabela pode ter entre 1 e 8 colunas distintas que devem ser definidas pelo utilizador. O número de colunas é controlado a partir dos botões "+" e "-". Depois de preencher todas as caixas de texto relevantes, o utilizador deve pressionar o botão "Confirmar" para guardar a nova tabela ou o botão "Cancelar" para a descartar.
- Editar (Tecla E): Abre um painel funcionalmente idêntico ao painel de criação de novas tabelas, que permite editar a descrição e designação de uma tabela e das suas colunas. O número de colunas não pode ser modificado.
- Apagar (Tecla D): Remove a tabela selecionada do programa e da base de dados.
- Abrir (Tecla A): Abre a tabela selecionada, permitindo a visualização e gestão dos elementos dessa tabela. A estrutura da tabela depende daquilo que o utilizador introduziu quando a criou. Esta funcionalidade também pode ser ativada a partir de um duplo clique na tabela desejada.

Se o utilizador clicar numa tabela com o botão direito do rato, será aberto um menu pop-up com a opção "Adicionar aos Favoritos" que a vai marcar como favorita, mas se o utilizador repetir a operação numa tabela que já está marcada como favorita, será aberto um menu com a opção "Remover dos Favoritos".
No canto superior direito da aplicação estão mais 2 botões. O botão "Favoritos" filtra a lista de tabelas para que apenas as tabelas marcadas como favoritas são exibidas. O botão "Todos" volta a exibir todas as tabelas guardadas na base de dados.

<ins>Instruções para a gestão de elementos de tabelas:</ins>

Quando a funcionalidade de abrir uma tabela é acionada, será aberto um novo form semelhante ao anterior, mas exibindo o conteúdo da tabela selecionada e permitindo diversas funcionalidades de gestão dos elementos da tabela.
Na barra menu, para além da opção "Encerrar Aplicação", o menu "Main" também contém a opção "Retornar", que permite fechar a tabela atual e regressar à página inicial do programa. Esta função é replicada pelo botão "Retornar" no canto inferior esquerdo da página. O menu "Help" continua a ter a opção "Instruções de Utilização", que abre um painel informativo para explicar funcionalidades relevantes. A barra menu também continua a ter o menu "Manage", mas desta vez as opções envolvem métodos de gestão dos elementos da tabela atual, que também podem ser executados a partir dos botões no canto inferior direito da página ou com as teclas de atalho.
- Adicionar (Tecla N): Abre um painel que permite adicionar elementos novos à tabela do utilizador, respeitando o número de colunas definido na criação da tabela. Depois de preencher as colunas desejadas, o utilizador deve pressionar o botão "Confirmar" para guardar o novo elemento ou o botão "Cancelar" para o descartar.
- Editar (Tecla E): Abre um painel funcionalmente idêntico ao painel de adição de elementos na tabela, permitindo editar qualquer característica do elemento selecionado.
- Apagar (Tecla D): Remove o elemento selecionada da tabela.
As funcionalidades de gestão de favoritos continuam a estar presentes nesta página, funcionando da mesma forma. Ou seja, os elementos podem ser marcados como favoritos e desmarcados com o botão direito do rato e os elementos favoritos podem ser filtrados a partir dos botões "Todos" e "Favoritos" no canto superior esquerdo da página.
