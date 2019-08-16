
DROP TABLE PROJECTIMG;
DROP TABLE PROJECTSKILL;
DROP TABLE PROJECT;
DROP TABLE USERSKILL;
DROP TABLE SKILL;
DROP TABLE SKILLCLS;
DROP TABLE USERAUTH;
DROP TABLE USER;
DROP TABLE AUTHORITY;

CREATE TABLE USER
(
   USER_ID         VARCHAR(20),
   USER_MAIL       VARCHAR(20),
   USER_PASS       VARCHAR(500),
   USER_NM         VARCHAR(10),
   USER_ENGNM      VARCHAR(30),
   USER_BIRTH      VARCHAR(10),
   USER_TEL        VARCHAR(20),
   USER_ADD        VARCHAR(50),
   USER_DTL        VARCHAR(2000),
   USER_GITURL     VARCHAR(200),
   USER_BLOGURL    VARCHAR(200),
   PRIMARY KEY(USER_ID)
);

CREATE TABLE AUTHORITY
(
   AUTH_ID      VARCHAR(10),
   AUTH_NAME    VARCHAR(20),
   PRIMARY KEY(AUTH_ID)
);

CREATE TABLE USERAUTH
(
   USER_ID    VARCHAR(20),
   AUTH_ID      VARCHAR(10),
   PRIMARY KEY(USER_ID, AUTH_ID),
   FOREIGN KEY(USER_ID) REFERENCES USER (USER_ID),
   FOREIGN KEY(AUTH_ID) REFERENCES AUTHORITY (AUTH_ID)
);

CREATE TABLE SKILLCLS
(
   SKILL_CLS_NO    CHAR(1),
   SKILL_CLS_NM    VARCHAR(20),
   PRIMARY KEY(SKILL_CLS_NO)
);


CREATE TABLE SKILL
(
   SKILL_NO        VARCHAR(5),
   SKILL_NM        VARCHAR(30),
   SKILL_CLS_NO    CHAR(1),
   SKILL_IMG       VARCHAR(20),
   PRIMARY KEY(SKILL_NO),
   FOREIGN KEY(SKILL_CLS_NO) REFERENCES SKILLCLS (SKILL_CLS_NO)
);

CREATE TABLE USERSKILL
(
   USER_ID    VARCHAR(20),
   SKILL_NO     VARCHAR(5),
   SKILL_LEV    CHAR(1),
   PRIMARY KEY(USER_ID, SKILL_NO),
   FOREIGN KEY(USER_ID) REFERENCES USER (USER_ID),
   FOREIGN KEY(SKILL_NO) REFERENCES SKILL (SKILL_NO)
);

CREATE TABLE PROJECT
(
   PROJ_NO       VARCHAR(5),
   PROJ_TITLE	 VARCHAR(50),
   PROJ_SUBCON   VARCHAR(200),
   PROJ_CON      VARCHAR(2000),
   PROJ_START    DATE,
   PROJ_END      DATE,
   PROJ_DATE     DATE,
   PROJ_GIT		 VARCHAR(50),
   PRIMARY KEY(PROJ_NO)
);

CREATE TABLE PROJECTSKILL
(
   PROJ_NO     VARCHAR(5),
   SKILL_NO    VARCHAR(5),
   PRIMARY KEY(PROJ_NO, SKILL_NO),
   FOREIGN KEY(PROJ_NO) REFERENCES PROJECT (PROJ_NO),
   FOREIGN KEY(SKILL_NO) REFERENCES SKILL (SKILL_NO)
);

CREATE TABLE PROJECTIMG
(
   PROJ_IMG_NO      VARCHAR(5),
   PROJ_NO          VARCHAR(5),
   PROJ_IMG_NM      VARCHAR(50),
   PROJ_IMG_TITLE   VARCHAR(40),
   PROJ_IMG_SAV     VARCHAR(100),
   PROJ_IMG_TYPE    VARCHAR(10),
   PROJ_IMG_SIZE    MEDIUMINT,
   PROJ_IMG_DATE    DATE,
   PRIMARY KEY(PROJ_IMG_NO),
   FOREIGN KEY(PROJ_NO) REFERENCES PROJECT (PROJ_NO)
);

INSERT INTO user(USER_ID,
				 USER_MAIL,
                 USER_PASS,
                 USER_NM,
                 USER_ENGNM,
                 USER_BIRTH,
                 USER_TEL,
                 USER_ADD,
                 USER_DTL,
                 USER_GITURL,
                 USER_BLOGURL)
        VALUES ('dhaudgkr',
        		'dhaudgkr@gmail.com',
                '{bcrypt}$2a$10$C4VlMVhEsWqCqCh7pgfdFuadHshB/cv6pdv4AejhvaDphYr70w4JK',
                '오명학',
                'Oh MyeongHak',
                '1993.10.06',
                '010-4807-9310',
                '경기도 평택시 WW로 XXX, YYY동 ZZZ호',
                '안녕하세요. 코딩국가대표 오명학입니다. 잘부탁드립니다.',
                'https://github.com/dh37789',
                'https://www.notion.so/dh37789/Code-Note-19ded0b9506948f5a733bac65142d5fd');
                
