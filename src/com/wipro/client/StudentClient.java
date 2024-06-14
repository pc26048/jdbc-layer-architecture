package com.wipro.client;


import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.Scanner;

import com.wipro.model.Student;
import com.wipro.service.StudentService;
import com.wipro.service.StudentServiceImpl;

public class StudentClient {
	
	private static final Logger logger=Logger.getLogger(StudentClient.class.getName());

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		StudentService ss=new StudentServiceImpl();
		
		
		
		
//		ss.addStudent(new Student(101,"Rajesh","Pune","rajesh@gmail.com"));
//		ss.addStudent(new Student(102,"Aman","Mumbai","aman@gmail.com"));
//		ss.addStudent(new Student(103,"Praveen","Kanpur","praveen@gmail.com"));
//		ss.addStudent(new Student(104,"Alok","Lucknow","alok@gmail.com"));
		
		
		ss.getAllStudents().stream().forEach(s->System.out.println(s));
		logger.info("Data inserted successfully...");
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			logger.info("\n"+"1. Insert Student :"+"\n"+"2. Update  Student :"+"\n"+"3. Delete Student : "+"\n"+"4. View All Student :"+"\n"+"5. View a Student : "+"\n"+"6. Exit : ");

			
			logger.info("Enter Your Choice (1..6) :");
			int choice =sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			
				case 1:
					
					logger.info("Enter the student Id: ");
					int studentId=sc.nextInt();
					sc.nextLine();
					logger.info("Enter the student name: ");
					String studentname=sc.next();
					logger.info("Enter the Address: ");
					String studentaddress=sc.next();
					logger.info("Enter the email: ");
					String studentemail=sc.next();
					Student s1=new Student();
					s1.setId(studentId);
					s1.setName(studentname);
					s1.setAddress(studentaddress);
					s1.setEmail(studentemail);
					ss.addStudent(s1);
					
					logger.info("Student inserted successfully...");
					logger.info("Students list:-------------------");
					ss.getAllStudents().forEach(s->System.out.println(s));
					break;
					
				case 2:
					logger.info("Enter the student id to update: ");
					int stuId=sc.nextInt();
					sc.nextLine();
					logger.info("Enter new name: ");
					String name=sc.next();
					logger.info("Enter new address: ");
					String address=sc.next();
					logger.info("Enter new email");
					String email=sc.next();
					
					Student s=new Student();
					s.setId(stuId);
					s.setName(name);
					s.setAddress(address);
					s.setEmail(email);
					ss.updateStudent(stuId, s);
					logger.info("Student updated successfully...");
					
				
					logger.info("Students list:------------------");
					
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
				
				case 3:
					logger.info("Enter the student id to be deleted: ");
					int deleteId=sc.nextInt();
					ss.deleteStudent(deleteId);
					
					logger.info("Students list:-----------------------");
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
				
				case 4:
					logger.info("Students list:------------------------");
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
					
				case 5:
					
					logger.info("Enter the student id to be view: ");
					int proId=sc.nextInt();
					Student student=ss.getStudent(proId);
					logger.info(student.toString());
					break;
				case 6:
					
					logger.info("Exiting.....");
					
					sc.close();
					return;
				default:
					logger.info("Invalid choice. Try again!");
					
				
			}
		}
		
		
		

	}

}
