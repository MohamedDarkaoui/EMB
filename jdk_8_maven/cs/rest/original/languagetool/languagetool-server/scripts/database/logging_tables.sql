USE lt;
-- Create the `ignore_words` table if it doesn't exist
CREATE TABLE IF NOT EXISTS ignore_words (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    ignore_word VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the `users` table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    api_key VARCHAR(255) NOT NULL
);

-- Insert test users if they don't already exist
INSERT INTO users (email, api_key) VALUES ('test@test.de', 'foo') ON DUPLICATE KEY UPDATE email=email;
INSERT INTO users (email, api_key) VALUES ('two@test.de', 'foo-two') ON DUPLICATE KEY UPDATE email=email;

-- Create the `check_log` table if it doesn't exist
CREATE TABLE IF NOT EXISTS check_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    language VARCHAR(8),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    server INT,
    client INT,
    language_detected VARCHAR(8),
    computation_time INT,
    text_session_id INT,
    INDEX (date),
    INDEX (user_id)
);

-- Create the `servers` table if it doesn't exist
CREATE TABLE IF NOT EXISTS servers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hostname VARCHAR(64) NOT NULL
);

-- Create the `clients` table if it doesn't exist
CREATE TABLE IF NOT EXISTS clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

-- Create the `rule_matches` table if it doesn't exist
CREATE TABLE IF NOT EXISTS rule_matches (
    match_id INT AUTO_INCREMENT PRIMARY KEY,
    check_id INT NOT NULL,
    rule_id VARCHAR(128) NOT NULL,
    match_count INT NOT NULL,
    INDEX (check_id),
    INDEX (rule_id)
);

-- Create the `cache_stats` table if it doesn't exist
CREATE TABLE IF NOT EXISTS cache_stats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    server INT NOT NULL,
    cache_hits FLOAT NOT NULL,
    INDEX (date)
);

-- Create the `misc_log` table if it doesn't exist
CREATE TABLE IF NOT EXISTS misc_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    server INT,
    client INT,
    user INT,
    message VARCHAR(1024) NOT NULL,
    INDEX (date)
);

-- Create the `check_error` table if it doesn't exist
CREATE TABLE IF NOT EXISTS check_error (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(64) NOT NULL,
    date DATETIME NOT NULL,
    server INT,
    client INT,
    user INT,
    language_set VARCHAR(8),
    language_detected VARCHAR(8),
    text_length INT,
    extra VARCHAR(256),
    INDEX (date)
);

-- Create the `access_limits` table if it doesn't exist (if it already exists, this command will be ignored)
CREATE TABLE IF NOT EXISTS access_limits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(64) NOT NULL,
    date DATETIME NOT NULL,
    server INT,
    client INT,
    user INT,
    referrer VARCHAR(128),
    user_agent VARCHAR(512),
    reason VARCHAR(128),
    INDEX (date)
);
