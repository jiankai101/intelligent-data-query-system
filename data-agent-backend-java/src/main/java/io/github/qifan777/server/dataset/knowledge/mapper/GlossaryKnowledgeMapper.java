package io.github.qifan777.server.dataset.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.qifan777.server.dataset.knowledge.domain.GlossaryKnowledge;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GlossaryKnowledgeMapper extends BaseMapper<GlossaryKnowledge> {

    @Select("SELECT * FROM glossary_knowledge WHERE database_id = #{databaseId}")
    List<GlossaryKnowledge> findByDatabaseId(@Param("databaseId") String databaseId);
}
