package com.dzjk.qzgw.dal.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceInfoDO;
import com.dzjk.qzgw.dal.mapper.QzgwServiceInfoDOMapper;

/**
* The Table QZGW_SERVICE_INFO.
* QZGW_SERVICE_INFO
*/
@Repository("qzgw.QzgwServiceInfoDAO")
public class QzgwServiceInfoDAO{

    @Autowired
    private QzgwServiceInfoDOMapper qzgwServiceInfoDOMapper;

    /**
     * desc:插入表:QZGW_SERVICE_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_SERVICE_INFO( ID ,STATUS ,CREATOR ,MODIFIER ,CREATE_TIME ,SERVICE_CODE ,BELONG_SYSTEM ,MODIFIED_TIME )VALUES( #{id,jdbcType=INTEGER} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{serviceCode,jdbcType=VARCHAR} , #{belongSystem,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(QzgwServiceInfoDO entity){
        return qzgwServiceInfoDOMapper.insert(entity);

    }
    /**
     * desc:更新表:QZGW_SERVICE_INFO.<br/>
     * descSql =  UPDATE QZGW_SERVICE_INFO SET STATUS = #{status,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR} ,BELONG_SYSTEM = #{belongSystem,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(QzgwServiceInfoDO entity){
        return qzgwServiceInfoDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:QZGW_SERVICE_INFO.<br/>
     * descSql =  DELETE FROM QZGW_SERVICE_INFO WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return qzgwServiceInfoDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:QZGW_SERVICE_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_SERVICE_INFO WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return QzgwServiceInfoDO
     */
    public QzgwServiceInfoDO getByPrimary(Integer id){
        return qzgwServiceInfoDOMapper.getByPrimary(id);

    }

    public List<QzgwServiceInfoDO> loadAll(){
        return qzgwServiceInfoDOMapper.loadAll();
    }
}
