package sistemalogin.trabalhofinal.dao;

import java.sql.*;
public class DB {
    private static final String URL = "jdbc:sqlite:TrabalhoFinal/src/main/java/sistemalogin/trabalhofinal/resources/LoginDB";

    public static void createTablesIfNotExists() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                // Criar tabela Usuario
                String createUsuarioTable = "CREATE TABLE IF NOT EXISTS Usuario (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT NOT NULL, " +
                        "senha TEXT NOT NULL, " +
                        "notificacoesLidas INTEGER DEFAULT 0, " +
                        "notificacoesRecebidas INTEGER DEFAULT 0, " +
                        "tipo TEXT NOT NULL, " +
                        "aprovado BOOLEAN NOT NULL, " +
                        "criacaoData TEXT NOT NULL" +
                        ");";

                // Criar tabela Mensagens
                String createMensagensTable = "CREATE TABLE IF NOT EXISTS Mensagens (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "usuarioId INTEGER NOT NULL, " +
                        "mensagem TEXT NOT NULL, " +
                        "Lida BOOLEAN NOT NULL, " +
                        "FOREIGN KEY (usuarioId) REFERENCES Usuario (id)" +
                        ");";

                try (Statement stmt = conn.createStatement()) {
                    // Executar comandos para criar as tabelas
                    stmt.execute(createUsuarioTable);
                    stmt.execute(createMensagensTable);
                    System.out.println("Tabelas criadas com sucesso ou já existem.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }

    public static void main() {
        createTablesIfNotExists();
    }

}
