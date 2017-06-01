package com.factracing.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.factracing.beans.GameRoom;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Controller
public class DatabaseController
{

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private static DataSource dataSource;


	@Bean
	public DataSource dataSource() throws SQLException
	{
		if (dbUrl == null || dbUrl.isEmpty())
		{
			return new HikariDataSource();
		}
		else
		{
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}


	@RequestMapping("/db")
	String db(Map<String, Object> model)
	{
		try (Connection connection = dataSource.getConnection())
		{
			try (Statement stmt = connection.createStatement())
			{
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick TIMESTAMP)");
				stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
				try (ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks"))
				{
					ArrayList<String> output = new ArrayList<String>();
					while (rs.next())
					{
						output.add("Read from DB: " + rs.getTimestamp("tick"));
					}
					model.put("records", output);
					return "db";
				}
				catch (Exception e)
				{
					return null;
				}
			}
			catch (Exception e)
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}


	public static boolean saveGameRoomToDB(GameRoom room)
	{
		try (Connection connection = dataSource.getConnection())
		{
			try (Statement stmt = connection.createStatement())
			{
				String roomID = room.getRoomID();
				int minPlayers = room.getMinPlayers();
				int maxPlayers = room.getMaxPlayers();
				int playerCount = room.getPlayerCount();
				String creatorID = room.getCreator().getUserID();
				stmt.executeUpdate("INSERT INTO gameroom (gameroomid, minplayers, maxplayers, playercount, creatorid) VALUES (" + roomID
						+ ", " + minPlayers + ", " + maxPlayers + ", " + playerCount + ", " + creatorID + ");");
			}
			catch (Exception e)
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}


	public static boolean deleteGameRoomFromDB(GameRoom room)
	{
		try (Connection connection = dataSource.getConnection())
		{
			try (Statement stmt = connection.createStatement())
			{
				String roomID = room.getRoomID();
				stmt.executeUpdate("DELETE FROM gameroom WHERE gameroomid = " + roomID + ";");
			}
			catch (Exception e)
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
}
