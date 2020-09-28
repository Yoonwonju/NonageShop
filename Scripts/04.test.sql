-- 테이블 삭제
--DROP TABLE PRODUCT CASCADE CONSTRAINTS;

-- 시퀀스 삭제
--DROP TRIGGER PRODUCT_NO_SEQ;

-- 트리거 삭제
--DROP SEQUENCE TRI_PRODUCT_NO_SEQ;

ALTER TABLE PRODUCT 
RENAME COLUMN DEL_USEYN TO DEL_YN;

SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT WHERE NO = 36;

-- Member
SELECT * FROM MEMBER;
SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, LEAVE_YN, JOIN_DATE FROM MEMBER;
SELECT 1 FROM MEMBER WHERE ID = 'tre';
SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, LEAVE_YN, JOIN_DATE FROM MEMBER WHERE ID = 'one';

INSERT INTO MEMBER (ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, LEAVE_YN, JOIN_DATE) VALUES (three, 3333, 세번째, third@test.co.kr, 123-123, 대구시송파구잠실2동 리센츠 아파트 201동 505호, 010-123-1234, y, sysdate);

SELECT * FROM MEMBER;
SELECT count(*) FROM address;

select ZIP_NUM, SIDO, GUGUN, DONG, ZIP_CODE, BUNJI from address where dong like '%구암동%';

-- cart
insert into cart(memberid, pno, quantity) values('one', 1, 1);
select * from cart_view where id='one' order by cseq DESC;

SELECT c."NO" , c.MEMBERID , c.PNO , m.NAME , p.NAME, c.QUANTITY, c.REG_DATE, p.MARGIN , c.RESULT 
  FROM cart c JOIN MEMBER m ON c.MEMBERID = m.ID JOIN PRODUCT p ON c.PNO =p."NO" 
 WHERE result = '1';
 
-- ORDER
SELECT *
  FROM USER_SEQUENCES;

 SELECT ORDER_DETAIL_NO_SEQ.CURRVAL FROM dual;

select max(no) from orders;
SELECT * FROM ORDER_DETAIL;

-- 
SELECT * FROM cart;
SELECT * FROM product;
SELECT * FROM member;
SELECT * FROM ADDRESS;

SELECT ZIP_NUM,SIDO,GUGUN,DONG,ZIP_CODE,BUNJI FROM ADDRESS WHERE DONG LIKE '고덕1동';
--

SELECT * FROM ORDERs;
SELECT * FROM ORDER_DETAIL;
SELECT * FROM order_view;
SELECT * FROM cart;
SELECT DNO, ONO, MID, ORDER_DATE, PNO, QUANTITY, MNAME, ZIP_NUM, ADDRESS, PHONE, PNAME, SALEPRICE, RESULT
  FROM ORDER_VIEW WHERE MID = 'two' AND ono=(SELECT max(no) FROM ORDERS) AND RESULT = '1';
  
SELECT max(no) FROM ORDERS;
-- ORDER
insert into orders(id) values('two'); -- ono4

insert into order_detail(ono, pno, quantity) values((SELECT max(no) FROM ORDERS), 9, 3);
insert into order_detail(ono, pno, quantity) values((SELECT max(no) FROM ORDERS), 10, 3);
insert into order_detail(ono, pno, quantity) values((SELECT max(no) FROM ORDERS), 11, 3);

SELECT * FROM ORDER_VIEW where mid='two' and result='1' order by ono DESC;

select distinct ono from order_view 
where mid='two' and result='1' order by ono DESC;

SELECT ONO, MID, MNAME, PHONE, ZIP_NUM, ADDRESS, DNO, ORDER_DATE, RESULT,
       PNO, PNAME, QUANTITY, SALEPRICE 
  FROM ORDER_VIEW 
 WHERE MID='two' AND RESULT LIKE '%' ;
 

--QnA
SELECT NO, SUBJECT, CONTENT, REP, ID, REP_YN, WRITE_DATE FROM QNA;
update qna SET rep='답변내용', rep_yn='2';

SELECT NO, SUBJECT, CONTENT, REP, ID, REP_YN, WRITE_DATE FROM QNA WHERE ID='one' ORDER BY NO DESC;
SELECT NO, SUBJECT, CONTENT, REP, ID, REP_YN, WRITE_DATE FROM QNA WHERE NO=2;
INSERT INTO QNA (SUBJECT, CONTENT, ID) VALUES(?, ?, ?);