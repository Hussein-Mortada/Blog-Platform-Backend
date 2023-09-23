# -- Insert example users
# INSERT INTO user (username, salt, password) VALUES
#                                                 ('user1', 'salt1', 'password1'),
#                                                 ('user2', 'salt2', 'password2'),
#                                                 ('user3', 'salt3', 'password3'),
#                                                 ('user4', 'salt4', 'password4'),
#                                                 ('user5', 'salt5', 'password5'),
#                                                 ('user6', 'salt6', 'password6'),
#                                                 ('user7', 'salt7', 'password7'),
#                                                 ('user8', 'salt8', 'password8'),
#                                                 ('user9', 'salt9', 'password9'),
#                                                 ('user10', 'salt10', 'password10');

-- Insert example blogs for various industries
INSERT INTO blog (user_id, title, blogtext, industry_id) VALUES
                                                           (12, 'Tech Blog 1', 'Tech Blog Text 1', 1),
                                                           (12, 'Tech Blog 2', 'Tech Blog Text 1 , Tech Blog Text 1,Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1Tech Blog Text 1', 1),
                                                           (12, 'Beauty Blog 1', 'Beauty Blog Text 1', 2),
                                                           (12, 'Health Blog 1', 'Health Blog Text 1', 3),
                                                           (4, 'Travel Blog 1', 'Travel Blog Text 1', 4),
                                                           (5, 'Pets Blog 1', 'Pets Blog Text 1', 5),
                                                           (6, 'Gaming Blog 1', 'Gaming Blog Text 1', 6),
                                                           (7, 'Fitness Blog 1', 'Fitness Blog Text 1', 7),
                                                           (8, 'Art Blog 1', 'Art Blog Text 1', 8),
                                                           (9, 'Entertainment Blog 1', 'Entertainment Blog Text 1', 9),
                                                           (10, 'Food Blog 1', 'Food Blog Text 1', 10);

INSERT INTO blog (user_id, title, blogtext, industry_id) VALUES
                                                             (1, 'Tech Blog 2', 'Tech Blog Text 2', 1),
                                                             (2, 'Beauty Blog 2', 'Beauty Blog Text 2', 2),
                                                             (3, 'Health Blog 2', 'Health Blog Text 2', 3),
                                                             (4, 'Travel Blog 2', 'Travel Blog Text 2', 4),
                                                             (5, 'Pets Blog 2', 'Pets Blog Text 2', 5),
                                                             (6, 'Gaming Blog 2', 'Gaming Blog Text 2', 6),
                                                             (7, 'Fitness Blog 2', 'Fitness Blog Text 2', 7),
                                                             (8, 'Art Blog 2', 'Art Blog Text 2', 8),
                                                             (9, 'Entertainment Blog 2', 'Entertainment Blog Text 2', 9),
                                                             (10, 'Test Delete', 'test delete', 10),
                                                             (10, 'Food Blog 2', 'Food Blog Text 2', 10);

-- Insert example comments for blogs
-- You can modify the number of comments and their content as needed
INSERT INTO comment (blog_id, user_id, commenttext) VALUES
                                                      (1, 2, 'Interesting tech blog!'),
                                                      (1, 3, 'I agree, great insights!'),
                                                      (2, 4, 'I love beauty products.'),
                                                      (2, 5, 'Me too! Whats your favorite brand?'),
                                                    (3, 6, 'Health is wealth.'),
                                                    (4, 7, 'Traveling is so much fun!'),
                                                    (4, 8, 'I want to travel more.'),
                                                    (5, 9, 'I have a cute pet.'),
                                                    (5, 10, 'Pets are the best!'),
                                                    (6, 1, 'Im a gamer too.'),
                                                    (7, 2, 'Fitness is important for a healthy life.');

-- Add more comments as needed
