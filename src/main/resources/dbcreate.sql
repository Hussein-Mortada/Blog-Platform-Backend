
-- Create a new schema called 'blog'
CREATE SCHEMA IF NOT EXISTS blog;

-- Use the 'blog' schema
USE blog;

DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS industry;
DROP TABLE IF EXISTS user;

-- Create the user table
CREATE TABLE IF NOT EXISTS user (
                                    user_id INT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(255) NOT NULL,
                                    salt VARCHAR(255) NOT NULL,
                                    password VARCHAR(255) NOT NULL
    );

-- Create the industry table
CREATE TABLE IF NOT EXISTS industry (
                                        industry_id INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );

-- Insert example industries
INSERT INTO industry (name) VALUES
                                ('Tech'),
                                ('Beauty'),
                                ('Health'),
                                ('Travel'),
                                ('Pets'),
                                ('Gaming'),
                                ('Fitness'),
                                ('Art'),
                                ('Entertainment'),
                                ('Food');

-- Create the blog table
CREATE TABLE IF NOT EXISTS blog (
                blog_id INT AUTO_INCREMENT PRIMARY KEY,
                user_id INT NOT NULL,
                title VARCHAR(255) NOT NULL,
                blogtext TEXT NOT NULL,
                industry_id INT NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                FOREIGN KEY (user_id) REFERENCES user(user_id),
                FOREIGN KEY (industry_id) REFERENCES industry(industry_id)
    );

-- Create the comment table
CREATE TABLE IF NOT EXISTS comment (
                                       comment_id INT AUTO_INCREMENT PRIMARY KEY,
                                       blog_id INT NOT NULL,
                                       user_id INT NOT NULL,
                                       commenttext TEXT NOT NULL,
                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       FOREIGN KEY (blog_id) REFERENCES blog(blog_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
    );