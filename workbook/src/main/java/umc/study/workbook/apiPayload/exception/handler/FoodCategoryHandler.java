package umc.study.workbook.apiPayload.exception.handler;

import umc.study.workbook.apiPayload.code.BaseErrorCode;
import umc.study.workbook.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
