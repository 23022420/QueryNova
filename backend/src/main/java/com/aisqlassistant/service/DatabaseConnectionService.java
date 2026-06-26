package com.aisqlassistant.service;

import com.aisqlassistant.entity.DatabaseConnection;
import com.aisqlassistant.repository.DatabaseConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseConnectionService {

    private final DatabaseConnectionRepository repository;

    public DatabaseConnection save(DatabaseConnection connection) {

        return repository.save(connection);

    }

    public List<DatabaseConnection> getAllConnections() {

        return repository.findAll();

    }

    public boolean testConnection(DatabaseConnection db) {

    String url;

    if ("PostgreSQL".equalsIgnoreCase(db.getDatabaseType())) {

        url = "jdbc:postgresql://"
                + db.getHost()
                + ":"
                + db.getPort()
                + "/"
                + db.getDatabaseName();

    } else {

        url = "jdbc:mysql://"
                + db.getHost()
                + ":"
                + db.getPort()
                + "/"
                + db.getDatabaseName();

    }

    try (Connection connection = DriverManager.getConnection(
            url,
            db.getUsername(),
            db.getPassword())) {

        return connection.isValid(5);

    } catch (SQLException e) {

        return false;

    }

}
}