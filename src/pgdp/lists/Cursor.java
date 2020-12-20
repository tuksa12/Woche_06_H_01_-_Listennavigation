package pgdp.lists;

public class Cursor{
    //Attributes
    private NavigableList navigableList;
    private ListElement current;
    //Constructor
    public Cursor(NavigableList navigableList,ListElement current) {
        this.navigableList = navigableList;
        this.current = current;
        if (navigableList.isEmpty())
            current = null;
        else{
            if (current.isDeleted()) {
                if (current.getPrev() == null) {
                        this.current = navigableList.first;
                } else {
                    this.current = current.getPrev();
                }
            }
        }
    }
    //Getters
    public NavigableList getNavigableList() {
        return navigableList;
    }

    public ListElement getCurrent() {
        return current;
    }

    //Method to se if there is a another list element right of the current list element
    public boolean hasNext(){
        if(current.getNext() != null){
            return true;
        }
        return false;
    }

    //Method to se if there is a another list element left of the current list element
    public boolean hasPrevious(){
        if (current.getPrev() != null){
            return true;
        }
        return false;
    }

    //Getter info in the current element
    public String getInfo(){
        if (current != null){
            return current.getInfo();
        }
        return null;
    }

    //Setter info in the current list element
    public boolean setInfo(String info){
        if (info != null){
            current.setInfo(info);
            return true;
        }
        return false;
    }

    //Move the cursor
    public boolean moveToNext(){
        if(current.getNext() !=null){
            current = current.getNext();
            return true;
        }
        return false;
    }

    public boolean moveToPrevious(){
        if(current.getPrev() !=null){
            current = current.getPrev();
            return true;
        }
        return false;
    }

    //Insert a elemente before the current element
    public boolean insertBefore(String info){
        if (info != null){
            ListElement previous = new ListElement(info);
            if (navigableList.size == 0) {
                navigableList.first = previous;
                navigableList.last = previous;
                current = previous;
                //navigableList.first.setInfo(previous.getInfo());
                //navigableList.last.setInfo(previous.getInfo());
                navigableList.size++;
                return true;
            }else{
                previous.setPrev(current.getPrev());
                previous.setNext(current);
                current.setPrev(previous);
                if (current == navigableList.first){
                    navigableList.first = previous;
                }
                navigableList.size++;
                return true;
            }
        }
    return false;
    }

    //Insert a elemente after the current element
    public boolean insertAfter(String info){
        if (info != null){
            ListElement after = new ListElement(info);
            if (navigableList.size == 0){
                navigableList.first = after;
                navigableList.last = after;
                current = after;
                //navigableList.first.setInfo(after.getInfo());
                //navigableList.last.setInfo(after.getInfo());
                navigableList.size++;
                return true;
            }else{
                after.setNext(current.getNext());
                after.setPrev(current);
                current.setNext(after);
                if (current == navigableList.last){
                    navigableList.last = after;
                }
                navigableList.size++;
                return true;
            }
        }
        return false;
    }

    //Remove the current element
    public boolean remove(){
        if (current.getPrev() != null){
            current.getPrev().setNext(current.getNext());
            current.getPrev().setNext(current.getNext());
            //current.setInfo("dElEtEd");
            navigableList.size--;
            return true;
        }else if (current.getPrev() == null){
            navigableList.first = current.getNext();
            //current.setInfo("dElEtEd");
            navigableList.size--;
            return true;
        }
        else if (current.getNext() != null){
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            //current.setInfo("dElEtEd");
            navigableList.size--;
            return true;
        }else if (current.getNext() == null){
            navigableList.last = current.getPrev();
            //current.setInfo("dElEtEd");
            navigableList.size--;
            return true;
        }
    return false;
    }

    //Compares the current cursor to another one
    public boolean isEqualTo(Cursor cursor){
        if (this.navigableList == cursor.navigableList && this.current ==cursor.current){
            return true;
        }
    return false;
    }

    //Creates another identical cursor
    public Cursor createCopy(){
        Cursor cursor = new Cursor(navigableList,current);
    return cursor;}

}
