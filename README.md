# Sistema de Gerenciamento de Eventos - IFRO - Porto Velho Câmpus Calama

Este repositório contém o projeto do **Sistema de Gerenciamento de Eventos** do **IFRO Câmpus Porto Velho Calama**. O sistema tem como objetivo facilitar e centralizar o processo de criação, divulgação, controle e inscrição de eventos realizados pela instituição.

## Sobre o Projeto

A proposta deste sistema é criar uma alternativa os métodos manuais ou fragmentados atualmente utilizados para o gerenciamento de eventos, oferecendo uma plataforma acessível para:

- Docentes e funcionários do IFRO criarem e administrarem eventos.
- O público externo consultar e se inscrever em eventos ofertados.

## Instalação

Este projeto é uma aplicação Java que utiliza conexão com banco de dados MySQL para gerenciamento de eventos e atividades.

---

##  Rodando o projeto

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
