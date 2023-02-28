-- CustomerDao (ID 중복체크, 회원가입, 로그인, 정보수정, 리스트(top-N), 회원수(cnt)

-- 1. 아이디 중복체크
SELECT * FROM CUSTOMER WHERE cID='aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('sss', '222', '이미림', '010-1122-1233', NULL, '서울시 강서구', 'f', '1995-08-02');
-- 3. 로그인
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='111';
-- 4. 정보 수정
UPDATE CUSTOMER SET cPW='111',
                    cNAME='김하나',
                    cTEL='010-1111-1111',
                    cEMAIL='aaa@a.com',
                    cADDRESS='서울시 봉천동',
                    cGENDER='f',
                    cBIRTH='1995-01-01'
                WHERE cID='aaa';
-- 5. 회원 리스트
SELECT * FROM(SELECT ROWNUM RN, A. * FROM (SELECT * FROM CUSTOMER ORDER BY cRDATE DESC) A) WHERE RN BETWEEN 1 AND 15;
-- 6. 회원 수
SELECT COUNT(*) FROM CUSTOMER;




-- FileboardDao (리스트(top-N), 글갯수(cnt), 글쓰기(원글 query 1개, 답변글 query 2개), 조회수 올리기, 글수정, 글삭제, 상세보기)

-- 1. 리스트
SELECT * FROM (SELECT ROWNUM RN, A. * FROM (SELECT * FROM FILEBOARD ORDER BY fREF DESC, fRE_STEP) A) F, CUSTOMER C WHERE F.cID = C.cID AND RN BETWEEN 1 AND 10;
-- 2. 글 갯수
SELECT COUNT(*) FROM FILEBOARD;
-- 3. 글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (fNUM_SEQ.NEXTVAL, 'ccc', '답글', '책 추천 감사', NULL, '111', 2, 1, 1, '192.1.1.2');
-- 4. 글 수정
UPDATE FILEBOARD SET fSUBJECT='책 추천 (수정)',
                    fCONTENT='이게 더 좋아요',
                    fFILENAME='1.docx',
                    fPW='111',
                    cID='aaa'
                WHERE fNUM='1';
-- 5. 글 삭제
DELETE FROM FILEBOARD WHERE fNUM='5' AND fPW='111';
-- 6. 상세보기
SELECT * FROM FILEBOARD F, CUSTOMER C WHERE F.cID = C.cID AND fNUM='1';
-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM='1';
-- 8 . 답변글 쓰기
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=1 AND fRE_STEP>0;




-- BookDao (리스트(top-N), 책 갯수, 책 등록, 상세보기(pk로 dto 가져오기))

-- 1. 리스트 출력
SELECT * FROM (SELECT ROWNUM RN, A. * FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A) WHERE RN BETWEEN 1 AND 20;

-- 2. 책 갯수
SELECT COUNT(*) FROM BOOK;

-- 3. 책 등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내일의 부',16000,'100.jpg','noImg.png','좋아',10);

-- 4. 상세 보기
SELECT * FROM BOOK WHERE bID='1';

COMMIT;
ROLLBACK;