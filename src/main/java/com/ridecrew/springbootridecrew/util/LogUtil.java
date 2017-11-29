package com.ridecrew.springbootridecrew.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;


public class LogUtil {
    public static String getStackTrace(Throwable e) {
        StringBuffer buffer = new StringBuffer();
        printStackTrace(buffer, e, false);
        return buffer.toString();
    }

    public static String getStackTrace(StackTraceElement[] stackTraceElements) {
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i < stackTraceElements.length; i++) {
            buffer.append("\tat " + stackTraceElements[i]);
            buffer.append("\r\n");
        }
        return buffer.toString();
    }

    public static void log(File logFile, Throwable e) {
        log(logFile, e, null);
    }

    public static void log(File logFile, Throwable e, String appendMessage) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(logFile, true);
            if(appendMessage != null) {
                IOUtils.write("\n" + appendMessage, fos);
            }
            IOUtils.write("\n"+getStackTrace(e), fos);
        } catch (FileNotFoundException e1) {
            throw new RuntimeException(e1);
        }catch (IOException e1) {
            throw new RuntimeException(e1);
        }finally {
            IOUtils.closeQuietly(fos);
        }
    }

    private static void printStackTrace(StringBuffer buffer, Throwable e, boolean cause) {
        if(cause) {
            buffer.append("Caused by: ");
        }
        buffer.append(e);
        buffer.append("\r\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (int i=0; i < trace.length; i++) {
            buffer.append("\tat " + trace[i]);
            buffer.append("\r\n");
        }
        Throwable ourCause = e.getCause();
        if (ourCause != null) {
            printStackTrace(buffer, ourCause, true);
        }
    }
}
