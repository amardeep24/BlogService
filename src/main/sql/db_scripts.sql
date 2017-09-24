-- Database: Blog

-- DROP DATABASE "Blog";

CREATE DATABASE "Blog"
    WITH 
    OWNER = "Blog"
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = 50;

GRANT ALL ON DATABASE "Blog" TO "Blog";

GRANT TEMPORARY, CONNECT ON DATABASE "Blog" TO PUBLIC;

GRANT ALL ON DATABASE "Blog" TO postgres;

-- Table: public.blog

-- DROP TABLE public.blog;

CREATE TABLE public.blog
(
    blog_id integer NOT NULL,
    blog_title character varying COLLATE pg_catalog."default" NOT NULL,
    blog_text character varying COLLATE pg_catalog."default",
    blog_author integer NOT NULL,
    create_date date NOT NULL,
    update_date date,
    CONSTRAINT blog_pkey PRIMARY KEY (blog_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.blog
    OWNER to postgres;

GRANT ALL ON TABLE public.blog TO "Blog";

GRANT ALL ON TABLE public.blog TO postgres;

-- Table: public.author

-- DROP TABLE public.author;

CREATE TABLE public.author
(
    author_id integer NOT NULL,
    author_name character varying COLLATE pg_catalog."default" NOT NULL,
    author_email character varying COLLATE pg_catalog."default",
    author_phone character varying COLLATE pg_catalog."default",
    create_date date,
    update_date date,
    CONSTRAINT author_pkey PRIMARY KEY (author_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.author
    OWNER to postgres;

GRANT ALL ON TABLE public.author TO "Blog";

GRANT ALL ON TABLE public.author TO postgres;

CREATE SEQUENCE public.author_id_seq
    INCREMENT 10
    START 100
    MINVALUE 100
    MAXVALUE 1000000
    CACHE 20;

ALTER SEQUENCE public.author_id_seq
    OWNER TO postgres;

GRANT ALL ON SEQUENCE public.author_id_seq TO postgres;

GRANT ALL ON SEQUENCE public.author_id_seq TO "Blog";

CREATE SEQUENCE public.blog_id_seq
    INCREMENT 10
    START 4290
    MINVALUE 100
    MAXVALUE 1000000
    CACHE 20;

ALTER SEQUENCE public.blog_id_seq
    OWNER TO postgres;

GRANT ALL ON SEQUENCE public.blog_id_seq TO postgres;

GRANT ALL ON SEQUENCE public.blog_id_seq TO "Blog";