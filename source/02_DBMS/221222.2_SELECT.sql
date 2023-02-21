-- [II] SELECT 문 - 조회
-- 1. SELECT 문장 작성법
-- "--"는 주석, 웬만하면 주석은 한 줄에 포함하지 않게 작성
-- 현재 계정(실행: CTRL + ENTER)
-- SELECT는 필드를 조회하는 것 / *는 모든 필드를 의미

SHOW USER;

SELECT * FROM TAB;
    -- 현 계정이 가지고 있는 테이블 정보
SELECT * FROM EMP;
    -- EMP 테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT;
    -- DEPT 테이블의 모든 열(필드), 모든 행
SELECT * FROM SALGRADE;

-- 2. 특정 열만 출력:
DESC EMP;
    -- (특정 테이블의 구조를 알고 싶을 때: DESC) EMP 테이블의 구조를 출력함
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
    -- EMPNO, ENAME, SAL, JOB 필드 모든 행 검색
SELECT EMPNO, ENAME, SAL, JOB, MGR, SAL, COMM FROM EMP;
    -- SELECT 뒤의 필드만 출력
    
-- 필드에 별칭을 두는 경우:
SELECT EMPNO AS "사 번", ENAME AS "이름", SAL AS "급여", JOB AS "직책" FROM EMP;
    -- 필드에 AS "" 사용하여 별칭을 줄 수 있음
SELECT EMPNO "사 번", ENAME "이름", SAL "급여", JOB "직책" FROM EMP;
    -- AS 제외해도 별칭 지급 가능
SELECT EMPNO "사 번", ENAME 이름, SAL 급여, JOB 직책 FROM EMP;
    -- 스페이스가 있으면 "" 필수, 스페이스 없으면 "" 제외 가능
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB FROM EMP;
    -- 한글도 특수문자이기 때문에 웬만하면 영어로 작성하는 것 추천

-- 3. 특정 행만 출력: WHERE절 (조건절) -- 비교연산자 : 같다(=), 다르다(!=, ^=, <>), >, >=, <
-- 비교 연산자는 숫자, 문자, 날짜형 모두 가능
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000;
    -- SAL이 3000이랑 같은 행을 출력
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL != 3000;
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL ^= 3000;
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL <> 3000;
    -- SAL이 3000이랑 다른 행을 출력
-- ex1. 사원이름(ENAME)이 'A','B','C'로 시작하는 사원의 모든 필드
-- A < AA < AAA < AAAA < AAAAA < AA...A < A...AB ...
SELECT * FROM EMP WHERE ENAME <= 'D';
-- ex2. 81년도 이전에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
-- ex3. 부서번호 (DEPTNO)가 10번인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10;
-- ex4. 이름(ENAME)이 FORD인 직원의 EMPNO, ENAME, MGR(상사의 사번)을 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
    -- SQL문은 대소문자 구별 없지만, 데이터는 대소문자 구별함 (like 'FORD')
    
