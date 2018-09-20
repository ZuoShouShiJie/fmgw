package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwTransInfoDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_TRANS_INFO.
 * QZGW_TRANS_INFO
 */
public interface QzgwTransInfoDOMapper{

    /**
     * desc:插入表:QZGW_TRANS_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_TRANS_INFO( ID ,STATUS ,CREATOR ,ORG_CODE ,TRANS_NO ,MODIFIER ,CREATE_TIME ,REQUEST_MSG ,SYSTEM_CODE ,RESPONSE_MSG ,SERVICE_CODE ,MODIFIED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{creator,jdbcType=VARCHAR} , #{orgCode,jdbcType=VARCHAR} , #{transNo,jdbcType=VARCHAR} , #{modifier,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{requestMsg,jdbcType=LONGVARCHAR} , #{systemCode,jdbcType=VARCHAR} , #{responseMsg,jdbcType=LONGVARCHAR} , #{serviceCode,jdbcType=VARCHAR} , #{modifiedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwTransInfoDO entity);
    /**
     * desc:更新表:QZGW_TRANS_INFO.<br/>
     * descSql =  UPDATE QZGW_TRANS_INFO SET STATUS = #{status,jdbcType=VARCHAR} ,ORG_CODE = #{orgCode,jdbcType=VARCHAR} ,TRANS_NO = #{transNo,jdbcType=VARCHAR} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,REQUEST_MSG = #{requestMsg,jdbcType=LONGVARCHAR} ,SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ,RESPONSE_MSG = #{responseMsg,jdbcType=LONGVARCHAR} ,SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR} ,MODIFIED_TIME = #{modifiedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwTransInfoDO entity);
    /**
     * desc:根据主键删除数据:QZGW_TRANS_INFO.<br/>
     * descSql =  DELETE FROM QZGW_TRANS_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:QZGW_TRANS_INFO.<br/>
     * descSql =  SELECT * FROM QZGW_TRANS_INFO WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return QzgwTransInfoDO
     */
    QzgwTransInfoDO getByPrimary(Long id);
}
