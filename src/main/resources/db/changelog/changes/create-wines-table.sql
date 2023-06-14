--liquibase formatted sql
--changeset <tzhyravetskyi>:<create-wines-table>
CREATE TABLE IF NOT EXISTS public.wines
    (
        id bigint NOT NULL,
        name character varying(256) NOT NULL,
        description character varying(256) NOT NULL,
        CONSTRAINT wine_pk PRIMARY KEY (id)
);

--rollback DROP TABLE wines