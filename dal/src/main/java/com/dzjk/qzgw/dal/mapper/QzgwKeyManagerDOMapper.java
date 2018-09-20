package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;

import java.util.List;


/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_KEY_MANAGER.
 * QZGW_KEY_MANAGER
 */
public interface QzgwKeyManagerDOMapper{

    /**
     * desc:插入表:QZGW_KEY_MANAGER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_KEY_MANAGER( ID ,CREATOR ,ORG_CODE ,MODIFIER ,PUBLIC_KEY ,CREATE_TIME ,PRIVATE_KEY ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{creator,jdbcType=VARCHAR} , #{orgCode,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{publicKey,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{privateKey,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwKeyManagerDO entity);
    /**
     * desc:更新表:QZGW_KEY_MANAGER.<br/>
     * descSql =  UPDATE QZGW_KEY_MANAGER SET ORG_CODE = #{orgCode,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,PUBLIC_KEY = #{publicKey,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,PRIVATE_KEY = #{privateKey,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwKeyManagerDO entity);
    /**
     * desc:根据主键删除数据:QZGW_KEY_MANAGER.<br/>
     * descSql =  DELETE FROM QZGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:QZGW_KEY_MANAGER.<br/>
     * descSql =  SELECT * FROM QZGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwKeyManagerDO
     */
    QzgwKeyManagerDO getByPrimary(Long id);

    List<QzgwKeyManagerDO> loadAll();
}
