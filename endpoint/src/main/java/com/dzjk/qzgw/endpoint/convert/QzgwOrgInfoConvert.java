package com.dzjk.qzgw.endpoint.convert;

import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;
import com.dzjk.qzgw.facade.model.vo.QzgwKeyManagerVo;
import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwOrgInfoConvert {

    public static List<QzgwOrgInfoVo> reConvert(List<QzgwOrgInfoDO> qzgwOrgInfoDOS) {
        List<QzgwOrgInfoVo> qzgwOrgInfoVos = new ArrayList<QzgwOrgInfoVo>();
        for (QzgwOrgInfoDO qzgwOrgInfoDO : qzgwOrgInfoDOS) {
            QzgwOrgInfoVo qzgwOrgInfoVo = reConvert(qzgwOrgInfoDO);
            if (qzgwOrgInfoVo != null) {
                qzgwOrgInfoVos.add(qzgwOrgInfoVo);
            }
        }
        return qzgwOrgInfoVos;
    }

    public static QzgwOrgInfoVo reConvert(QzgwOrgInfoDO qzgwOrgInfoDO) {
        QzgwOrgInfoVo qzgwOrgInfoVo = new QzgwOrgInfoVo();
        qzgwOrgInfoVo.setId(qzgwOrgInfoDO.getId());
        qzgwOrgInfoVo.setOrgCode(qzgwOrgInfoDO.getOrgCode());
        qzgwOrgInfoVo.setOrgUser(qzgwOrgInfoDO.getOrgUser());
        qzgwOrgInfoVo.setOrgPwd(qzgwOrgInfoDO.getOrgPwd());
        qzgwOrgInfoVo.setStatus(qzgwOrgInfoDO.getStatus());

        return qzgwOrgInfoVo;
    }
}
