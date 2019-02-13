package model;

public class notes_in {
    //used for passing and retrieving data from the database
    private long kd_id;
    private String notes;

    public notes_in(){

    }
    //used to add values into the table
    public notes_in(String notes){
        this.notes=notes;

    }
    //creating getter and setter
    public long getKd_id(){
        return kd_id;
    }
    public void setKd_id(long kd_id){
        this.kd_id=kd_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
