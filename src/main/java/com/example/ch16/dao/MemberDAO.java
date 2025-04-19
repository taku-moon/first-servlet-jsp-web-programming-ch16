package com.example.ch16.dao;

import com.example.ch16.vo.MemberVo;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private static MemberDAO dao = new MemberDAO();

    private MemberDAO() {

    }

    public static MemberDAO getInstance() {
        return dao;
    }

    public Connection getConnection() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/firstservletjsp");
        dataSource.setUser("firstservletjsp-user");
        dataSource.setPassword("1234");

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        }

        return connection;
    }

    public void close(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println("오류발생: " + e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("오류발생: " + e);
            }
        }
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                System.out.println("오류발생: " + e);
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println("오류발생: " + e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("오류발생: " + e);
            }
        }
    }

    public void memberInsert(MemberVo member) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into  member values (?, ?, ?, ?)");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getName());
            preparedStatement.setString(4, member.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        } finally {
            close(connection, preparedStatement);
        }
    }

    public MemberVo memberSearch(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        MemberVo member = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from member where id=?");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                member = new MemberVo();
                member.setId(resultSet.getString(1));
                member.setPassword(resultSet.getString(2));
                member.setName(resultSet.getString(3));
                member.setEmail(resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        } finally {
            close(connection, preparedStatement, resultSet);
        }

        return member;
    }

    public void memberUpdate(MemberVo member) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update member set password=?, name=?, email=? where id=?");
            preparedStatement.setString(1, member.getPassword());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setString(4, member.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        } finally {
            close(connection, preparedStatement);
        }
    }

    public void memberDelete(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from member where id=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        } finally {
            close(connection, preparedStatement);
        }
    }

    public List<MemberVo> memberList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<MemberVo> members = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from member");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MemberVo member = new MemberVo();
                member.setId(resultSet.getString(1));
                member.setPassword(resultSet.getString(2));
                member.setName(resultSet.getString(3));
                member.setEmail(resultSet.getString(4));
                members.add(member);
            }
        } catch (Exception e) {
            System.out.println("오류발생: " + e);
        } finally {
            close(connection, preparedStatement);
        }

        return members;
    }
}
