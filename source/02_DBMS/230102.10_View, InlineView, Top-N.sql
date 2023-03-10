-- [X] View, In-Line View, TOP-N
-- 1. VIEW : 가상의 테이블 (1)단순 VIEW (2)복합 VIEW

-- (1)단순 VIEW : 하나의 테이블을 이용하여 만든 VIEW

-- 물리적인 저장 공간과 데이터를 가지는 테이블
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1;
-- EMP 테이블과 EMP1 테이블은 완전히 별개의 테이블
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) VALUES (1111, '홍', 'ITMANAGER', 40);
SELECT * FROM EMP WHERE EMPNO=1111;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
    -- EMP1에는 데이터를 넣었지만 EMP에는 데이터가 없음
DROP TABLE EMP1;

-- 물리적인 저장 공간과 데이터가 없는 가상의 테이블
CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMPv0;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%'; -- VIEW (가상의 테이블)이기 때문에 USER_TABLES에 나타나지 않음
SELECT * FROM USER_VIEWS;
DROP VIEW EMPv0;

-- EX. EMP 테이블의 EMPNO, ENAME, JOB, DEPTNO 필드만 가져온 가상의 테이블 뷰, EMPv0
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
    
INSERT INTO EMPv0 VALUES (1111, '홍', 'ITMANAGER', 40);
SELECT * FROM EMPv0;
SELECT * FROM EMP WHERE EMPNO=1111;
    -- VIEW에 INSERT 해도 EMP 테이블에 삽입됨
UPDATE EMPv0 SET JOB = 'ANALYST' WHERE EMPNO='1111';
DELETE FROM EMPv0;

-- EMPv0이라는 VIEW = EMP의 30번 부서만
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, '홍', NULL, NULL, SYSDATE, NULL, NULL, 30);
SELECT * FROM EMPv0;
SELECT * FROM EMPv0 WHERE EMPNO<1113;
DELETE FROM EMPv0 WHERE EMPNO<1114;

-- 단순 VIEW에서 INSERT 불가한 경우 
    -- VIEW 생성시 NOT NULL 필드를 미포함한 경우
CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB FROM EMP;
INSERT INTO EMPv0 VALUES (1112, '홍', 'MANAGER');
SELECT * FROM EMP WHERE EMPNO=1112; -- (INSERT에서 언급하지 않은 필드는 NULL이 들어감)

CREATE OR REPLACE VIEW EMPv0 AS SELECT ENAME, JOB FROM EMP; -- (NOT NULL 필드 미포함)
INSERT INTO EMPv0 VALUES ('홍', 'MANAGER');
DELETE FROM EMP WHERE EMPNO<1113;
COMMIT;
SELECT * FROM EMP;


-- VIEW의 제한조건
-- WITH CHECK OPTION 추가 : VIEW의 조건에 해당되는 데이터만 삽입, 수정, 삭제 가능

-- EX. EMP 테이블의 30번 부서의 가상 테이블(30번 부서만 수정(DML)가능)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=30
        WITH CHECK OPTION;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 30); -- WITH CHECK OPTION 때문에 30번 부서만 인서트 됨
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, '홍', 40); -- 제한조건으로 에러남
    SELECT * FROM EMP WHERE ENAME='SMITH';
    DELETE FROM EMPv0 WHERE ENAME='SMITH'; -- SMITE가 30번 부서가 아니기 때문에 삭제 불가능

-- WITH READ ONLY 추가 : 읽기 전용 VIEW
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=20
        WITH READ ONLY;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, '홍', 20); -- WITH READ ONLY 제한 조건으로 에러남


-- (2) 복합 VIEW : 2개 이상의 테이블로 구성한 VIEW, 가상의 필드를 이용한 VIEW
-- ① 2개 이상의 테이블로 구성한 VIEW
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, JOB, D.DEPTNO, DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO;
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1112, 'HONG', 'MANAGER', 10, 'SALES'); -- 복합VIEW를 이용하면 INSERT 불가
-- ② 가상의 필드를 이용한 VIEW (컬럼에 별칭을 사용)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, SAL*12 YEAR_SAL FROM EMP WHERE DEPTNO=10; -- 별칭
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1113, 'HONG', 12000);
    
    --별칭이 없는 경우
    CREATE OR REPLACE VIEW EMPv0 
        AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10; -- 서브쿼리 (SELECT문)는 실행되지만 VIEW는 안 만들어짐
        
    CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL) -- 별칭만 따로 빼서 지칭하면 생성 가능
        AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10; 
        

