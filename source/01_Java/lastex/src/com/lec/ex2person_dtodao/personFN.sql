-- 프로그램 요구사항에 필요한 DML

-- 1을 누르면 데이터 입력
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '정우성', (SELECT jNO FROM JOB WHERE jNAME='배우'), 90, 80, 81);

SELECT JNAME FROM JOB;

-- 2를 누르면 원하는 직업을 입력 받아 직업별 조회후 총점을 추가하여 총점이 높은 순으로 이름(번호) 출력
SELECT ROWNUM RN, A.* 
        FROM (SELECT  pNAME || '(' || pNO || '번)' "pNAME", jNAME, KOR, ENG, MAT, KOR+ENG+MAT "TOT" 
            FROM PERSON P, JOB J
            WHERE P.jNO=J.jNO AND jNAME='배우' ORDER BY TOT DESC) A
        WHERE jNAME = '배우';


-- 3을 누르면 모든 행의 등수, 이름, 직업명, 국어, 영어, 수학, 총점
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT pNAME || '(' || pNO || '번)' "pNAME", jNAME, KOR, ENG, MAT, KOR+ENG+MAT "TOT" 
            FROM PERSON P, JOB J
            WHERE P.jNO=J.jNO ORDER BY TOT DESC) A);