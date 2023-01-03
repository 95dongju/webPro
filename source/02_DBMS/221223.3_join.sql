--[III] JOIN : 2�� �̻��� ���̺��� �����Ͽ� �˻��ϴ� ���
SELECT * FROM EMP WHERE ENAME ='SCOTT'; -- 1��
SELECT * FROM DEPT;

-- CROSS JOIN (FROM ���� ���̺� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT';
    -- �ܼ��� 2���� ���̺��� ������ / ������ EMP, �������� DEPT
    
-- ��1. EQUI JOIN (�����ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP, DEPT 
    WHERE ENAME ='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;

--ex. ���, �̸�, JOB, �����, �μ���ȣ, �μ��̸�, �ٹ���
SELECT EMPNO, ENAME, JOB, MGR, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT 
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
    
SELECT EMPNO, ENAME, JOB, MGR, E.DEPTNO, D.DNAME, D.LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- �Ϲ������� ���̺� ��Ī �־ �����
    -- ���̺��� ��Ī�� "" ���� �ʰ� �ٷ� ��
    -- FROM���� ��Ī �����ϸ� SELECT ������ ��Ī���� ȣ���ؾ� ��
    -- ��ȣ�� �ʵ常 ���̺� ������ �ֱ� (E.DEPTNO)
    
--ex. �޿��� 2000 �̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL >2000;

--ex. 20�� �μ��� ������ �̸�, �μ�, �ٹ��� ���
SELECT ENAME, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO=20;

--ex. LOC�� CHICAGO�� ����� �̸�, ����, �޿�, �μ���, �ٹ����� ���
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- JOIN ������ ���� ���� ���� �Ϲ���

--ex. �μ���ȣ�� 10 OR 20���� ����� �̸�, ����, �ٹ����� ��� (�޿��� ����)
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10,20) ORDER BY SAL;
    
--ex. JOB�� SALESMAN OR MANAGER�� ����� �̸�, �޿�, �󿩱�, ���� ((SAL+COMM)*12), �μ���, �ٹ����� ��� (������ ū ��)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ANNUALSAL, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') ORDER BY ANNUALSAL DESC;
    -- NULL�ϼ��� �ְ� �ƴ� ���� �ִ� ���� NVL�̶�� �Լ� NVL(��, 0)�� ���ξ� ��  
    
--ex. COMM�� NULL�̰� SAL�� 1200 �̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ���
SELECT ENAME, SAL, D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200 ORDER BY DNAME, SAL DESC;
    -- NULL�� ���� ���� '=' �ƴ϶� 'IS NULL' ���
    
    
--	���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC='NEW YORK';
--	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND DNAME='ACCOUNTING';
--	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB='MANAGER';
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;


-- ��2. NON-EQUI JOIN (�����ʵ尡 ���� ���� ���)
    -- �����ʵ尡 ���� ������ ��Ī ���� ����
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- ���� ����
SELECT * FROM SALGRADE; -- �޿� ��� ����
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT'; -- CROSS JOIN
SELECT * FROM EMP, SALGRADE WHERE SAL >= LOSAL AND SAL <=HISAL AND ENAME='SCOTT'; -- ������ ���
SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME='SCOTT'; -- BETWEEN ���

--ex. ��� ����� ���, �̸�, ��å, �����, �޿�, �޿���� ��� (1���, 2��� ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;


--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC FROM EMP E, SALGRADE, DEPT D WHERE D.DEPTNO = E.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
--	�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, D.DEPTNO, LOC FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 ANNUALSAL, DNAME FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL ORDER BY DNAME, ANNUALSAL;
--	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000 ORDER BY DNAME, JOB, SAL DESC;
--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, LOC FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND TO_CHAR(HIREDATE, 'RR')= '81' ORDER BY GRADE;

-- ��3. SELF-JOIN (������ ���̺��� ����)
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME='SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO=7902;
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME FROM EMP WORKER, EMP MANAGER WHERE WORKER.ENAME='SMITH' AND WORKER.MGR = MANAGER.EMPNO;

-- ex. ��� ����� ���, �̸�, ����� ���, ����� �̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO; 
    -- MGR�� NULL�� �ʵ�(KING)�� �ֱ� ������ ������� �����Ͱ� ���� EMPNO �� NULL �Ұ���
    
--ex. 'SMITH�� ���� FORD��' �������� ���
SELECT W.ENAME || '�� ���� ' || M.ENAME ||'��' MESSAGE FROM EMP W, EMP M WHERE W.MGR = M.EMPNO;
    

--	�Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
--	SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT W.ENAME FROM EMP W, EMP S WHERE W.DEPTNO=S.DEPTNO AND S.ENAME='SCOTT' AND W.ENAME <> 'SCOTT';
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP VALUES (9999, 'HONG', NULL, NULL, NULL, 6000, NULL, 50);
ROLLBACK;
SELECT * FROM DEPT;
SELECT * FROM EMP;
--	SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT E1.ENAME FROM EMP E1, EMP E2, DEPT D1, DEPT D2 WHERE D1.DEPTNO=E1.DEPTNO AND D2.DEPTNO=E2.DEPTNO AND D1.LOC=D2.LOC AND E2.ENAME='SCOTT' AND E1.ENAME <> 'SCOTT';

-- ��4. OUTER JOIN : EQUI JOIN & SELF JOIN �� ���ǿ� �������� �ʴ� ����� ��Ÿ������
--  (1) SELF JOIN������ OUTER JOIN
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO(+);

--ex. "SMITH�� ���� FORD" ... "KING�� ���� ����"
SELECT W.ENAME || '�� ���� ' || M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO(+);

--ex. ���ܻ�� �̸��� ���
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;

-- (2) EQUI JOIN������ OUTER JOIN;
SELECT * FROM EMP; -- 14��
SELECT * FROM DEPT; -- 4�� (10,20,30,40)
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO; -- 40�� �μ� ��� �ȵ�
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO(+)=D.DEPTNO;


-- �� <��������> PART1
--1. �̸�, ���ӻ���
SELECT E.ENAME, M.ENAME MANAGER FROM EMP E, EMP M WHERE E.MGR=M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ���
SELECT E.ENAME, E.SAL, E.JOB, M.ENAME MANAGER FROM EMP E, EMP M WHERE E.MGR=M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT E.ENAME, E.SAL, E.JOB, M.ENAME MANAGER FROM EMP E, EMP M WHERE E.MGR=M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT E.ENAME, E.SAL, D.DNAME, M.ENAME MANAGER FROM EMP E, EMP M, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.MGR=M.EMPNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT E.ENAME, E.SAL, E.DEPTNO, DNAME MANAGER, D.LOC, M.ENAME FROM EMP E, DEPT D, EMP M WHERE E.DEPTNO=D.DEPTNO AND E.MGR=M.EMPNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT E.ENAME, E.SAL, GRADE, DNAME, M.ENAME MANAGER FROM EMP E, SALGRADE, DEPT D, EMP M WHERE E.MGR=M.EMPNO AND E.SAL BETWEEN LOSAL AND HISAL AND E.SAL > 2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT E.ENAME, E.SAL, GRADE, DNAME, M.ENAME MANAGER FROM EMP E, EMP M, SALGRADE, DEPT D WHERE E.MGR(+)=M.EMPNO AND D.DEPTNO=E.DEPTNO AND E.SAL BETWEEN LOSAL AND HISAL ORDER BY D.DEPTNO;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT E.ENAME, E.SAL, GRADE, DEPTNO, (E.SAL+NVL(E.COMM,0))*12 ANNUALSAL, M.ENAME MANAGER FROM EMP E, EMP M, SALGRADE, DEPT D WHERE E.MGR=M.EMPNO AND D.DEPTNO=E.DEPTNO AND E.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT E.ENAME, E.SAL, GRADE, DEPTNO, (E.SAL+NVL(E.COMM,0))*12 ANNUALSAL, M.ENAME MANAGER FROM EMP E, EMP M, SALGRADE, DEPT D WHERE E.MGR=M.EMPNO AND D.DEPTNO=E.DEPTNO AND E.SAL BETWEEN LOSAL AND HISAL ORDER BY D.DNAME, E.SAL DESC;
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE D.DEPTNO=E.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D WHERE D.DEPTNO=E.DEPTNO AND LOC='NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, D.DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D WHERE ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL>2000 ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL > 2500 ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E.ENAME, M.ENAME MANAGER FROM EMP E, EMP M WHERE E.MGR(+)=M.EMPNO;
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E.ENAME, M.ENAME MANAGER, K.ENAME FROM EMP E, EMP M, EMP K WHERE E.MGR=M.EMPNO AND M.MGR=K.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E.ENAME, M.ENAME MANAGER, K.ENAME UPPER_MANAGER FROM EMP E, EMP M, EMP K WHERE E.MGR=M.EMPNO AND M.MGR=K.EMPNO(+);