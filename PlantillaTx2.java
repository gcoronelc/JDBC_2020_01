Connection cn = null;
try {
  // Acceso al objeto Connection
  cn = AccesoDB.getConnection();
  // Inicia Tx
  cn.setAutoCommit(false);

  
  // Confirmar Tx
  cn.commit();
} catch (Exception e) {
  try {
	// Cancela Tx
	cn.rollback();
  } catch (Exception e1) {
  }
  String mensaje = "Error en el Proceso, intentelo mas tarde.";
  if(e.getMessage() != null && !e.getMessage().isEmpty()){
	mensaje += " " + e.getMessage();
  }
  throw new RuntimeException(mensaje);
} finally {
  try {
	cn.close();
  } catch (Exception e) {
  }
}
