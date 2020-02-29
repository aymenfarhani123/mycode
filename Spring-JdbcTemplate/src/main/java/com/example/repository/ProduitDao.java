package com.example.repository;

import java.util.List;

import com.example.domain.Produit;

public interface ProduitDao {
	
	public void insert(Produit p);
	public Produit findById(int id);
	public List<Produit> findAll();
	public String findNameById(int id);
	public void insertBatchProduits(List<Produit> produits);
	public void insertBatchUpdate(String sql);

}
