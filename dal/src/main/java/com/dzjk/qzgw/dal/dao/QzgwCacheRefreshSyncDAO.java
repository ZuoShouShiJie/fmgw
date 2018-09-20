package com.dzjk.qzgw.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.qzgw.dal.dataobject.QzgwCacheRefreshSyncDO;
import com.dzjk.qzgw.dal.mapper.QzgwCacheRefreshSyncDOMapper;

/**
* The Table QZGW_CACHE_REFRESH_SYNC.
* QZGW_CACHE_REFRESH_SYNC
*/
@Repository("qzgw.QzgwCacheRefreshSyncDAO")
public class QzgwCacheRefreshSyncDAO{

    @Autowired
    private QzgwCacheRefreshSyncDOMapper qzgwCacheRefreshSyncDOMapper;

    /**
     * desc:插入表:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO QZGW_CACHE_REFRESH_SYNC( NAME ,LATEST_NO ,CREATE_TIME ,MODIFY_TIME ,SERVICE_CODE )VALUES( #{name,jdbcType=VARCHAR} , #{latestNo,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{modifyTime,jdbcType=TIMESTAMP} , #{serviceCode,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(QzgwCacheRefreshSyncDO entity){
        return qzgwCacheRefreshSyncDOMapper.insert(entity);

    }
    /**
     * desc:更新表:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  UPDATE QZGW_CACHE_REFRESH_SYNC SET LATEST_NO = #{latestNo,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    public Long update(QzgwCacheRefreshSyncDO entity){
        return qzgwCacheRefreshSyncDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  DELETE FROM QZGW_CACHE_REFRESH_SYNC WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
     * @param name name
     * @param serviceCode serviceCode
     * @return Long
     */
    public Long deleteByPrimary(String name,String serviceCode){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("name",name);
        params.put("serviceCode",serviceCode);
        return qzgwCacheRefreshSyncDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:QZGW_CACHE_REFRESH_SYNC.<br/>
     * descSql =  SELECT * FROM QZGW_CACHE_REFRESH_SYNC WHERE NAME = #{name,jdbcType=VARCHAR} AND SERVICE_CODE = #{serviceCode,jdbcType=VARCHAR}
     * @param name name
     * @param serviceCode serviceCode
     * @return QzgwCacheRefreshSyncDO
     */
    public QzgwCacheRefreshSyncDO getByPrimary(String name,String serviceCode){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("name",name);
        params.put("serviceCode",serviceCode);
        return qzgwCacheRefreshSyncDOMapper.getByPrimary(params);

    }
}
