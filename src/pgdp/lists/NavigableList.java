package pgdp.lists;

public class NavigableList {
    //Attributes
    public ListElement first;
    public ListElement last;
    public int size = 0;

    //Constructor to initiate a empty list
    public NavigableList() {
        first = null;
        last = null;
    }

    //Method to see if list is empty
    public boolean isEmpty(){
        if (first == null && last == null){
            return true;
        }
        return false;
    }

    //Method the returns the size
    public int size(){
        if (isEmpty()){
            return 0;
        }else{
            return size;
        }
    }

    //Method to add a specific string at the begin of the list
    public boolean addFirst(String addFirst){
        if (addFirst != null){
            ListElement firstElement = new ListElement(addFirst);
            if (size == 0){
                first = firstElement;
                last = firstElement;
            }else{
                first.setPrev(firstElement);
                firstElement.setNext(first);
                first = firstElement;
            }
            size++;
            return true;
        }
        return false;
    }

    //Method to add a specific string at the end of the list
    public boolean addLast(String addLast){
        if (addLast != null){
            ListElement lastElement = new ListElement(addLast);
            if (size == 0){
                first = lastElement;
                last = lastElement;
            }else{
                last.setNext(lastElement);
                lastElement.setPrev(last);
                last = lastElement;
            }
            size++;
            return true;
        }
        return false;
    }

    //Get a the message in a specific index
    public String get(int index){
        ListElement element;
        if (index < 0 || index >= size){
            return null;
        }else{
            if (index < size/2){
                element = first;
                for (int i = 0; i < index; i++) {
                    element = element.getNext();
                }return element.getInfo();
            }else {
                element = last;
                for (int i = size-1; i > index; i--) {
                    element = element.getPrev();
                }return element.getInfo();
            }
        }
    }

    //Removes a specific string from the list
    public boolean remove (String remove){
        ListElement element = first;
        if (first.getInfo() == remove){
            first = first.getNext();
            return true;
        }else if (last.getInfo() != remove){
            for (int i = 0; i < size; i++) {
                if (element.getInfo() == remove){
                    element.getPrev().setNext(element.getNext());
                    element.getNext().setPrev(element.getPrev());
                    return true;
                }
                element = element.getNext();
            }
        }
        else if (last.getInfo() == remove){
            last.getPrev().setNext(null);
            last = last.getPrev();
            return true;
        }
        return false;
    }

    //To string method
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (first == null && last == null){
            System.out.println("[]");
        }else{
            sb.append("[");
            for (ListElement element = first; element != null; element = element.getNext()) {
                sb.append(element.getInfo());
                if (element.getNext() != null){
                    sb.append(",");
            }
        }
            sb.append("]");
        }
        String message = sb.toString();
        return message;
    }

    //Creates a cursor in a specific index
    public Cursor createCursorAt(int index){
        if (index > size || index < 0){
            return null;
        }else{
            ListElement element = first;
            for (int i = 0; i < index ; i++) {
                if (size-1 == index){
                    element = last;
                } else{
                    element = element.getNext();
                }
            }
            Cursor create = new Cursor(this,element);
            return create;
        }
    }
}
