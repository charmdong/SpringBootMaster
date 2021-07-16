package com.donggun.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createdDate;
	private int cnt;
	
}
