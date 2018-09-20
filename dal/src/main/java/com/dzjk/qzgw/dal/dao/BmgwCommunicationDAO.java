package com.dzjk.qzgw.dal.dao;

import com.dzjk.qzgw.dal.mapper.BmgwCommunicationDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.BmgwCommunicationDO;

/**
* The Table BMGW_COMMUNICATION.
* BMGW_COMMUNICATION
*/
@Repository("bmgw.BmgwCommunicationDAO")
public class BmgwCommunicationDAO{

    @Autowired
    private BmgwCommunicationDOMapper bmgwCommunicationDOMapper;

    /**
     * desc:插入表:BMGW_COMMUNICATION.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BMGW_COMMUNICATION( ID ,URL ,CREATOR ,MODIFIER ,CREATE_TIME ,HTTP_REQ_TYPE ,MODIFIED_TIME ,EXCHANGE_TYPE_ID ,CHANNEL_SYSTEM_ID ,EXCHANGE_TYPE_NAME )VALUES( #{id,jdbcType=INTEGER} , #{url,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{httpReqType,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} , #{exchangeTypeId,jdbcType=VARCHAR} , #{channelSystemId,jdbcType=VARCHAR} , #{exchangeTypeName,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(BmgwCommunicationDO entity){
        return bmgwCommunicationDOMapper.insert(entity);

    }
    /**
     * desc:更新表:BMGW_COMMUNICATION.<br/>
     * descSql =  UPDATE BMGW_COMMUNICATION SET URL = #{url,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,HTTP_REQ_TYPE = #{httpReqType,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} ,EXCHANGE_TYPE_ID = #{exchangeTypeId,jdbcType=VARCHAR} ,CHANNEL_SYSTEM_ID = #{channelSystemId,jdbcType=VARCHAR} ,EXCHANGE_TYPE_NAME = #{exchangeTypeName,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(BmgwCommunicationDO entity){
        return bmgwCommunicationDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:BMGW_COMMUNICATION.<br/>
     * descSql =  DELETE FROM BMGW_COMMUNICATION WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return bmgwCommunicationDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:BMGW_COMMUNICATION.<br/>
     * descSql =  SELECT * FROM BMGW_COMMUNICATION WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return BmgwCommunicationDO
     */
    public BmgwCommunicationDO getByPrimary(Integer id){
        return bmgwCommunicationDOMapper.getByPrimary(id);

    }
}
