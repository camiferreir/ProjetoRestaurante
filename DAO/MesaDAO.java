package DAO;

import DTO.MesaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MesaDAO {

    public void CadastrarMesa(MesaDTO objMesaDTO) {
        String sql = "insert into tb_mesa (id_mesa, numero_mesa, status_mesa)"
                + " VALUES (?, ?, ?)";
        Connection conexao = ConexaoDAO.conector();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, objMesaDTO.getId_Mesa());
            pst.setInt(2, objMesaDTO.getNumero_mesa());
            pst.setString(3, objMesaDTO.getStatus_mesa());

            int add = pst.executeUpdate();

            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Mesa cadastrada com sucesso!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método cadastrarMesa: " + e.getMessage());
        }
    }

    public void AlterarMesa(MesaDTO objMesaDTO) {
        String sql = "update tb_mesa set numero_mesa = ?, status_mesa = ? WHERE id_mesa = ?";
        Connection conexao = ConexaoDAO.conector();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, objMesaDTO.getNumero_mesa());
            pst.setString(2, objMesaDTO.getStatus_mesa());
            pst.setInt(3, objMesaDTO.getId_Mesa());

            int atualizou = pst.executeUpdate();

            if (atualizou > 0) {
                JOptionPane.showMessageDialog(null, "Mesa alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Mesa não encontrada!");
            }

            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar mesa: " + e.getMessage());
        }
    }

    public void ExcluirMesa(MesaDTO objMesaDTO) {
        String sql = "delete from tb_mesa where id_mesa = ?";
        Connection conexao = ConexaoDAO.conector();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, objMesaDTO.getId_Mesa());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Mesa deletada com sucesso!");
                conexao.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }
}