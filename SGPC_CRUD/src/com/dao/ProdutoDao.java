package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Produto;

/**
 * CLASSE RESPONSÁVEL NA MANIPULAÇÃO DOS DADOS NO SGBD {@LINK MANIPULADADOS}
 **/
public class ProdutoDao implements ManipulaDados<Produto> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	/***
	 * METODO SALVA OS DADOS DO PRODUTO NO SGBD
	 * 
	 * @param produto
	 */
	@Override
	public void adiciona(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO produto(nome," + " descricao," + " quantidade," + "obs)" + "VALUES(?, ?, ?, ?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getQnt());
			ps.setString(4, produto.getObs());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out
					.println("Erro ao salvar o produto : " + e.getMessage() + "\n" + "Causa do erro :" + e.getCause());
		} finally {
			conexao.close();
		}

	}

	/***
	 * METODO ATUALIZA OS DADOS DO PRODUTO NO SGBD
	 * 
	 * @param produto
	 */
	@Override
	public void update(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE  produto SET" + " nome=?," + " descricao=?," + " quantidade =?," + " obs =?"
					+ " WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getQnt());
			ps.setString(4, produto.getObs());
			ps.setInt(5, produto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro não foi possivel atualizar o produto : " + e.getMessage());
		} finally {
			conexao.close();
		}

	}

	/***
	 * METODO REMOVE OS DADOS DO PRODUTO NO SGBD
	 * 
	 * @param cliente
	 */
	@Override
	public void remove(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM produto WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, produto.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o produto: " + "\n" + e.getMessage() + "\n");
		} finally {
			conexao.close();
		}

	}

	/***
	 * METODO LISTA OS DADOS DO PRODUTO SALVO NO SGBD
	 * 
	 * @return
	 */
	@Override
	public List<Produto> getAll() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select * from produto";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQnt(rs.getInt("quantidade"));
				produto.setObs(rs.getString("obs"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println(
					"Erro ao pesquisa lista produto, com descricao do produto " + "\n" + e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}

	/***
	 * METODO BUSCA OS DADOS DO PRODUTO SALVO NO SGBD POR ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Produto getId(int id) throws Exception {
		Produto produto = null;
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM produto WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQnt(rs.getInt("quantidade"));
				produto.setObs(rs.getString("obs"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisa produto " + "\n" + e.getMessage());
		} finally {
			conexao.close();
		}
		return produto;
	}

}
