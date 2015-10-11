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

import java.util.List;

/**
 * blancoBatchProcess ��������������o�b�`�����N���X�̊e���������킵�܂��B
 */
public class BlancoBatchProcessStructure {
    /**
     * ���b�Z�[�W��`ID���w�肵�܂��B�K�{���ڂł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * �p�b�P�[�W�����w�肵�܂��B�K�{���ڂł��B
     *
     * �t�B�[���h: [package]�B
     */
    private String fPackage;

    /**
     * ���b�Z�[�W��`�̐������L�ڂ��܂��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * �N���X���̌���ɕt�^�����T�t�B�b�N�X�B
     *
     * �t�B�[���h: [suffix]�B
     */
    private String fSuffix;

    /**
     * �t�B�[���h��ێ����郊�X�g�B
     *
     * �t�B�[���h: [inputItemList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure>()]�B
     */
    private List<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure> fInputItemList = new java.util.ArrayList<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure>();

    /**
     * �߂�l���L������t�B�[���h�B
     *
     * �t�B�[���h: [output]�B
     */
    private BlancoBatchProcessOutputStructure fOutput;

    /**
     * �o�b�`�̊J�n�E�I�����b�Z�[�W��\�����邩�ǂ����BblancoBatchProcess�P�̂ŗ��p����ꍇ�ɂ�true��ݒ肵�܂��B���v���_�N�g�ւ̑g�ݍ��ݎ���false��ݒ肵�܂��B
     *
     * �t�B�[���h: [showMessageBeginEnd]�B
     * �f�t�H���g: [true]�B
     */
    private boolean fShowMessageBeginEnd = true;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���b�Z�[�W��`ID���w�肵�܂��B�K�{���ڂł��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���b�Z�[�W��`ID���w�肵�܂��B�K�{���ڂł��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [package] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�p�b�P�[�W�����w�肵�܂��B�K�{���ڂł��B]�B
     *
     * @param argPackage �t�B�[���h[package]�ɐݒ肷��l�B
     */
    public void setPackage(final String argPackage) {
        fPackage = argPackage;
    }

    /**
     * �t�B�[���h [package] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�p�b�P�[�W�����w�肵�܂��B�K�{���ڂł��B]�B
     *
     * @return �t�B�[���h[package]����擾�����l�B
     */
    public String getPackage() {
        return fPackage;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���b�Z�[�W��`�̐������L�ڂ��܂��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���b�Z�[�W��`�̐������L�ڂ��܂��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [suffix] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�N���X���̌���ɕt�^�����T�t�B�b�N�X�B]�B
     *
     * @param argSuffix �t�B�[���h[suffix]�ɐݒ肷��l�B
     */
    public void setSuffix(final String argSuffix) {
        fSuffix = argSuffix;
    }

    /**
     * �t�B�[���h [suffix] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�N���X���̌���ɕt�^�����T�t�B�b�N�X�B]�B
     *
     * @return �t�B�[���h[suffix]����擾�����l�B
     */
    public String getSuffix() {
        return fSuffix;
    }

    /**
     * �t�B�[���h [inputItemList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�t�B�[���h��ێ����郊�X�g�B]�B
     *
     * @param argInputItemList �t�B�[���h[inputItemList]�ɐݒ肷��l�B
     */
    public void setInputItemList(final List<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure> argInputItemList) {
        fInputItemList = argInputItemList;
    }

    /**
     * �t�B�[���h [inputItemList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�t�B�[���h��ێ����郊�X�g�B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure>()]�B
     *
     * @return �t�B�[���h[inputItemList]����擾�����l�B
     */
    public List<blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure> getInputItemList() {
        return fInputItemList;
    }

    /**
     * �t�B�[���h [output] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�߂�l���L������t�B�[���h�B]�B
     *
     * @param argOutput �t�B�[���h[output]�ɐݒ肷��l�B
     */
    public void setOutput(final BlancoBatchProcessOutputStructure argOutput) {
        fOutput = argOutput;
    }

    /**
     * �t�B�[���h [output] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�߂�l���L������t�B�[���h�B]�B
     *
     * @return �t�B�[���h[output]����擾�����l�B
     */
    public BlancoBatchProcessOutputStructure getOutput() {
        return fOutput;
    }

    /**
     * �t�B�[���h [showMessageBeginEnd] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�o�b�`�̊J�n�E�I�����b�Z�[�W��\�����邩�ǂ����BblancoBatchProcess�P�̂ŗ��p����ꍇ�ɂ�true��ݒ肵�܂��B���v���_�N�g�ւ̑g�ݍ��ݎ���false��ݒ肵�܂��B]�B
     *
     * @param argShowMessageBeginEnd �t�B�[���h[showMessageBeginEnd]�ɐݒ肷��l�B
     */
    public void setShowMessageBeginEnd(final boolean argShowMessageBeginEnd) {
        fShowMessageBeginEnd = argShowMessageBeginEnd;
    }

    /**
     * �t�B�[���h [showMessageBeginEnd] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�o�b�`�̊J�n�E�I�����b�Z�[�W��\�����邩�ǂ����BblancoBatchProcess�P�̂ŗ��p����ꍇ�ɂ�true��ݒ肵�܂��B���v���_�N�g�ւ̑g�ݍ��ݎ���false��ݒ肵�܂��B]�B
     * �f�t�H���g: [true]�B
     *
     * @return �t�B�[���h[showMessageBeginEnd]����擾�����l�B
     */
    public boolean getShowMessageBeginEnd() {
        return fShowMessageBeginEnd;
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
        buf.append("blanco.batchprocess.valueobject.BlancoBatchProcessStructure[");
        buf.append("name=" + fName);
        buf.append(",package=" + fPackage);
        buf.append(",description=" + fDescription);
        buf.append(",suffix=" + fSuffix);
        buf.append(",inputItemList=" + fInputItemList);
        buf.append(",output=" + fOutput);
        buf.append(",showMessageBeginEnd=" + fShowMessageBeginEnd);
        buf.append("]");
        return buf.toString();
    }
}
