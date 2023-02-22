DROP TABLE FRIEND;

CREATE SEQUENCE FRIEND_NO_SEQ
        INCREMENT BY 1
        START WITH 1
        MINVALUE 1
        MAXVALUE 9999
        NOCYCLE
        NOCACHE
        ORDER;
        
DROP SEQUENCE FRIEND_NO_SEQ;

CREATE TABLE FRIEND(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10) NOT NULL,
    TEL VARCHAR2(50)
);

INSERT INTO FRIEND(NO, NAME, TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL, '홍길', '010-9999-9999');

SELECT * FROM FRIEND;

SELECT * FROM FRIEND WHERE NAME LIKE '%'||''||'%' AND TEL LIKE '%'||''||'%';
COMMIT;

