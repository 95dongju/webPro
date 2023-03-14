DROP TABLE PRODUCT;
CREATE TABLE PRODUCT(
    PNO NUMBER(4) PRIMARY KEY,
    PNAME VARCHAR2(100) NOT NULL,
    PSTOCK NUMBER(4) NOT NULL
);

SELECT * FROM PRODUCT;

INSERT INTO PRODUCT VALUES(1, '공책', 10);
INSERT INTO PRODUCT VALUES(2, '볼펜', 20);
INSERT INTO PRODUCT VALUES(3, '지우개', 0);

COMMIT;