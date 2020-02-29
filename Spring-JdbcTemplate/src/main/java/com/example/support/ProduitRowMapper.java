package com.example.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.domain.Produit;

public class ProduitRowMapper implements RowMapper<Produit> {

	@Override
	public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produit produit=new Produit();
		produit.setId(rs.getInt("id"));
		produit.setName(rs.getString("name"));
		return produit;
	}

}
