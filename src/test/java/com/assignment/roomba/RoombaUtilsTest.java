package com.assignment.roomba;

import com.assignment.roomba.entities.OutputJson;
import com.assignment.roomba.entities.InputJson;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoombaUtilsTest {
    
    public RoombaUtilsTest() {
    }
    /**
     * Test of navigateThroughRoom method, of class RoombaUtils.
     */
    @Test
    public void testNavigateThroughRoom() {
        System.out.println("navigateThroughRoom");
        InputJson inputJson = new InputJson();
        inputJson.setCoords(new int[]{1,2});
        inputJson.setRoomSize(new int[]{5,5});
        inputJson.setInstructions("NNESEESWNWW");
        inputJson.setPatches(new int[][]{{1,0},{2,2},{2,3}});
        
        RoombaUtils instance = new RoombaUtils();
        OutputJson expResult = new OutputJson(new int[]{1,3}, 1);
        OutputJson result = instance.navigateThroughRoom(inputJson);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testComingBackToSamePosition() {
        System.out.println("testComingBackToSamePosition");
        InputJson inputJson = new InputJson();
        inputJson.setCoords(new int[]{1,2});
        inputJson.setRoomSize(new int[]{5,5});
        inputJson.setInstructions("NESW");
        inputJson.setPatches(new int[][]{{1,0},{2,2},{2,3}});
        
        RoombaUtils instance = new RoombaUtils();
        OutputJson expResult = new OutputJson(new int[]{1,2}, 2);
        OutputJson result = instance.navigateThroughRoom(inputJson);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStartPositionIsDirty() {
        System.out.println("testStartPositionIsDirty");
        InputJson inputJson = new InputJson();
        inputJson.setCoords(new int[]{1,2});
        inputJson.setRoomSize(new int[]{5,5});
        inputJson.setInstructions("NESW");
        inputJson.setPatches(new int[][]{{1,2},{2,2},{2,3}});
        
        RoombaUtils instance = new RoombaUtils();
        OutputJson expResult = new OutputJson(new int[]{1,2}, 3);
        OutputJson result = instance.navigateThroughRoom(inputJson);
        
        assertEquals(expResult, result);
    }
    
}
