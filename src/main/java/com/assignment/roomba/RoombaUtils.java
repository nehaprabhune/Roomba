package com.assignment.roomba;

import com.assignment.roomba.entities.InputJson;
import com.assignment.roomba.entities.Location;
import com.assignment.roomba.entities.OutputJson;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class RoombaUtils {
    
    public OutputJson navigateThroughRoom(InputJson inputJson){        
        int[] roomsize = inputJson.getRoomSize();
        int rowSize = roomsize[0];
        int colSize = roomsize[1];
        int[] currentLocation = inputJson.getCoords();
        Set<Location> cleanedLocations = new HashSet<>();
        for(char instruction: inputJson.getInstructions().toCharArray()){
            Optional<Location> currentLocationWasCleaned = currentLocationWasCleaned(currentLocation, inputJson.getPatches());
            
            if(currentLocationWasCleaned.isPresent()){
                cleanedLocations.add(currentLocationWasCleaned.get());
            }
            
            if(instruction == 'N'){
                currentLocation = goNorth(currentLocation, colSize);
            }
            if(instruction == 'S'){
                currentLocation = goSouth(currentLocation);
            }
            if(instruction == 'E'){
                currentLocation = goEast(currentLocation, rowSize);
            }
            if(instruction == 'W'){
                currentLocation = goWest(currentLocation);
            }
            
        }
        return new OutputJson(currentLocation, cleanedLocations.size());
    }

    private int[] goNorth(int[] location, int colSize) {
        int yValue = location[1]+1;
        if(yValue > colSize){
            yValue = colSize;
        }
        location[1] = yValue;
        return location;
    }
    
    private int[] goSouth(int[] location) {
        int yValue = location[1]-1;
        if(yValue < 0){
            yValue = 0;
        }
        location[1] = yValue;
        return location;
    }
    
    private int[] goEast(int[] location, int rowSize) {
        int xValue = location[0]+1;
        if(xValue > rowSize){
            xValue = rowSize;
        }
        location[0] = xValue;
        return location;
    }
    
    private int[] goWest(int[] location) {
        int xValue = location[0]-1;
        if(xValue < 0){
            xValue = 0;
        }
        location[0] = xValue;
        return location;
    }

    private Optional<Location> currentLocationWasCleaned(int[] currentLocation, int[][] patches) {
        for(int[] patch:patches){
            if(patch[0] == currentLocation[0] && patch[1] == currentLocation[1]){
                Location cleanedLocation = new Location(patch[0], patch[1]);
                return Optional.ofNullable(cleanedLocation);
            }
        }
        return Optional.empty();
    }
    
}
