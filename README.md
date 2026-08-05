# Health Check App

Spring Boot と MyBatis で作成した健康診断記録管理アプリです。  
ユーザー登録、ログイン、健康診断データの一覧表示、詳細表示、登録、編集、削除ができます。

## 主な機能

- ユーザー登録
- ログイン / ログアウト
- ログインユーザーごとの健康診断記録一覧表示
- 健康診断記録の詳細表示
- 健康診断記録の新規登録
- 健康診断記録の編集
- 健康診断記録の削除
- H2 Database Console の利用

## 使用技術

- Java 21
- Spring Boot 4.1.0
- Spring MVC
- Spring Security
- Thymeleaf
- Thymeleaf Layout Dialect
- MyBatis
- H2 Database
- Bootstrap 5.3.8
- Lombok
- ModelMapper
- Maven

## 画面URL

- | URL | 内容 | 認証 |
- | --- | --- | --- |
- | `/` | `/login` へリダイレクト | 不要 |
- | `/login` | ログイン画面 | 不要 |
- | `/signup/signup` | ユーザー登録画面 | 不要 |
- | `/user/list` | 健康診断記録一覧画面 | 必要 |
- | `/user/input/{userId}` | 健康診断記録登録画面 | 必要 |
- | `/user/detail/{healthCheckId}` | 健康診断記録詳細画面 | 必要 |
- | `/user/edit/{healthCheckId}` | 健康診断記録編集画面 | 必要 |
- | `/h2-console` | H2 Database Console | 不要 |

## セットアップ

### 1. リポジトリを取得

```bash
git clone <repository-url>
cd health-check-app
```

### 2. アプリを起動

```bash
./mvnw spring-boot:run
```

起動後、ブラウザで以下にアクセスします。

```text
http://localhost:8080/login
```

## H2 Database

このアプリは H2 Database を使用します。DB 接続設定は `src/main/resources/application.properties` にあります。

```properties
spring.datasource.url=jdbc:h2:~/health_check_db
spring.datasource.username=sa
spring.datasource.password=
```

H2 Console を開く場合は、アプリ起動後に以下へアクセスします。

```text
http://localhost:8080/h2-console
```

H2 Console の接続情報:

- |	項目			| 値 |
- |	---			| --- |
- |	JDBC URL		| `jdbc:h2:~/health_check_db` |
- |	User Name	| `sa` |
- |	Password		| 空欄 |

## 初期データ

アプリ起動時に `src/main/resources/schema.sql` と `src/main/resources/data.sql` が実行されます。

- `schema.sql`: `app_user` テーブルと `health_check` テーブルを作成
- `data.sql`: サンプルユーザーと健康診断記録を登録

現在の設定では `spring.sql.init.mode=always` のため、起動するたびにテーブルが再作成され、データが初期化されます。登録したデータを残したい場合は、初期化設定や SQL の内容を変更してください。

サンプルユーザー:

- |	ユーザーID	| ユーザー名	|
- |	---			| ---		|
- | `user1`		| ユーザー1	|
- | `user2`		| ユーザー2	|

新しくログインする場合は、画面の「新規登録はこちら」からユーザーを作成できます。

## テーブル構成

### app_user

- | カラム | 型 | 内容 |
- | --- | --- | --- |
- | `id` | `BIGINT` | ユーザー管理ID |
- | `user_id` | `VARCHAR(50)` | ログイン用ユーザーID |
- | `user_name` | `VARCHAR(100)` | ユーザー名 |
- | `password` | `VARCHAR(255)` | BCrypt で暗号化されたパスワード |

### health_check

- | カラム | 型 | 内容 |
- | --- | --- | --- |
- | `health_check_id` | `INT` | 健康診断記録ID |
- | `user_id` | `VARCHAR(50)` | ユーザーID |
- | `check_date` | `DATE` | 健診日 |
- | `result` | `VARCHAR(50)` | 診断結果 |
- | `height` | `DOUBLE` | 身長 |
- | `weight` | `DOUBLE` | 体重 |
- | `bmi` | `DOUBLE` | BMI |
- | `systolic_blood_pressure` | `INT` | 最高血圧 |
- | `diastolic_blood_pressure` | `INT` | 最低血圧 |

## テスト

```bash
./mvnw test
```

## ディレクトリ構成

```text
src
├── main
│   ├── java/com/zawzaw/healthcheck
│   │   ├── config
│   │   ├── controller
│   │   ├── form
│   │   ├── model
│   │   ├── repository
│   │   ├── service
│   │   ├── serviceImpl
│   │   └── user
│   └── resources
│       ├── mapper
│       ├── static
│       ├── templates
│       ├── application.properties
│       ├── schema.sql
│       └── data.sql
└── test
```
