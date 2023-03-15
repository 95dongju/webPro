--------------------------------------------------------------
--------------------------MVC_MEMBER--------------------------
--------------------------------------------------------------
-- DROP & CREATE
DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL    
);
-- DUMMY DATA
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
--------------------------------------------------------------
--------------------------FILEBOARD---------------------------
--------------------------------------------------------------
DROP TABLE FILEBOARD;
-- CREATE TABLE
CREATE TABLE FILEBOARD(
    fID NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) NOT NULL,
    fTITLE VARCHAR2(100) NOT NULL,
    fCONTENT VARCHAR2(4000),
    fFILENAME VARCHAR2(100) NOT NULL,
    fRDATE DATE DEFAULT SYSDATE,
    fHIT NUMBER(6) DEFAULT 0,
    fGROUP NUMBER(6),
    fSTEP NUMBER(6),
    fINDENT NUMBER(6),
    fIP VARCHAR2(30),
    FOREIGN KEY (mID) REFERENCES MVC_MEMBER (mID)
);
DROP SEQUENCE fNO_SEQ;
CREATE SEQUENCE fNO_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
-- DUMMY DATA (원글과 답변)
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'go', '더미', '내용', 'NOIMG.JPG', fNO_SEQ.CURRVAL, 0, 0, '192.1.1');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'go', '더미2', '내용2', 'NOIMG.JPG', fNO_SEQ.CURRVAL, 0, 0, '154.1.1');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'gico', '답글', '내용2-1', 'NOIMG.JPG', 2, 1, 1, '178.1.1');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (fNO_SEQ.NEXTVAL, 'gico', '답글1', '내용1-1', 'NOIMG.JPG', 1, 1, 1, '178.1.1');
--------------------------------------------------------------
----------------------------ADMIN-----------------------------
--------------------------------------------------------------
DROP TABLE ADMIN;
CREATE TABLE ADMIN(
    aID VARCHAR2(30) PRIMARY KEY,
    aPW VARCHAR2(30) NOT NULL,
    aNAME VARCHAR2(30) NOT NULL
);

INSERT INTO ADMIN
    VALUES ('admin', 'admin1', '관리자');

COMMIT;