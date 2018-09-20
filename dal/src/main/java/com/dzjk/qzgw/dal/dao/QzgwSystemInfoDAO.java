package com.dzjk.qzgw.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.QzgwSystemInfoDO;
import com.dzjk.qzgw.dal.mapper.QzgwSystemInfoDOMapper;

/**
* The Table QZGW_SYSTEM_INFO.
* QZGW_SYSTEM_INFO
*/
@Repository("qzgw.QzgwSystemInfoDAO")
public class QzgwSystemInfoDAO{

    @Autowired
    private QzgwSystemInfoDOMapper qzgwSystemInfoDOMapper;

    /**
     * desc:插入表:QZGW_SYSTEM_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_SYSTEM_INFO( ID ,STATUS ,CREATOR ,MODIFIER ,CREATE_TIME ,SYSTEM_CODE ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{systemCode,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(QzgwSystemInfoDO entity){
        return qzgwSystemInfoDOMapper.insert(entity);

    }
    /**
     * desc:更新表:QZGW_SYSTEM_INFO.<br/>
     * descSql =  UPDATE QZGW_SYSTEM_INFO SET STATUS = #{status,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(QzgwSystemInfoDO entity){
        return qzgwSystemInfoDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:QZGW_SYSTEM_INFO.<br/>
     * descSql =  DELETE FROM QZGW_SYSTEM_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Long id){
        return qzgwSystemInfoDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:QZGW_SYSTEM_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_SYSTEM_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwSystemInfoDO
     */
    public QzgwSystemInfoDO getByPrimary(Long id){
        return qzgwSystemInfoDOMapper.getByPrimary(id);

    }
}
