package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwServiceOrgDO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_SERVICE_ORG.
 * QZGW_SERVICE_ORG
 */
public interface QzgwServiceOrgDOMapper{

    /**
     * desc:插入表:QZGW_SERVICE_ORG.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_SERVICE_ORG( ID ,STATUS ,CREATOR ,MODIFIER ,CREATE_TIME ,SERVICE_CODE ,MODIFIED_TIME ,BELONG_ORG_CODE )VALUES( #{id,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{serviceCode,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} , #{belongOrgCode,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwServiceOrgDO entity);
    /**
     * desc:更新表:QZGW_SERVICE_ORG.<br/>
     * descSql =  UPDATE QZGW_SERVICE_ORG SET STATUS = #{status,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} ,BELONG_ORG_CODE = #{belongOrgCode,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwServiceOrgDO entity);
    /**
     * desc:根据主键删除数据:QZGW_SERVICE_ORG.<br/>
     * descSql =  DELETE FROM QZGW_SERVICE_ORG WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:QZGW_SERVICE_ORG.<br/>
     * descSql =  SELECT * FROM QZGW_SERVICE_ORG WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwServiceOrgDO
     */
    QzgwServiceOrgDO getByPrimary(Long id);

    List<QzgwServiceOrgDO> loadAll();
}
