--------------------------------------------------------------
-----------------------MemberDao Query------------------------
--------------------------------------------------------------
-- (1) 로그인
SELECT * FROM MVC_MEMBER WHERE mID='go' and mPW='1';
-- (2) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE mId='go';
-- (3-1) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE mId='go';
-- (3-2) 이메일 중복체크
SELECT * FROM MVC_MEMBER WHERE mEMAIL = 'gayun@naver.com';
-- (4) 회원가입
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1998/12/12','강남');
-- (5) 회원정보 수정
UPDATE MVC_MEMBER SET mPw = '111',
                    mName = '송중기',
                    mEmail = 'song@naver.com',
                    mPhoto = 'song.JPG',
                    mBirth = '1991/12/12',
                    mAddress = '서울'
        WHERE mId='aaa';
-- (6) 회원리스트(top-N구문)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A)
        WHERE RN BETWEEN 1 AND 10;
-- (7) 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
-- (8) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE mID='eee';
COMMIT;
--------------------------------------------------------------
-----------------------BoardDao Query-------------------------
--------------------------------------------------------------
-- (1) 글 목록 (startRow, endRow)
SELECT B.*, M.mNAME FROM(SELECT ROWNUM RN, A.* FROM(SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A) B, MVC_MEMBER M WHERE RN BETWEEN 1 AND 10 AND B.mID = M.mID;
-- (2) 글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;
-- (3-1) 글쓰기 (원글)
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'gico', '답글1', '내용1-1', 'NOIMG.JPG', 0, 0, 0, '178.1.1');
-- (3-2-1) 글쓰기 (답변 전 단계) : 원글의 fGROUP과 같고, 원글의 fSTEP보다 크면 fSTEP을 하나 증가
UPDATE FILEBOARD SET fSTEP = fSTEP + 1
            WHERE fGROUP = 2 AND fSTEP > 0;
-- (3-2-2) 글쓰기 (답변) : 
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'gico', '답글1', '내용1-1', 'NOIMG.JPG', 2, 2, 2, '178.1.1');
-- (4) 조회수
UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fID = '1';
-- (5) 글번호로 글 전체 내용 가져오기
SELECT B.*, M.mNAME FROM FILEBOARD B, MVC_MEMBER M WHERE B.mID = M.mID AND fID = '1';
-- (6) 글 수정 (fID, fTITLE, fCONTENT, fFILENAME, fRDATE (sysdate), fIP 수정)
UPDATE FILEBOARD SET fTITLE = '수정1',
                    fCONTENT = '내용 바꿈',
                    fFILENAME = 'NOIMG.png',
                    fRDATE = SYSDATE,
                    fIP = '181.1.2'
                WHERE fID = '1';
-- (7) 글 삭제(fID)
DELETE FROM FILEBOARD WHERE fID='4';
-- (8) 회원 탈퇴시 탈퇴하는 회원(mID)이 쓴 글 모두 삭제하기
DELETE FROM FILEBOARD WHERE mID='gico';
COMMIT;

--------------------------------------------------------------
-----------------------AdminDao Query-------------------------
--------------------------------------------------------------
-- (1) admin 로그인
SELECT * FROM ADMIN WHERE aID='admin' AND aPW='admin1';
-- (2) 로그인 후 세션에 넣을 용도 admin aid로 AdminDto 가져오기
SELECT * FROM ADMIN WHERE aID='admin';
-- (3) 