-- EX. 사번, 이름, 급여, 10의 자리에서 반올림한 급여를 뷰로 생성
 CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, ROUND(SAL, -2) ROUND_SAL FROM EMP; -- 가상의 필드를 만들면 INSERT 안됨
    
-- EX. JOB, DEPTNO를 출력 (중복 제거)
 CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP;
    
-- EX. 부서번호, 최소급여, 최대급여, 부서평균급여를 포함한 EMPv0 VIEW 를 생성
 CREATE OR REPLACE VIEW EMPv0 (EMPNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
    
-- 부서명, 최소급여, 최대급여, 평균급여를 포함한 DEPTNOv0 VIEW를 생성
 CREATE OR REPLACE VIEW DEPTNOv0 (DNAME, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL) 
        FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO GROUP BY DNAME;

-- 2. INLINE-VIEW : FROM절의 서브쿼리를 INLINE VIEW라 하며, FROM 절의 서브쿼리는 VIEW처럼 작용함
-- EX. 급여가 2000 초과하는 사원의 평균 급여

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000); -- FROM 절 서브쿼리를 VIEW로 잠시 만들어서 보여줌

-- 3. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호, 해당 부서 평균
SELECT EMPNO, ENAME, SAL, E.DEPTNO, ROUND(AVGSAL)
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL>AVGSAL;

-- INLINE VIEW 문법
-- SELECT 필드1, 필드2,  ...
--  FROM 테이블1, (서브쿼리) 별칭 반드시
--      WHERE 조인 조건


-- 3. TOP-N 구문 ★★★★★★★★★★★★★★★★★★
     -- (TOP 1~10등, 11~20등, ...)
-- 함수를 이용한 RANK 출력 (1~꼴등까지 다 출력함)
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC),
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER FROM EMP;
-- WHERE ROW_NUMBER() OVER(ORDER BY SAL DESC)<6;
-- 함수가 WHERE 절에 들어갈 수 없음.

-- ROWNUM (테이블로부터 가져온 순서) 과 INLINE-VIEW를 이용한 TOP-N
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME, SAL FROM EMP;

SELECT ROWNUM, ENAME, SAL   -- 2.
    FROM EMP    -- 1.
     ORDER BY SAL;     -- 3.
    -- INSERT 순서대로 가져옴
    
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL);
    -- SAL을 ORDER BY 해서 ROWNUM 시킴
    
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- 1등부터 꼴찌까지 출력함
    
-- SAL을 기준으로 1등부터 5등까지 출력
SELECT ROWNUM, A.*
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL) A
    WHERE ROWNUM < 6;

-- SAL을 기준으로 6등부터 10등까지 (FROM 절에서 가져온 값이 WHERE절에 참이 아니기 때문에 값을 버림 ==> ROWNUM이 계속 1이 됨)
SELECT ROWNUM RK, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10; --ROWNUM >= 6 AND ROWNUM <=10;
    
-- TOP-N
SELECT * FROM EMP ORDER BY SAL; -- 1단계
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM EMP ORDER BY SAL) A; -- 2단계
SELECT * 
    FROM (SELECT ROWNUM RN, A.* -- ALIAS가 반드시 있어야 SELECT문의 ROWNUM이 아니라 VIEW절 안의 ROWNUM을 가지고 옴
        FROM (SELECT * FROM EMP ORDER BY SAL) A )
    WHERE RN BETWEEN 6 AND 10;

-- EX. 이름을 알파벳 순서대로 정렬해서 6~10번째 출력 (순서, 이름, 사번, JOB, MGR, HIREDATE)
SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME);
SELECT * 
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
        FROM (SELECT * FROM EMP ORDER BY ENAME)) 
    WHERE RN BETWEEN 6 AND 10;

-- EX. 입사순으로 11번째부터 15번째인 사원의 모든 필드 출력
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE) A)
    WHERE RN BETWEEN 11 AND 15;
    


-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU AS SELECT DNAME, ENAME 
    FROM DEPT D, EMP E
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER) AS SELECT W.ENAME, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). -- 학생 질문
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT DEPTNO, SUM(SAL) "SUM" FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC) A)
    ORDER BY RN;

-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT DEPTNO, SUM(SAL) "SUM" FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC) A)
    WHERE RN BETWEEN 2 AND 3
    ORDER BY RN;

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A);
        
-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 10 AND 14;
    
-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;