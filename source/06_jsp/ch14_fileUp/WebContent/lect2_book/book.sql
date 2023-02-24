-- 
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY;
CREATE TABLE BOOKCATEGORY(
  CATEGORY_CODE NUMBER(3) PRIMARY KEY,
  CATEGORY_NAME VARCHAR2(50) UNIQUE NOT NULL,
  OFFICE_LOC    VARCHAR2(50) NOT NULL
);
CREATE TABLE BOOK(
  BOOK_ID VARCHAR2(30) PRIMARY KEY,
  CATEGORY_CODE NUMBER(3) REFERENCES BOOKCATEGORY(CATEGORY_CODE),
  BOOK_TITLE VARCHAR2(100) NOT NULL,
  BOOK_PRICE NUMBER(6) NOT NULL,
  BOOK_COUNT NUMBER(4) NOT NULL,
  AUTHOR     VARCHAR2(30) NOT NULL,
  PUBLISHING VARCHAR2(30) NOT NULL,
  BOOK_IMAGE1 VARCHAR2(100) DEFAULT 'onImg.png' NOT NULL,
  BOOK_IMAGE2 VARCHAR2(100) DEFAULT 'NOTHING.JPG' NOT NULL,
  BOOK_DISCOUNT NUMBER(3) DEFAULT 0,
  BOOK_RDATE DATE DEFAULT SYSDATE NOT NULL
);
SELECT * FROM BOOK;
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY;

-- CH14_FILEUP BOOK 예제
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
CREATE TABLE BOOK(
  bID NUMBER(7) PRIMARY KEY,
  bTITLE VARCHAR2(100) NOT NULL, -- 책이름
  bPRICE NUMBER(6)     NOT NULL, -- 책가격
  bIMAGE1 VARCHAR2(100) NOT NULL, -- 책 대표 이미지
  bIMAGE2 VARCHAR2(100) NOT NULL, -- 책 추가 이미지
  bCONTENT VARCHAR2(4000),        -- 책 설명
  bDISCOUNT NUMBER(3)   NOT NULL, -- 할인율
  bRDATE    DATE DEFAULT SYSDATE NOT NULL
);
CREATE SEQUENCE BOOK_SEQ MAXVALUE 9999999 NOCACHE NOCYCLE;
SELECT * FROM BOOK;
-- 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
  VALUES (BOOK_SEQ.NEXTVAL, '이것이 자바다', 20000, 'noImg.png', 'NOTHING.png', 'OOO', 20);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
  VALUES (BOOK_SEQ.NEXTVAL, 'JSP', 15000, 'NOTHING.png', 'noImg.png', '111', 10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
  VALUES (BOOK_SEQ.NEXTVAL, 'SPRING', 30000, 'NOTHING.png', 'noImg.png', '222', 15);
-- 책 리스트 (PAGING 없이)
SELECT * FROM BOOK ORDER BY bRDATE DESC; -- 선착도서 순으로 출력
-- 책 리스트 (PAGING 추가 - top-n 구문)
SELECT * FROM (SELECT ROWNUM RN, A. * FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A) WHERE RN BETWEEN 2 AND 3;
-- 등록된 책 갯수
SELECT COUNT(*) FROM BOOK;
-- 상세보기 ( bID로 책정보 가져오기)
SELECT * FROM BOOK WHERE bID=2;