package ru.otus.jdbc.mapper;

public class EntitySQLMetaDataImpl implements  EntitySQLMetaData{

    private final EntityClassMetaData metaData;

    public EntitySQLMetaDataImpl(EntityClassMetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String getSelectAllSql() {
        return String.format("SELECT * FROM %s", metaData.getName());
    }

    @Override
    public String getSelectByIdSql() {
        return null;
    }

    @Override
    public String getInsertSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }
}
