package com.mho.portfolio.main;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Alias("mainvo")
@Setter @Getter
public class MainVO {
	private String id;
	private String pass;
}
