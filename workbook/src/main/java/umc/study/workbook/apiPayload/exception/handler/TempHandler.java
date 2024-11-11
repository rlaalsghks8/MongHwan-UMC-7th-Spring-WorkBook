package umc.study.workbook.apiPayload.exception.handler;

import umc.study.workbook.apiPayload.code.BaseErrorCode;
import umc.study.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorcode) {
        super(errorcode);
    }
}
