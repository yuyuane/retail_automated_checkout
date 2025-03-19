/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author yuyua
 */
public class DoorMap {
    
    HashMap<Integer, Door> doorMap;
    String message;
    
    public static void main(String[] args) {
        DoorMap doorMap = new DoorMap();
        System.out.println(doorMap.toString());
        Boolean bool = doorMap.updateDoorStatusByDoorNo(3,"open");
        System.out.println(bool);
        System.out.println("----------------");
        System.out.println(doorMap.toString());
        Boolean bool1 = doorMap.updateDoorStatusByDoorNo(2,"working");
        System.out.println(bool1);
        System.out.println("----------------");
        System.out.println(doorMap.toString());
    }
    
    public DoorMap(){
        doorMap = new HashMap<>();
        getAllDoor();
    }
    
    public void getAllDoor(){
        Door door1 = new Door(1,"close");
        doorMap.put(1, door1);
        Door door2 = new Door(2,"close");
        doorMap.put(2, door2);
        Door door3 = new Door(3,"close");
        doorMap.put(3, door3);
    }
    
    public Door getDoorByDoorNo(int doorNo){
        Door door = doorMap.get(doorNo);
        return door;
    }
    
    public Boolean updateDoorStatusByDoorNo(int doorNo, String status){
        //get the Door and check status of this door
        Door door = getDoorByDoorNo(doorNo);
        if(door.getStatus().equals(status)){
            return false;
        }
        Door doorEdit = new Door(doorNo,status);
        doorMap.put(doorNo, doorEdit);
        return true;
    }
    
    @Override
    public String toString(){
        message = "---";
         for (Door door: doorMap.values()) {
            message += door.toString();
        }
        message += "---";
        return message;
    }
}

class Door{
    private int doorNo;
    //status: open、close、working
    private String doorStatus;
    public Door(int no, String status){
        this.doorNo = no;
        this.doorStatus = status;
    }
    
    public String getStatus(){
        return this.doorStatus;
    }
    
    @Override
    public String toString(){
        return "Door{doorNo="+this.doorNo+", doorStatus="+this.doorStatus+"}\n";
    }
    
}
