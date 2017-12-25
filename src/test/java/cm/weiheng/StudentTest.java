package cm.weiheng;

import cm.weiheng.bean.Student;
import cm.weiheng.dao.StudentDao;
import cm.weiheng.daoimpl.StudentDaoImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentTest {
    Logger logger=Logger.getLogger(StudentTest.class);
    StudentDao dao=null;
    @Before
    public void before(){
        dao=new StudentDaoImpl();

    }
    @Test
    public void testAddStudent(){
        dao.addStudent(new Student("小明",12));

    }



    @Test
    public void testDelete(){
        dao.deleteStudent(2);

    }
    @Test
    public void testUpdate(){
        Student student=new Student("哈话u",1);
        student.setId(1);
        dao.updateStudent(student);
    }
    // 返回list
    @Test
    public void selectList() {
        List<Student> allStudents = dao.selectAllStudents();
       logger.debug("allStudents++++++++++++++++++"+allStudents);
    }
    @Test
    public void selectListByMap() {
        Map<String, Object> stringObjectMap = dao.selectAllStudentsMap();
        logger.debug("allStudents++++++++++++++++++"+stringObjectMap);
    }
    @Test
    public void selectById() {
        Student student = dao.selectById(1);
        logger.debug("selectById++++++++++++++++++"+student);
    }
    @Test
    public void selectByName() {
        List<Student> students = dao.selectByName("小");
        logger.debug("selectByName++++++++++++++++++"+students);
    }

}
