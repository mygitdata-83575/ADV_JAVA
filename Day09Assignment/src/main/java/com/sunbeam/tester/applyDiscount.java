package com.sunbeam.tester;

import org.hibernate.SessionFactory;


import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;


import java.util.Scanner;

public class applyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)){
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter discount category and amount  ");
			System.out.println(dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()), sc.nextDouble()));
			//String msg=dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()),sc.nextDouble());
	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
