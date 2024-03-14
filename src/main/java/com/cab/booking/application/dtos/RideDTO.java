package com.cab.booking.application.dtos;

public class RideDTO {

    private String username;
    private Long sourceXCoordinates;
    private Long sourceYCoordinates;
    private Long destinationXCoordinates;
    private Long destinationYCoordinates;

    public RideDTO() {
    }

    public RideDTO(String username, Long sourceXCoordinates, Long sourceYCoordinates, Long destinationXCoordinates, Long destinationYCoordinates) {
        this.username = username;
        this.sourceXCoordinates = sourceXCoordinates;
        this.sourceYCoordinates = sourceYCoordinates;
        this.destinationXCoordinates = destinationXCoordinates;
        this.destinationYCoordinates = destinationYCoordinates;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSourceXCoordinates() {
        return sourceXCoordinates;
    }

    public void setSourceXCoordinates(Long sourceXCoordinates) {
        this.sourceXCoordinates = sourceXCoordinates;
    }

    public Long getSourceYCoordinates() {
        return sourceYCoordinates;
    }

    public void setSourceYCoordinates(Long sourceYCoordinates) {
        this.sourceYCoordinates = sourceYCoordinates;
    }

    public Long getDestinationXCoordinates() {
        return destinationXCoordinates;
    }

    public void setDestinationXCoordinates(Long destinationXCoordinates) {
        this.destinationXCoordinates = destinationXCoordinates;
    }

    public Long getDestinationYCoordinates() {
        return destinationYCoordinates;
    }

    public void setDestinationYCoordinates(Long destinationYCoordinates) {
        this.destinationYCoordinates = destinationYCoordinates;
    }

    @Override
    public String toString() {
        return "RideDTO{" +
                "username='" + username + '\'' +
                ", sourceXCoordinates=" + sourceXCoordinates +
                ", sourceYCoordinates=" + sourceYCoordinates +
                ", destinationXCoordinates=" + destinationXCoordinates +
                ", destinationYCoordinates=" + destinationYCoordinates +
                '}';
    }
}
