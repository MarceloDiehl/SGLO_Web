CREATE DATABASE loja_orion_UC15;
USE loja_orion_UC15;

CREATE TABLE cadastrocliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    dataNascimento DATE NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    RG VARCHAR(14) NOT NULL,
    endereco VARCHAR(45) NOT NULL,
    numeroPredial INT NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    estado CHAR(45) NOT NULL,
    CEP VARCHAR(9),
    telefone VARCHAR(15),
    clienteDesde DATE NOT NULL
);

CREATE TABLE escolaridade (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    formacao VARCHAR(45) NOT NULL
);

CREATE TABLE cargo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeCargo VARCHAR(45) NOT NULL    
);

CREATE TABLE genero (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE cadastroFuncionario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    dataNascimento DATE NOT NULL,
    idCargo INT NOT NULL,
    idEscolaridade INT NOT NULL,
    especialidade VARCHAR(45), 
    telefone VARCHAR(14),
    CPF VARCHAR(14) NOT NULL,
    idGenero INT NOT NULL,
    endereco VARCHAR(45) NOT NULL,
    numeroPredial INT NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    estado CHAR(2) NOT NULL,
    CEP VARCHAR(9),
    contatoEmergencia VARCHAR(14) NOT NULL,
    dataEntrada DATE NOT NULL,    
    RG VARCHAR(14) NOT NULL,
    CTPAS VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha TEXT NOT NULL,
    FOREIGN KEY (idCargo) REFERENCES cargo(id),
    FOREIGN KEY (idEscolaridade) REFERENCES escolaridade(id),
    FOREIGN KEY (idGenero) REFERENCES genero(id)
);

CREATE TABLE tipo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL    
);

CREATE TABLE condicao (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL   
);

CREATE TABLE catalogoProduto (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codProduto VARCHAR(6) NOT NULL UNIQUE,
    titulo VARCHAR(70) NOT NULL,
    valor DECIMAL(9,2) NOT NULL,
    quantidade INT NOT NULL,
    entrada DATE NOT NULL,
    idTipo INT NOT NULL,
    idCondicao INT NOT NULL,
    descricao VARCHAR(500),    
    FOREIGN KEY (idTipo) REFERENCES tipo(id),
    FOREIGN KEY (idCondicao) REFERENCES condicao(id)
);

CREATE TABLE metodoPagamento (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(55) NOT NULL
);

CREATE TABLE controlevendas (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codProduto VARCHAR(6) NOT NULL,
    tituloProduto VARCHAR(70) NOT NULL,
    valorUnitario DECIMAL(9,2) NOT NULL,
    quantidade INT NOT NULL,
    valorTotal DECIMAL(9,2) NOT NULL,
    dataVenda DATE NOT NULL,
    idVendedor INT NOT NULL,
    cpfNota VARCHAR(14),
    idMetodoPagamento INT NOT NULL
);