INSERT INTO authority VALUES('1', 'ADMIN');                

INSERT INTO userauth VALUES('dhaudgkr', '1');

INSERT INTO skillcls VALUES('1', 'Language');
INSERT INTO skillcls VALUES('2', 'Framework');
INSERT INTO skillcls VALUES('3', 'Database');
INSERT INTO skillcls VALUES('4', 'Version Control');

INSERT INTO skill VALUES('1', 'Java', '1', 'java.png');
INSERT INTO skill VALUES('2', 'HTML5', '1', 'html5.png');
INSERT INTO skill VALUES('3', 'CSS3', '1', 'css3.png');
INSERT INTO skill VALUES('4', 'Javascript', '1', 'javascript.png');
INSERT INTO skill VALUES('5', 'Spring Framework', '2', 'springFramework.png');
INSERT INTO skill VALUES('6', 'Spring Boot', '2', 'boot.png');
INSERT INTO skill VALUES('7', 'Vue.js', '2', 'vue.png');
INSERT INTO skill VALUES('8', 'Node.Js', '2', 'nodejs.png');
INSERT INTO skill VALUES('9', 'Oracle', '3', 'oracle.png');
INSERT INTO skill VALUES('10', 'MariaDB', '3', 'maria.png');
INSERT INTO skill VALUES('11', 'GitHub', '4', 'github.png');
INSERT INTO skill VALUES('12', 'SVN', '4', 'svn.png');

INSERT INTO userskill VALUES('dhaudgkr', '1', '2');
INSERT INTO userskill VALUES('dhaudgkr', '2', '3');
INSERT INTO userskill VALUES('dhaudgkr', '3', '3');
INSERT INTO userskill VALUES('dhaudgkr', '4', '2');
INSERT INTO userskill VALUES('dhaudgkr', '5', '2');
INSERT INTO userskill VALUES('dhaudgkr', '6', '2');
INSERT INTO userskill VALUES('dhaudgkr', '7', '2');
INSERT INTO userskill VALUES('dhaudgkr', '8', '1');
INSERT INTO userskill VALUES('dhaudgkr', '9', '2');
INSERT INTO userskill VALUES('dhaudgkr', '10', '2');
INSERT INTO userskill VALUES('dhaudgkr', '11', '2');
INSERT INTO userskill VALUES('dhaudgkr', '12', '2');

INSERT INTO PROJECT VALUES('PR001',
			 			   'JavaFx 메모장', 
			 			   'JavaFx를 이용해 간단한 메모장을 만들어 보았습니다.', 
			 			   'JavaFx를 이용해 간단한 메모장을 만들어 보았습니다. 자바1.8과 JavaFX GUI를 이용해 간단한 메모장을 만들어 보았습니다.', 
			 			   '2019-04-03', 
			 			   '2019-04-05', 
			 			   NOW(), 
			 			   'https://www.naver.com');

INSERT INTO PROJECT VALUES('PR002',
			 			   '시각장애인을 위한 화장도우미', 
			 			   'JavaFx를 이용해 간단한 메모장을 만들어 보았습니다.', 
			 			   'JavaFx를 이용해 간단한 메모장을 만들어 보았습니다. 자바1.8과 JavaFX GUI를 이용해 간단한 메모장을 만들어 보았습니다.', 
			 			   '2019-04-03', 
			 			   '2019-04-05', 
			 			   NOW(), 
			 			   'https://www.naver.com');

INSERT INTO PROJECT VALUES('PR003',
			 			   '프리랜서 프로젝트 계약사이트',
			 			   '프리랜서 프로젝트 계약사이트를 만들어 보았습니다.',
			 			   'Spring Framework를 이용해 프리랜서 프로젝트 계약사이트를 만들어 보았습니다. 자바1.8과 JavaFX GUI를 이용해 간단한 메모장을 만들어 보았습니다.',
			 			   '2019-02-13',
			 			   '2019-03-27',
			 			   NOW(),
			 			   'https://www.naver.com');

INSERT INTO PROJECT VALUES('PR004',
			 			   '포트폴리오',
			 			   'Rest api + Vue를 이용한 포트폴리오 사이트',
			 			   'Spring Framework를 이용해 프리랜서 프로젝트 계약사이트를 만들어 보았습니다. 자바1.8과 JavaFX GUI를 이용해 간단한 메모장을 만들어 보았습니다.',
			 			   '2019-07-25',
			 			   '2019-08-31',
			 			   NOW(),
			 			   'https://www.naver.com');
COMMIT;