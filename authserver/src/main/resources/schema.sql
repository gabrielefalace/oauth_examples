CREATE TABLE oauth_access_token(
	token_id VARCHAR PRIMARY KEY, 
	token BLOB, 
	authentication_id VARCHAR, 
	user_name VARCHAR, 
	client_id VARCHAR, 
	authentication BLOB, 
	refresh_token VARCHAR
);

CREATE TABLE oauth_refresh_token (
	token_id VARCHAR PRIMARY KEY,
	token BLOB,
	authentication VARCHAR
);