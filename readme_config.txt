Install mySql

Install java

Import inrik schema

Create contents database with details bellow


Create a mysql data table ‘contents’, a user with passwords as bellow

SELECT User, Host FROM mysql.user WHERE User = 'andrew' AND Host = 'localhost';
DROP USER 'andrew'@'localhost';
CREATE USER 'andrew'@'localhost' IDENTIFIED BY 'passw0rd!';

CREATE USER 'andrew'@'localhost' IDENTIFIED BY 'passw0rd';

GRANT ALL PRIVILEGES ON * . * TO 'andrew'@'localhost';


CREATE USER 'inrik'@'localhost' IDENTIFIED BY 'passw0rd!';

GRANT ALL PRIVILEGES ON * . * TO 'inrik'@'localhost';

SHOW GRANTS FOR 'inrik'@'localhost';

ALTER USER 'inrik'@'localhost' IDENTIFIED BY 'password!';

DROP USER 'inrik'@'localhost';

UPDATE DATABASECHANGELOGLOCK SET LOCKED=0, LOCKGRANTED=null, LOCKEDBY=null where ID=1;

insert into users (active, channelName, confirmed, creationdate, fullname, password, phoneNumber, token, username,locale,email)
 values(1,'Inrik channel', 1, '2021-03-06 00:56:50.917000', 'I N R I K', '$2a$10$5CnPhCnru/89wkTHVMzjrulRPBk0PqLIrlxbMXYiFwS02d5DAUFnG', '6502931966', '1XW7QDL9418898', "info@inrik.com","en_US","info@inrik.com");


