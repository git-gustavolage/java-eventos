# Sistema de Gerenciamento de Eventos - IFRO - Porto Velho Câmpus Calama

Este repositório contém o projeto do **Sistema de Gerenciamento de Eventos** do **IFRO Câmpus Porto Velho Calama**. O sistema tem como objetivo facilitar e centralizar o processo de criação, divulgação, controle e inscrição de eventos realizados pela instituição.

## Sobre o Projeto

A proposta deste sistema é criar uma alternativa os métodos manuais ou fragmentados atualmente utilizados para o gerenciamento de eventos, oferecendo uma plataforma acessível para:

- Docentes e funcionários do IFRO criarem e administrarem eventos.
- O público externo consultar e se inscrever em eventos ofertados.

  ---

## Design da Interface (UI/UX)

Toda a modelagem das interfaces e prototipagem do fluxo de usuário foi realizada na plataforma **Figma**. O design busca ser intuitivo e acessível para todos os públicos do campus.

> 🔗 **[Acesse o protótipo no Figma aqui](https://www.figma.com/design/jsaz1RhHSy6JO9HLVJ6Hdv/Untitled?m=auto&t=HubLDjVgVnRlhtyn-6)**

---

### Tecnologias Utilizadas

| Tecnologia | Aplicação |
| :--- | :--- |
| **Java 17+** | Linguagem principal do projeto. |
| **Java Swing** | Construção das interfaces gráficas desktop. |
| **MySQL/JDBC** | Persistência e gerenciamento de dados. |
| **Figma** | Design e prototipagem das telas (UI/UX). |
| **Git/GitHub** | Controle de versão e colaboração. |

---

## Como Configurar e Executar

Siga os passos abaixo para configurar o ambiente de desenvolvimento e executar o projeto.

### 1. Pré-requisitos

-   **JDK 17** ou superior.
-   **Git** instalado e configurado.
-   Uma **IDE Java** (NetBeans, IntelliJ, Eclipse).
-   **MySQL Server** e um cliente de banco de dados (MySQL Workbench, DBeaver).
  
## 2. Passos de Instalação e Execução

### 1. Clonar o repositório
```bash
git clone https://github.com/git-gustavolage/java-eventos
cd java-eventos
```

### 2. Criar banco de dados (MySQL)

Copie e rode os comandos SQL encontrados dentro do arquivo `eventos.sql` para criar as tabelas necessários para executar projeto.

(Recomendado) Execute também o arquivo `seed.sql` para inserir dados iniciais dentro do banco, melhorando a experiência no primeiro uso do sistema.

### 3. Variáveis de ambiente

- Renomeie o arquivo `config.properties.example` para `config.properties`

```bash
cp config.properties.example config.properties
```

- Altere os valores das propriedades de acordo com o seu ambiente

```
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/seu-banco
db.user=seu-usuario
db.password=sua-senha
```

### Passo a Passo para uma Contribuição

### 1. Mude para a branch 'develop' e sincronize com o repositório remoto
```
git checkout develop
git pull origin develop
```
### 2. Crie uma nova branch para sua funcionalidade
```
# Exemplo: git checkout -b feature/implementar-tela-login
git checkout -b feature/sua-funcionalidade
```
### 3. Desenvolva sua tarefa e faça commits atômicos
```
# Use o padrão de Commits Semânticos (ex: "feat:", "fix:", "docs:")
git add .
git commit -m "tipo(escopo): mensagem descritiva"
```

### 4. Envie sua branch para o repositório remoto
```
git push origin feature/sua-funcionalidade
Abra um Pull Request: Ao finalizar o desenvolvimento na sua branch, abra um Pull Request para a develop do repositório original, referenciando a issue que você criou no título ou na descrição.
```

## Equipe

| Nome                         | Função                             | Contato                       |
| :--------------------------- | :--------------------------------- | :---------------------------- |
| *Breno Carvalho Santos* | *Figma/Front-end* | brenoleno111@gmail.com   |
| *Erick do Couto Ferreira* | *Back-end* | *erickcouto749@gmail.com* |
|  *Gustavo Lage Dos Santos* | *FullStack* | *lageg901@gmail.com* |
| *Kassandra de Oliveira Rodrigues* | *FullStack* | *kassandra.olv.rodrigues@gmail.com* |

---

## Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE.md` para mais detalhes.


---

<p align="center">
  Mantido por <strong>Kassandra de Oliveira Rodrigues</strong>
  <br>
  Aluno de Análise e Desenvolvimento de Sistemas – IFRO Campus Calama
</p>
