package com.sist.dao;

import lombok.Data;

@Data
public class GoodsVO {
	private int no,goods_discount,hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_poster,goods_delivery;
}
