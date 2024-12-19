package org.example.wakandaforever;

import java.sql.*;

public class Database {

    private static Connection connection;

    public static void suppressSQLiteErrors(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA busy_timeout = 1000"); // Configure un délai d'attente
            stmt.execute("PRAGMA synchronous = OFF");   // Désactive certaines vérifications
        }
    }

    public static Connection getConnection(String url) throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url);

            try (Statement stmt = connection.createStatement()) {
                stmt.execute("PRAGMA journal_mode=WAL;");
            }
        }
        suppressSQLiteErrors(connection);
        return connection;
    }

    public static void initDatabase(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS dia (id INT, vibranium BIGINT, energie BIGINT, habitant INT, nivel INT, ladron INT)");
        }
    }

    public static void printDia(int id) {
        String sqlSelect = "SELECT * FROM dia WHERE id = ?";

        try (Connection conn = Database.getConnection(Main.URL)) {

            try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                selectStmt.setInt(1, id);
                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()) {
                    int num = rs.getInt("id");
                    long vibranium = rs.getLong("vibranium");
                    long energie = rs.getLong("energie");
                    int habitant = rs.getInt("habitant");
                    int nivel = rs.getInt("nivel");
                    int ladron = rs.getInt("ladron");
                    System.out.println("En el dia " + num + " huvo :\nVibranium : "+vibranium+"\nEnergia : "+energie+"\nHabitantes : "+habitant+"\nNivel : "+nivel+"\nLadron : "+ladron+"");
                } else {
                    System.out.println("No hay dia con este ID !");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al recoger los datos del dia : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void clearTable() {
        String sqlDelete = "DELETE FROM dia";

        try (PreparedStatement stmt = getConnection(Main.URL).prepareStatement(sqlDelete)) {
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Todo borrado : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error al borrar la tabla : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void InsertDia(int id, long vibranium, long energie, int habitant, int nivel, int ladron) {
        try {
            String sql = "INSERT INTO dia (id, vibranium, energie, habitant, nivel, ladron) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = Database.getConnection(Main.URL); // Utilisation de Main.URL
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.setLong(2, vibranium);
                stmt.setLong(3, energie);
                stmt.setInt(4, habitant);
                stmt.setInt(5, nivel);
                stmt.setInt(6, ladron);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}