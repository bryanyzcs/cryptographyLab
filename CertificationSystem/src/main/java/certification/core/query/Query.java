package certification.core.query;

import java.sql.*;

/**.
 * Query certificate by serial number.
 */
public class Query {
    /**
     * Query the certificate by serial number.
     * @param seq -serial number
     * @return commonName if the certificate is in the DB, otherwise
     */
    public String queryCertificate(String seq){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String returnValue = null ;
        // 注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificationsystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");

            st = conn.createStatement();
            // 查询
            String sql = "select * from certs where "+"serial='"+seq+"'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            // 遍历
            while (rs.next()) {
                String commonName = rs.getString("commonName");
                System.out.println("serial == " + seq + "   commonName == " + commonName);
                returnValue = commonName;
            }

            if (returnValue == null){
                sql = "select * from crl where "+"serial='"+seq+"'";
                System.out.println(sql);
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    returnValue = "Revoked!";
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean querySQL(String seq){
        return false;
    }
}
