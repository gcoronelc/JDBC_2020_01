
// Variables
Connection cn = null;
// Proceso
try {
	// Objeto connection
	cn = AccesoDB.getConnection();
	
} catch (SQLException e) {
	throw new RuntimeException(e.getMessage());
} catch (Exception e) {
	String msg = "Error en el proceso ...";
	throw new RuntimeException(msg);
} finally {
	try {
		cn.close();
	} catch (Exception e) {
	}
}

