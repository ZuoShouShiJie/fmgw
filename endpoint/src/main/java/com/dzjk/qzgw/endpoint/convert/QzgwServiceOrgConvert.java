package com.dzjk.qzgw.endpoint.convert;

import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceOrgDO;
import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceOrgVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceOrgConvert {
    public static List<QzgwServiceOrgVo> reConvert(List<QzgwServiceOrgDO> qzgwServiceOrgDOS) {
        List<QzgwServiceOrgVo> qzgwServiceOrgVos = new ArrayList<QzgwServiceOrgVo>();
        for (QzgwServiceOrgDO qzgwServiceOrgDO : qzgwServiceOrgDOS) {
            QzgwServiceOrgVo qzgwServiceOrgVo = reConvert(qzgwServiceOrgDO);
            if (qzgwServiceOrgVo != null) {
                qzgwServiceOrgVos.add(qzgwServiceOrgVo);
            }
        }
        return qzgwServiceOrgVos;
    }

    public static QzgwServiceOrgVo reConvert(QzgwServiceOrgDO qzgwServiceOrgDO) {
        QzgwServiceOrgVo qzgwServiceOrgVo = new QzgwServiceOrgVo();
        qzgwServiceOrgVo.setId(qzgwServiceOrgDO.getId());
        qzgwServiceOrgVo.setServiceCode(qzgwServiceOrgDO.getServiceCode());
        qzgwServiceOrgVo.setBelongOrgCode(qzgwServiceOrgDO.getBelongOrgCode());
        qzgwServiceOrgVo.setStatus(qzgwServiceOrgDO.getStatus());
        return qzgwServiceOrgVo;
    }
}
