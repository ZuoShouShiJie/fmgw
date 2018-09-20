package com.dzjk.qzgw.endpoint.convert;

import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import com.dzjk.qzgw.facade.model.vo.QzgwKeyManagerVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwKeyManagerConvert {

    public static List<QzgwKeyManagerVo> reConvert(List<QzgwKeyManagerDO> qzgwKeyManagerDOS) {
        List<QzgwKeyManagerVo> qzgwKeyManagerVos = new ArrayList<QzgwKeyManagerVo>();
        for (QzgwKeyManagerDO qzgwKeyManagerDO : qzgwKeyManagerDOS) {
            QzgwKeyManagerVo qzgwKeyManagerVo = reConvert(qzgwKeyManagerDO);
            if (qzgwKeyManagerVo != null) {
                qzgwKeyManagerVos.add(qzgwKeyManagerVo);
            }
        }
        return qzgwKeyManagerVos;
    }

    public static QzgwKeyManagerVo reConvert(QzgwKeyManagerDO qzgwKeyManagerDO) {
        QzgwKeyManagerVo qzgwKeyManagerVo = new QzgwKeyManagerVo();
        qzgwKeyManagerVo.setOrgCode(qzgwKeyManagerDO.getOrgCode());
        qzgwKeyManagerVo.setPublicKey(qzgwKeyManagerDO.getPublicKey());
        qzgwKeyManagerVo.setPrivateKey(qzgwKeyManagerDO.getPrivateKey());
        return qzgwKeyManagerVo;
    }
}
