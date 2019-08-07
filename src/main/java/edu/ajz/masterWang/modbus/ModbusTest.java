package edu.ajz.masterWang.modbus;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName ModbusTest
 * @Description TODO
 * @Author master wang
 * @Date 2019/4/23 21:30
 * @Version 1.0
 **/
public class ModbusTest {

    CommPort commPort = new CommPort() {
        @Override
        public void enableReceiveFraming(int i) throws UnsupportedCommOperationException {

        }

        @Override
        public void disableReceiveFraming() {

        }

        @Override
        public boolean isReceiveFramingEnabled() {
            return false;
        }

        @Override
        public int getReceiveFramingByte() {
            return 0;
        }

        @Override
        public void disableReceiveTimeout() {

        }

        @Override
        public void enableReceiveTimeout(int i) throws UnsupportedCommOperationException {

        }

        @Override
        public boolean isReceiveTimeoutEnabled() {
            return false;
        }

        @Override
        public int getReceiveTimeout() {
            return 0;
        }

        @Override
        public void enableReceiveThreshold(int i) throws UnsupportedCommOperationException {

        }

        @Override
        public void disableReceiveThreshold() {

        }

        @Override
        public int getReceiveThreshold() {
            return 0;
        }

        @Override
        public boolean isReceiveThresholdEnabled() {
            return false;
        }

        @Override
        public void setInputBufferSize(int i) {

        }

        @Override
        public int getInputBufferSize() {
            return 0;
        }

        @Override
        public void setOutputBufferSize(int i) {

        }

        @Override
        public int getOutputBufferSize() {
            return 0;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return null;
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            return null;
        }
    };

}
