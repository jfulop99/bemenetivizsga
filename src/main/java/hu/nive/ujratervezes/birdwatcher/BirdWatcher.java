package hu.nive.ujratervezes.birdwatcher;

// import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BirdWatcher {

    private DataSource dataSource;

    public BirdWatcher(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getUniqueBirdsJDBC() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT species FROM birds_spotted ORDER BY species")) {
            return getResults(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<String> getResults(PreparedStatement ps) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                result.add(rs.getString("species"));
            }
        }
        return result;
    }


    public List<String> getUniqueBirds() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query("SELECT DISTINCT species FROM birds_spotted ORDER BY species",
                (resultSet, i) -> resultSet.getString("species"));

    }
}
