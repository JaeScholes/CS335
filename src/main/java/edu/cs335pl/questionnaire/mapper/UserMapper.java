package edu.cs335pl.questionnaire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cs335pl.questionnaire.pojo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository //注解不要漏了，下面的继承不要漏了
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from #{}")
//    public User findUserByAaccount(@Param())

}
