package com.example.ch16.dao;

import com.example.ch16.vo.MemberVo;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MemberDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/firstservletjsp";
    private static final String USER = "firstservletjsp-user";
    private static final String PASSWORD = "1234";

    private static final MysqlDataSource dataSource = new MysqlDataSource();

    private static Connection getConnection() throws SQLException {
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource.getConnection();
    }

    public static void memberInsert(MemberVo member) {
        final String sql = "insert into member values (?, ?, ?, ?)";

        try (final Connection connection = getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, member.id());
            preparedStatement.setString(2, member.password());
            preparedStatement.setString(3, member.name());
            preparedStatement.setString(4, member.email());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new RuntimeException(sqlException);
        }
    }

    public static void memberUpdate(MemberVo member) {
        final String sql = "update member set password = ?, name = ?, email = ? where id = ?";

        try (final Connection connection = getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ) {
            preparedStatement.setString(1, member.password());
            preparedStatement.setString(2, member.name());
            preparedStatement.setString(3, member.email());
            preparedStatement.setString(4, member.id());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new RuntimeException(sqlException);
        }
    }

    public static void memberDelete(String id) {
        final String sql = "delete from member where id = ?";

        try (final Connection connection = getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new RuntimeException(sqlException);
        }
    }

    public static MemberVo memberSearch(String id) {
        final String sql = "select * from member where id = ?";

        try (final Connection connection = getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, id);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new NoSuchElementException("No such member");
                }

                return new MemberVo(
                        resultSet.getString("id"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new RuntimeException(sqlException);
        }
    }

    public static List<MemberVo> memberList() {
        final String sql = "select * from member";

        try (final Connection connection = getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(sql)
         ) {
            final List<MemberVo> members = new ArrayList<>();

            while (resultSet.next()) {
                members.add(new MemberVo(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }

            return members;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new RuntimeException(sqlException);
        }
    }
}
