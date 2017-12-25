package cm.weiheng.dao;

import cm.weiheng.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 增加学生信息
     * @param student
     */
    void addStudent(Student student);
    //新增完毕之后有ID
    void addStudentCacheId(Student student);
    //删除学生信息
    void deleteStudent(int id);
    //修改学生信息
    void updateStudent(Student student);
    //查询所有
    List<Student> selectAllStudents();
    //查询出来的是一个map集合
    Map<String ,Object> selectAllStudentsMap();
    //查询指定的
    Student selectById(int id);

    //根据姓名模糊查询
    List<Student> selectByName(String name);

}
