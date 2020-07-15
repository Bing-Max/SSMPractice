import com.bing.dao.DeptMapper;
import com.bing.dao.UserMapper;
import com.bing.entity.Department;
import com.bing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private Department department;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<Department> list = deptMapper.getAll();
        for(Department dept: list){
            System.out.println(dept.getDeptId()+" -- "+dept.getDeptName());
        }
    }

    @Test
    public void test03(){
        System.out.println(deptMapper.getById(1).getDeptName());
    }

    @Test
    public void test04(){
        List<User> list = userMapper.getAll();
        for(User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void test05(){
        System.out.println(userMapper.getByName("user01"));
        System.out.println("passwd: " + userMapper.getByName("user01").getPasswd());
    }

//    @Test
//    public void test06(){
//        department.setDeptId(1);
//        department.setDeptName("研发部");
//        User user = new User();
//        for(int i = 0; i < 1000; i++){
//            user.setName("user"+ (i +4));
//            user.setPasswd("123456");
//            user.setDepartment(department);
//    //        System.out.println(user);
//            userMapper.add(user);
//        }
//
//    }
}
