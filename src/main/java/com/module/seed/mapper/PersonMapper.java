package com.module.seed.mapper;

import com.module.seed.model.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PersonMapper {
    @Delete({
        "delete from person",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into person (id, name)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Person record);

    int insertSelective(Person record);

    @Select({
        "select",
        "id, name",
        "from person",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.module.seed.mapper.PersonMapper.BaseResultMap")
    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    @Update({
        "update person",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Person record);
}