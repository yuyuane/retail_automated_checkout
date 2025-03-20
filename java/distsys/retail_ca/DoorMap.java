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
        Door door = doorMap.getDoorByPaymentNo("payNo_ac8-4b35-a9f7-6b6a6e1469312");
        System.out.println(door.toString());
//        System.out.println(doorMap.toString());
//        Boolean bool = doorMap.updateDoorStatusByDoorNo(2,"open","payNo_ac8-4b35-a9f7-6b6a6e1469312");
//        System.out.println(bool);
//        System.out.println("----------------");
//        System.out.println(doorMap.toString());
//        Boolean bool1 = doorMap.updateDoorStatusByDoorNo(3,"close",null);
//        System.out.println(bool1);
//        System.out.println("----------------");
//        System.out.println(doorMap.toString());
    }
    
    public DoorMap(){
        doorMap = new HashMap<>();
        getAllDoor();
    }
    
    public void getAllDoor(){
        Door door1 = new Door(1,"close",null);
        doorMap.put(1, door1);
        Door door2 = new Door(2,"open","payNo_ac8-4b35-a9f7-6b6a6e1469311");
        doorMap.put(2, door2);
        Door door3 = new Door(3,"close","payNo_ac8-4b35-a9f7-6b6a6e1469312");
        doorMap.put(3, door3);
    }
    
    public Door getDoorByDoorNo(int doorNo){
        Door door = doorMap.get(doorNo);
        return door;
    }
    
    public Door getDoorByPaymentNo(String paymentNo){
        for (Door door: doorMap.values()) {
            if((door.getPaymentNo()!=null) && door.getPaymentNo().equals(paymentNo)){
                return door;
            }
        }
        return null;
    }
    
    public Boolean updateDoorStatusByDoorNo(int doorNo, String status, String paymentNo){
        //get the Door and check status of this door
        Door door = getDoorByDoorNo(doorNo);
        if(door.getStatus().equals(status)){
            return false;
        }
        Door doorEdit = new Door(doorNo,status,paymentNo);
        doorMap.put(doorNo, doorEdit);
        return true;
    }
    
    @Override
    public String toString(){
         for (Door door: doorMap.values()) {
            message += door.toString();
        }
        return message;
    }
}

class Door{
    private int doorNo;
    //status: open、close、working
    private String doorStatus;
    private String paymentNo;
    public Door(int no, String status, String payNo){
        this.doorNo = no;
        this.doorStatus = status;
        this.paymentNo = payNo;
    }
    
    public int getDoorNo(){
        return this.doorNo;
    }
    
    public String getStatus(){
        return this.doorStatus;
    }
    
    public String getPaymentNo(){
        return this.paymentNo;
    }
    
    @Override
    public String toString(){
        return "Door{doorNo="+this.doorNo+", doorStatus="+this.doorStatus+", paymentNo="+this.paymentNo+"}\n";
    }
    
}
