package org.cloudfoundry.client.lib;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;

public class CloudControllerException extends CloudOperationException {

    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_CLOUD_CONTROLLER_ERROR_MESSAGE = "Controller operation failed: {0}";

    public CloudControllerException(CloudOperationException cloudOperationException) {
        super(cloudOperationException.getStatusCode(), cloudOperationException.getStatusText(), cloudOperationException.getDescription(),
            cloudOperationException.getCloudFoundryErrorCode(), cloudOperationException.getCloudFoundryErrorName(),
            cloudOperationException);
    }

    public CloudControllerException(HttpStatus statusCode) {
        super(statusCode);
    }

    public CloudControllerException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public CloudControllerException(HttpStatus statusCode, String statusText, String description) {
        super(statusCode, statusText, description);
    }

    public CloudControllerException(HttpStatus statusCode, String statusText, String description, int cloudFoundryErrorCode,
        String cloudFoundryErrorName) {
        super(statusCode, statusText, description, cloudFoundryErrorCode, cloudFoundryErrorName);
    }

    @Override
    public String getMessage() {
        return decorateExceptionMessage(super.getMessage());
    }

    private String decorateExceptionMessage(String exceptionMessage) {
        return MessageFormat.format(DEFAULT_CLOUD_CONTROLLER_ERROR_MESSAGE, exceptionMessage);
    }

}