INSERT INTO config(configName, configValue) VALUES ("imagedir","Install mySql

Install java

Import inrik schema

Create inrik database with details bellow


Create a mysql data table ‘inrik’, a user with passwords as bellow

SELECT User, Host FROM mysql.user WHERE User = 'andrew' AND Host = 'localhost';
DROP USER 'andrew'@'localhost';
CREATE USER 'andrew'@'localhost' IDENTIFIED BY 'passw0rd!';

CREATE USER 'andrew'@'localhost' IDENTIFIED BY 'passw0rd';

GRANT ALL PRIVILEGES ON * . * TO 'andrew'@'localhost';


CREATE USER 'inrik'@'localhost' IDENTIFIED BY 'passw0rd!';

GRANT ALL PRIVILEGES ON * . * TO 'inrik'@'localhost';

SHOW GRANTS FOR 'inrik'@'localhost';

ALTER USER 'inrik'@'localhost' IDENTIFIED BY 'password!';

DROP USER 'inrik'@'localhost';

UPDATE DATABASECHANGELOGLOCK SET LOCKED=0, LOCKGRANTED=null, LOCKEDBY=null where ID=1;

insert into users (active, channelName, confirmed, creationdate, fullname, password, phoneNumber, token, username,locale,email)
 values(1,'Inrik channel', 1, '2021-03-06 00:56:50.917000', 'I N R I K', '$2a$10$5CnPhCnru/89wkTHVMzjrulRPBk0PqLIrlxbMXYiFwS02d5DAUFnG', '6502931966', '1XW7QDL9418898', "info@inrik.com","en_US","info@inrik.com");


INSERT INTO config (configname, configvalue) VALUES ("imagedir","/Users/hamidporasl/webdata/images");
INSERT INTO config (configname, configvalue) VALUES ("videodir","/Users/hamidporasl/webdata/videos");
INSERT INTO config (configname, configvalue) VALUES ("audiodir","/Users/hamidporasl/webdata/audios");
INSERT INTO config (configname, configvalue) VALUES ("filedir","/Users/hamidporasl/webdata/files");
INSERT INTO config (configname, configvalue) VALUES ("profilepath","/Users/hamidporasl/webdata/profilepath");
INSERT INTO config (configname, configvalue) VALUES ("serverlog","/Users/hamidporasl/webdata/logs");
INSERT INTO config(configname, configvalue) VALUES ("defaultChannelIconPath","/Users/hamidporasl/webdata/images/defaultChannelIcon.png");
INSERT INTO config (configname, configvalue) VALUES ("ffmpeg","d:/tools/ffmpeg/bin/ffmpeg.exe");
INSERT INTO config(configName, configvalue) VALUES ("ffprobe","d:/tools/ffmpeg/bin/ffprobe.exe");
INSERT INTO config(configname, configvalue) VALUES ("mail.transport.protocol","smtp");
INSERT INTO config(configname, configvalue) VALUES ("mail.smtp.host","outlook.office365.com");
INSERT INTO config(configname, configvalue) VALUES ("mail.smtp.auth","true");
INSERT INTO config(configname, configvalue) VALUES ("mail.sender","xxxxx");
INSERT INTO config(configname, configvalue) VALUES ("mail.password","XXXXXX");
INSERT INTO config(configname, configvalue) VALUES ("mail.smtp.starttls.enable","true");
INSERT INTO config(configname, configvalue) VALUES ("mail.smtp.port","587");


*** Create table states and insert list of states there
CREATE TABLE states (
    statename VARCHAR(255)
);

INSERT INTO states (statename) VALUES
('Alabama'),
('Alaska'),
('Arizona'),
('Arkansas'),
('California'),
('Colorado'),
('Connecticut'),
('Delaware'),
('Florida'),
('Georgia'),
('Hawaii'),
('Idaho'),
('Illinois'),
('Indiana'),
('Iowa'),
('Kansas'),
('Kentucky'),
('Louisiana'),
('Maine'),
('Maryland'),
('Massachusetts'),
('Michigan'),
('Minnesota'),
('Mississippi'),
('Missouri'),
('Montana'),
('Nebraska'),
('Nevada'),
('New Hampshire'),
('New Jersey'),
('New Mexico'),
('New York'),
('North Carolina'),
('North Dakota'),
('Ohio'),
('Oklahoma'),
('Oregon'),
('Pennsylvania'),
('Rhode Island'),
('South Carolina'),
('South Dakota'),
('Tennessee'),
('Texas'),
('Utah'),
('Vermont'),
('Virginia'),
('Washington'),
('West Virginia'),
('Wisconsin'),
('Wyoming');
------------------------













 ");

INSERT INTO configinfo (configName, configValue) VALUES ("videodir","d:/tools/tomcat10/webapps/v/videos");

INSERT INTO configinfo (configName, configValue) VALUES ("audiodir","d:/tools/tomcat10/webapps/v/audios");

INSERT INTO configinfo (configName, configValue) VALUES ("filedir","d:/tools/tomcat10/webapps/v/files");

INSERT INTO configinfo (configName, configValue) VALUES ("profilepath","d:/tools/tomcat10/webapps/v/profilepath");

INSERT INTO configinfo (configName, configValue) VALUES ("serverlog","d:/tools/tomcat10/webapps/serverlog");

INSERT INTO configinfo (configName, configValue) VALUES ("defaultChannelIconPath","resources/images/defaultChannelIcon.png");

INSERT INTO configinfo (configName, configValue) VALUES ("ffmpeg","d:/tools/ffmpeg/bin/ffmpeg.exe");

INSERT INTO configinfo (configName, configValue) VALUES ("ffprobe","d:/tools/ffmpeg/bin/ffprobe.exe");

INSERT INTO configinfo (configName, configValue) VALUES ("mail.transport.protocol","smtp");

INSERT INTO configinfo (configName, configValue) VALUES ("mail.smtp.host","outlook.office365.com");

INSERT INTO configinfo (configName, configValue) VALUES ("mail.smtp.auth","true");
INSERT INTO configinfo (configName, configValue) VALUES ("mail.sender","info@inrik.com");
INSERT INTO configinfo (configName, configValue) VALUES ("mail.password","InEwts4354SDerik");
INSERT INTO configinfo (configName, configValue) VALUES ("mail.smtp.starttls.enable","true");
INSERT INTO configinfo (configName, configValue) VALUES ("mail.smtp.port","587");


*** Create table states and insert list of states there
CREATE TABLE states (
    statename VARCHAR(255)
);

INSERT INTO states (statename) VALUES
('Alabama'),
('Alaska'),
('Arizona'),
('Arkansas'),
('California'),
('Colorado'),
('Connecticut'),
('Delaware'),
('Florida'),
('Georgia'),
('Hawaii'),
('Idaho'),
('Illinois'),
('Indiana'),
('Iowa'),
('Kansas'),
('Kentucky'),
('Louisiana'),
('Maine'),
('Maryland'),
('Massachusetts'),
('Michigan'),
('Minnesota'),
('Mississippi'),
('Missouri'),
('Montana'),
('Nebraska'),
('Nevada'),
('New Hampshire'),
('New Jersey'),
('New Mexico'),
('New York'),
('North Carolina'),
('North Dakota'),
('Ohio'),
('Oklahoma'),
('Oregon'),
('Pennsylvania'),
('Rhode Island'),
('South Carolina'),
('South Dakota'),
('Tennessee'),
('Texas'),
('Utah'),
('Vermont'),
('Virginia'),
('Washington'),
('West Virginia'),
('Wisconsin'),
('Wyoming');
------------------------













 