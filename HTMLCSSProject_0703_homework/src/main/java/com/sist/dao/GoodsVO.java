package com.sist.dao;

import lombok.Data;

@Data
public class GoodsVO {
	private int no;
	private String goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster;
}
