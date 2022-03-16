package com.pauloapp.apificar.abc.dtos;

public class ResponseDto {

    private String statusCode;
    private String statusMessage;
    private ResponseDetailDto[] detailsData;

    public ResponseDto() {
    }

    public ResponseDto(String statusCode, String statusMessage, ResponseDetailDto[] detailsData) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.detailsData = detailsData;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ResponseDetailDto[] getDetailsData() {
        return detailsData;
    }

    public void setDetailsData(ResponseDetailDto[] detailsData) {
        this.detailsData = detailsData;
    }
}