-- 4. 조건절에 논리연산자 : AND, OR, NOT
-- ex1. 급여(SAL)이 2000이상 3000이하인 직원의 모든 필드
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <=3000;
-- ex2. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
-- 날짜 표기법 세팅 (YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
-- 날짜 표기법을 모르면 특정 날짜의 행을 논리연산자로 찾을 수 없기 때문에 아래 함수 사용
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD')>='82/01/01'
    AND TO_CHAR(HIREDATE, 'RR/MM/DD')<='82/12/31';
    -- 단일행 함수 (행마다 따로 수행하는 함수)
ALTER SESSION SET NLS_DATE_FORMAT = 'YY/MM/DD';
-- ex3. 연봉이 2400 이상인 직원의 ENAME, SAL, 연봉(SAL*12)을 출력
SELECT ENAME, SAL, SAL*12 FROM EMP;
    -- 필드에 있는 부분은 연산자를 써도 됨. BUT, 
    -- 이렇게 하면 타이틀에 곱하기 같은 특수문자가 들어가게 되기 때문에 아래처럼 이름 지정해 줌.
    -- 하지만 아래처럼 이름 지정한 절에서 바로 뽑아오면 안됨.
SELECT ENAME, SAL, SAL*12 ANNUALSAL -- (3) 그 다음 별칭 지정한 절로 감
    FROM EMP                        -- (1) 처음 FROM절 실행하고
    WHERE ANNUALSAL >= 2400;    -- (2) WHERE 조건에 만족하는지 확인함
    -- WHERE 절에는 별칭을 쓸 수가 없음! 아래처럼 써야 함.
SELECT ENAME, SAL, SAL*12 ANNUALSAL -- (3)
    FROM EMP                        -- (1) 
    WHERE SAL*12 >= 2400;       -- (2)
-- ex4. 연봉이 10,000 이상인 직원의 ENAME, SAL, 연봉 (연봉순으로 정렬해서 출력)
SELECT ENAME, SAL, SAL*12 "연봉" --(3)앨리야스 별칭에는 ""쌍따옴표.
    FROM EMP                    --(1)
    WHERE SAL*12 > 2400         --(2)
    ORDER BY 연봉;               --(4)
-- ex5. 10번 부서(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    -- SINGLE QUATATION MARK : 문자 / DOUBLE QUATATION MARK : 별칭
--ex6. 부서번호가 10번 부서가 아닌 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPT = 10;

-- 5. 산술연산자
SELECT EMPNO, ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;
-- ex1. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12+COMM)을 출력
SELECT ENAME, SAL, COMM, SAL*12+COMM 연봉 FROM EMP;
    -- 산술연산의 결과는 NULL을 포함하면 결과가 NULL이 됨
    -- NYL(NULL일 수도 있는 필드명, 대치값)을 이용함. 필드명과 대치값은 타입이 일치함.
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) 연봉 FROM EMP;
-- 모든 사원의 ENAME, MGR (상사사번)을 출력 (상사가 없으면 CEO로 출력) > 해당 내용은 4장에서 가능
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;


-- 6. 연결연산자 (||) : 필드나 문자를 연결
SELECT ENAME || '은 ' || JOB FROM EMP;
-- ex. 모든 사원에 대하여 'SMITH : ANNUAL SALARY = XXXX' 포맷으로 출력
SELECT ENAME || ':' || 'ANUAL SALARY = ' || (SAL*12+NVL(COMM,0)) FROM EMP;
    -- 연결연산자 우선순위가 높기 때문에 산술연산자를 ()안에 넣어서 우선순위 줘야 함
    
