package com.zawzaw.healthcheck.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(message = "ユーザーIDを入力してください")
	private String userId;
	
	@NotEmpty(message = "パスワードを入力してください")
	@Size(min = 4,max = 20, message = "パスワード4~20文字で入力してください")
	@Pattern(regexp = "^[a-zA-Z0-9]+$",message = "パスワードは半角英数字のみで入力してください")
	private String password;
	
	@NotBlank(message = "名前を入力してください")
	private String userName;
	
}
