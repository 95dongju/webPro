-- [XI] INDEX
--      : 조회 속도를 빠르게 함

SELECT * FROM USER_INDEXES;
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP테이블과 같은 내용의  EMP01;
SELECT * FROM EMP01; -- 14행 (0.002초)
INSERT INTO EMP01 SELECT * FROM EMP01; -- ★데이터뻥튀기 1번(28) 2번(56행)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; -- ★ 11번 (11만개)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번(22만) 2번(44만) 3번(90만)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01; -- 91만개


-- 인덱스 생선 전 조회 (91만개) (0.021초)
SELECT * FROM EMP01 WHERE ENAME='HONG';

-- 인덱스 생성 (0.44초)
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);

-- 인덱스 생성 후 조회 (91만개) (0.004초)
SELECT * FROM EMP01 WHERE ENAME='HONG';

COMMIT;

-- INSERT를 많이 하는 테이블은 INDEX 사용하면 속도가 느려짐

INSERT INTO EMP01 SELECT * FROM EMP01;
-- 인덱스 생성 후 91만개->182만으로 INSERT (30.247초)

SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
ROLLBACK; -- (13.983초)

DROP INDEX IDX_EMP01_ENAME; -- 인덱스 삭제

INSERT INTO EMP01 SELECT * FROM EMP01;
-- 인덱스 제거 후 91만개->182만으로 INSERT  (1.047초)

SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP01';
DROP TABLE EMP01; -- 테이블 삭제하면 해당 테이블 인덱스 자동 삭제

