SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%';
SELECT * FROM EMP WHERE JOB LIKE '%'||'E'||'%';
SELECT * FROM EMP WHERE DEPTNO=20;

-- Emp.xml의 id=empList
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'E'||'%';
--Dept.xml의 id=deptList
SELECT * FROM DEPT;