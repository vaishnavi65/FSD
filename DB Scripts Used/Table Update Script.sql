/*project table*/
insert into project values(1, 'Project1',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,'Completed');
insert into project values(2, 'Project2',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,'In Progress');
insert into project values(3, 'Project3',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,'In progress');
select * from project;
delete from project
/*Parent_task*/
insert into parent_task values (1,'parent_task_1');
insert into parent_task values (2,'parent_task_2');
insert into parent_task values (3,'parent_task_3');
select * from parent_task;
drop table parent_task;
/*task*/
insert into task values(1,1,1,'Task1','2019-06-15','2019-06-24',1,'In Progress');
insert into task values(2,2,2,'Task2','2019-06-15','2019-06-24',1,'In Progress');
insert into task values(3,3,3,'Task3','2019-06-15','2019-06-24',1,'Completed');

select count(*) from task where project_id=1

select count(*) from task where project_id=1 and (end_date<=curdate() or status='Completed')


/*users*/
insert into users values(29,'lara','Hydon',1,6,8);
insert into users values(2,'Ram','Sharma',2,2,2);
insert into users values(3,'Mike','Cook',3,3,3);
select * from users;
delete from users
select * from (select * from users where employee_id is not null group by employee_id)a order by a.first_name;

select * from users where project_id=3

delete from users




