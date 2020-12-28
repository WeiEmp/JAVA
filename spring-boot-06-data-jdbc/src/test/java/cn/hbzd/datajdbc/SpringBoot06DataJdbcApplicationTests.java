package cn.hbzd.datajdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot06DataJdbcApplicationTests {


	@Autowired
	DataSource dataSource;


	@Test
	void contextLoads() throws SQLException {
//		com.zaxxer.hikari.HikariDataSource
		System.out.println(dataSource.getClass());
//		HikariProxyConnection@1985280051 wrapping com.mysql.cj.jdbc.ConnectionImpl@571a01f9
		System.out.println(dataSource.getConnection());

	}

}
