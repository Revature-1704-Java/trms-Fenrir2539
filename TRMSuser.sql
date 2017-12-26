conn Admin/starpoo88

CREATE USER trms 
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to trms;
GRANT resource to trms;
GRANT create session TO trms;
GRANT create table TO trms;
GRANT create view TO trms;



CREATE TABLE EMPLOYEE
(
   EmployeeID NUMBER NOT NULL,
   FirstName VARCHAR2(40) NOT NULL,
   LastName VARCHAR2(40) NOT NULL,
   EmployeeTypeID NUMBER NOT NULL,
   DepartmentID NUMBER NOT NULL,
   ReportsTo NUMBER,
   CONSTRAINT PK_EmployeeID PRIMARY KEY  (EmployeeID),
   CONSTRAINT FK_ReportsTo FOREIGN KEY (ReportsTo) REFERENCES EMPLOYEE(EmployeeID)
);

CREATE TABLE EMPLOYEE_TYPE
(
   EmployeeTypeID NUMBER NOT NULL,
   EmployeeType VARCHAR2(40) NOT NULL,
   CONSTRAINT PK_EmployeeTypeID PRIMARY KEY  (EmployeeTypeID)
);

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_EmployeeTypeID
   FOREIGN KEY (EmployeeTypeID)
   REFERENCES EMPLOYEE_TYPE (EmployeeTypeID);
   
CREATE TABLE DEPARTMENT
(
   DepartmentID NUMBER NOT NULL,
   DepartmentName VARCHAR2(40) NOT NULL,
   CONSTRAINT PK_DepartmentID PRIMARY KEY  (DepartmentID)
);

--
ALTER TABLE DEPARTMENT
    ADD Department_Head NUMBER;

ALTER TABLE DEPARTMENT
ADD CONSTRAINT FK_Emp_Dept_Head
   FOREIGN KEY (Department_Head)
   REFERENCES EMPLOYEE (EmployeeID);
--

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_DepartmentID
   FOREIGN KEY (DepartmentID)
   REFERENCES DEPARTMENT (DepartmentID);
   
CREATE TABLE LOGIN
(
   EmployeeID NUMBER NOT NULL,
   UserName VARCHAR2(40) NOT NULL,
   PWord VARCHAR2(40) NOT NULL,
   CONSTRAINT PK_Login PRIMARY KEY  (EmployeeID),
   CONSTRAINT FK_Login FOREIGN KEY (EmployeeID) REFERENCES EMPLOYEE(EmployeeID)
);

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_Employee_Login
   FOREIGN KEY (EmployeeID)
   REFERENCES LOGIN (EmployeeID);
   
CREATE TABLE EMPLOYEE_REIM_FUNDS
(
   EmployeeID NUMBER NOT NULL,
   AmountAvailable NUMBER(6,2),
   AmountPending NUMBER(6,2),
   AmountAwarded NUMBER(6,2),
   CONSTRAINT PK_EMployee_Reim_Funds PRIMARY KEY  (EmployeeID)
);

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_Employee_Reim_Funds
   FOREIGN KEY (EmployeeID)
   REFERENCES EMPLOYEE_REIM_FUNDS (EmployeeID);

CREATE TABLE REIMBURSEMENT
(
   ReimID NUMBER NOT NULL,
   EmployeeID NUMBER NOT NULL,
   EventDate DATE,
   EventID NUMBER,
   GradeID NUMBER,
   PassingGrade VARCHAR2(40),
   Employee_Cost NUMBER(6,2),
   Reim_Amount NUMBER(6,2),
   Reim_Location VARCHAR2(100),
   Reim_Description VARCHAR2(100),
   Work_hours_Missed NUMBER,
   Status VARCHAR2(40),
   CONSTRAINT PK_Reim PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Reim_Employee FOREIGN KEY (EmployeeID) REFERENCES EMPLOYEE(EmployeeID)
);

/* NOT WORKING WHYYYYYYYYYYY
ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_Employee_Reim
   FOREIGN KEY (EmployeeID)
   REFERENCES REIMBURSEMENT (EmployeeID);
*/

CREATE TABLE EVENT
(
   EventID NUMBER NOT NULL,
   Event_Type VARCHAR2(40),
   Reim_Percent NUMBER,
   CONSTRAINT PK_Event PRIMARY KEY  (EventID)
);

CREATE TABLE GRADE
(
   GradeID NUMBER NOT NULL,
   Grade_Type VARCHAR2(40),
   CONSTRAINT PK_Grade PRIMARY KEY  (GradeID)
);

