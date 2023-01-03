-- [X] View, In-Line View, TOP-N
-- 1. VIEW : ������ ���̺� (1)�ܼ� VIEW (2)���� VIEW

-- (1)�ܼ� VIEW : �ϳ��� ���̺��� �̿��Ͽ� ���� VIEW

-- �������� ���� ������ �����͸� ������ ���̺�
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1;
-- EMP ���̺�� EMP1 ���̺��� ������ ������ ���̺�
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) VALUES (1111, 'ȫ', 'ITMANAGER', 40);
SELECT * FROM EMP WHERE EMPNO=1111;
-- EMP1���� �����͸� �־����� EMP���� �����Ͱ� ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
DROP TABLE EMP1;

-- �������� ���� ������ �����Ͱ� ���� ������ ���̺�
CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMPv0;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%'; -- VIEW (������ ���̺�)�̱� ������ USER_TABLES�� ��Ÿ���� ����
SELECT * FROM USER_VIEWS;
DROP VIEW EMPv0;

    -- EX. EMP ���̺��� EMPNO, ENAME, JOB, DEPTNO �ʵ常 ������ ������ ���̺� ��, EMPv0
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
 -- VIEW�� INSERT �ص� EMP ���̺� ���Ե�
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 40);
SELECT * FROM EMPv0;
SELECT * FROM EMP WHERE EMPNO=1111;
UPDATE EMPv0 SET JOB = 'ANALYST' WHERE EMPNO='1111';
DELETE FROM EMPv0;

    -- EMPv0�̶�� VIEW = EMP�� 30�� �μ���
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, NULL, NULL, 30);
SELECT * FROM EMPv0;
SELECT * FROM EMPv0 WHERE EMPNO<1113;
DELETE FROM EMPv0 WHERE EMPNO<1114;

-- �ܼ� VIEW���� INSERT �Ұ��� ��� 
    -- VIEW ������ NOT NULL �ʵ带 �������� ���
CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB FROM EMP;
INSERT INTO EMPv0 VALUES (1112, 'ȫ', 'MANAGER');
SELECT * FROM EMP WHERE EMPNO=1112; -- (INSERT���� ������� ���� �ʵ�� NULL�� ��)

CREATE OR REPLACE VIEW EMPv0 AS SELECT ENAME, JOB FROM EMP; -- (NOT NULL �ʵ� ������)
INSERT INTO EMPv0 VALUES ('ȫ', 'MANAGER');
DELETE FROM EMP WHERE EMPNO<1113;
COMMIT;
SELECT * FROM EMP;


-- VIEW�� ��������
-- WITH CHECK OPTION �߰� : VIEW�� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����

    -- EX. EMP ���̺��� 30�� �μ��� ���� ���̺�(30�� �μ��� ����(DML)����)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=30
        WITH CHECK OPTION;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 30); -- WITH CHECK OPTION ������ 30�� �μ��� �μ�Ʈ ��
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, 'ȫ', 40); -- ������������ ������
    SELECT * FROM EMP WHERE ENAME='SMITH';
    DELETE FROM EMPv0 WHERE ENAME='SMITH'; -- SMITE�� 30�� �μ��� �ƴϱ� ������ ���� �Ұ���

-- WITH READ ONLY �߰� : �б� ���� VIEW
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=20
        WITH READ ONLY;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, 'ȫ', 20); -- WITH READ ONLY ���� �������� ������


-- (2) ���� VIEW : 2�� �̻��� ���̺�� ������ VIEW, ������ �ʵ带 �̿��� VIEW
-- �� 2�� �̻��� ���̺�� ������ VIEW
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, JOB, D.DEPTNO, DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO;
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1112, 'HONG', 'MANAGER', 10, 'SALES'); -- ����VIEW�� �̿��ϸ� INSERT �Ұ�
-- �� ������ �ʵ带 �̿��� VIEW (�÷��� ��Ī�� ���)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, SAL*12 YEAR_SAL FROM EMP WHERE DEPTNO=10; -- ��Ī
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1113, 'HONG', 12000);
    
    --��Ī�� ���� ���
    CREATE OR REPLACE VIEW EMPv0 
        AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10; -- �������� (SELECT��)�� ��������� VIEW�� �� �������
        
    CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL) -- ��Ī�� ���� ���� ��Ī�ϸ� ���� ����
        AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10; 
        

-- EX. ���, �̸�, �޿�, 10�� �ڸ����� �ݿø��� �޿��� ��� ����
 CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, ROUND(SAL, -2) ROUND_SAL FROM EMP; -- ������ �ʵ带 ����� INSERT �ȵ�
    
-- EX. JOB, DEPTNO�� ��� (�ߺ� ����)
 CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP;
    
-- EX. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ EMPv0 VIEW �� ����
 CREATE OR REPLACE VIEW EMPv0 (EMPNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
    
-- �μ���, �ּұ޿�, �ִ�޿�, ��ձ޿��� ������ DEPTNOv0 VIEW�� ����
 CREATE OR REPLACE VIEW DEPTNOv0 (DNAME, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL) 
        FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO GROUP BY DNAME;

-- 2. INLINE-VIEW : FROM���� ���������� INLINE VIEW�� �ϸ�, FROM ���� ���������� VIEWó�� �ۿ���
-- EX. �޿��� 2000 �ʰ��ϴ� ����� ��� �޿�

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000); -- FROM �� ���������� VIEW�� ��� ���� ������

-- 3. �μ� ��� ���޺��� ������ ���� ����� ���, �̸�, �޿�, �μ���ȣ, �ش� �μ� ���
SELECT EMPNO, ENAME, SAL, E.DEPTNO, ROUND(AVGSAL)
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL>AVGSAL;

-- INLINE VIEW ����
-- SELECT �ʵ�1, �ʵ�2,  ...
--  FROM ���̺�1, (��������) ��Ī �ݵ��
--      WHERE ���� ����


-- 3. TOP-N ���� �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
     -- (TOP 1~10��, 11~20��, ...)
-- �Լ��� �̿��� RANK ��� (1~�õ���� �� �����)
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC),
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER FROM EMP;
--    WHERE ROW_NUMBER() OVER(ORDER BY SAL DESC)<6;
--  �Լ��� WHERE ���� �� �� ����.

-- ROWNUM (���̺�κ��� ������ ����) �� INLINE-VIEW�� �̿��� TOP-N
