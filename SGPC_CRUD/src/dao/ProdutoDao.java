package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

/**
 * Classe responsável na manipulação dos dados no SGBD {@link ManipulaDados}
 **/
public class ProdutoDao implements ManipulaDados<Produto> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	/**
	 * Método para salvar os dados no SGBD 
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

	/**
	 * Método para atualizar os dados no SGBD 
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

	/**
	 * Método para remover os dados no SGBD 
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

	/**
	 * Método para listar os dados salvo no SGBD 
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

	/**
	 * Método para buscar os dados pelo ID salvo no SGBD 
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
