/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess;

import java.io.File;
import java.io.IOException;

import blanco.batchprocess.message.BlancoBatchProcessMessage;
import blanco.batchprocess.stringgroup.BlancoBatchProcessSupportedLangStringGroup;
import blanco.batchprocess.valueobject.BlancoBatchProcessStructure;

/**
 * �u�o�b�`������`���vExcel�l������o�b�`�������������钊�ېe�N���X�E�\�[�X�R�[�h�𐶐��B
 * 
 * ���̃N���X�́A����XML�t�@�C������\�[�X�R�[�h��������������@�\��S���܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoBatchProcessXml2SourceFile {
    /**
     * ���b�Z�[�W�N���X�B
     */
    protected final BlancoBatchProcessMessage fMsg = new BlancoBatchProcessMessage();

    /**
     * ������������\�[�X�t�@�C���̕����G���R�[�f�B���O�B
     */
    private String fEncoding = null;

    /**
     * ������������\�[�X�t�@�C���̕����G���R�[�f�B���O���w�肵�܂��B
     * 
     * @param argEncoding
     *            ������������\�[�X�t�@�C���̕����G���R�[�f�B���O�B
     */
    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * ����XML�t�@�C������\�[�X�R�[�h�������������܂��B
     * 
     * @param argMetaXmlSourceFile
     *            ���^��񂪊܂܂�Ă���XML�t�@�C���B
     * @param argRuntimePackage
     *            �����^�C���p�b�P�[�W�Bnull����ђ���0�̕�����̏ꍇ�͒�`�����ƂɃ����^�C���N���X�𐶐��B
     * @param argTargetLang
     *            �o�͑Ώۃv���O���~���O����B
     * @param argDirectoryTarget
     *            �\�[�X�R�[�h������f�B���N�g�� (/main�������������w�肵�܂�)�B
     * @throws IOException
     *             ���o�͗�O�����������ꍇ�B
     */
    public void process(final File argMetaXmlSourceFile,
            final String argRuntimePackage, final String argTargetLang,
            final File argDirectoryTarget) throws IOException {

        final BlancoBatchProcessStructure[] structures = new BlancoBatchProcessXmlParser()
                .parse(argMetaXmlSourceFile);
        if (structures == null || structures.length == 0) {
            // �������Ȃ��B
            return;
        }

        for (int index = 0; index < structures.length; index++) {
            // ���^���̉�͌��ʂ����ƂɃ\�[�X�R�[�h�������������s���܂��B
            structure2Source(structures[index], argRuntimePackage,
                    argTargetLang, argDirectoryTarget);
        }
    }

    /**
     * �^����ꂽ�N���X���o�����[�I�u�W�F�N�g����AJava�\�[�X�R�[�h�������������܂��B
     * 
     * @param argStructure
     *            ���B
     * @param argDirectoryTarget
     *            �\�[�X�R�[�h�̏o�͐�f�B���N�g��
     * @throws IOException
     *             ���o�͗�O�����������ꍇ�B
     */
    public void structure2Source(
            final BlancoBatchProcessStructure argStructure,
            final String argRuntimePackage, final String argTargetLang,
            final File argDirectoryTarget) throws IOException {
        final int targetLang = new BlancoBatchProcessSupportedLangStringGroup()
                .convertToInt(argTargetLang);
        if (targetLang == BlancoBatchProcessSupportedLangStringGroup.NOT_DEFINED) {
            throw new IllegalArgumentException(fMsg.getMbbpi002(argTargetLang));
        }

        final BlancoBatchProcessExpandBatchProcess expandBatchProcess = new BlancoBatchProcessExpandBatchProcess();
        expandBatchProcess.setEncoding(fEncoding);
        expandBatchProcess.expandSourceFile(argStructure, argRuntimePackage,
                targetLang, argDirectoryTarget);

        final BlancoBatchProcessExpandProcess expandProcess = new BlancoBatchProcessExpandProcess();
        expandProcess.setEncoding(fEncoding);
        expandProcess.expandSourceFile(argStructure, argRuntimePackage,
                targetLang, argDirectoryTarget);
    }
}
