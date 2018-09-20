package com.dzjk.qzgw.endpoint.convert;

import com.dzjk.qzgw.dal.dataobject.QzgwServiceInfoDO;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceOrgDO;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceOrgVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceInfoConvert {
    public static List<QzgwServiceInfoVo> reConvert(List<QzgwServiceInfoDO> qzgwServiceInfoDOS) {
        List<QzgwServiceInfoVo> qzgwServiceInfoVos = new ArrayList<QzgwServiceInfoVo>();
        for (QzgwServiceInfoDO qzgwServiceInfoDO : qzgwServiceInfoDOS) {
            QzgwServiceInfoVo qzgwServiceOrgVo = reConvert(qzgwServiceInfoDO);
            if (qzgwServiceOrgVo != null) {
                qzgwServiceInfoVos.add(qzgwServiceOrgVo);
            }
        }
        return qzgwServiceInfoVos;
    }

    public static QzgwServiceInfoVo reConvert(QzgwServiceInfoDO qzgwServiceInfoDO) {
        QzgwServiceInfoVo qzgwServiceInfoVo = new QzgwServiceInfoVo();
        qzgwServiceInfoVo.setId(qzgwServiceInfoDO.getId());
        qzgwServiceInfoVo.setStatus(qzgwServiceInfoDO.getStatus());
        qzgwServiceInfoVo.setServiceCode(qzgwServiceInfoDO.getServiceCode());
        qzgwServiceInfoVo.setServiceName(qzgwServiceInfoDO.getServiceName());
        qzgwServiceInfoVo.setBelongSystem(qzgwServiceInfoDO.getBelongSystem());
        return qzgwServiceInfoVo;
    }
}
