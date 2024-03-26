package dao;

import connections.ConnectionFactory;
import model.entities.Servico;
import model.entities.ServicoConta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoContaDAO {

    private final Connection myConnection;

    public ServicoContaDAO() throws ClassNotFoundException, SQLException {
        this.myConnection = new ConnectionFactory().getConnection();
    }

    public void insert(ServicoConta servicoConta) throws SQLException {

        PreparedStatement stmt = myConnection.prepareStatement(
                "INSERT INTO tb_servico_conta (id_servico, id_conta, status, data_inicio) values ( ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))"
        );

        stmt.setInt(1, servicoConta.getId_Servico());
        stmt.setInt(2, servicoConta.getId_Conta());
        stmt.setString(3, servicoConta.getStatus());
        stmt.setString(4, servicoConta.getDataInicio());

        stmt.execute();
        stmt.close();

    }

    public List<Servico> getMyServices(int idConta) throws SQLException, ClassNotFoundException {
        ServicoDAO servicoDAO = new ServicoDAO();
        PreparedStatement stmt = myConnection.prepareStatement(
                "SELECT * FROM tb_servico_conta WHERE id_conta = ?"
        );
        stmt.setInt(1, idConta);

        ResultSet rs = stmt.executeQuery();

        List<Servico> servicos = new ArrayList<>();

        try{

            while (rs.next()){
                rs.getInt("id_servico");
                servicos.add(servicoDAO.findById(rs.getInt("id_servico")));
            }

        } finally {
            stmt.close();
            rs.close();
        }

        return servicos;
    }
}
