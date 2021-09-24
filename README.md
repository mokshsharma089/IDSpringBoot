# IDSpringBoot
Practice project for SpringBoot based on Enterprise Pattern

## Includes Features such as 
1. Validation in Controller Layer.
2. Validation in Service Layer(Mostly Used).
3. Global Controller Error handling using @RestControllerAdvice and @ExceptionHandler.
4. Usage of H2(inbuit memory) database.

## H2 Script for Data Manipulation

insert into identity_card values('999999999999','XYZ Puram New Delhi-38','ABC',9599895998);  
insert into identity_card values('111111111111','GHJ House UIO Ganj New Delhi-02','DEF',8535995998);  
insert into identity_card values('222222222222','GHJ House UIO Nagar New Delhi-32','GHI',7811595998);  
insert into identity_card values('333333333333','C-7/45 Keshav Puram New Delhi-110035','JKL',9984995998);  

select * from identity_card;  

delete from identity_card;  

## Rest Endpoints
1. POST - localhost:3000/id/vc/create - ```json
  {
    "idNumber":"675477343800",
    "name":"Jeill singh",
    "address":"90-D New Road, Seattle, USA-89645",
    "phoneNo":"4589458921"
}```
2. POST - localhost:3000/id/vs/create - ```json
  {
    "idNumber":"974520642044",
    "name":"Bill Gates",
    "address":"90-D New Road, Seattle, USA-89645",
    "phoneNo":"4589458921"
}```
3. GET - localhost:3000/id/974520442044 
4. GET - localhost:3000/id/name/Bill
5. GET - localhost:3000/id/phone/8585912788
6. PUT - localhost:3000/id/update/ - ```json
  {
    "idNumber":"974520442044",
    "address":"90-B Old Road, Toronto, Canada-3489645"
}```
7. DELETE- localhost:3000/id/delete/974520442044
