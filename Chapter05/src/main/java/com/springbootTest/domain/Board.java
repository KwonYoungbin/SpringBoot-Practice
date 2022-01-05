package com.springbootTest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member")
@Entity
public class Board {
	@Id @GeneratedValue
	private Long seq;
	private String title;
//	private String writer;	연관관계 매핑을 위한 주석처리
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable = false)
	private Member member;
}
