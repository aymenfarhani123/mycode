package com.example.demo;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.domain.Produit;
import com.example.repository.ProduitDao;

public class TestProduit {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		ProduitDao produitDao=(ProduitDao) context.getBean("produitDAO");
		Produit produit=new Produit(1,"Spring with JdbcTemplate");
		Produit produit2=new Produit(2,"Clean code");
		produitDao.insert(produit);
		produitDao.insert(produit2);
		Produit produitInDataBase=produitDao.findById(1);
		out.println(produitInDataBase);
		List<Produit> produits=produitDao.findAll();
		produits.stream().forEach(out::println);
		String produitName=produitDao.findNameById(2);
		out.println(produitName);
		
		Produit produit3=new Produit(10,"Spring Framework");
		Produit produit4=new Produit(11,"Mysql DataBase");
		List<Produit> batchList=new ArrayList<Produit>();
		batchList.add(produit3);
		batchList.add(produit4);
		produitDao.insertBatchProduits(batchList);
		out.println("insert batch produits "+batchList);
		
		produitDao.insertBatchUpdate("update produit set name='spring with jpa'");
		}

}
