package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.BmgwKeyManagerDO;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BMGW_KEY_MANAGER.
 * BMGW_KEY_MANAGER
 */
public interface BmgwKeyManagerDOMapper{

    /**
     * desc:插入表:BMGW_KEY_MANAGER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BMGW_KEY_MANAGER( ID ,CREATOR ,MODIFIER ,PUBLIC_KEY ,CREATE_TIME ,PRIVATE_KEY ,MODIFIED_TIME ,CHANNEL_SYSTEM_ID )VALUES( #{id,jdbcType=BIGINT} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{publicKey,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{privateKey,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} , #{channelSystemId,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(BmgwKeyManagerDO entity);
    /**
     * desc:更新表:BMGW_KEY_MANAGER.<br/>
     * descSql =  UPDATE BMGW_KEY_MANAGER SET MODIFIER = #{modifier,jdbcType=VARCHAR} ,PUBLIC_KEY = #{publicKey,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,PRIVATE_KEY = #{privateKey,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} ,CHANNEL_SYSTEM_ID = #{channelSystemId,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(BmgwKeyManagerDO entity);
    /**
     * desc:根据主键删除数据:BMGW_KEY_MANAGER.<br/>
     * descSql =  DELETE FROM BMGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:BMGW_KEY_MANAGER.<br/>
     * descSql =  SELECT * FROM BMGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return BmgwKeyManagerDO
     */
    BmgwKeyManagerDO getByPrimary(Long id);
    BmgwKeyManagerDO keyInfo(String channelSystemId);
}
