INSERT INTO building (ID) VALUES (1);
INSERT INTO building (ID) VALUES (2);



INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (1, 20,'ON');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (1, 30,'ON');
INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID,  BUILDING_ID ) VALUES (1, 1, 1,1);

INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (2, 10,'OFF');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (2, 40,'ON');
INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID,  BUILDING_ID ) VALUES (2, 2, 2,1);

INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (3, 20,'OFF');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (3, 50,'ON');
INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID,  BUILDING_ID ) VALUES (3, 3, 3,2);


