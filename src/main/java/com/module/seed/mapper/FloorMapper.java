package com.module.seed.mapper;

import com.module.seed.model.Floor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FloorMapper {
    @Delete({
        "delete from floor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into floor (id, name, ",
        "assistant_id)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{assistantId,jdbcType=BIGINT})"
    })
    int insert(Floor record);

    int insertSelective(Floor record);

    @Select({
        "select",
        "id, name, assistant_id",
        "from floor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.module.seed.mapper.FloorMapper.BaseResultMap")
    Floor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Floor record);

    @Update({
        "update floor",
        "set name = #{name,jdbcType=VARCHAR},",
          "assistant_id = #{assistantId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Floor record);
}