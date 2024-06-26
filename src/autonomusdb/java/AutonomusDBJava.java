/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonomusdb.java;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 *
 * @author Jose Luis
 */
public class AutonomusDBJava {

    
    public static void main(String[] args)  throws Exception {
    final String DB_URL="jdbc:oracle:thin:@motadb_medium?TNS_ADMIN=C:\\Wallet_MOTADB";
    // Update the Database Username and Password to point to your Autonomous Database
    final String DB_USER = "admin";
    String DB_PASSWORD = "Arquitectura1." ;
    //final String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";
    final String CONN_FACTORY_CLASS_NAME="oracle.jdbc.replay.OracleConnectionPoolDataSourceImpl";
    PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
    
    pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
      
    pds.setURL(DB_URL);
    pds.setUser(DB_USER);
    pds.setPassword(DB_PASSWORD);
    pds.setConnectionPoolName("JDBC_UCP_POOL");
    
     pds.setInitialPoolSize(5);

 
    pds.setMinPoolSize(5);


    pds.setMaxPoolSize(20);
    
     try (Connection conn = pds.getConnection()) {
      System.out.println("Conexion Exitosa");
      
    } catch (SQLException e) {
        System.out.println("ADBQuickStart - "
          + "SQLException occurred : " + e.getMessage());
    } 
    
    }
    
}
