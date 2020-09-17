SELECT * FROM PRODUCT;
--DROP TABLE PRODUCT;
--DELETE FROM PRODUCT;
--TRUNCATE TABLE PRODUCT;

insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN) 
values('롱부츠', '2', 40000, 50000, 10000,'따뜻한 롱부츠 입니다.', 'w-28.jpg', 'n');

insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN)
values( '힐', '1', '10000', '12000', '2000', '여성용전용 힐', 'w-26.jpg', 'n');
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN) 
VALUES( '슬리퍼', '4', '5000', '5500', '500', '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN)
values('회색힐', '1', '10000', '12000', '2000', '여성용전용 힐', 'w9.jpg', 'n');
insert into product(name,kind,price,saleprice,margin,content,image)
values( '여성부츠', '2', '12000', '18000', '6000', '여성용 부츠', 'w4.jpg' );
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN)
values( '핑크샌달', '3', '5000', '5500', '500', '사계절용 샌달입니다.', 'w-10.jpg', 'y');
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN)
values('슬리퍼', '3', '5000', '5500', '500', '편안한 슬리퍼입니다.', 'w11.jpg', 'y');
insert into product(name,kind,price,saleprice,margin,content,image) 
values('스니커즈', '4', '15000', '20000', '5000', '활동성이 좋은 스니커즈입니다.', 'w1.jpg');
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN) 
values('샌달', '3', '5000', '5500', '500', '사계절용 샌달입니다.', 'w-09.jpg','n');
insert into product(name,kind,price,saleprice,margin,content,image, BEST_YN) 
values('스니커즈', '5', '15000', '20000', '5000', '활동성이 좋은 스니커즈입니다.', 'w-05.jpg','n');



-- VIEW
-- 신상품
create or replace view new_pro_view
as
select NO, name, saleprice, image 
from( select rownum, no, name, saleprice, image 
      from product  
      where DEL_YN='y' 
      order by reg_date desc)
where  rownum <= 4;

SELECT NO, NAME, SALEPRICE, IMAGE FROM NEW_PRO_VIEW;

-- VIEW
-- 베스트상품

create or replace view best_pro_view
as
select no, name, saleprice, image 
from( select rownum, no, name, saleprice, image 
      from product  
      where BEST_YN='y' 
      order by reg_date desc)
where rownum <= 4;

SELECT NO, NAME, SALEPRICE, IMAGE FROM best_pro_view;

SELECT NO,NAME,KIND,PRICE,SALEPRICE,MARGIN,CONTENT,IMAGE,DEL_YN,BEST_YN,REG_DATE
  FROM PRODUCT
 WHERE NO = 42;
 
SELECT NO,NAME,KIND,PRICE,SALEPRICE,MARGIN,CONTENT,IMAGE,DEL_YN,BEST_YN,REG_DATE
  FROM PRODUCT
 WHERE KIND = 2;