package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder					// �����ڸ� �̿��� ������Ʈ�� �����ϴ� �Ͱ� ����� ���
@NoArgsConstructor			// �Ű������� ���� ������ ����
@AllArgsConstructor			// ��� �Ű������� �޴� ������ ����
@Data						// Getter, Setter
public class TodoEntity {
	private String id;
	private String userId;
	private String title;
	private boolean done;
}
