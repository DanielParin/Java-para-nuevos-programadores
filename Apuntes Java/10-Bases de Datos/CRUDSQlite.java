//Necesario hacer un proyecto maven para importar las dependencias (poo.xml).

import java.sql.*;

class CRUDSQlite {

    // Vamos a crear 2 variables una la conexión y otra el path a la Base de Datos.

    private Connection connection;
    private final String databasePath = "jdbc:sqlite:coches.db";
    // Jdbc: -> Es lo que nos permite acceder a los sistemas de gestión de BBDD.
    // sqlite: -> El tipo de base de datos que tenemos (sql,mariadb,mongodb...).
    // coches.db -> Ruta donde está nuestra base de datos.

    public CRUDSQlite() {

        try {
            connection = DriverManager.getConnection(databasePath); // Nos conectamos a la base de datos.
            createTable(); // Creamos la tabla.
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    /*
     * Antes de empezar con las sentencias vamos a distinguir entre los dos tipos de
     * statement.
     * 
     * Statement -> Se usa para sentencias sql donde no tenemos que pasar
     * parámetros.
     * PreparedStatement -> Se usa para sentencias sql donde hay que pasar
     * parámetros.
     */

    private void createTable() {

        // Ponemos la sentencia para crear la tabla si no existe.
        // Podemos usar """....""" o "....\n" + "....\n" para construir la sentencia.

        String sql = """
                CREATE TABLE IF NOT EXISTS Coche(
                  matricula TEXT PRIMARY KEY,
                  marca TEXT,
                  modelo TEXT,
                  fMatriculacion DATE
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql); // Ejecutamos la sentencia(statement) pasándole el string de sql.
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insertCoche(String matricula, String marca, String modelo, String fMatriculacion) {
        // Ponemos la sentencia para insertar.

        String sql = "INSERT INTO Coche(matricula, marca, modelo, fMatriculacion) VALUES(?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Ahora tenemos que decir que valores hay que pasarle a las ? de la sentencia
            // sql.

            preparedStatement.setString(1, matricula); // La ? número uno del string sql (matricula) tomará el valor de
                                                       // el argumento matricula.
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setString(4, fMatriculacion);
            preparedStatement.executeUpdate(); // Ejecutamos los cambios.

        } catch (SQLException e) {
            System.err.println("Error al insertar un coche: " + e.getMessage());
        }
    }

    public void actualizarCoche(String matricula, String nuevaMarca, String nuevoModelo, String nuevafMatriculacion) {

        // Ponemos la sentencia para actualizar un coche.
        String sql = "UPDATE Coche SET marca=?, modelo=?, fMatriculacion=? WHERE matricula=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nuevaMarca);
            preparedStatement.setString(2, nuevoModelo);
            preparedStatement.setString(3, nuevafMatriculacion);
            preparedStatement.setString(4, matricula);

            // Vamos a comprobar si se ha actualizado bien.

            int filasAfectadas = preparedStatement.executeUpdate(); // Nos devolverá las filas afectadas por nuestra
                                                                    // sentencia.

            if (filasAfectadas > 0) {
                // Si se han afectado más de 0 filas es que la consulta se ha realizado bien.
                System.out.println("Se ha actualizado correctamente.");
            } else {
                // Por el contrario si no se afecta nada, es porque no había ningún coche con la
                // matrícula introducida.
                System.err.println("No se encontró ningún coche con esa matricula.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar coche: " + e.getMessage());
        }
    }

    public void eliminarCoche(String matricula) {

        String sql = "DELETE FROM Coche WHERE matricula=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, matricula);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se ha eliminado el coche correctamente.");
            } else {
                System.err.println("No se ha encontrado ningún coche con esa matrícula.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar coche: " + e.getMessage());
        }
    }

    public void mostrarCoches() {

        String sql = "SELECT * FROM Coche";

        // Para mostrar los coches necesitamos los resultados, por ello primero creamos
        // el statement, y luego
        // asociamos los resultados a la ejecución de la sentencia sql.

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            // Mientras que haya resultados, los imprimimos.
            while (resultSet.next()) {
                System.out.println("*****************************************************");// No necesario, es para
                                                                                            // diferenciar coches.
                // Ponemos que del result cogemos un string (getString) e indicamos la columna
                // de la que queremos el valor ("matricula").
                System.out.println("Matricula: " + resultSet.getString("matricula"));
                System.out.println("Marca: " + resultSet.getString("marca"));
                System.out.println("Modelo: " + resultSet.getString("modelo"));
                System.out.println("Fecha de Matriculacion: " + resultSet.getString("fMatriculacion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar los coches: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CRUDSQlite coches = new CRUDSQlite();

        coches.insertCoche("4321ZXY", "Toyota", "Corolla", "2020-11-24");
        coches.insertCoche("1234ABC", "Hyundai", "Getz", "2003-02-15");
        coches.mostrarCoches();

        coches.actualizarCoche("1234ABC", "Hyundai", "Getz", "2005-02-15");
        coches.mostrarCoches();

        coches.eliminarCoche("4321ZXY");
        coches.mostrarCoches();
    }
}