-- Emp.xml id=empList (출력순서 : empno 순)
SELECT * FROM EMP ORDER BY EMPNO;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO) A) WHERE RN BETWEEN 6 AND 10;
-- Emp.xml id=empDeptList
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO) A) WHERE RN BETWEEN 6 AND 10;
-- Emp.xml id=totcnt
SELECT COUNT(*) FROM EMP;
-- Emp.xml id=detail
SELECT * FROM EMP WHERE EMPNO=7782;
-- Emp.xml id=managerList
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
-- Emp.xml id=insert
INSERT INTO EMP VALUES (9000, 'CLAIR', 'MANAGER', 7902, '23/04/11', 3100, 310, 40);
-- Emp.xml id=update
UPDATE EMP SET ENAME = 'CLAIR',
                JOB = 'IT',
                MGR = 7902,
                HIREDATE = '23/04/11',
                SAL = 4000,
                COMM = 1000,
                DEPTNO = 40
            WHERE EMPNO = 9000;
-- Emp.xml id=delete
DELETE FROM EMP WHERE EMPNO=9000;
-- Dept.xml id=deptList
SELECT * FROM DEPT;
COMMIT;
