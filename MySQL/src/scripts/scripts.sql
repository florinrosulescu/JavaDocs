CREATE TABLE LOCATIONS (
  LOCATION_ID INT(8) AUTO_INCREMENT PRIMARY KEY,
  STREET_ADDRESS VARCHAR(12),
  POSTAL_CODE VARCHAR(12),
  CITY VARCHAR(30) NOT NULL ,
  STATE_PROVINCE VARCHAR(25)
);

CREATE TABLE DEPARTMENTS(
  DEPARTMENT_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  DEPARTMENT_NAME VARCHAR(30) NOT NULL ,
  LOCATION_ID INT(8)
);


CREATE TABLE JOBS(
  JOB_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  JOB_TITLE VARCHAR(35) NOT NULL ,
  MIN_SALARY INT(6),
  MAX_SALARY INT(6)
);


CREATE TABLE EMPLOYEES(
  EMPLOYEE_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  FIRST_NAME VARCHAR(20),
  LAST_NAME VARCHAR(25) NOT NULL ,
  EMAIL VARCHAR(25) NOT NULL ,
  PHONE_NUMBER VARCHAR(20),
  HIRE_DATE DATE,
  JOB_ID INT(10),
  SALARY DECIMAL(8,2),
  COMISSION_PCT DECIMAL(2,2),
  MANAGER_ID INT(8),
  DEPARTMENT_ID INT(8)
);




ALTER TABLE  employees add FOREIGN KEY (MANAGER_ID)
  REFERENCES  employees(EMPLOYEE_ID);

ALTER TABLE employees ADD FOREIGN KEY(JOB_ID)
  REFERENCES jobs(JOB_ID);

ALTER TABLE employees ADD FOREIGN KEY (DEPARTMENT_ID)
  REFERENCES departments(DEPARTMENT_ID);

ALTER TABLE departments ADD FOREIGN KEY (LOCATION_ID)
  REFERENCES locations(LOCATION_ID);




INSERT INTO departments VALUES (
  1,
  'Administration',
  1700
);

INSERT INTO locations VALUES (
  1700,
  'STRADA',
  1234,
  'BUCURESTI',
  'SECTOR1'
);

INSERT INTO jobs VALUES (
  1,
  'President',
  20000,
  40000
);

INSERT INTO employees VALUES (
  1,
  'Steven',
  'King',
  'SKING',
  '515.123.4567',
  NOW(),
  '1',
  24000,
  NULL,
  NULL,
  1
);


ALTER  TABLE employees
    DROP FOREIGN KEY employees_ibfk_1




ALTER TABLE jobs MODIFY JOB_ID VARCHAR(10);


ALTER TABLE employees MODIFY JOB_ID VARCHAR(10);


ALTER TABLE employees ADD FOREIGN KEY(JOB_ID)
REFERENCES jobs(JOB_ID);


ALTER TABLE locations MODIFY STREET_ADDRESS VARCHAR(50)

-- Locations
INSERT INTO locations VALUES
  ( 1000
    , '1297 Via Cola di Rie'
    , '00989'
    , 'Roma'
    , NULL
  );

INSERT INTO locations VALUES
  ( 1100
    , '93091 Calle della Testa'
    , '10934'
    , 'Venice'
    , NULL
  );

INSERT INTO locations VALUES
  ( 1200
    , '2017 Shinjuku-ku'
    , '1689'
    , 'Tokyo'
    , 'Tokyo Prefecture'
  );

INSERT INTO locations VALUES
  ( 1300
    , '9450 Kamiya-cho'
    , '6823'
    , 'Hiroshima'
    , NULL
  );

INSERT INTO locations VALUES
  ( 1400
    , '2014 Jabberwocky Rd'
    , '26192'
    , 'Southlake'
    , 'Texas'
  );

INSERT INTO locations VALUES
  ( 1500
    , '2011 Interiors Blvd'
    , '99236'
    , 'South San Francisco'
    , 'California'
  );

INSERT INTO locations VALUES
  ( 1600
    , '2007 Zagora St'
    , '50090'
    , 'South Brunswick'
    , 'New Jersey'
  );

INSERT INTO locations VALUES
  ( 1700
    , '2004 Charade Rd'
    , '98199'
    , 'Seattle'
    , 'Washington'
  );

INSERT INTO locations VALUES
  ( 1800
    , '147 Spadina Ave'
    , 'M5V 2L7'
    , 'Toronto'
    , 'Ontario'
  );

INSERT INTO locations VALUES
  ( 1900
    , '6092 Boxwood St'
    , 'YSW 9T2'
    , 'Whitehorse'
    , 'Yukon'
  );

INSERT INTO locations VALUES
  ( 2000
    , '40-5-12 Laogianggen'
    , '190518'
    , 'Beijing'
    , NULL
  );

INSERT INTO locations VALUES
  ( 2100
    , '1298 Vileparle (E)'
    , '490231'
    , 'Bombay'
    , 'Maharashtra'
  );

INSERT INTO locations VALUES
  ( 2200
    , '12-98 Victoria Street'
    , '2901'
    , 'Sydney'
    , 'New South Wales'
  );

INSERT INTO locations VALUES
  ( 2300
    , '198 Clementi North'
    , '540198'
    , 'Singapore'
    , NULL
  );

INSERT INTO locations VALUES
  ( 2400
    , '8204 Arthur St'
    , NULL
    , 'London'
    , NULL
  );

INSERT INTO locations VALUES
  ( 2500
    , 'Magdalen Centre, The Oxford Science Park'
    , 'OX9 9ZB'
    , 'Oxford'
    , 'Oxford'
  );

INSERT INTO locations VALUES
  ( 2600
    , '9702 Chester Road'
    , '09629850293'
    , 'Stretford'
    , 'Manchester'
  );

INSERT INTO locations VALUES
  ( 2700
    , 'Schwanthalerstr. 7031'
    , '80925'
    , 'Munich'
    , 'Bavaria'
  );

INSERT INTO locations VALUES
  ( 2800
    , 'Rua Frei Caneca 1360 '
    , '01307-002'
    , 'Sao Paulo'
    , 'Sao Paulo'
  );

INSERT INTO locations VALUES
  ( 2900
    , '20 Rue des Corps-Saints'
    , '1730'
    , 'Geneva'
    , 'Geneve'
  );

INSERT INTO locations VALUES
  ( 3000
    , 'Murtenstrasse 921'
    , '3095'
    , 'Bern'
    , 'BE'
  );

INSERT INTO locations VALUES
  ( 3100
    , 'Pieter Breughelstraat 837'
    , '3029SK'
    , 'Utrecht'
    , 'Utrecht'
  );

INSERT INTO locations VALUES
  ( 3200
    , 'Mariano Escobedo 9991'
    , '11932'
    , 'Mexico City'
    , 'Distrito Federal,'
  );

--PENTRU VALUES -- REPLACE
--dd-MM-yyyy WITH %d-%m-%Y
--TO_DATE STR_TO_DATE
-- DIN AL DOILEA FISIER