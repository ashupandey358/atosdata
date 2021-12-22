CREATE TABLE question (
    id               NUMBER NOT NULL,
    question         VARCHAR2(5000),
    detailedquestion VARCHAR2(10000),
    userid           NUMBER NOT NULL
)
LOGGING;

ALTER TABLE question ADD CONSTRAINT question_pk PRIMARY KEY ( id );

CREATE TABLE "user" (
    id           NUMBER NOT NULL,
    name         VARCHAR2(50),
    mobilenumber VARCHAR2(10),
    email        VARCHAR2(50),
    password     VARCHAR2(50),
    pannumber    VARCHAR2(20)
)

logging;

ALTER TABLE "user" ADD CONSTRAINT user_pk PRIMARY KEY ( id );

ALTER TABLE question
    ADD CONSTRAINT question_user_fk FOREIGN KEY ( userid )
        REFERENCES "user" ( id )
    NOT DEFERRABLE;

CREATE SEQUENCE question_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER question_id_trg BEFORE
    INSERT ON question
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    SELECT
        question_id_seq.NEXTVAL
    INTO :new.id
    FROM
        dual;

END;
/

CREATE SEQUENCE user_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER user_id_trg BEFORE
    INSERT ON "user"
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    SELECT
        user_id_seq.NEXTVAL
    INTO :new.id
    FROM
        dual;

END;
/