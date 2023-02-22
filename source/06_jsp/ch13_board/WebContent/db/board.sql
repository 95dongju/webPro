-- BOARD TABLE DROP & CREATE
CREATE TABLE BOARD (
    NUM NUMBER(5,0) PRIMARY KEY, -- 글번호
    WRITER VARCHAR2(30) NOT NULL, -- 작성자
    SUBJECT VARCHAR2(100) NOT NULL, -- 글제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 본문내용
    EMAIL VARCHAR2(30), -- 작성자 이메일
    READCOUNT NUMBER(5) DEFAULT 0, -- 조회수
    PW VARCHAR2(30) NOT NULL, -- 비밀번호 (삭제용)
    REF NUMBER(5,0) NOT NULL, -- 글 그룹 (원글의 경우 글번호로/답변글일 경우 원글의 REF로) 
    RE_STEP NUMBER(3) NOT NULL, -- 글 그룹내 출력 순서 (원글은 0, 답변글은 1~...)
    RE_INDENT NUMBER(3) NOT NULL, -- 글 LIST 출력시 글제목 들여쓰기 정도(원글 0)
    IP VARCHAR2(30) NOT NULL, -- 작성자 IP
    RDATE DATE DEFAULT SYSDATE -- 작성일
);

-- 1. 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 2. 글 목록 (글 그룹이 최신인 글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;

-- 3. 글쓰기 (원글쓰기) - 글쓴이, 글제목, 글본문, 이메일, pw
    -- 글 번호 생성하는 서브쿼리
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD),
            '홍길동', '제목1', '본문내용', NULL, '111',
            (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1'
            );
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD),
            '지길동', '제목2', '본문내용', NULL, '111',
            (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1'
            );

-- 4. 글 번호로 글 상세보기 내용(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM=2;
SELECT * FROM BOARD ORDER BY REF DESC;

-- 6. 글 수정
UPDATE BOARD SET SUBJECT = '수정된 제목1',
                CONTENT = '수정된 본문\n제곧내',
                EMAIL = 'hong@hong.com',
                PW = '111',
                IP='127.0.0.1'
            WHERE NUM=1;

-- 7. 글 삭제 (비밀번호를 맞게 입력한 경우만 삭제)
COMMIT;
DELETE FROM BOARD WHERE NUM=2 AND PW='111';
ROLLBACK;


-- 데이터 조작단
DELETE FROM BOARD;
SELECT * FROM BOARD ORDER BY REF DESC;
UPDATE BOARD SET READCOUNT = 11 WHERE NUM=1;
