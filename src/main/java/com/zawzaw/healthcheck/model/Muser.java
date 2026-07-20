package com.zawzaw.healthcheck.model;

import lombok.Data;

@Data
		/* Muserクラスは　ログイン と 最初の登録用 */
public class Muser {
	private String userId;
	private String password;
	private String userName;
}
