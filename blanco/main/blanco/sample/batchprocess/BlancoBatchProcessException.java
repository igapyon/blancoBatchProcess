/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.sample.batchprocess;

/**
 * �o�b�`�����ɂ����ė�O�����������ۂɗ��p����܂��BblancoBatchProcess�̗�O�ł��B
 */
@SuppressWarnings("serial")
public class BlancoBatchProcessException extends RuntimeException {
    /**
     * �ڍ׃��b�Z�[�W�������Ȃ���O���\�z���܂��B
     */
    public BlancoBatchProcessException() {
        super();
    }

    /**
     * �w�肳�ꂽ�ڍ׃��b�Z�[�W������O���\�z���܂��B
     *
     * @param message �ڍ׃��b�Z�[�W�B
     */
    public BlancoBatchProcessException(final String message) {
        super(message);
    }

    /**
     * �w�肳�ꂽ�ڍ׃��b�Z�[�W����ь������w�肵�ė�O���\�z���܂��B
     *
     * @param message �ڍ׃��b�Z�[�W�B
     * @param cause �����B
     */
    public BlancoBatchProcessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * �������w�肵�ė�O���\�z���܂��B
     *
     * @param cause �����B
     */
    public BlancoBatchProcessException(final Throwable cause) {
        super(cause);
    }
}
