CREATE DATABASE EmployeePortal;

USE employeeportal;

CREATE  TABLE employee (
	code INT AUTO_INCREMENT NOT NULL ,
	first_name VARCHAR(100) NOT NULL ,
	middle_name  VARCHAR(100) NULL ,
	last_name  VARCHAR(100) NULL ,
	dob  DATE NOT NULL ,
	gender  VARCHAR(45) NULL ,
	email  VARCHAR(45) NOT NULL UNIQUE,
	contact  VARCHAR(45) NULL ,
	skype_id  VARCHAR(45) NULL ,
	profile_picture  VARCHAR(100) NULL ,
	password  VARCHAR(100) NOT NULL DEFAULT '12345',
	enabled  VARCHAR(45) NOT NULL DEFAULT 'true' ,
    skills VARCHAR(20) NOT NULL,
	PRIMARY KEY ( code ));
  
  
CREATE  TABLE  job_title (
	job_code  INT NOT NULL auto_increment,
	job_title  VARCHAR(100) NOT NULL ,
	PRIMARY KEY ( job_code ));
 
 
CREATE  TABLE  user_roles (
	user_role_id  INT NOT NULL AUTO_INCREMENT ,
	username  VARCHAR(100) NOT NULL ,
	role  VARCHAR(100) NOT NULL ,
	PRIMARY KEY ( user_role_id ));
  
  
CREATE  TABLE  skill_master (
	skill_id  INT NOT NULL AUTO_INCREMENT ,
	skill_name  VARCHAR(100) NOT NULL ,
	PRIMARY KEY ( skill_id ));
  
  
  
CREATE  TABLE  employee_skills (
	employee_skill_id  INT NOT NULL PRIMARY KEY,
	employee_code  INT NOT NULL ,
	skill_code  INT NOT NULL ,
	FOREIGN KEY (employee_code) REFERENCES employee(code) ON DELETE CASCADE,
	FOREIGN KEY (skill_code) REFERENCES skill_master(skill_id) ON DELETE CASCADE);
  
 
CREATE  TABLE  project_master (
	project_id  INT NOT NULL AUTO_INCREMENT ,
	name VARCHAR(30) NOT NULL,
	description  VARCHAR(45) NOT NULL ,
	start_date  DATE NOT NULL ,
	end_date  DATE NULL ,
	project_logo  VARCHAR(45) NULL ,
	PRIMARY KEY ( project_id ) );
	  
  
CREATE  TABLE  address (
	address_id  INT NOT NULL AUTO_INCREMENT ,
	employee_code  INT NOT NULL ,
	street  VARCHAR(45) NOT NULL ,
	address_line  VARCHAR(45) NULL ,
	city  VARCHAR(45) NOT NULL ,
	state  VARCHAR(45) NOT NULL ,
	pincode  VARCHAR(45) NOT NULL ,
	PRIMARY KEY ( address_id ) ,
	FOREIGN KEY(employee_code) REFERENCES employee(code) ON DELETE CASCADE);
   
   
CREATE  TABLE  job_details (
	job_detail_id  INT AUTO_INCREMENT PRIMARY KEY ,
	employee_code  INT NOT NULL ,
	date_of_joining  DATE NOT NULL ,
	total_experience  INT NOT NULL ,
	job_code  INT NOT NULL ,
	reporting_manager  INT NOT NULL,
	team_lead  INT NOT NULL,
	current_project_id  INT,
	FOREIGN KEY (employee_code) REFERENCES employee(code) ON DELETE CASCADE ,
	FOREIGN KEY (job_code) REFERENCES job_title(job_code) ON DELETE CASCADE ,
	FOREIGN KEY (reporting_manager) REFERENCES employee(code) ON DELETE CASCADE ,
	FOREIGN KEY (team_lead) REFERENCES employee(code) ON DELETE CASCADE ,
	FOREIGN KEY (current_project_id) REFERENCES project_master(project_id) ON DELETE CASCADE);