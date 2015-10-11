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
import java.util.ArrayList;
import java.util.List;

import blanco.batchprocess.message.BlancoBatchProcessMessage;
import blanco.batchprocess.stringgroup.BlancoBatchProcessBlancoTypeStringGroup;
import blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure;
import blanco.batchprocess.valueobject.BlancoBatchProcessOutputStructure;
import blanco.batchprocess.valueobject.BlancoBatchProcessStructure;
import blanco.commons.util.BlancoStringUtil;
import blanco.xml.bind.BlancoXmlBindingUtil;
import blanco.xml.bind.BlancoXmlUnmarshaller;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;

/**
 * �u�o�b�`������`���vExcel�l��������𒊏o���܂��B
 * 
 * ���̃N���X�́A����XML�t�@�C�������񒊏o����@�\��S���܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoBatchProcessXmlParser {
    /**
     * ���b�Z�[�W�N���X�B
     */
    protected final BlancoBatchProcessMessage fMsg = new BlancoBatchProcessMessage();

    /**
     * ����XML�t�@�C����XML�h�L�������g���p�[�X���āA���̔z����擾���܂��B
     * 
     * @param argMetaXmlSourceFile
     *            ����XML�t�@�C���B
     * @return �p�[�X�̌��ʓ���ꂽ���̔z��B
     */
    public BlancoBatchProcessStructure[] parse(final File argMetaXmlSourceFile) {
        final BlancoXmlDocument documentMeta = new BlancoXmlUnmarshaller()
                .unmarshal(argMetaXmlSourceFile);
        if (documentMeta == null) {
            return null;
        }

        return parse(documentMeta);
    }

    /**
     * ����XML�t�@�C���`����XML�h�L�������g���p�[�X���āA�o�����[�I�u�W�F�N�g���̔z����擾���܂��B
     * 
     * @param argXmlDocument
     *            ����XML�t�@�C����XML�h�L�������g�B
     * @return �p�[�X�̌��ʓ���ꂽ�o�����[�I�u�W�F�N�g���̔z��B
     */
    public BlancoBatchProcessStructure[] parse(
            final BlancoXmlDocument argXmlDocument) {
        final List<BlancoBatchProcessStructure> listStructure = new ArrayList<BlancoBatchProcessStructure>();
        // ���[�g�G�������g���擾���܂��B
        final BlancoXmlElement elementRoot = BlancoXmlBindingUtil
                .getDocumentElement(argXmlDocument);
        if (elementRoot == null) {
            // ���[�g�G�������g�������ꍇ�ɂ͏������f���܂��B
            return null;
        }

        // sheet(Excel�V�[�g)�̃��X�g���擾���܂��B
        final List<blanco.xml.bind.valueobject.BlancoXmlElement> listSheet = BlancoXmlBindingUtil
                .getElementsByTagName(elementRoot, "sheet");

        final int sizeListSheet = listSheet.size();
        for (int index = 0; index < sizeListSheet; index++) {
            final BlancoXmlElement elementSheet = listSheet.get(index);

            final List<blanco.xml.bind.valueobject.BlancoXmlElement> listCommon = BlancoXmlBindingUtil
                    .getElementsByTagName(elementSheet,
                            "blancobatchprocess-common");
            if (listCommon.size() == 0) {
                // common�������ꍇ�ɂ̓X�L�b�v���܂��B
                continue;
            }

            // �ŏ��̃A�C�e���̂ݏ������Ă��܂��B
            final BlancoXmlElement elementCommon = listCommon.get(0);
            final String name = BlancoXmlBindingUtil.getTextContent(
                    elementCommon, "name");
            if (BlancoStringUtil.null2Blank(name).trim().length() == 0) {
                // name����̏ꍇ�ɂ͏������X�L�b�v���܂��B
                continue;
            }

            final BlancoBatchProcessStructure processStructure = parseElementSheet(
                    elementSheet, elementCommon);
            if (processStructure != null) {
                // ����ꂽ�����L�����܂��B
                listStructure.add(processStructure);
            }
        }

        final BlancoBatchProcessStructure[] result = new BlancoBatchProcessStructure[listStructure
                .size()];
        listStructure.toArray(result);
        return result;
    }

    /**
     * ����XML�t�@�C���`���́usheet�vXML�G�������g���p�[�X���āA�o�����[�I�u�W�F�N�g�����擾���܂��B
     * 
     * @param argElementSheet
     *            ����XML�t�@�C���́usheet�vXML�G�������g�B
     * @return �p�[�X�̌��ʓ���ꂽ�o�����[�I�u�W�F�N�g���B�uname�v��������Ȃ������ꍇ�ɂ� null��߂��܂��B
     */
    public BlancoBatchProcessStructure parseElementSheet(
            final BlancoXmlElement argElementSheet,
            final BlancoXmlElement argElementCommon) {
        final BlancoBatchProcessStructure processStructure = new BlancoBatchProcessStructure();
        // ���̓p�����[�^�����擾���܂��B
        final BlancoXmlElement elementInparameterList = BlancoXmlBindingUtil
                .getElement(argElementSheet,
                        "blancobatchprocess-inparameter-list");

        // �o�̓p�����[�^�����擾���܂��B
        final BlancoXmlElement elementOutput = BlancoXmlBindingUtil.getElement(
                argElementSheet, "blancobatchprocess-output");

        // �V�[�g����ڍׂȏ����擾���܂��B
        processStructure.setName(BlancoXmlBindingUtil.getTextContent(
                argElementCommon, "name"));
        processStructure.setPackage(BlancoXmlBindingUtil.getTextContent(
                argElementCommon, "package"));

        if (BlancoStringUtil.null2Blank(processStructure.getPackage()).trim()
                .length() == 0) {
            throw new IllegalArgumentException(fMsg
                    .getMbbpi001(processStructure.getName()));
        }

        if (BlancoXmlBindingUtil
                .getTextContent(argElementCommon, "description") != null) {
            processStructure.setDescription(BlancoXmlBindingUtil
                    .getTextContent(argElementCommon, "description"));
        }

        if (BlancoXmlBindingUtil.getTextContent(argElementCommon, "suffix") != null) {
            processStructure.setSuffix(BlancoXmlBindingUtil.getTextContent(
                    argElementCommon, "suffix"));
        }

        if (elementInparameterList == null) {
            return null;
        }

        // �ꗗ�̓��e���擾���܂��B
        final List<blanco.xml.bind.valueobject.BlancoXmlElement> listField = BlancoXmlBindingUtil
                .getElementsByTagName(elementInparameterList, "inparameter");
        for (int indexField = 0; indexField < listField.size(); indexField++) {
            final BlancoXmlElement elementField = listField.get(indexField);

            final BlancoBatchProcessInputItemStructure inputItem = new BlancoBatchProcessInputItemStructure();

            inputItem.setName(BlancoXmlBindingUtil.getTextContent(elementField,
                    "name"));
            if (BlancoStringUtil.null2Blank(inputItem.getName()).length() == 0) {
                continue;
            }

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementField, "type"))
                    .length() > 0) {
                inputItem.setType(BlancoXmlBindingUtil.getTextContent(
                        elementField, "type"));
            }
            inputItem.setRequire("true".equals(BlancoXmlBindingUtil
                    .getTextContent(elementField, "require")));
            inputItem.setDefault(BlancoXmlBindingUtil.getTextContent(
                    elementField, "default"));
            inputItem.setDescription(BlancoXmlBindingUtil.getTextContent(
                    elementField, "description"));

            if (new BlancoBatchProcessBlancoTypeStringGroup()
                    .convertToInt(inputItem.getType()) == BlancoBatchProcessBlancoTypeStringGroup.NOT_DEFINED) {
                // TODO ���b�Z�[�W��`�����������{�B
                throw new IllegalArgumentException("�T�|�[�g���Ȃ��^["
                        + inputItem.getType() + "]���^�����܂���");
            }

            if (inputItem.getRequire() && inputItem.getDefault() != null) {
                throw new IllegalArgumentException(fMsg.getMbbpi003(
                        processStructure.getName(), inputItem.getName()));
            }

            processStructure.getInputItemList().add(inputItem);
        }

        // �o�͒l���擾���܂��B
        {
            final BlancoBatchProcessOutputStructure outputStructure = new BlancoBatchProcessOutputStructure();

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementOutput,
                            "end-success")).length() > 0) {
                // TODO ���ꂪ�����������O�𔭐����ׂ��H
                outputStructure.setEndSuccess(BlancoXmlBindingUtil
                        .getTextContent(elementOutput, "end-success"));
            }

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementOutput,
                            "end-batchprocess-exception")).length() > 0) {
                outputStructure
                        .setEndBatchProcessException(BlancoXmlBindingUtil
                                .getTextContent(elementOutput,
                                        "end-batchprocess-exception"));
            }

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementOutput,
                            "end-illegal-argument-exception")).length() > 0) {
                outputStructure
                        .setEndIllegalArgumentException(BlancoXmlBindingUtil
                                .getTextContent(elementOutput,
                                        "end-illegal-argument-exception"));
            }

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementOutput,
                            "end-io-exception")).length() > 0) {
                outputStructure.setEndIoException(BlancoXmlBindingUtil
                        .getTextContent(elementOutput, "end-io-exception"));
            }

            if (BlancoStringUtil.null2Blank(
                    BlancoXmlBindingUtil.getTextContent(elementOutput,
                            "end-error")).length() > 0) {
                outputStructure.setEndError(BlancoXmlBindingUtil
                        .getTextContent(elementOutput, "end-error"));
            }

            outputStructure.setDescription(BlancoXmlBindingUtil.getTextContent(
                    elementOutput, "description"));

            processStructure.setOutput(outputStructure);
        }

        return processStructure;
    }
}
