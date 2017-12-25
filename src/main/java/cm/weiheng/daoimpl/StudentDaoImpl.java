package cm.weiheng.daoimpl;

import cm.weiheng.bean.Student;
import cm.weiheng.dao.StudentDao;
import cm.weiheng.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao{

    /**
     *
     * @param student 需要新增的学生对象
     */
    public void addStudent(Student student) {
       //获取session
        SqlSession session=null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            session.insert("addStudent", student);
            //手动提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //务必要关闭
            if (session!=null){
                session.close();
            }

        }

    }

    public void addStudentCacheId(Student student) {
        //获取session
        SqlSession session=null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            session.insert("addStudentCacheId", student);
            //手动提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //务必要关闭
            if (session!=null){
                session.close();
            }
        }
    }

    public void deleteStudent(int id) {
        //获取session
        SqlSession session=null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            session.delete("deleteStudent", id);
            //手动提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    public void updateStudent(Student student) {
        SqlSession session=null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            session.update("updateStudent", student);
            //手动提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    /**
     * 查询返回list集合
     * @return
     */
    public List<Student> selectAllStudents() {
        List<Student> students=new ArrayList<Student>();
        SqlSession session=null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            students=session.selectList("selectAllStudents");
            //查询就不需要你提交事务
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }


        return students;
    }

    /**
     * 返回map集合
     * @return
     */
    public Map<String, Object> selectAllStudentsMap() {
        Map<String, Object> students = new HashMap<String, Object>();
        SqlSession session = null;

        try {

            session = SessionFactoryUtil.getSqlSession();
            // 还是之前list的方法 但是 key放什么？ key必须是查询出来实体类的属性值
            students=session.selectMap("selectAllStudentsMap", "name");
            //查询就不需要你提交事务
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }

    public Student selectById(int id) {
        Student students=null;
        SqlSession session=null;
        try {

            session = SessionFactoryUtil.getSqlSession();
            students = session.selectOne("selectById", id);
            //查询就不需要你提交事务
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }
    //根据name模糊查询 返回list集合
    public List<Student> selectByName(String name) {
        List<Student> students=null;
        SqlSession session=null;
        try {

            session = SessionFactoryUtil.getSqlSession();
            students = session.selectList("selectByName", name);
            //查询就不需要你提交事务
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }
}
