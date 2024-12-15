package java.com.ust.traineapp.repositiory;

import java.com.ust.traineapp.model.Trainee;

import java.com.ust.traineapp.service.TraineeService;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {

    List<Trainee> res=new ArrayList<>();
    public Trainee save(Trainee trainee) {
        res.add(trainee);
        return trainee;
//        Connection connection= jdbcConnectionUtil.createConnection();
//        String sql= """
//                insert into trainee(name,location,date_joined)
//                values(?,?,?)
//                """;
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1,trainee.name());
//            statement.setString(2,trainee.location());
//            statement.setDate(3, Date.valueOf(trainee.joinedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
//            int rowCount=statement.executeUpdate();
//            System.out.println(rowCount+" rows inserted");
//            return getTrainee(trainee.id());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public Trainee getTrainee(int id) {

        for(Trainee t:res){
            if(t.id()==id){
                return t;
            }
        }
        return null;
//        Connection connection=jdbcConnectionUtil.createConnection();
//
//        String sql= """
//                select * from trainee where id=?
//                """;
//        try {
//            PreparedStatement statement=connection.prepareStatement(sql);
//            statement.setInt(1,id);
//            ResultSet resultSet=statement.executeQuery();
//            return getTraineefromResultSet(resultSet);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<Trainee> getAllTrainees() {

        return res;

//        Connection connection=jdbcConnectionUtil.createConnection();
//        String sql= """
//                select * from trainee
//                """;
//        try {
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery(sql);
//            return getTraineefromResultSetList(resultSet);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void deleteTrainee(int id) {



//        Connection connection=jdbcConnectionUtil.createConnection();
//
//        String sql= """
//                delete from trainee where id=?
//                """;
//
//        try {
//            PreparedStatement statement=connection.prepareStatement(sql);
//            statement.setInt(1,id);
//            statement.executeUpdate();
//
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }


    }


    public Trainee getTraineefromResultSet(ResultSet resultSet){
        Trainee trainee=null;

        try {
            if(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String location=resultSet.getString("location");
                LocalDate joinedDate=resultSet.getDate("date_joined").toLocalDate();
                trainee=new Trainee(id,name,location,joinedDate);
                return trainee;
            }
            return trainee;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Trainee> getTraineefromResultSetList(ResultSet resultSet){
        List<Trainee> res=new ArrayList<>();

        try {
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String location=resultSet.getString("location");
                LocalDate joinedDate=resultSet.getDate("date_joined").toLocalDate();
                Trainee trainee=new Trainee(id,name,location,joinedDate);
                res.add(trainee);
            }
            return res;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}