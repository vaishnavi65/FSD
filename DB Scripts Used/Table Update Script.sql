/*project table*/
insert into project values(1, 'Project1',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,1);
insert into project values(2, 'Project2',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,1);
insert into project values(3, 'Project3',STR_TO_DATE('15-06-2019', '%d-%m-%Y'),STR_TO_DATE('24-06-2019', '%d-%m-%Y'),5,1);
select * from project;
/*Parent_task*/
insert into parent_task values (1,'parent_task_1');
insert into parent_task values (2,'parent_task_2');
insert into parent_task values (3,'parent_task_3');
select * from parent_task;
/*task*/
insert into task values(1,1,1,'Task1','2019-06-15','2019-06-24',1,1);
insert into task values(2,2,2,'Task2','2019-06-15','2019-06-24',1,1);
insert into task values(3,3,3,'Task3','2019-06-15','2019-06-24',1,1);
select * from task;
/*users*/
insert into users values(1,'lara','Hydon',1,1,1);
insert into users values(2,'Ram','Sharma',2,2,2);
insert into users values(3,'Mike','Cook',3,3,3);
select * from users;

delete from users




