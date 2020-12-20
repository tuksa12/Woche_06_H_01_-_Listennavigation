package pgdp.lists;

public class Cursor{
    public NavigableList navigableList;
    public ListElement current;

    public Cursor(NavigableList navigableList,ListElement current) {//implementar if clauses para os 3 pontos antes dos methods do cursor
        this.navigableList = navigableList;
        this.current = current;

        if (current.isDeleted()) {
            if (current.getPrev() == null) {
                if (navigableList.isEmpty()) {
                    this.current = null;
                } else if (navigableList.isEmpty() == false && this.current == null) {
                    this.current = navigableList.first;
                } else {
                    this.current = navigableList.first;
                }
            } else {
                this.current = current.getPrev();
            }
        }
    }

    public NavigableList getNavigableList() {
        return navigableList;
    }

    public ListElement getCurrent() {
        return current;
    }

    public boolean hasNext(){
        if(current.getNext() != null){
            return true;
        }
    return false;}

    public boolean hasPrevious(){
        if (current.getPrev() != null){
            return true;
        }
    return false;}

    public String getInfo(){
        if (current != null){
            return current.getInfo();
        }
        return null;
    }

    public boolean setInfo(String info){
        if (info != null){
            this.current.setInfo(info);
            return true;
        }
    return false;}

    public boolean moveToNext(){
        if(current.getNext() !=null){
            current = current.getNext();
            return true;
        }
    return false;}

    public boolean moveToPrevious(){
        if(current.getPrev() !=null){
            current = current.getPrev();
            return true;
        }
        return false;}

    public boolean insertBefore(String info){
        if (info != null){
            ListElement previous = new ListElement(info);
            if (navigableList.size == 0) {
                navigableList.first.setInfo(previous.getInfo());
                navigableList.last.setInfo(previous.getInfo());
                navigableList.size++;
                return true;
            }else{
                navigableList.first.setPrev(previous);
                navigableList.size++;
                return true;
            }
        }
    return false;}

    public boolean insertAfter(String info){
        if (info != null){
            ListElement after = new ListElement(info);
            if (navigableList.size == 0){
                navigableList.first.setInfo(after.getInfo());
                navigableList.last.setInfo(after.getInfo());
                navigableList.size++;
                return true;
            }else{
                navigableList.last.setNext(after);
                navigableList.size++;
                return true;
            }
        }
        return false;}

    public boolean remove(){
        if (current.getPrev() != null){
            current.getPrev().setNext(current.getNext());
            navigableList.size--;
            return true;
        }else if (current.getPrev() == null){
            navigableList.first = current.getNext();
            navigableList.size--;
            return true;
        }
        else if (current.getNext() != null){
            current.getNext().setPrev(current.getPrev());
            navigableList.size--;
            return true;
        }else if (current.getNext() == null){
            navigableList.last = current.getPrev();
            navigableList.size--;
            return true;
        }
    return false;}

    public boolean isEqualTo(Cursor cursor){
        if (this.navigableList == cursor.navigableList && this.current ==cursor.current){
            return true;
        }
    return false;}

    public Cursor createCopy(){
        Cursor cursor = new Cursor(navigableList,current);
    return cursor;}


}
