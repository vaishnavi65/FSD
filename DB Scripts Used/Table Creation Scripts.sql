/*
--creating database
*/
CREATE DATABASE dbo; 
use dbo;
/*
--creating projecttable
*/
-- drop table project
CREATE TABLE IF NOT EXISTS project (
    project_id INT AUTO_INCREMENT,
    project VARCHAR(500) NOT NULL,
    start_date DATE,
    end_date DATE,
    priority TINYINT NOT NULL,
    status TINYINT NOT NULL,
    PRIMARY KEY (project_id)
) ;

/*
--creating parent_tasktable
*/
-- drop table parent_task
CREATE TABLE IF NOT EXISTS parent_task (
    parent_id INT,
    parent_task VARCHAR(500) NOT NULL,
    PRIMARY KEY (parent_id)
) ;
/*
--creating tasktable
*/
 -- drop table task
CREATE TABLE IF NOT EXISTS task (
    task_id INT AUTO_INCREMENT,
    parent_id INT,
    project_id INT NOT NULL,
    task VARCHAR(500) NOT NULL,
    start_date DATE,
    end_date DATE,
    priority TINYINT NOT NULL,
    status TINYINT NOT NULL,
    PRIMARY KEY (task_id)
) ;
/*
--creating userstable
*/
	
   -- drop table users
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    employee_id INT UNIQUE NOT NULL,
    project_id INT NOT NULL,
    task_id INT NOT NULL,
    PRIMARY KEY (user_id)
) ;
