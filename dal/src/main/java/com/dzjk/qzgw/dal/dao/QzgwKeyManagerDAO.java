package com.dzjk.qzgw.dal.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import com.dzjk.qzgw.dal.mapper.QzgwKeyManagerDOMapper;

/**
* The Table QZGW_KEY_MANAGER.
* QZGW_KEY_MANAGER
*/
@Repository("qzgw.QzgwKeyManagerDAO")
public class QzgwKeyManagerDAO{

    @Autowired
    private QzgwKeyManagerDOMapper qzgwKeyManagerDOMapper;

    /**
     * desc:插入表:QZGW_KEY_MANAGER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_KEY_MANAGER( ID ,CREATOR ,ORG_CODE ,MODIFIER ,PUBLIC_KEY ,CREATE_TIME ,PRIVATE_KEY ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{creator,jdbcType=VARCHAR} , #{orgCode,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{publicKey,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{privateKey,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(QzgwKeyManagerDO entity){
        return qzgwKeyManagerDOMapper.insert(entity);

    }
    /**
     * desc:更新表:QZGW_KEY_MANAGER.<br/>
     * descSql =  UPDATE QZGW_KEY_MANAGER SET ORG_CODE = #{orgCode,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,PUBLIC_KEY = #{publicKey,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,PRIVATE_KEY = #{privateKey,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(QzgwKeyManagerDO entity){
        return qzgwKeyManagerDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:QZGW_KEY_MANAGER.<br/>
     * descSql =  DELETE FROM QZGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Long id){
        return qzgwKeyManagerDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:QZGW_KEY_MANAGER.<br/>
     * descSql =  SELECT * FROM QZGW_KEY_MANAGER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwKeyManagerDO
     */
    public QzgwKeyManagerDO getByPrimary(Long id){
        return qzgwKeyManagerDOMapper.getByPrimary(id);

    }
    public List<QzgwKeyManagerDO> loadAll(){
        return qzgwKeyManagerDOMapper.loadAll();
    }

}
