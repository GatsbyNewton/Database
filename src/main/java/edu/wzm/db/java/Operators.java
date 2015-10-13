package edu.wzm.db.java;

import edu.wzm.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GatsbyNewton on 2015/10/12.
 */
public class Operators {

    private Connection conn = null;
    private PreparedStatement pstm = null;

    //Insert operator
    public boolean add(User user)throws Exception{
        try {
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO user(id, name, age)")
                    .append("     VALUES(?, ?, ?)");
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql.toString());
            pstm.setObject(1, user.getId());
            pstm.setObject(2, user.getName());
            pstm.setObject(3, user.getAge());

            return pstm.executeUpdate() > 0;
        }
        finally {
            DBUtils.close(pstm);
            DBUtils.close(conn);
        }
    }

    //Delete operator
    public boolean delete(String id)throws Exception{

        try {
            String sql = "DELETE FROM user WHERE id = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, id);

            return pstm.executeUpdate() > 0;
        }
        finally {
            DBUtils.close(pstm);
            DBUtils.close(conn);
        }
    }

    //Update operator
    public boolean modify(User user)throws Exception{

        try {
            String sql = "UPDATE user SET age = ? WHERE id = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, user.getAge());
            pstm.setObject(2, user.getId());

            return pstm.executeUpdate() > 0;
        }
        finally {
            DBUtils.close(pstm);
            DBUtils.close(conn);
        }
    }

    //Select operator
    public List query(Integer id)throws  Exception{
        ResultSet rs = null;
        List list = null;
        try{
            StringBuilder sql = new StringBuilder()
                    .append("SELECT name, age")
                    .append("  FROM user")
                    .append(" WHERE id > ?");
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql.toString());
            pstm.setObject(1, id);
            rs = pstm.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();
            list = new ArrayList();
            Map map = null;
            while (rs.next()){
                map = new HashMap();
                for(int i = 1; i <= size; i++){
                    map.put(rsmd.getColumnLabel(i), rs.getString(i));
                }
                list.add(map);
            }
            return list;
        }
        finally {
            DBUtils.close(rs);
            DBUtils.close(pstm);
            DBUtils.close(conn);
        }
    }
}
