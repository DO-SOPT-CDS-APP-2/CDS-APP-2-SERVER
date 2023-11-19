package org.sopt.cdsserver.common.exception.model;

import org.sopt.cdsserver.common.exception.enums.ErrorType;

public class NotFoundException extends SoptException {

    public NotFoundException(final ErrorType errorType) {
        super(errorType);
    }
}
