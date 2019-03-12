-- Database: teste
-- DROP DATABASE teste;
CREATE DATABASE teste
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.cadastro
-- DROP TABLE public.cadastro;
CREATE TABLE public.cadastro
(
    nome character(50) COLLATE pg_catalog."default" NOT NULL,
    id numeric(18,0) NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cadastro
    OWNER to postgres;
	
	
-- Table: public.historico
-- DROP TABLE public.historico;
CREATE TABLE public.historico
(
    valor character(50) COLLATE pg_catalog."default" NOT NULL,
    id_cadastro numeric(18,0) NOT NULL,
    CONSTRAINT pk_id_cadastro_historico PRIMARY KEY (id_cadastro)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.historico
    OWNER to postgres;
	

-- SEQUENCE: public.cadastros_sequence
-- DROP SEQUENCE public.cadastros_sequence;
CREATE SEQUENCE public.cadastros_sequence;

ALTER SEQUENCE public.cadastros_sequence
    OWNER TO postgres;

GRANT ALL ON SEQUENCE public.cadastros_sequence TO postgres WITH GRANT OPTION;