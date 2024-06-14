package com.wipro.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.wipro.model.Student;
import com.wipro.util.DBUtils;

public class StudentServiceImpl implements StudentService {

	private static final Logger logger = Logger.getLogger(Student.class.getName());

	@Override
	public void addStudent(Student student) throws SQLException, ClassNotFoundException {

		String sql = "insert into student values (?,?,?,?)";
		try (PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)) {

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from student where id=?";
		try (PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Student with id " + id + " deleted successfully...");

	}

	@Override
	public void updateStudent(int id, Student student) throws ClassNotFoundException, SQLException {

		String sql = "update student set name=?, address=?, email=? where id=?";
		try (PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)) {

			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getEmail());
			ps.setInt(4, student.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		List<Student> list = new ArrayList<>();
		try(Statement st = DBUtils.getConnection().createStatement()) {
			String sql="select * from student";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				list.add(s);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Student getStudent(int id) throws ClassNotFoundException, SQLException {
		Student s = new Student();
		try(Statement st = DBUtils.getConnection().createStatement()) {
			String query = "select * from student where id=" + id;
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				s.setId(id);
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
