package com.tyss.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto {
	
	private long pid;
	private String pname;
    private String url;
    private String description;
    private int price;
}
