# Projetos-de-sistema--Trabalho-final
Trabalho final da matéria de Projetos de Sistema de Software
<br>
Link google docs: https://docs.google.com/document/d/1J8Xxi4A2dqayLkG8itU_oglxKKnIjfg8GKw2r9WlwpI/edit?usp=sharing

# Task List Application

## Visão geral
O sistema descrito é uma aplicação para gerenciamento de usuários e notificações. A seguir estão os principais recursos e funcionalidades do sistema:

## Instalação
1. Clone o repositório: `git clone https://github.com/Fantiko/Projetos-de-sistema---Trabalho-final`


## Estrutura do projeto
<br>

```
├───.idea
│   └───inspectionProfiles
├───target
│   └───logs
└───TrabalhoFinal
    ├───src
    │   └───main
    │       └───java
    │           └───sistemalogin
    │               └───trabalhofinal
    │                   ├───dao
    │                   ├───mensagem
    │                   ├───model
    │                   ├───presenter
    │                   ├───resources
    │                   └───view
    └───target
``` 


- `/src`: Contém o código-fonte da aplicação.
- `/main/java/sistemalogin`: Pacote principal do sistema de login
  - ``/trabalhofinal``: Pacote raiz da aplicação Trabalho Final
    - ``/dao``: Classes de Data Access Object (DAO) para manipulação de dados
    - ``/mensagem``: Classes relacionadas ao sistema de mensagens
    - ``/model``: Contém os modelos de dados (entidades)
    - ``/presenter``: Contém as classes que seguem o padrão MVP (intermediários)
    - ``/resources``: Arquivos de recursos (ex: propriedades, configurações)
    - ``/view``: Contém a camada de visualização (UI)
- ``/target``: Diretório de saída do projeto (compilação e artefatos gerados)


# Requisitos não funcionais atendidos
<br>

>-[x] RNF01 – Casos de uso do tipo CRUD com State\
>  Os casos de uso do tipo CRUD devem seguir o que foi ministrado e debatido em aula, 
>utilizando o padrão de navegação entre janelas disponíveis em https://whimsical.com/crud-manter-HcNY9D491ajiNZ7j8EA7Y9

>-[x] RNF02 – Persistência de dados\
Utilize como persistência qualquer banco de dados, relacional ou não, que não exija instalações ou configurações extras no ambiente de implementação. Prefira utilizar o SQLite. Não utilizar o Docker para manter o banco de dados.

>-[x] RNF03 – Padrão de projeto DAO\
Utilize o padrão de projeto DAO, sabendo que não é permitido utilizar Framework de persistência como  Hibernate ou similares.

>-[x] RNF04 – Interface gráfica\
> O sistema deve ser desenvolvido utilizando o kit de componentes gráficos do Java Swing.\
> O sistema deve permitir que usuários naveguem entre telas que estejam abertas para realizar as funções desejadas. Ou seja,
> utilizar o MDI (Multiple Document Interface). Um exemplo de sistema com o padrão MDI é apresentado na figura abaixo. A barra de botões é opcional.

>-[x] RNF05 – Utilizar o padrão de projeto Command\
> Ao utilizar o State, utilizar o padrão Command integrado a ele.

>-[x] RNF06 – Padrão de projeto Observer\
>  Implemente o padrão Observer de modo que caso qualquer usuário altere algum dado em uma janela aberta, as demais janelas abertas referentes àquele dado sejam atualizadas.

>-[x] RNF07 – Formatos de arquivos de Log\
  O sistema deve permitir os seguintes formatos para arquivos de log: CSV (com separação de campos usando ponto e vírgula “;”), JSON.

>-[x] RNF08 – Padrão de Projeto Adapter para Log/
  O módulo de log deve adotar o padrão de projeto Adapter. Além disso, deve ser um projeto Maven independente, utilizado pelo sistema proposto nesta especificação.

>-[x] RNF09 – Criação de senhas\
>  Ao criar senhas do sistema utilizar adaptar o Validador de senhas, disponível em https://github.com/claytonfraga/validadorsenha, 
> que deve ser incluído como JAR no projeto Maven, utilizando o JitPack (https://jitpack.io/)

# Demais requisitos atendidos:
<br>

1. Criar um documento no Google Docs que descreva de forma explícita quais requisitos foram implementados. Serão considerados apenas os requisitos que foram implementados e totalmente atendidos.
2.  Garantir que o software compile sem erros. Softwares com erros de código que impeçam a compilação não serão corrigidos e receberão nota zero.
3.  Garantir que o software execute corretamente. Softwares que não executarem não serão corrigidos e receberão nota zero.
4.  Aplicar os conceitos e técnicas estudados na disciplina.
5.  Utilizar os padrões de projeto adequados e demonstrar criatividade e aplicabilidade desses padrões.
6.  Desenvolver o sistema utilizando a linguagem Java 17.
7.  Criar o projeto utilizando o Maven.
8.  Aplicar o padrão MVP (Passive View) conforme debatido em aulas e correções realizadas durante o semestre.
9.  Implementar o tratamento de exceções em todo o projeto.
10.  Entregar o projeto via GitLab ou GitHub, utilizando como repositório para controle de versões e trabalho em equipe. Não usar como backup um arquivo compactado. A entrega deve ser feita com o comando clone: `git clone https://github.com/Fantiko/Projetos-de-sistema---Trabalho-final`.


