package com.sist.vo;

import lombok.Data;

/*
NO                NOT NULL NUMBER(38)     
GOODS_NAME                 VARCHAR2(4000) 
GOODS_SUB                  VARCHAR2(4000) 
GOODS_PRICE                VARCHAR2(26)   
GOODS_DISCOUNT             NUMBER(38)     
GOODS_FIRST_PRICE          VARCHAR2(26)   
GOODS_DELIVERY             VARCHAR2(26)   
GOODS_POSTER               VARCHAR2(4000) 
HIT                        NUMBER(38)     
 */
@Data
public class GoodsVO {

	private int no,goods_discount,hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
	
	private int price; // price : 정수형 변환용 (문자열로 있으면 구매창에 가격이 안뜸)
}
