package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_ORG_INFO.
 * QZGW_ORG_INFO
 */
public interface QzgwOrgInfoDOMapper{

    /**
     * desc:插入表:QZGW_ORG_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_ORG_INFO( ID ,ORG_PWD ,STATUS ,CREATOR ,ORG_CODE ,ORG_USER ,MODIFIER ,CREATE_TIME ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{orgPwd,jdbcType=VARCHAR} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{orgCode,jdbcType=VARCHAR} , #{orgUser,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwOrgInfoDO entity);
    /**
     * desc:更新表:QZGW_ORG_INFO.<br/>
     * descSql =  UPDATE QZGW_ORG_INFO SET ORG_PWD = #{orgPwd,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,ORG_CODE = #{orgCode,jdbcType=VARCHAR} ,ORG_USER = #{orgUser,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwOrgInfoDO entity);
    /**
     * desc:根据主键删除数据:QZGW_ORG_INFO.<br/>
     * descSql =  DELETE FROM QZGW_ORG_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:QZGW_ORG_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_ORG_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwOrgInfoDO
     */
    QzgwOrgInfoDO getByPrimary(Long id);

    List<QzgwOrgInfoDO> loadAll();

}
