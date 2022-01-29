package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder					// 생성자를 이용해 오브젝트를 생성하는 것과 비슷한 기능
@NoArgsConstructor			// 매개변수가 없는 생성자 구현
@AllArgsConstructor			// 모든 매개변수를 받는 생성자 구현
@Data						// Getter, Setter
public class TodoEntity {
	private String id;
	private String userId;
	private String title;
	private boolean done;
}
