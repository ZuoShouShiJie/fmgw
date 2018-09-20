package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.BmgwCommunicationDO;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BMGW_COMMUNICATION.
 * BMGW_COMMUNICATION
 */
public interface BmgwCommunicationDOMapper{

    /**
     * desc:插入表:BMGW_COMMUNICATION.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BMGW_COMMUNICATION( ID ,URL ,CREATOR ,MODIFIER ,CREATE_TIME ,HTTP_REQ_TYPE ,MODIFIED_TIME ,EXCHANGE_TYPE_ID ,CHANNEL_SYSTEM_ID ,EXCHANGE_TYPE_NAME )VALUES( #{id,jdbcType=INTEGER} , #{url,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{httpReqType,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} , #{exchangeTypeId,jdbcType=VARCHAR} , #{channelSystemId,jdbcType=VARCHAR} , #{exchangeTypeName,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(BmgwCommunicationDO entity);
    /**
     * desc:更新表:BMGW_COMMUNICATION.<br/>
     * descSql =  UPDATE BMGW_COMMUNICATION SET URL = #{url,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,HTTP_REQ_TYPE = #{httpReqType,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} ,EXCHANGE_TYPE_ID = #{exchangeTypeId,jdbcType=VARCHAR} ,CHANNEL_SYSTEM_ID = #{channelSystemId,jdbcType=VARCHAR} ,EXCHANGE_TYPE_NAME = #{exchangeTypeName,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(BmgwCommunicationDO entity);
    /**
     * desc:根据主键删除数据:BMGW_COMMUNICATION.<br/>
     * descSql =  DELETE FROM BMGW_COMMUNICATION WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:BMGW_COMMUNICATION.<br/>
     * descSql =  SELECT * FROM BMGW_COMMUNICATION WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return BmgwCommunicationDO
     */
    BmgwCommunicationDO getByPrimary(Integer id);
}
