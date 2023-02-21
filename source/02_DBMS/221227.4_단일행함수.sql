-- [IV] 단일행함수
-- 함수 = 단일행함수, 그룹함수(집계함수)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH') FROM EMP; -- 단일행 단일행 적용
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- 단일행함수 (INPUT 1행 > OUTPUT 1행)
SELECT SUM(SAL), AVG(SAL) FROM EMP; -- 그룹함수 (INPUT 14행 > OUTPUT 1행)
    -- 그룹함수를 볼 때는 분산, 표준편차를 같이 봐야 함
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO; -- 그룹함수 (INPUT N행 > OUTPUT 1행)

-- ★1. 단일행 함수의 종류: 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL(), ETC...
-- 1. 숫자관련함수
-- DUAL 테이블: 오라클에서 제공한 1행 1열짜리 DUMMY TABLE
SELECT ABS(-1) FROM DUAL;
SELECT * FROM TAB;
SELECT ABS(-1) FROM DUMMY; -- 절대값
SELECT FLOOR(34.5678) FROM DUAL; -- 소수점에서 내림
SELECT FLOOR(34.5678*10)/100 FROM DUAL; -- 소수점 두번째에서 내림(버림)
SELECT TRUNC(34.5678, 2) FROM DUAL; --소수점 N번째 자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL; -- 매개변수 1개만 쓰면 소수점에서 알아서 내림
SELECT TRUNC(34.5678, 1) FROM DUAL; -- 두번째 매개변수에서 선언한 소수점에서 내림 (일의 자리)

-- ex. EMP 테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;  -- 십의 자리

SELECT CEIL(34.5678) FROM DUAL; -- 소수점에서 올림

SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678*10)/10 FROM DUAL; -- 일의 자리에서 반올림
SELECT ROUND(34.5678,2) FROM DUAL; -- 소수점 두번째 자리에서 반올림

SELECT MOD(9,2) FROM DUAL; -- 나머지 연산자

--ex. 홀수년도에 입사한 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'),2)=1;

-- 2. 문자관련함수
-- (1) 대소문자 관련
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- 첫 문자만 대문자로
SELECT INITCAP('welcome to oracle') FROM DUAL;
SELECT UPPER('ABCabc') FROM DUAL; -- 다 대문자로
SELECT LOWER('ABCabc') FROM DUAL; -- 다 소문자로

--ex. 이름이 Scott인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
--ex. job이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- (2) 문자연결(CONCAT함수, || 연산자)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT ('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
-- ex. SMITH는 manager다
SELECT CONCAT(CONCAT(ENAME,'는 '), CONCAT(JOB,'다')) FROM EMP;

SELECT ENAME || '는 ' || JOB || '다' FROM EMP;