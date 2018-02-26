
CREATE TABLE TBL_ALUNO(

ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
NOME VARCHAR(200) UNIQUE NOT NULL,
MATRICULA VARCHAR(20) NULL,
TBL_TURMA INTEGER,
FOREIGN KEY (TBL_TURMA) REFERENCES TBL_TURMA,

);


CREATE TABLE TBL_TURMA(

ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
NOME VARCHAR(200) UNIQUE NOT NULL,

);
