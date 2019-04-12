package pl.golabm.repository;

import pl.golabm.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonRepository extends AbstractDAO {



    public Integer insertPerson(Person person) throws SQLException, ClassNotFoundException {

        Integer id = null;

        Statement statement = getStatement();
        statement.executeUpdate("INSERT into customers(name, surname, age) values (\'" + person.getName()
                + "\', \'" + person.getSurname() + "\'," + person.getAge() + ")", Statement.RETURN_GENERATED_KEYS);

        ResultSet customerId = statement.getGeneratedKeys();
        if (customerId.next()) {
            id = customerId.getInt(1);

        }
        return id;
    }
}
