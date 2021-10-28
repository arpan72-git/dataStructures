*****************************************DEFECT  TRACKER***************************************************************

This project contains 3 microservices :
1. User Registration Microservice : This MS lets the user to register and login to the defect tracker portal.
    	                     i) register user : http://localhost:3333/register     - POST request
			eg:     {
			                "userId": "arpan563",
				"password": "Angel1234",
				"name": "Arpan Agrawal",
				"email": "agrawal.arpan46@gmail.com",
				"address": "Andhra Pradesh",
				"phoneNo": 1234567890 ,
				"userRole": "Developer"
			          }		
	
		   ii) login user      : http://localhost:3333/login           - POST request
			eg : {
			            "userId": "arpan4",
		            	            "password": "Angel1234"
 		   	       } 

2. Defects Microservice : This MS lets the user to :
                                        i) add new defects :    http://localhost:3333/adddefect    -  POST request
			eg: {
			          "productName": "product name ",
			          "yearOfPurchase": 2017	,
		   	          "description": "description ",
		                           "priority": 5,
	                                            "date": "2019-02-02",
	  	                           "userId": "arpan4"
}
                                       ii) update the status of the defects : http://localhost:3333/update/{defectid}/{status}  - PUT request
			eg: http://localhost:3333/update/11/open
                                      iii) view defects via defectid/userid : http://localhost:3333/view/defects/{defectid}    - GET request
					             http://localhost:3333/view/{userid}  - GET request
			eg:  http://localhost:3333/view/defects/11
			       http://localhost:3333/view/arpan2 

3. User Profile Microservice  : This MS lets the user to view the user profile(user details + defect details for this user)
		                http://localhost:3333/viewuser/{userid}   - GET request
			eg : http://localhost:3333/viewuser/arpan4

Note : All the validations errors are displayed on console.

***************************************************************************************************************************
