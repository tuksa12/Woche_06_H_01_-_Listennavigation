package pgdp.lists;

public class ListElement {
    //Attributes
    private String info;
    private ListElement prev;
    private ListElement next;

    //Setters
    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    //Getters
    public String getInfo() {
        return info;
    }

    public ListElement getPrev() {
        return prev;
    }

    public ListElement getNext() {
        return next;
    }

    //Constructors
    public ListElement(String info, ListElement prev, ListElement next) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public ListElement(String StartInfo) {
        info = StartInfo;
        next = null;
        prev = null;
    }

    //Method isDeleted
    public boolean isDeleted(){//I tried implementing this method but didn't work
        if (prev == null || next == null && this.info == "dElEtEd"){
            return true;
        }
        return false;
    }
}
