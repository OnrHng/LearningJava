package Database;

import java.sql.*;

public class TestDB {
  /*
    CRUD  = Create
            Read
            Update
            Delete


    USING CONSTANT = sql query lerini hard code olarak yazilmasi durumda sql injection a acik hale getirirsiniz db nizi
      bundan dolayi constant kullanmak daha guvenli bir yoldur.
  */

  public static final String DB_NAME = "test.db";
  public static final String CONNECTION_STR = "jdbc:sqlite:C:\\Users\\onur\\Databases\\" +  DB_NAME;

  public static final String TABLE_CONTACTS = "contacts";

  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_PHONE = "phone";
  public static final String COLUMN_EMAIL = "email";

  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection(CONNECTION_STR);
//      Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\onur\\Databases\\test.db");
      System.out.println("Connected with Sqlite DB");
      // Create Statement
      Statement statement = connection.createStatement();

      // Drop Table
      statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

      // Create Table
      statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

      // INSERT DATA - good practice
      insertContact(statement,"Tim", 6545678, "tim@email.com");
      insertContact(statement,"Joe", 45632, "joe@anywhere.com");
      insertContact(statement,"Jane", 4829484, "jane@somewhere.com");
      insertContact(statement,"Fido", 9038, "dog@email.com");

      //bad way to insert data
      statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Sally', 54321, 'sally@email.com')");
      statement.execute("INSERT INTO contacts (name, phone, email) VALUES('John', 1234, 'john@email.com')");
      statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Hansel', 989897, 'hansel@email.com')");

      // UPDATE DATA
      statement.execute(
              "UPDATE " + TABLE_CONTACTS + " SET " +
              COLUMN_PHONE + "=5566789" +
              " WHERE " + COLUMN_NAME + "='Jane'");
//      statement.execute("UPDATE contacts SET phone = 1234565 WHERE name = 'Sally'");

      // DELETE DATA
      statement.execute("DELETE FROM " +TABLE_CONTACTS +
              " WHERE " + COLUMN_NAME + "='Joe'");
//      statement.execute("DELETE FROM contacts WHERE name = 'Hansel'");

      // GET RESULTS
      ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS); // it is easy way to get resultset from
                                                                                  // using .execute() then getResultSet()v
//      statement.execute("SELECT * FROM contacts");
//      ResultSet resultSet = statement.getResultSet();
      while (resultSet.next()) {
        System.out.println(
                resultSet.getString(COLUMN_NAME) + " " +
                resultSet.getInt(COLUMN_PHONE) + " " +
                resultSet.getString(COLUMN_EMAIL));
      }
      resultSet.close();

      statement.close();
      connection.close();

    }catch (SQLException e){
      System.out.println("something went wrong: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
    statement.execute("INSERT INTO " + TABLE_CONTACTS +
            " (" + COLUMN_NAME + ", " +
            COLUMN_PHONE + ", " +
            COLUMN_EMAIL +
            " ) " +
            "VALUES('" + name + "', " + phone + ", '" + email + "')");
  }
}
