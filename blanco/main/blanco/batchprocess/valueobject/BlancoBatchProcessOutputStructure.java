/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess.valueobject;

/**
 * blancoBatchProcess ��������������o�b�`�����N���X�̏o�͂�����킵�܂��B
 */
public class BlancoBatchProcessOutputStructure {
    /**
     * ����I�����̖߂�l�B
     *
     * �t�B�[���h: [END_SUCCESS]�B
     * �f�t�H���g: ["0"]�B
     */
    private String fEndSuccess = "0";

    /**
     * �o�b�`������O�I�����̖߂�l�B�w�肳��Ă���ꍇ�� BlancoBatchProcessException ����������܂��B�w�肳��Ȃ��ꍇ�ɂ� BlancoBatchProcessException �͐�������܂���B
     *
     * �t�B�[���h: [END_BATCH_PROCESS_EXCEPTION]�B
     */
    private String fEndBatchProcessException;

    /**
     * ���ُ͈�I�����̖߂�l�B
     *
     * �t�B�[���h: [END_ILLEGAL_ARGUMENT_EXCEPTION]�B
     * �f�t�H���g: ["7"]�B
     */
    private String fEndIllegalArgumentException = "7";

    /**
     * ���o�͗�O�I���̖߂�l�B
     *
     * �t�B�[���h: [END_IO_EXCEPTION]�B
     * �f�t�H���g: ["8"]�B
     */
    private String fEndIoException = "8";

    /**
     * �ُ�I�����̖߂�l�B
     *
     * �t�B�[���h: [END_ERROR]�B
     * �f�t�H���g: ["9"]�B
     */
    private String fEndError = "9";

    /**
     * �����B
     *
     * �t�B�[���h: [DESCRIPTION]�B
     */
    private String fDescription;

    /**
     * �t�B�[���h [END_SUCCESS] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����I�����̖߂�l�B]�B
     *
     * @param argEndSuccess �t�B�[���h[END_SUCCESS]�ɐݒ肷��l�B
     */
    public void setEndSuccess(final String argEndSuccess) {
        fEndSuccess = argEndSuccess;
    }

    /**
     * �t�B�[���h [END_SUCCESS] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����I�����̖߂�l�B]�B
     * �f�t�H���g: ["0"]�B
     *
     * @return �t�B�[���h[END_SUCCESS]����擾�����l�B
     */
    public String getEndSuccess() {
        return fEndSuccess;
    }

    /**
     * �t�B�[���h [END_BATCH_PROCESS_EXCEPTION] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�o�b�`������O�I�����̖߂�l�B�w�肳��Ă���ꍇ�� BlancoBatchProcessException ����������܂��B�w�肳��Ȃ��ꍇ�ɂ� BlancoBatchProcessException �͐�������܂���B]�B
     *
     * @param argEndBatchProcessException �t�B�[���h[END_BATCH_PROCESS_EXCEPTION]�ɐݒ肷��l�B
     */
    public void setEndBatchProcessException(final String argEndBatchProcessException) {
        fEndBatchProcessException = argEndBatchProcessException;
    }

    /**
     * �t�B�[���h [END_BATCH_PROCESS_EXCEPTION] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�o�b�`������O�I�����̖߂�l�B�w�肳��Ă���ꍇ�� BlancoBatchProcessException ����������܂��B�w�肳��Ȃ��ꍇ�ɂ� BlancoBatchProcessException �͐�������܂���B]�B
     *
     * @return �t�B�[���h[END_BATCH_PROCESS_EXCEPTION]����擾�����l�B
     */
    public String getEndBatchProcessException() {
        return fEndBatchProcessException;
    }

    /**
     * �t�B�[���h [END_ILLEGAL_ARGUMENT_EXCEPTION] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���ُ͈�I�����̖߂�l�B]�B
     *
     * @param argEndIllegalArgumentException �t�B�[���h[END_ILLEGAL_ARGUMENT_EXCEPTION]�ɐݒ肷��l�B
     */
    public void setEndIllegalArgumentException(final String argEndIllegalArgumentException) {
        fEndIllegalArgumentException = argEndIllegalArgumentException;
    }

    /**
     * �t�B�[���h [END_ILLEGAL_ARGUMENT_EXCEPTION] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���ُ͈�I�����̖߂�l�B]�B
     * �f�t�H���g: ["7"]�B
     *
     * @return �t�B�[���h[END_ILLEGAL_ARGUMENT_EXCEPTION]����擾�����l�B
     */
    public String getEndIllegalArgumentException() {
        return fEndIllegalArgumentException;
    }

    /**
     * �t�B�[���h [END_IO_EXCEPTION] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���o�͗�O�I���̖߂�l�B]�B
     *
     * @param argEndIoException �t�B�[���h[END_IO_EXCEPTION]�ɐݒ肷��l�B
     */
    public void setEndIoException(final String argEndIoException) {
        fEndIoException = argEndIoException;
    }

    /**
     * �t�B�[���h [END_IO_EXCEPTION] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���o�͗�O�I���̖߂�l�B]�B
     * �f�t�H���g: ["8"]�B
     *
     * @return �t�B�[���h[END_IO_EXCEPTION]����擾�����l�B
     */
    public String getEndIoException() {
        return fEndIoException;
    }

    /**
     * �t�B�[���h [END_ERROR] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�ُ�I�����̖߂�l�B]�B
     *
     * @param argEndError �t�B�[���h[END_ERROR]�ɐݒ肷��l�B
     */
    public void setEndError(final String argEndError) {
        fEndError = argEndError;
    }

    /**
     * �t�B�[���h [END_ERROR] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�ُ�I�����̖߂�l�B]�B
     * �f�t�H���g: ["9"]�B
     *
     * @return �t�B�[���h[END_ERROR]����擾�����l�B
     */
    public String getEndError() {
        return fEndError;
    }

    /**
     * �t�B�[���h [DESCRIPTION] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����B]�B
     *
     * @param argDescription �t�B�[���h[DESCRIPTION]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [DESCRIPTION] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����B]�B
     *
     * @return �t�B�[���h[DESCRIPTION]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.batchprocess.valueobject.BlancoBatchProcessOutputStructure[");
        buf.append("END_SUCCESS=" + fEndSuccess);
        buf.append(",END_BATCH_PROCESS_EXCEPTION=" + fEndBatchProcessException);
        buf.append(",END_ILLEGAL_ARGUMENT_EXCEPTION=" + fEndIllegalArgumentException);
        buf.append(",END_IO_EXCEPTION=" + fEndIoException);
        buf.append(",END_ERROR=" + fEndError);
        buf.append(",DESCRIPTION=" + fDescription);
        buf.append("]");
        return buf.toString();
    }
}
