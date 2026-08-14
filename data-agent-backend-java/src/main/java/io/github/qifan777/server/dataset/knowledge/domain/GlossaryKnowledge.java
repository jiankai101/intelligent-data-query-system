package io.github.qifan777.server.dataset.knowledge.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.UUID;

@TableName("glossary_knowledge")
public class GlossaryKnowledge {
    @TableId(type = IdType.INPUT)
    private UUID id;
    @TableField("database_id")
    private String databaseId;
    private String term;
    private String description;
    private String synonyms;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getDatabaseId() { return databaseId; }
    public void setDatabaseId(String databaseId) { this.databaseId = databaseId; }
    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSynonyms() { return synonyms; }
    public void setSynonyms(String synonyms) { this.synonyms = synonyms; }
}
