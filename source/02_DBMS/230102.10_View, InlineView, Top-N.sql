-- [X] View, In-Line View, TOP-N
-- 1. VIEW : ������ ���̺� (1)�ܼ� VIEW (2)���� VIEW

-- (1)�ܼ� VIEW : �ϳ��� ���̺��� �̿��Ͽ� ���� VIEW

-- �������� ���� ������ �����͸� ������ ���̺�
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1;
-- EMP ���̺�� EMP1 ���̺��� ������ ������ ���̺�
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) VALUES (1111, 'ȫ', 'ITMANAGER', 40);
SELECT * FROM EMP WHERE EMPNO=1111;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
    -- EMP1���� �����͸� �־����� EMP���� �����Ͱ� ����
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
    
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 40);
SELECT * FROM EMPv0;
SELECT * FROM EMP WHERE EMPNO=1111;
    -- VIEW�� INSERT �ص� EMP ���̺� ���Ե�
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
-- WHERE ROW_NUMBER() OVER(ORDER BY SAL DESC)<6;
-- �Լ��� WHERE ���� �� �� ����.

-- ROWNUM (���̺�κ��� ������ ����) �� INLINE-VIEW�� �̿��� TOP-N
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME, SAL FROM EMP;

SELECT ROWNUM, ENAME, SAL   -- 2.
    FROM EMP    -- 1.
     ORDER BY SAL;     -- 3.
    -- INSERT ������� ������
    
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL);
    -- SAL�� ORDER BY �ؼ� ROWNUM ��Ŵ
    
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- 1����� ������� �����
    
-- SAL�� �������� 1����� 5����� ���
SELECT ROWNUM, A.*
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL) A
    WHERE ROWNUM < 6;

-- SAL�� �������� 6����� 10����� (FROM ������ ������ ���� WHERE���� ���� �ƴϱ� ������ ���� ���� ==> ROWNUM�� ��� 1�� ��)
SELECT ROWNUM RK, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10; --ROWNUM >= 6 AND ROWNUM <=10;
    
-- TOP-N
SELECT * FROM EMP ORDER BY SAL; -- 1�ܰ�
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM EMP ORDER BY SAL) A; -- 2�ܰ�
SELECT * 
    FROM (SELECT ROWNUM RN, A.* -- ALIAS�� �ݵ�� �־�� SELECT���� ROWNUM�� �ƴ϶� VIEW�� ���� ROWNUM�� ������ ��
        FROM (SELECT * FROM EMP ORDER BY SAL) A )
    WHERE RN BETWEEN 6 AND 10;

-- EX. �̸��� ���ĺ� ������� �����ؼ� 6~10��° ��� (����, �̸�, ���, JOB, MGR, HIREDATE)
SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME);
SELECT * 
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
        FROM (SELECT * FROM EMP ORDER BY ENAME)) 
    WHERE RN BETWEEN 6 AND 10;

-- EX. �Ի������ 11��°���� 15��°�� ����� ��� �ʵ� ���
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE) A)
    WHERE RN BETWEEN 11 AND 15;
    


-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU AS SELECT DNAME, ENAME 
    FROM DEPT D, EMP E
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER) AS SELECT W.ENAME, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT DEPTNO, SUM(SAL) "SUM" FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC) A)
    ORDER BY RN;

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT DEPTNO, SUM(SAL) "SUM" FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC) A)
    WHERE RN BETWEEN 2 AND 3
    ORDER BY RN;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A);
        
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 10 AND 14;
    
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;