CREATE TABLE GRADE_APPROVAL
(
   ReimID NUMBER NOT NULL,
   Supervisor_Approval NUMBER,
   BenCo_Approval NUMBER,
   CONSTRAINT PK_Grade_Reim PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Grade_Reim FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT FK_Reim_Grade
   FOREIGN KEY (ReimID)
   REFERENCES GRADE_APPROVAL (ReimID);
   
CREATE TABLE APPROVAL
(
   ReimID NUMBER NOT NULL,
   Supervisor_Approval NUMBER,
   DepartmentHead_Approval NUMBER,
   BenCo_Approval NUMBER,
   CONSTRAINT PK_Approval PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Approval_Reim FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT FK_Reim_Approval
   FOREIGN KEY (ReimID)
   REFERENCES APPROVAL (ReimID);

CREATE TABLE REIM_INFO_REQUEST
(
   ReimID NUMBER NOT NULL,
   Supervisor_Notes VARCHAR2(2000),
   DepartmentHead_Notes VARCHAR2(2000),
   BenCo_Notes VARCHAR2(2000),
   Employee_Notes VARCHAR2(4000),
   CONSTRAINT PK_Reim_Info PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Reim_Info FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT FK_Info_Reim
   FOREIGN KEY (ReimID)
   REFERENCES REIM_INFO_REQUEST (ReimID);
   
CREATE TABLE REIM_JUSTIFICATION
(
   ReimID NUMBER NOT NULL,
   Work_Just VARCHAR2(1000),
   Deny_Just VARCHAR2(1000),
   Exceed_Just VARCHAR2(1000),
   CONSTRAINT PK_Reim_Just PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Reim_Just FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT FK_Just_Reim
   FOREIGN KEY (ReimID)
   REFERENCES REIM_JUSTIFICATION (ReimID);
   
CREATE TABLE REIM_DATES
(
   ReimID NUMBER NOT NULL,
   Date_Create DATE,
   Created_Time TIMESTAMP,
   Last_Update_Date DATE,
   CONSTRAINT PK_Reim_Date PRIMARY KEY  (ReimID),
   CONSTRAINT FK_Reim_Date FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT FK_Date_Reim
   FOREIGN KEY (ReimID)
   REFERENCES REIM_DATES (ReimID);
   
CREATE TABLE REIM_FILE
(
   FileID NUMBER NOT NULL,
   ReimID NUMBER NOT NULL,
   File_Desc VARCHAR2(60),
   File_Path VARCHAR2(1000),
   Last_Update_Date DATE,
   CONSTRAINT PK_Reim_File PRIMARY KEY  (FileID),
   CONSTRAINT FK_Reim_File FOREIGN KEY (ReimID) REFERENCES REIMBURSEMENT(ReimID)
);

--Employee PKSequence and Trigger
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    SELECT SQ_EMPLOYEE_PK.NEXTVAL
    INTO :NEW.EmployeeID FROM DUAL;
END;
/

--Reim PKSequence and Trigger
CREATE SEQUENCE SQ_REIM_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_REIM
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
    SELECT SQ_REIM_PK.NEXTVAL
    INTO :NEW.ReimID FROM DUAL;
END;
/

--EmployeeType PKSeq & Trigger
CREATE SEQUENCE SQ_EMPTYPE_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_EMP_TYPE
BEFORE INSERT ON EMPLOYEE_TYPE
FOR EACH ROW
BEGIN
    SELECT SQ_EMPTYPE_PK.NEXTVAL
    INTO :NEW.EmployeeTypeID FROM DUAL;
END;
/

--Department PKSeq & Trigger
CREATE SEQUENCE SQ_DEPT_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_DEPT
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
    SELECT SQ_DEPT_PK.NEXTVAL
    INTO :NEW.DepartmentID FROM DUAL;
END;
/

--Event
CREATE SEQUENCE SQ_EVENT_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_EVENT
BEFORE INSERT ON EVENT
FOR EACH ROW
BEGIN
    SELECT SQ_EVENT_PK.NEXTVAL
    INTO :NEW.EventID FROM DUAL;
END;
/

--Grade
CREATE SEQUENCE SQ_GRADE_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_GRADE
BEFORE INSERT ON GRADE
FOR EACH ROW
BEGIN
    SELECT SQ_GRADE_PK.NEXTVAL
    INTO :NEW.GradeID FROM DUAL;
END;
/
--File
CREATE SEQUENCE SQ_FILE_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_FILE
BEFORE INSERT ON REIM_FILE
FOR EACH ROW
BEGIN
    SELECT SQ_FILE_PK.NEXTVAL
    INTO :NEW.FileID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER INSERT_REIM_DATE BEFORE INSERT ON REIM_DATES
FOR EACH ROW
BEGIN
    :NEW.Date_Create := SYSDATE;
    :NEW.Created_Time := SYSTIMESTAMP;
    :NEW.Last_Update_Date := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER UPDATE_REIM_DATE AFTER UPDATE ON APPROVAL
FOR EACH ROW
BEGIN
    UPDATE REIM_DATES
    SET Last_Update_Date = SYSDATE;
END;
/




