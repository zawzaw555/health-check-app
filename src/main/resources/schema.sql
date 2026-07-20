DROP TABLE IF EXISTS health_check;
DROP TABLE IF EXISTS app_user;

/* ログインのテーブル  */
CREATE TABLE app_user (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL UNIQUE,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

/* health data テーブル */
CREATE TABLE health_check (
	health_check_id INT AUTO_INCREMENT PRIMARY KEY,
	user_id VARCHAR(50) NOT NULL,
	check_date DATE NOT NULL,
	result VARCHAR(50),
	
	height DOUBLE,
	weight DOUBLE,
	bmi DOUBLE,
	
	systolic_blood_pressure INT,
	diastolic_blood_pressure INT,
	
	CONSTRAINT fk_health_check_user
		FOREIGN KEY (user_id)
		REFERENCES app_user(user_id)
);