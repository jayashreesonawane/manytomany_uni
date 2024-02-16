package manytomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni.dto.Course;
import manytomany_uni.dto.Student;

public class StudentMain {

	public static void main(String[] args) {

		Course course = new Course();
		course.setId(101);
		course.setName("Java");
		course.setFees(10000);
		course.setDuration(2);

		Course course2 = new Course();
		course2.setId(102);
		course2.setName("SQL");
		course2.setFees(6000);
		course2.setDuration(2);

		Course course3 = new Course();
		course3.setId(103);
		course3.setName("Frameworks");
		course3.setFees(20000);
		course3.setDuration(2);

		Student student = new Student();
		student.setId(1);
		student.setName("Jayashree");
		student.setAddress("Nashik");
		student.setPhone(1234567890l);

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Manisha");
		student2.setAddress("Pune");
		student2.setPhone(9876543210l);

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Aakanksha");
		student3.setAddress("Nagpur");
		student3.setPhone(6549873210l);

		List<Course> list1 = new ArrayList<Course>();
		list1.add(course);
		list1.add(course2);
		student.setCourses(list1);

		List<Course> list2 = new ArrayList<Course>();
		list2.addAll(list1);
		list2.add(course3);
		student.setCourses(list2);

		List<Course> list3 = new ArrayList<Course>();
		list3.add(course2);
		list3.add(course3);
		student.setCourses(list3);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(course);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityManager.persist(student);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityTransaction.commit();

	}
}
