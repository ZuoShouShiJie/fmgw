package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwSystemInfoDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_SYSTEM_INFO.
 * QZGW_SYSTEM_INFO
 */
public interface QzgwSystemInfoDOMapper{

    /**
     * desc:插入表:QZGW_SYSTEM_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_SYSTEM_INFO( ID ,STATUS ,CREATOR ,MODIFIER ,CREATE_TIME ,SYSTEM_CODE ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{systemCode,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwSystemInfoDO entity);
    /**
     * desc:更新表:QZGW_SYSTEM_INFO.<br/>
     * descSql =  UPDATE QZGW_SYSTEM_INFO SET STATUS = #{status,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwSystemInfoDO entity);
    /**
     * desc:根据主键删除数据:QZGW_SYSTEM_INFO.<br/>
     * descSql =  DELETE FROM QZGW_SYSTEM_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:QZGW_SYSTEM_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_SYSTEM_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwSystemInfoDO
     */
    QzgwSystemInfoDO getByPrimary(Long id);
}
