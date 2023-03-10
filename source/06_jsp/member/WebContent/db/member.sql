DROP TABLE MVC_MEMBER;

CREATE TABLE MVC_MEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30) NOT NULL,
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE  NOT NULL
);

-- id 중복체크
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MID='aaa';

-- join
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('bbb', '222', '김감감', '123@gmai.com', 'NOIMG.png', TO_DATE('1993-01-21', 'YYYY-MM-DD'), '부산시');

-- login check 
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW='111';

-- mid로 memberDto 가져오기
SELECT * FROM MVC_MEMBER WHERE MID='aaa';

SELECT * FROM MVC_MEMBER;
COMMIT;