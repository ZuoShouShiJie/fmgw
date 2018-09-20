package com.dzjk.qzgw.dal.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;
import com.dzjk.qzgw.dal.mapper.QzgwOrgInfoDOMapper;

/**
* The Table QZGW_ORG_INFO.
* QZGW_ORG_INFO
*/
@Repository("qzgw.QzgwOrgInfoDAO")
public class QzgwOrgInfoDAO{

    @Autowired
    private QzgwOrgInfoDOMapper qzgwOrgInfoDOMapper;

    /**
     * desc:插入表:QZGW_ORG_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_ORG_INFO( ID ,ORG_PWD ,STATUS ,CREATOR ,ORG_CODE ,ORG_USER ,MODIFIER ,CREATE_TIME ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{orgPwd,jdbcType=VARCHAR} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{orgCode,jdbcType=VARCHAR} , #{orgUser,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(QzgwOrgInfoDO entity){
        return qzgwOrgInfoDOMapper.insert(entity);

    }
    /**
     * desc:更新表:QZGW_ORG_INFO.<br/>
     * descSql =  UPDATE QZGW_ORG_INFO SET ORG_PWD = #{orgPwd,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,ORG_CODE = #{orgCode,jdbcType=VARCHAR} ,ORG_USER = #{orgUser,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(QzgwOrgInfoDO entity){
        return qzgwOrgInfoDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:QZGW_ORG_INFO.<br/>
     * descSql =  DELETE FROM QZGW_ORG_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Long id){
        return qzgwOrgInfoDOMapper.deleteByPrimary(id);

    }
    /**
     * desc:根据主键获取数据:QZGW_ORG_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_ORG_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwOrgInfoDO
     */
    public QzgwOrgInfoDO getByPrimary(Long id){
        return qzgwOrgInfoDOMapper.getByPrimary(id);

    }

    public List<QzgwOrgInfoDO> loadAll(){
        return qzgwOrgInfoDOMapper.loadAll();
    }

}