-- 7. 중복 제거(DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

        -- ★ 연습문제
        --1. emp 테이블의 구조 출력
        DESC EMP;
        --2. emp 테이블의 모든 내용을 출력 
        SELECT * FROM EMP;
        --3. 현 scott 계정에서 사용가능한 테이블 출력
        SHOW USER;
        SELECT * FROM TAB;
        --4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
        SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
        --5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
        SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL <2000;
        --6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
        SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '81/03/01';
        --7. 업무가 SALESMAN인 사람들 모든 자료 출력
        SELECT * FROM EMP WHERE JOB = 'SALESMAN';
        --8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
        SELECT * FROM EMP WHERE JOB != 'CLERK';
        --9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
        SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >=1500 AND SAL <=3000;
        --10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
        SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
        --11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
        SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >=3000;
        --12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
        SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB = 'MANAGER' AND SAL >=2500;
        --13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
        SELECT ENAME || '은' || JOB || '업무이고 연봉은 ' || (SAL*12+NVL(COMM,0)) || '다' FROM EMP;
        --CF. "ENAME의 상여는 800" (연결연산자로 하면 NULL 출력 안됨)

-- 8. SQL 연산자 (BETWEEN, IN, LIKE, IS NULL)
-- (1) BETWEEN A AND B : A부터 B까지 (A,B 포함)
-- ex. SAL이 1500 이상 3000이하인 직원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
    -- 둘 다 똑같은 문장임. (BETWEEN 3000 AND 1500 하면 안 됨
-- ex. SAL이 1500 미만 3000 초과
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
-- ex. 이름이 'A', 'B', 'C'로 시작하는 직원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME!='D';
-- ex. 82년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; 

--(2)IN
-- ex. 부서번호가 10, 20, 40번 부서인 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
-- ex. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN (7901,7788,7566);
-- ex. 직책이 MANAGER이거나 ANALYST인 사원의 모든 필드
SELECT * FROM EMP WHERE JOB IN ('MANAGER','ANALYST');

--(3)LIKE %(0글자 이상), _(한글자)를 포함한 패턴
-- ex. 이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --M, MA, MAA, ... MZZZ...
-- ex. 이름에 N이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE'%N%';
-- ex. 이름에 N이 들어가거나 JOB에 N이 들어가는 모든 사원의 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
-- ex. 이름이 'S'로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
-- ex. SAL이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
-- ex. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
-- ex. 1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '%01%'; -- 1월 말고도 01일도 나옴
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
-- ex. 이름에 '%'가 들어간 사원의 모든 필드
    -- 특정한 문자를 검색할 때는 앞에 역슬래시 쓰고 뒤에 ESCAPE 써서 '빼라'
SELECT * FROM EMP WHERE ENAME LIKE '%%%'; -- 모든 사원 다 나옴
INSERT INTO EMP VALUES (9999, 'LISA%', NULL, NULL, NULL, 6000, 1500, 40);
    -- 데이터 추가
SELECT * FROM EMP WHERE ENAME='LISA%';
SELECT * FROM EMP WHERE ENAME LIKE'%\%%' ESCAPE '\';
ROLLBACK;
    -- DML (데이터 조작어: 추가, 수정, 삭제를 취소함)

--(4) IS NULL
-- ex. 상여금이 입력되지 않는 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE COMM IS NULL OR COMM=0;
-- ex. 상여금을 받는 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;
    -- SELECT * FROM EMP WHERE COMM NOT IS NULL AND COMM!=0; XX 안됨
    -- SELECT * FROM EMP WHERE COMM != NULL AND COMM!=0; XX 안됨


-- 9. 정렬 (오름차순, 내림차순) : ORDER BY 절
    -- 오름차순 정렬이 DEFAULT값
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL;
    -- 급여 오름차순 정렬 (ACSENDING) 기본
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC;
    -- 급여 내림차순 정렬 (DESCENDING)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, ENAME;
    -- 급여가 동일하면 이름(오름차순)으로 정렬
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE DESC;
    -- 급여가 동일하면 입사일이 늦은(내림차순)으로 정렬
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME;
    -- ABC순으로 정렬
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME DESC;
    -- Z부터 정렬
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE;
    -- 먼저 입사한 순(오름차순)으로 정렬
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) ANNUALSAL FROM EMP ORDER BY ANNUALSAL;
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) ANNUALSAL FROM EMP ORDER BY SAL*12+NVL(COMM,0);
    -- ORDER BY 절에는 ALIAS 들어올 수 있고 식이 들어올 수도 있음
    
    
    
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12+NVL(COMM,0)>=24000 ORDER BY SAL;
--4.	DLQ싸일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;
--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP WHERE SAL > 1500 AND DEPTNO IN (10,20);
--7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE 'C%' OR ENAME LIKE 'P%' ORDER BY ENAME;
--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM >= SAL*1.1;
--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;
--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%';
--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%' AND JOB != 'SALESMAN';
--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '___N%';
--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';
--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12 > 35000;

-- 형변환 함수
-- 날짜형(HIREDATE)을 문자형으로 변환: TO_CHAR(날짜형데이터, 패턴)
SELECT TO_CHAR(HIREDATE, 'MM-DD-RR') FROM EMP;
-- 년도가 2자리일때는 RR, 4자리일때는 YYYY

-- 문자형을 날짜형으로 변환 : TO_DATE(문자형데이터, 패턴)
SELECT TO_DATE('01-12-1996', 'MM-DD-YYYY') FROM EMP;
