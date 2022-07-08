--Stardew Villager Table

CREATE TABLE stardew_villagers(
	villager_id serial PRIMARY KEY,
	villager_name TEXT,
	villager_birthday TEXT,
	villager_gender_fk int REFERENCES villager_genders(gender_id),
	villager_marriage_candidacy_fk int REFERENCES marriage_candidacies(marriage_candidacy_id),
	villager_address_fk int REFERENCES villager_addresses(address_id),
	villager_career_fk int REFERENCES villager_careers(career_id),
	villager_favorite_movie_fk int REFERENCES village_movies(movie_id)
);

INSERT INTO stardew_villagers(villager_name, villager_birthday, villager_gender_fk, villager_marriage_candidacy_fk, villager_address_fk, villager_career_fk, villager_favorite_movie_fk)
VALUES 	('Abigail', 'Fall 13', 2, 1, 9, 19, 7),
		('Alex', 'Summer 13', 1, 1, 1, 19, 7),
		('Caroline', 'Winter 7', 2, 2, 9, 19, 2),
		('Clint', 'Winter 26', 1, 2, 5, 4, 9),
		('Demetrius', 'Summer 19', 2, 2, 6, 15, 5),
		('Dwarf', 'Summer 22', 3, 2, 16, 17, 1),
		('Elliott', 'Fall 5', 1, 1, 15, 2, 3),
		('Emily', 'Spring 27', 2, 1, 3, 3, 4),
		('Evelyn', 'Winter 20', 2, 2, 1, 14, 4),
		('George', 'Fall 24', 1, 2, 1, 14, 8),
		('Gus', 'Summer 8', 1, 2, 19, 17, 4),
		('Haley', 'Spring 14', 2, 1, 3, 12, 1),
		('Harvey', 'Winter 14', 1, 1, 7, 7, 4),
		('Jas', 'Summer 4', 2, 2, 11, 16, 2),
		('Jodi', 'Fall 11', 2, 2, 2, 19, 8),
		('Kent', 'Spring 4', 1, 2, 2, 10, 9),
		('Krobus', 'Winter 1', 1, 2, 18, 17, 9),
		('Leah', 'Winter 23', 2, 1, 12, 1, 3),		
		('Leo', 'Summer 26', 1, 2, 20, 19, 5),
		('Lewis', 'Spring 7', 1, 2, 8, 9, 5),
		('Linus', 'Winter 3', 1, 2, 20, 19, 9),
		('Marnie', 'Fall 18', 2, 2, 11, 17, 4),
		('Maru', 'Summer 10', 2, 1, 6, 11, 5),
		('Pam', 'Spring 18', 2, 2, 10, 5, 9),
		('Penny', 'Fall 2', 2, 1, 10, 18, 1),
		('Pierre', 'Spring 26', 1, 2, 9, 17, 6),
		('Robin', 'Fall 21', 2, 2, 6, 17, 2),
		('Sam', 'Summer 17', 1, 1, 2, 19, 6),
		('Sandy', 'Fall 15', 2, 2, 17, 17, 6),
		('Sebastian', 'Winter 10', 1, 2, 6, 13, 3),
		('Shane', 'Spring 20', 1, 1, 11, 6, 6),
		('Vincent', 'Spring 10', 1, 2, 2, 16, 1),
		('Willy', 'Summer 24', 1, 2, 14, 17, 9),
		('Wizard', 'Winter 17', 1, 2, 13, 20, 3);
	
SELECT * FROM stardew_villagers;

--Villager Genders Table
CREATE TABLE villager_genders(
	gender_id serial PRIMARY KEY,
	gender text
);

INSERT INTO villager_genders(gender)
VALUES ('Male'), ('Female'), ('Other');

SELECT * FROM villager_genders;

--Villager Marriage Candidacy Status Table
CREATE TABLE marriage_candidacies(
	marriage_candidacy_id serial PRIMARY KEY,
	marriage_candidacy text
);

INSERT INTO marriage_candidacies(marriage_candidacy)
VALUES ('Yes'), ('No');

SELECT * FROM marriage_candidacies;


--Villagers Addresses Table
CREATE TABLE villager_addresses(
	address_id serial PRIMARY KEY,
	address TEXT
);

INSERT INTO villager_addresses(address)
VALUES 	('1 River Road'), 
		('1 Willow Lane'), 
		('2 Willow Lane'), 
		('Stardew Valley Museum & Library'), 
		('Blacksmith''s Shop'), 
		('24 Mountain Road'), 
		('Clinic'), 
		('Mayor''s Manor'), 
		('Pierre''s General Store'), 
		('Trailer'), 
		('Marnie''s Ranch'), 
		('Leah''s Cottage'), 
		('Wizard''s Tower'), 
		('Fish Shop'), 
		('Beach Cabin'),
		('Dwarf''s Cave'),
		('Desert Oasis'),
		('The Sewers'),
		('Stardrop Saloon'),
		('Homeless');
		
SELECT * FROM villager_addresses;

--Villagers Careers Table
CREATE TABLE villager_careers(
	career_id serial PRIMARY KEY,
	career text
);

INSERT INTO villager_careers(career)
VALUES 	('Artist'),
		('Author'),
		('Bartender'),
		('Blacksmith'),
		('Bus Driver'),
		('Chicken Farmer'),
		('Doctor'),
		('JoJoMart Employee'),
		('Mayor'),
		('Military'),
		('Nurse'),
		('Photographer'),
		('Programmer'),
		('Retired'),
		('Scientist'),
		('School Child'),
		('Shop Owner'),
		('Tutor'),
		('Unemployed'),
		('Wizard');

	SELECT * FROM villager_careers;

--Village Movies Table
CREATE TABLE village_movies(
	movie_id serial PRIMARY KEY,
	movie text
);

INSERT INTO village_movies(movie)
VALUES 	('The Brave Little Sapling'),
		('Journey Of The Prairie King: The Motion Picture'),
		('Mysterium'),
		('The Miracle At Coldstar Ranch'),
		('Natural Wonders: Exploring Our Vibrant World'),
		('Wumbus'),
		('It Howls In The Rain'),
		('The Zuzu City Express'),
		('None');
	
SELECT * FROM village_movies;

