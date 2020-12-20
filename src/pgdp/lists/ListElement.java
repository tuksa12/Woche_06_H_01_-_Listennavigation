package pgdp.lists;

public class ListElement {
    private String info;
    private ListElement prev;
    private ListElement next;

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public String getInfo() {
        return info;
    }

    public ListElement getPrev() {
        return prev;
    }

    public ListElement getNext() {
        return next;
    }

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

    public boolean isDeleted(){
        if (prev == null || prev.next == next.prev  ){
            return false;
        }if (next == null || prev.next == next.prev  ){
            return false;
        }
        return true;
    }
}
