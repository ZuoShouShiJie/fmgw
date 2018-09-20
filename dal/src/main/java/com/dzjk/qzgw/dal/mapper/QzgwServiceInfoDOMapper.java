package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwServiceInfoDO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_SERVICE_INFO.
 * QZGW_SERVICE_INFO
 */
public interface QzgwServiceInfoDOMapper{

    /**
     * desc:插入表:QZGW_SERVICE_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_SERVICE_INFO( ID ,STATUS ,CREATOR ,MODIFIER ,CREATE_TIME ,SERVICE_CODE ,BELONG_SYSTEM ,MODIFIED_TIME )VALUES( #{id,jdbcType=INTEGER} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{serviceCode,jdbcType=VARCHAR} , #{belongSystem,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwServiceInfoDO entity);
    /**
     * desc:更新表:QZGW_SERVICE_INFO.<br/>
     * descSql =  UPDATE QZGW_SERVICE_INFO SET STATUS = #{status,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR} ,BELONG_SYSTEM = #{belongSystem,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwServiceInfoDO entity);
    /**
     * desc:根据主键删除数据:QZGW_SERVICE_INFO.<br/>
     * descSql =  DELETE FROM QZGW_SERVICE_INFO WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:QZGW_SERVICE_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_SERVICE_INFO WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return QzgwServiceInfoDO
     */
    QzgwServiceInfoDO getByPrimary(Integer id);

    List<QzgwServiceInfoDO> loadAll();
}
