package com.dzjk.qzgw.core.common.util;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.VelocityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by daixiaohu on 2018/4/18.
 */
public final class VelocityUtil {
    private static final Logger logger = LoggerFactory.getLogger(VelocityUtil.class);
    public static final String SENSITIVE = "sensitive";

    public VelocityUtil() {
    }

    public static String evaluate(VelocityContext context, String template) throws IOException, ParseErrorException, MethodInvocationException, VelocityException {
        StringWriter writer = new StringWriter();

        String var3;
        try {
            Velocity.evaluate(context, writer, "", template);
            var3 = writer.toString();
        } finally {
            IOUtils.closeQuietly(writer);
        }

        return var3;
    }

}