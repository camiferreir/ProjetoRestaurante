package DAO;

import DTO.CardapioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CardapioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void CadastrarPrato(CardapioDTO objCardapioDTO) {
        String sql = "INSERT INTO tb_cardapio (id_prato, nome_prato, descricao, preco, categoria) VALUES (?, ?, ?, ?, ?)";
        Connection conexao = ConexaoDAO.conector();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, objCardapioDTO.getId_prato());
            pst.setString(2, objCardapioDTO.getNome_prato());
            pst.setString(3, objCardapioDTO.getDescricao());
            pst.setDouble(4, objCardapioDTO.getPreco());
            pst.setString(5, objCardapioDTO.getCategoria());

            int add = pst.executeUpdate();

            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Prato cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método CadastrarPrato: " + e.getMessage());
        }
    }

    public void AlterarCardapio(CardapioDTO objCardapioDTO) {
        String sql = "UPDATE tb_cardapio SET nome_prato = ?, descricao = ?, preco = ?, categoria = ? WHERE id_prato = ?";
        Connection conexao = ConexaoDAO.conector();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, objCardapioDTO.getNome_prato());
            pst.setString(2, objCardapioDTO.getDescricao());
            pst.setDouble(3, objCardapioDTO.getPreco());
            pst.setString(4, objCardapioDTO.getCategoria());
            pst.setInt(5, objCardapioDTO.getId_prato());

            int add = pst.executeUpdate();

            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Prato alterado com sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método AlterarCardapio: " + e.getMessage());
        }
    }

    public void ExcluirCardapio(CardapioDTO objCardapioDTO) {
        String sql = "delete from tb_cardapio where id_prato = ?";
        Connection conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objCardapioDTO.getId_prato());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Usuário deletado com sucesso!");

                conexao.close();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }
}
