package com.mho.portfolio.main;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
	
	MainVO findMain();
}
