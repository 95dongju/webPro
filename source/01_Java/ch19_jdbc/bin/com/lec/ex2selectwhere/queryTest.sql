-- Ex1. �μ���ȣ �ް� �μ����� ����ϱ�
SELECT * FROM EMP WHERE DEPTNO=40;
-- Ex2. �μ���ȣ �ް� �μ������� ������� ���
SELECT E.EMPNO, E.ENAME, E.SAL, M.ENAME MANAGER
			    FROM EMP E, EMP M"
			    WHERE E.MGR=M.EMPNO AND M.DEPTNO=40;
-- Ex3. 
SELECT * FROM DEPT WHERE DNAME='RESEARCH';
-- Ex4. 
