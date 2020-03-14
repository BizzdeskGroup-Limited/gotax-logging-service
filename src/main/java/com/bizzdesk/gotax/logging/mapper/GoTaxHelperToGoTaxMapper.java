package com.bizzdesk.gotax.logging.mapper;

import com.bizzdesk.gotax.logging.entity.GoTaxLogs;
import com.gotax.framework.library.helpers.GoTaxLogHelper;

public class GoTaxHelperToGoTaxMapper {

    public static GoTaxLogs toGoTaxLogs(GoTaxLogHelper goTaxLogHelper) {
        return new GoTaxLogs()
                .setFullRequestPath(goTaxLogHelper.getFullRequestPath())
                .setHttpStatusCode(goTaxLogHelper.getHttpStatusCode())
                .setMethod(goTaxLogHelper.getMethod())
                .setPath(goTaxLogHelper.getPath())
                .setRemoteAddress(goTaxLogHelper.getRemoteAddress())
                .setRequestDate(goTaxLogHelper.getRequestDate())
                .setRequestHeaders(goTaxLogHelper.getRequestHeaders())
                .setRequestPayload(goTaxLogHelper.getRequestPayload())
                .setResponsePayload(goTaxLogHelper.getResponsePayload())
                .setUrlParameters(goTaxLogHelper.getUrlParameters());
    }
}
