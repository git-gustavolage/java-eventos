CREATE TABLE usuarios (
	id bigint(20) primary key not null auto_increment,
	email varchar(255) unique not null,
	password varchar(255) not null,
	nome varchar(255) not null,
	matricula varchar(255) unique null default null,
	data_nascimento date null default null,
	telefone varchar(255) null default null,
	genero varchar(255) null default null,
	is_admin tinyint(1) not null default 0,
	status tinyint(1) default 1
);

CREATE TABLE ambientes (
	id bigint(20) primary key not null auto_increment,
	nome varchar(255) unique not null,
	descricao varchar(255) null default null
);

CREATE TABLE eventos (
	id bigint(20) primary key not null auto_increment,
	id_organizador bigint(20) not null,
	titulo varchar(255) not null,
	descricao varchar(255) not null,
	data_inicio date not null,
	data_termino date not null,
	formato varchar(255) not null,
	is_publicado tinyint(1) not null default 0,
	is_cancelado tinyint(1) not null default 0,
	
	CONSTRAINT eventos_id_organizador_foreign FOREIGN KEY (id_organizador)
	REFERENCES usuarios(id)
    ON DELETE CASCADE
);

CREATE TABLE atividades (
	id bigint(20) primary key not null auto_increment,
	id_evento bigint(20) not null,
	id_responsavel bigint(20) not null,
	id_ambiente bigint(20) not null,
	titulo varchar(255) not null,
	descricao varchar(255) not null,
	data date not null,
	hora_inicio time not null,
	hora_termino time not null,
	is_cancelada tinyint(1) not null default 0,
	
	CONSTRAINT atividades_id_evento_foreign FOREIGN KEY (id_evento)
	references eventos(id)
	ON DELETE CASCADE,
	
	CONSTRAINT atividades_id_responsavel_foreign FOREIGN KEY (id_responsavel)
	references usuarios(id)
	ON DELETE CASCADE,
	
	CONSTRAINT atividades_id_ambiente_foreign FOREIGN KEY (id_ambiente)
	references ambientes(id)
	ON DELETE RESTRICT
);

CREATE TABLE inscricoes (
	id bigint(20) primary key not null auto_increment,
	id_usuario bigint(20) not null,
	id_evento bigint(20) not null,
	data date not null,
	
	CONSTRAINT inscricoes_id_usuario_foreign FOREIGN KEY (id_usuario)
	REFERENCES usuarios(id)
	ON DELETE CASCADE,
	
	CONSTRAINT inscricoes_id_evento_foreign FOREIGN KEY (id_evento)
	REFERENCES eventos(id)
	ON DELETE CASCADE
);

CREATE TABLE inscricoes_atividades (
	id bigint(20) primary key not null auto_increment,
	id_inscricao bigint(20) not null,
	id_atividade bigint(20) not null,
	data date not null,
	
	CONSTRAINT inscricoes_atividades_id_inscricao_foreign FOREIGN KEY(id_inscricao)
	REFERENCES inscricoes(id)
	ON DELETE CASCADE,
	
	CONSTRAINT inscricoes_atividades_id_atividade_foreign FOREIGN KEY (id_atividade)
	REFERENCES atividades(id)
	ON DELETE CASCADE
);

CREATE TABLE usuarios_presencas (
	id bigint(20) primary key not null auto_increment,
	id_usuario bigint(20) not null,
	id_atividade bigint(20) not null,
	data_confirmacao datetime null default null,
	
	CONSTRAINT usuarios_presencas_id_usuario_foreign FOREIGN KEY (id_usuario)
	REFERENCES usuarios(id)
	ON DELETE CASCADE,
	
	CONSTRAINT usuarios_presencas_id_atividade_foreign FOREIGN KEY (id_atividade)
	REFERENCES atividades(id)
	ON DELETE CASCADE
);

CREATE TABLE certificados (
	id bigint(20) primary key not null auto_increment,
	id_usuario bigint(20) not null,
	id_atividade bigint(20) not null,
	carga_horaria_em_minutos int not null,

	CONSTRAINT certificados_id_usuario_foreign FOREIGN KEY (id_usuario) 
	REFERENCES usuarios(id)
	ON DELETE CASCADE,

	CONSTRAINT certificados_id_atividade_foreign FOREIGN KEY (id_atividade)
	REFERENCES atividades(id)
	ON DELETE CASCADE
);
