package DAO;

import DTO.ClienteDTO;
import VIEW.TelaCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void inserirUsuario(ClienteDTO objClienteDTO) {
        String sql = "insert into tb_Cliente(nome_cliente, cpf_cliente, telefone_cliente, email_cliente)"
                + "values (?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objClienteDTO.getNome_cliente());
            pst.setString(2, objClienteDTO.getCpf_cliente());
            pst.setString(3, objClienteDTO.getFone_cliente());
            pst.setString(4, objClienteDTO.getEmail_cliente());
            int add = pst.executeUpdate();
            if (add > 0) {
                pesquisarAuto();

                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "método Inserir" + e);
        }
    }

    public void pesquisar(ClienteDTO objClienteDTO) {
        String sql = "select * from tb_cliente where id_cliente =?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId_cliente());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaCliente.txtNome.setText(rs.getString(2));
                TelaCliente.txtTelefone.setText(rs.getString(3));
                TelaCliente.txtEmail.setText(rs.getString(4));
                TelaCliente.txtCPF.setText(rs.getString(5));

                conexao.close();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario nao cadastrado!");
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Pesquisar" + e);

        }
    }

    public void editar(ClienteDTO objClienteDTO) {
        String sql = "update tb_cliente set nome_cliente = ?, telefone_cliente = ?, email_cliente = ?, cpf_cliente = ?"
                + " where id_cliente = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, objClienteDTO.getId_cliente());
            pst.setString(1, objClienteDTO.getNome_cliente());
            pst.setString(2, objClienteDTO.getFone_cliente());
            pst.setString(3, objClienteDTO.getEmail_cliente());
            pst.setString(4, objClienteDTO.getCpf_cliente());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Cliente editado editado com sucesso!");
                pesquisarAuto();
                conexao.close();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    public void pesquisarAuto() {
        String sql = "select * from tb_cliente";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaCliente.TbCliente.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome_cliente");
                String telefone = rs.getString("telefone_cliente");
                String email = rs.getString("email_cliente");
                String cpf = rs.getString("cpf_cliente");
                model.addRow(new Object[]{id, nome, telefone, email, cpf});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e.getMessage());
        }
    }

    public void excluir(ClienteDTO objClienteDTO) {
        String sql = "delete from tb_cliente where id_cliente = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId_cliente());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Cliente deletado com sucesso!");
                pesquisarAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        TelaCliente.txtCPF.setText(null);
        TelaCliente.txtTelefone.setText(null);
        TelaCliente.txtNome.setText(null);
        TelaCliente.txtEmail.setText(null);

    }

}
