/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess.task;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import blanco.batchprocess.BlancoBatchProcessConstants;
import blanco.batchprocess.BlancoBatchProcessMeta2Xml;
import blanco.batchprocess.BlancoBatchProcessXml2SourceFile;
import blanco.batchprocess.message.BlancoBatchProcessMessage;
import blanco.batchprocess.task.valueobject.BlancoBatchProcessProcessInput;

/**
 * �o�b�`�������������̎��ۂ̏������e�B
 */
public class BlancoBatchProcessProcessImpl implements BlancoBatchProcessProcess {
    /**
     * ���b�Z�[�W�N���X�B
     */
    protected final BlancoBatchProcessMessage fMsg = new BlancoBatchProcessMessage();

    protected BlancoBatchProcessProcessInput fInput;

    /**
     * ��̓I�ȃo�b�`�������e���L�q���邽�߂̃��\�b�h�ł��B
     * 
     * ���̃��\�b�h�Ɏ��ۂ̏������e���L�q���܂��B
     * 
     * @param input
     *            �o�b�`�����̓��̓p�����[�^�B
     * @return �o�b�`�����̏I���R�[�h�B����I���̏ꍇ�ɂ́ABlancoBatchProcessBatchProcess.END_SUCCESS�B
     * @throws IOException
     *             ���o�͗�O�����������ꍇ�B
     * @throws IllegalArgumentException
     *             ���͒l�ɕs�������������ꍇ�B
     */
    public int execute(final BlancoBatchProcessProcessInput input)
            throws IOException, IllegalArgumentException {
        fInput = input;
        System.out.println("- " + BlancoBatchProcessConstants.PRODUCT_NAME
                + " (" + BlancoBatchProcessConstants.VERSION + ")");

        try {
            final File fileMetadir = new File(input.getMetadir());
            if (fileMetadir.exists() == false) {
                throw new IllegalArgumentException(fMsg.getMbbpa001(input
                        .getMetadir()));
            }

            // �e���|�����f�B���N�g�����쐬�B
            new File(input.getTmpdir()
                    + BlancoBatchProcessConstants.TARGET_SUBDIRECTORY).mkdirs();

            // �w�肳�ꂽ���^�f�B���N�g�����������܂��B
            new BlancoBatchProcessMeta2Xml().processDirectory(fileMetadir,
                    input.getTmpdir()
                            + BlancoBatchProcessConstants.TARGET_SUBDIRECTORY);

            // XML�����ꂽ���ԃt�@�C������\�[�X�R�[�h�𐶐�
            final File[] fileMeta2 = new File(input.getTmpdir()
                    + BlancoBatchProcessConstants.TARGET_SUBDIRECTORY)
                    .listFiles();
            for (int index = 0; index < fileMeta2.length; index++) {
                if (fileMeta2[index].getName().endsWith(".xml") == false) {
                    continue;
                }

                if (progress("�t�@�C�� [" + fileMeta2[index].getName()
                        + "] ��������...")) {
                    return BlancoBatchProcessBatchProcess.END_ERROR;
                }

                final BlancoBatchProcessXml2SourceFile xml2source = new BlancoBatchProcessXml2SourceFile();
                xml2source.setEncoding(input.getEncoding());
                xml2source.process(fileMeta2[index], input.getRuntimepackage(),
                        input.getTargetlang(), new File(input.getTargetdir()));
            }

            return BlancoBatchProcessBatchProcess.END_SUCCESS;
        } catch (TransformerException ex) {
            throw new IOException("XML�ϊ��̉ߒ��ŗ�O���������܂���: " + ex.toString());
        }
    }

    /**
     * �����̒��ŃA�C�e������������邽�тɐi���񍐂Ƃ��ăR�[���o�b�N���܂��B
     * 
     * @param argProgressMessage
     *            ���ݏ������Ă���A�C�e���Ɋւ��郁�b�Z�[�W�B
     * @return ���������̂܂܌p������ꍇ�� false�B�������f�����N�G�X�g�������ꍇ�� true�B
     */
    public boolean progress(String argProgressMessage) {
        if (fInput.getVerbose()) {
            System.out.println(" " + argProgressMessage);
        }
        return false;
    }
}
