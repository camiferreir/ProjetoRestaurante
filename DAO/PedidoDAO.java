package DAO;

import DTO.PedidoDTO;
import VIEW.TelaPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camille
 */
public class PedidoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void inserirPedido(PedidoDTO objPedidoDTO) {
        String sql = "INSERT INTO tb_pedidos (id_cliente, id_mesa, total_pedido, status_pedido) "
                + "VALUES (?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId_cliente());
            pst.setInt(2, objPedidoDTO.getId_mesa());
            pst.setDouble(3, objPedidoDTO.getTotal());
            pst.setString(4, objPedidoDTO.getStatus());

            int add = pst.executeUpdate();
            if (add > 0) {
                pesquisarAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Pedido inserido com sucesso!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Método Inserir Pedido: " + e);
        }
    }

    public void pesquisar(PedidoDTO objPedidoDTO) {
        String sql = "SELECT * FROM tb_pedidos WHERE id_pedido = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId_pedido());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaPedido.txtId_Cliente.setText(rs.getString("id_cliente"));
                TelaPedido.txtId_Mesa.setText(rs.getString("id_mesa"));
                TelaPedido.txtTotal.setText(rs.getString("total_pedido"));
                TelaPedido.txtStatus.setText(rs.getString("status_pedido"));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Pesquisar Pedido: " + e);
        }
    }

    public void editar(PedidoDTO objPedidoDTO) {
        String sql = "UPDATE tb_pedidos SET id_cliente = ?, id_mesa = ?, total_pedido = ?, status_pedido = ?"
                + " WHERE id_pedido = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId_cliente());
            pst.setInt(2, objPedidoDTO.getId_mesa());
            pst.setDouble(3, objPedidoDTO.getTotal());
            pst.setString(4, objPedidoDTO.getStatus());
            pst.setInt(5, objPedidoDTO.getId_pedido());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Pedido editado com sucesso!");
                pesquisarAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar Pedido: " + e);
        }
    }

    public void excluir(PedidoDTO objPedidoDTO) {
        String sql = "DELETE FROM tb_pedidos WHERE id_pedido = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId_pedido());

            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Pedido excluído com sucesso!");
                pesquisarAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Excluir Pedido: " + e);
        }
    }

    public void pesquisarAuto() {
        String sql = "SELECT * FROM tb_pedidos";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaPedido.TbPedidos.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_pedido");
                int idCliente = rs.getInt("id_cliente");
                int idMesa = rs.getInt("id_mesa");
                double total = rs.getDouble("total_pedido");
                String status = rs.getString("status_pedido");

                model.addRow(new Object[]{id, idCliente, idMesa, total, status});
            }

            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Pesquisar Automático Pedido: " + e.getMessage());
        }
    }

    public void limparCampos() {
        TelaPedido.txtId_Pedido.setText(null);
        TelaPedido.txtId_Cliente.setText(null);
        TelaPedido.txtId_Mesa.setText(null);
        TelaPedido.txtTotal.setText(null);
        TelaPedido.txtStatus.setText(null);
    }
}
