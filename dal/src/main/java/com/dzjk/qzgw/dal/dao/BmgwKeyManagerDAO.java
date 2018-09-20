package com.dzjk.qzgw.dal.dao;

import com.dzjk.qzgw.dal.dataobject.BmgwKeyManagerDO;
import com.dzjk.qzgw.dal.mapper.BmgwKeyManagerDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* The Table BMGW_KEY_MANAGER.
* BMGW_KEY_MANAGER
*/
@Repository("bmgw.BmgwKeyManagerDAO")
public class BmgwKeyManagerDAO{

    @Autowired
    private BmgwKeyManagerDOMapper bmgwKeyManagerDOMapper;

    /**
     * desc:插入表:BMGW_KEY_MANAGER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BMGW_KEY_MANAGER( ID ,CREATOR ,MODIFIER ,PUBLIC_KEY ,CREATE_TIME ,PRIVATE_KEY ,MODIFIED_TIME ,CHANNEL_SYSTEM_ID )VALUES( #{id,jdbcType=BIGINT} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{publicKey,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{privateKey,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} , #{channelSystemId,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(BmgwKeyManagerDO entity){
        return bmgwKeyManagerDOMapper.insert(entity);

    }
    /**
     * desc:更新表:BMGW_KEY_MANAGER.<br/>
     * descSql =  UPDATE BMGW_KEY_MANAGER SET MODIFIER = #{modifier,jdbcType=VARCHAR} ,PUBLIC_KEY = #{publicKey,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,PRIVATE_KEY = #{privateKey,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} ,CHANNEL_SYSTEM_ID = #{channelSystemId,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(BmgwKeyManagerDO entity){
        return bmgwKeyManagerDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:BMGW_KEY_MANAGER.<br/>
     * descSql =  DELETE FROM BMGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Long id){
        return bmgwKeyManagerDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:BMGW_KEY_MANAGER.<br/>
     * descSql =  SELECT * FROM BMGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return BmgwKeyManagerDO
     */
    public BmgwKeyManagerDO getByPrimary(Long id){
        return bmgwKeyManagerDOMapper.getByPrimary(id);

    }
    public BmgwKeyManagerDO keyInfo(String channelSystemId){
        return bmgwKeyManagerDOMapper.keyInfo(channelSystemId);

    }
}
