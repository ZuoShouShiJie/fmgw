package com.dzjk.qzgw.facade.model;

import com.basic.framework.core.base.AbstractModel;

/**
 * Created by daixiaohu on 2018/5/2.
 */
public class FmgwResponse extends AbstractModel{
    private Header header;
    private Message message;
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
