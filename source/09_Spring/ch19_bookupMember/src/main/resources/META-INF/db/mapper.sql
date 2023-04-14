-- ★  ★  ★  ★  ★  ★ book.xml ★  ★  ★  ★  ★  ★ 
-- id = mainList(신간도서순)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- id = bookList (startRow ~ endRow까지) 출력순서: bTITLE 기준
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BTITLE) A) WHERE RN BETWEEN 1 AND 3;
-- id = totCntBook (등록된 책 갯수)
SELECT COUNT(*) FROM BOOK;

-- id = getDetailBook (책 번호로 DTO 가져오기)
SELECT * FROM BOOK WHERE BNUM = 1;
-- id = registerBook (책 등록)

-- id = modifyBook (책 수정)
UPDATE BOOK SET BTITLE = '',
                BWRITER = '',
                BRDATE = '',
                BIMG1 = '',
                BIMG2 = '',
                BINFO = ''
            WHERE BNUM = '';


-- member.xml
-- id = idConfirm(mid가 id인 데이터 갯수)
SELECT COUNT(*) FROM MEMBER WHERE MID = 'aaa';
-- id = joinMember (회원가입)
INSERT INTO MEMBER VALUES ('bbb', '1', '김길동', '95.dongju@gmail.com', '45754', '서울시 관악구 봉천동 671-271');
-- id = getDetailMember(mid로 memberDto 가져오기)
SELECT * FROM MEMBER WHERE MID = 'aaa';
-- id = modifyMember
UPDATE MEMBER SET MPW = '2',
                    MNAME = '김순순',
                    MMAIL = '95.dongju@gmail.com',
                    MPOST = '19827',
                    MADDR = '서울시 관악구 봉천동 팰리스타운5차'
                WHERE MID = 'bbb';
