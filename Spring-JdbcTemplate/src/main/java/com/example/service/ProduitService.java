package com.example.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.domain.Produit;
import com.example.repository.ProduitDao;
import com.example.support.ProduitRowMapper;

public class ProduitService implements ProduitDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Produit p) {
		String insertQuery="insert into produit (id, name) values(?,?)";
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(insertQuery,new Object[] {p.getId(),p.getName()});
	}

	@Override
	public Produit findById(int id) {
		String selectQuery="select * from Produit where id=?";
		jdbcTemplate=new JdbcTemplate(dataSource);
		Produit produit=(Produit) jdbcTemplate.queryForObject(selectQuery,new Object[] {id}, new ProduitRowMapper());
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		jdbcTemplate=new JdbcTemplate(dataSource);
		String selectAllQuery="select * from produit";
		List<Produit> produits=jdbcTemplate.query(selectAllQuery,new ProduitRowMapper());
		return produits;
	}

	@Override
	public String findNameById(int id) {
		jdbcTemplate=new JdbcTemplate(dataSource);
		String findNameQuery="select name from produit where id=?";
		String produitName=jdbcTemplate.queryForObject(findNameQuery,new Object[] {id},String.class);
		return produitName;
	}

	@Override
	public void insertBatchProduits(List<Produit> produits) {
		jdbcTemplate=new JdbcTemplate(dataSource);
		String batchinsertQuery="insert into produit (id, name) values (?,?)";
		jdbcTemplate.batchUpdate(batchinsertQuery,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Produit produit=produits.get(i);
				ps.setInt(1,produit.getId());
				ps.setString(2, produit.getName());
			}
			
			@Override
			public int getBatchSize() {
				return produits.size();
			}
		});

	}

	@Override
	public void insertBatchUpdate(String sql) {
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(new String[] {sql});
	}

}
