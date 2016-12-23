


CREATE TABLE People
(
  PersonID INT,
  PersonName VARCHAR(30),
  PageNumber INT
);

INSERT into People VALUES(1,'Teddy Roosevelt',1); 
INSERT INTO People 
VALUES (2, 'Toby Fox', 1);

INSERT INTO People 
VALUES (3, 'Ben Franklin', 1);

CREATE TABLE Pictures
(
    PersonID INT,
    ImgSrc VARCHAR(50)
);

INSERT INTO Pictures 
VALUES (1, 'images/teddyrooselvelt.png');
    	
INSERT INTO Pictures 
VALUES (2, 'images/tobyfox.png');

INSERT INTO Pictures 
VALUES (3, 'images/benfranklin.png');

CREATE TABLE Facts
(
    PersonID INT,
    OrderOfFact INT,
    FactText VARCHAR(2000)
);

INSERT INTO Facts 
VALUES (1, 1, 'Birthdate: April 19, 1897');

INSERT INTO Facts 
VALUES (1, 2, 'Place of Origin: New York City, NY');

INSERT INTO Facts 
VALUES (1, 3, '     26th President of the US, Teddy Roosevelt served from 1901 to 1909. Of all Roosevelt''s achievements, he was proudest of his work in conservation of natural resources, and extending Federal protection to land and wildlife. Roosevelt established the United States Forest Service, signed into law the creation of five National Parks, and signed the 1906 Antiquities Act, under which he proclaimed 18 new U.S. National Monuments. He also established the first 51 bird reserves, four game preserves, and 150 National Forests, including Shoshone National Forest, the nation''s first. Built the Panama Canal. Famously said about his foreign policy, “walk softly and carry a big stick.”

     Theodore Roosevelt is masculinity incarnate. In addition to his many great Presidential feats(development of National Parks,  There are a lot of stories about his “cowboy” attitude. One time, a gang stole TR''s boat.  Instead of crying like a girl about it, Roosevelt pursued them for two weeks through the Dakota Badlands, beat them up, handed them over to the authorities and got his boat back. During his presidency, He stood outside and gave a two-hour speech in Milwaukee immediately after being shot in the chest in an assassination attempt.  It was only after the speech ended that he went to the hospital to get the bullet removed after his death, a notable politician remarked, "Death had to take him sleeping, for if Roosevelt had been awake there would have been a fight."');

INSERT INTO Facts VALUES(2,1,'Birthdate: Unknown');

INSERT INTO Facts VALUES(2,2,'Place of Origin: Unknown');

INSERT INTO Facts VALUES(2,3,'     Toby Fox is the Main developer, designer, writer, and composer of the videogame Undertale. Undertale was funded on Kickstarter and raised roughly 50,000 dollars and took roughly 3 years to develop. Its budget is pennies compared to AAA games like The Witcher which had a budget of 63 million. Despite it''s humble beginnings Undertale has received a ton of critical acclaim, and has created a massive cult following. It was nominated for multiple The Game Awards including categories such as Best RPG, Best Indie Game, Best Game for Change. Toby Fox is a notoriously private person and is difficult to get into an interview, and it''s even more difficult to get him to answer questions about his personal life hence the unknown DOB or birthplace.

     Toby Fox is someone who had a vision and worked very hard to make his vision a reality. He had an idea for a game took his own initiative to learn how to code, and promote his project on KickStarter to get it off the ground. Unlike other projects on KickStarter, he followed through with the project and delivered something great. He intentionally did most of the work himself in order not to mess with his vision on his project. Undertale is well written, filled with quirky and endearing characters, amusing dialogue, and moments that forces the player questions their own actions and ask why they are doing it.');

INSERT INTO Facts VALUES(3,1,'Birthdate: January 17, 1706');

INSERT INTO Facts VALUES(3,2,'Place of Origin: Milk Street Boston, Massachusetts At age 17, Franklin ran away to Philadelphia, Pennsylvania');

INSERT INTO Facts VALUES(3,3,'     One of the most notable Founding Fathers of the United States. Franklin was a renowned polymath and a leading author, printer, political theorist, politician, freemason, postmaster, scientist, inventor, civic activist, statesman, and diplomat. As a scientist, he was a major figure in the American Enlightenment and the history of physics for his discoveries and theories regarding electricity. As an inventor, he is known for the lightning rod, bifocals, and the Franklin stove, among other inventions. He facilitated many civic organizations, including Philadelphia''s fire department and The University of Pennsylvania, an Ivy League institution.

     Ben Franklin was a colonial renaissance man. He excelled in many fields, one of which included founding the greatest country on earth (USA! USA! USA!). He emphasized religious tolerance in this political theory, believing that government should not be founded on religious grounds, giving its people freedom to pursue their own beliefs. Not only was he a brilliant political theorists but he was also a notable scientist and inventor. Think about that, when was the last time we had a notable political figure, who did notable scientific endeavors in their spare time? To be great at all these things Ben Franklin took good measure to make sure all of his time was well spent. Making a daily schedule, making sure the things that he did was worth doing, and living by a list a principles.');

