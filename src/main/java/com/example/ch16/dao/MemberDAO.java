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
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void memberInsert(MemberVo member) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into member values (?, ?, ?, ?)")
        ) {
            preparedStatement.setString(1, member.id());
            preparedStatement.setString(2, member.password());
            preparedStatement.setString(3, member.name());
            preparedStatement.setString(4, member.email());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public MemberVo memberSearch(String id) {
        MemberVo member = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from member where id=?")
        ) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    member = new MemberVo(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return member;
    }

    public void memberUpdate(MemberVo member) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update member set password=?, name=?, email=? where id=?");
         ) {
            preparedStatement.setString(1, member.password());
            preparedStatement.setString(2, member.name());
            preparedStatement.setString(3, member.email());
            preparedStatement.setString(4, member.id());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void memberDelete(String id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from member where id=?");
        ) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<MemberVo> memberList() {
        List<MemberVo> members = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from member");
             ResultSet resultSet = preparedStatement.executeQuery()
         ) {
            while (resultSet.next()) {
                MemberVo member = new MemberVo(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                members.add(member);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return members;
    }
}
