package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	public void adiciona(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "insert into cliente (nome,sobrenome,cpf,data_nascimento,localidade)values (?,?,?,?,?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getDataNascimento());
			ps.setString(5, cliente.getLocalidade());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out
					.println("Erro ao salvar o cliente : " + e.getMessage() + "\n" + "Causa do erro :" + e.getCause());
		} finally {
			conexao.close();
		}
	}

	public void update(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
						
			String sql = "update cliente set nome=?, sobrenome=?, cpf=?, data_nascimento=?, localidade=? where id=?";
			
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getDataNascimento());
			ps.setString(5, cliente.getLocalidade());
			ps.setInt(6, cliente.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro não foi possivel atualizar o cliente : " + e.getMessage());
		} finally {
			conexao.close();
		}
	}

	public void remove(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM cliente WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cliente.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o cliente: " + "\n" + e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
	}

	
	public List<Cliente> getAll() throws Exception {
		List<Cliente> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select * from cliente";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setLocalidade(rs.getString("localidade"));
				lista.add(cliente);
			}
		} catch (Exception e) {
			System.out.println(
					"Erro ao pesquisa lista cliente, com descricao do cliente " + "\n" + e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}

	public Cliente getId(int id) throws Exception {
		Cliente cliente = null;
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM cliente WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setLocalidade(rs.getString("localidade"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisa cliente" + "\n" + e.getMessage());
		} finally {
			conexao.close();
		}
		return cliente;
	}
}
