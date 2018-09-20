package com.dzjk.qzgw.dal.mapper;

import com.dzjk.qzgw.dal.dataobject.QzgwCacheRefreshSyncDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table QZGW_CACHE_REFRESH_SYNC.
 * QZGW_CACHE_REFRESH_SYNC
 */
public interface QzgwCacheRefreshSyncDOMapper{

    /**
     * desc:插入表:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_CACHE_REFRESH_SYNC( NAME ,LATEST_NO ,CREATE_TIME ,MODIFY_TIME ,SERVICE_CODE )VALUES( #{name,jdbcType=VARCHAR} , #{latestNo,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{modifyTime,jdbcType=TIMESTAMP} , #{serviceCode,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(QzgwCacheRefreshSyncDO entity);
    /**
     * desc:更新表:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  UPDATE QZGW_CACHE_REFRESH_SYNC SET LATEST_NO = #{latestNo,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    Long update(QzgwCacheRefreshSyncDO entity);
    /**
     * desc:根据主键删除数据:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  DELETE FROM QZGW_CACHE_REFRESH_SYNC WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
    * @param params params
    * the define of params
    *     name name
    *     serviceCode serviceCode
     * @return Long
     */
    Long deleteByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  SELECT * FROM QZGW_CACHE_REFRESH_SYNC WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
    * @param params params
    * the define of params
    *     name name
    *     serviceCode serviceCode
     * @return QzgwCacheRefreshSyncDO
     */
    QzgwCacheRefreshSyncDO getByPrimary(Map<String,Object> params);
}
