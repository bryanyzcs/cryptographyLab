package certification.core;

import certification.core.query.PathQuery;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Certificate Revoke List.
 */
public class CRL {

    public CRL(){

    }
    /**
     * Revoke the certificate with serial number.
     * @param serial -serial number
     * @param commenName
     * @return - "Revoke successfully!" if revoke the certificate of serial number, "Fail to revoke!"
     *          if fail to revoke;
     */
    public String doRequestCRL(String serial,String commenName){
        String message;
        Connection conn = null;
        Statement st = null;
        // 注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificationsystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
            String fileName;
            st = conn.createStatement();
            //写入
            String writeToSql = "select * from certs where serial='"+serial+"'";
            System.out.println(writeToSql);
            // 查询
            ResultSet rs = st.executeQuery(writeToSql);
            // 遍历
            boolean flag = true;
            while (rs.next()) {
                flag = false;
                fileName = rs.getString("fileName");
                String nameCompare = rs.getString("commonName");
                if(!commenName.equals(nameCompare)){
                    return "Fail to revoke!";
                } else {
                    doCRL(fileName,commenName,serial);
                }
            }
            String delete = "delete from certs where serial='"+serial+"'";
            if(st.executeUpdate(writeToSql)!=0) {
                System.out.println("Delete " + serial + " from cert repository successfully！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Revoke successfully!";
    }

    /**
     * Revoke certificate.
     * @param crtPath -path of cert need to be revoked.
     * @return
     */
    public boolean doCRL(String crtPath,String commonName,String serial) {
        String crlPath = PathQuery.crlPath+"ca.crl";
        File file = new File(crlPath);
        List<String> buffer = new ArrayList<>();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine())!=null){
                buffer.add(line);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Revoke: /"+serial+"/"+new Date().toString()+"/"+commonName+"\n");
            buffer.add(stringBuffer.toString());
            for (String writeto : buffer){
                writer.write(writeto);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeCrlToSql(serial,crlPath,commonName);
        return true;
    }
    /**
     * Write crl to sql
     * @return -true if store successfully
     */
    public boolean writeCrlToSql(String serial,String fileName,String commonName){
        Connection conn = null;
        Statement st = null;
        // 注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificationsystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");

            st = conn.createStatement();
            //写入
            String[] split = fileName.split("\\\\");
            fileName = split[0];
            for (int i=1;i<split.length;i++){
                fileName += "\\\\" + split[i];
            }
            String value = "(\'"+commonName+"\', \'"+serial+"\', \'"+fileName+"\')";
            String writeToSql = "insert into crl (commonName, serial, fileName) values "+value;
            System.out.println(writeToSql);
            // 查询
            int rs;
            rs = st.executeUpdate(writeToSql);
            if (rs!=0){
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
