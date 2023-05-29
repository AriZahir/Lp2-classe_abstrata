package trabalhoAriana;

import java.sql.SQLException;
import java.sql.DriverManager; 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Informações do banco de dados
    private static final String dbURL = "jdbc:mysql://localhost:3306/LP2";
    private static final String username = "root";
    private static final String password = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Estabelecer conexão com o banco de dados
            conn = (Connection) DriverManager.getConnection(dbURL, username, passaword);
            statement = conn.createStatement();

            Scanner scanner = new Scanner(System.in);

            // Exibir opções para o usuário
            System.out.println("Selecione uma opção:");
            System.out.println("1. Inserir registro");
            System.out.println("2. Atualizar registro");
            System.out.println("3. Excluir registro");
            System.out.println("4. Consultar registros");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Inserir registro
                    System.out.println("Digite o ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o endereço:");
                    String endereco = scanner.nextLine();

                    System.out.println("Digite o telefone:");
                    String telefone = scanner.nextLine();

                    System.out.println("Digite o tipo (Cliente ou Materia):");
                    String tipo = scanner.nextLine();

                    String insertQuery = "INSERT INTO tabela_transportadora (id, nome, endereco, telefone, tipo) VALUES (" + id + ", '" + nome + "', '" + endereco + "', '" + telefone + "', '" + tipo + "')";
                    statement.executeUpdate(insertQuery);

                    System.out.println("Registro inserido com sucesso!");
                    break;
                case 2:
                    // Atualizar registro
                    System.out.println("Digite o ID do registro a ser atualizado:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();

                    String updateQuery = "UPDATE tabela_transportadora SET nome = '" + novoNome + "' WHERE id = " + idToUpdate;
                    statement.executeUpdate(updateQuery);

                    System.out.println("Registro atualizado com sucesso!");
                    break;
                case 3:
                    // Excluir registro
                    System.out.println("Digite o ID do registro a ser excluído:");
                    int idToDelete = scanner.nextInt();

                    String deleteQuery = "DELETE FROM tabela_transportadora WHERE id = " + idToDelete;
                    statement.executeUpdate(deleteQuery);

                    System.out.println("Registro excluído com sucesso!");
                    break;
                case 4:
                    // Consultar registros
                    String selectQuery = "SELECT * FROM tabela_transportadora";
                    resultSet = statement.executeQuery(selectQuery);

                    while (resultSet.next()) {
                        int idConsulta = resultSet.getInt("id");
                        String nomeConsulta = resultSet.getString("nome");
                        String enderecoConsulta = resultSet.getString("endereco");
                        String telefoneConsulta = resultSet.getString("telefone");
                        String tipoConsulta = resultSet.getString("tipo");

                        System.out.println("ID: " + idConsulta + ", Nome: " + nomeConsulta + ", Endereço: " + enderecoConsulta + ", Telefone: " + telefoneConsulta + ", Tipo: " + tipoConsulta);
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (SQLException  e) {
            System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
        
        }

