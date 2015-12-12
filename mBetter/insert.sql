Insert into USER_DATA (ID,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD) values (1,'admin@test.com','admin','test','admin');
Insert into USER_DATA (ID,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD) values (2,'doctor@testl.com','doctor','test','doctor');

Insert into MENU_MASTER (MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,MENU_INDEX,MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE) values (1,null,null,1,0,1,'Manage',null,null,null,null);
Insert into MENU_MASTER (MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,MENU_INDEX,MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE) values (2,null,null,1,0,2,'menu1',null,null,null,null);
Insert into MENU_MASTER (MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,MENU_INDEX,MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE) values (3,null,null,1,0,3,'menu2',null,null,null,null);
Insert into MENU_MASTER (MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,MENU_INDEX,MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE) values (4,null,null,1,1,4,'menu3',null,null,null,null);


Insert into SUB_MENU_MASTER (SUB_MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,SUB_MENU_INDEX,SUB_MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE,PARENT_SUB_MENU_ID,MENU_ID) values (1,null,null,1,1,1,'User Roles',null,null,null,'manageRoles',null,1);
Insert into SUB_MENU_MASTER (SUB_MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,SUB_MENU_INDEX,SUB_MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE,PARENT_SUB_MENU_ID,MENU_ID) values (2,null,null,1,1,1,'menu1submenu1',null,null,null,'#',null,2);
Insert into SUB_MENU_MASTER (SUB_MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,SUB_MENU_INDEX,SUB_MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE,PARENT_SUB_MENU_ID,MENU_ID) values (3,null,null,1,1,2,'menu1submenu2',null,null,null,'#',null,2);
Insert into SUB_MENU_MASTER (SUB_MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,SUB_MENU_INDEX,SUB_MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE,PARENT_SUB_MENU_ID,MENU_ID) values (5,null,null,1,1,1,'menu2subsubmen1',null,null,null,'#',null,3);
Insert into SUB_MENU_MASTER (SUB_MENU_ID,INSERT_DATE,INSERT_ID,ACTIVE,IS_PAGE_REDIRECT,SUB_MENU_INDEX,SUB_MENU_NAME,MODIFY_BY,MODIFY_DATE,MODIFY_ID,REDIRECT_PAGE,PARENT_SUB_MENU_ID,MENU_ID) values (6,null,null,1,1,2,'menu2submenu2',null,null,null,'#',null,3);

Insert into ROLE_MASTER (ROLE_ID,INSERT_DATE,INSERT_ID,ACTIVE,MENU_ID,MENU_INDEX,MODIFY_BY,MODIFY_DATE,MODIFY_ID,OPTIONS,SUB_MENU_ID,SUB_MENU_INDEX,USER_ROLE) values (1,null,null,1,1,1,null,null,null,'add,view,delete',1,1,'admin');

insert into GENMST_DROPDOWN values(null,1,"On Roll","employeeType","1",null,null,'y',null,null,null,null,null);
insert into GENMST_DROPDOWN values(null,1,"Probation","employeeType","2",null,null,'y',null,null,null,null,null);
insert into GENMST_DROPDOWN values(null,1,"Permanent","employeeType","3",null,null,'y',null,null,null,null,null);
insert into GENMST_DROPDOWN values(null,1,"Inactive","employeeType","4",null,null,'n',null,null,null,null,null);
insert into GENMST_department values(1,'1','OPD',null,null,'y',null,null,null,null,null,1);
insert into GENMST_department values(2,'1','ENT',null,null,'y',null,null,null,null,null,1);
insert into GENMST_department values(3,'1','Physician',null,null,'y',null,null,null,null,null,1);
insert into GENMST_department values(4,'1','Allergy',null,null,'y',null,null,null,null,null,1);
insert into GENMST_sub_department values(null,'1',1,null,null,'y',null,null,null,null,null,'Diabeties',1);
insert into GENMST_sub_department values(null,'1',1,null,null,'y',null,null,null,null,null,'Fever',1);
insert into GENMST_sub_department values(null,'1',1,null,null,'y',null,null,null,null,null,'Cold',1);
insert into GENMST_sub_department values(null,'1',1,null,null,'y',null,null,null,null,null,'Aches',1);
insert into GENMST_sub_department values(null,'1',2,null,null,'y',null,null,null,null,null,'Ear Ache',1);
insert into GENMST_sub_department values(null,'1',2,null,null,'y',null,null,null,null,null,'Throat Ache',1);
insert into GENMST_sub_department values(null,'1',2,null,null,'y',null,null,null,null,null,'Nose Problem',1);
insert into GENMST_sub_department values(null,'1',3,null,null,'y',null,null,null,null,null,'TB',1);
insert into GENMST_sub_department values(null,'1',3,null,null,'y',null,null,null,null,null,'Malaria',1);
insert into GENMST_sub_department values(null,'1',4,null,null,'y',null,null,null,null,null,'Itching',1);

