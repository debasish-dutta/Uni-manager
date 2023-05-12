CREATE TABLE student_data (
	id VARCHAR(36) NOT NULL,
	`roll no` VARCHAR(50) NOT NULL,
	`name` VARCHAR(50),
	`date of birth` DATE,
	phone VARCHAR(50),
	email VARCHAR(50),
	gender VARCHAR(50),
	`present address` VARCHAR(150),
	`registration no` VARCHAR(50),
	`father name` VARCHAR(50),
	`mother name` VARCHAR(50),
	`guardian phone` VARCHAR(50),
	`permanent address` VARCHAR(150),
	degree VARCHAR(5),
	batch VARCHAR(50),
	department VARCHAR(25),
	PRIMARY KEY (id, `roll no`)
);
-- INSERT INTO student_data (
-- 		id,
-- 		`roll no`,
-- 		`name`,
-- 		`date of birth`,
-- 		`phone`,
-- 		email,
-- 		gender,
-- 		`present address`,
-- 		`registration no`,
-- 		`father name`,
-- 		`mother name`,
-- 		`guardian phone`,
-- 		`permanent address`,
-- 		degree,
-- 		batch,
-- 		department,
pp_img -- 	)
-- values (
-- 		'0cd742c7-e218-485c-8bfa-5830e3b0b2d7',
-- 		'HJ-703-482-4928',
-- 		'Scotty Gowdridge',
-- 		'2001-11-23',
-- 		'+91 636 387 3629',
-- 		'ggowdridge0@nih.gov',
-- 		'Male',
-- 		'PO Box 17251, mattis, Jammu and Kashmir, 914921',
-- 		'86630082',
-- 		'30',
-- 		'Gregory Gowdridge',
-- 		'Cleo Gowdridge',
-- 		'+91 601 045 1745',
-- 		'Suite 4, nascetur, Andhra Pradesh, 968735',
-- 		'Bsc',
-- 		2000,
-- 		'Electronics and Communication Technology',
-- 		'Science'
-- 	);
LOAD DATA LOCAL INFILE 'random_student_data.csv' INTO TABLE student_data FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;
ALTER TABLE student_data
ADD INDEX idx_roll_no (`roll no`);
CREATE TABLE student_image (
	Id varchar(36) PRIMARY KEY NOT NULL,
	`roll no` VARCHAR(50),
	file_ longblob NOT NULL,
	CONSTRAINT `fk_roll_no` FOREIGN KEY (`roll no`) REFERENCES `student_data` (`roll no`)
);
LOAD DATA LOCAL INFILE 'random_student_image.csv' INTO TABLE student_image FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;
LOAD DATA LOCAL INFILE 'random_student_image.csv' INTO TABLE student_image FIELDS TERMINATED BY ',' IGNORE 1 ROWS (Id, `roll no`, @img)
SET file_ = LOAD_FILE(@img);
INSERT INTO student_image(Id, `roll no`, `file_`)
VALUES(
		'1bd2524b-55cc-433a-8054-570bf072fcfa',
		'EK-704-731-9640',
		LOAD_FILE(
			'/Users/debasishdutta/My Programming Stuffs/Java/Project/img_align_celeba/052628.jpg'
		)
	);