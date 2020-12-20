package pgdp.lists;

public class NavigableList {
    public ListElement first;
    public ListElement last;
    public int size = 0;

    public NavigableList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        if (first == null && last == null){
            return true;
        }
        return false;
    }

    public int size(){
        if (isEmpty()){
            return 0;
        }else{
            return size;
        }
    }

    public boolean addFirst(String addFirst){
        if (addFirst != null){
            ListElement firstElement = new ListElement(addFirst);
            if (size == 0){
                first = firstElement;
                last = firstElement;
            }else{
                first.setPrev(firstElement);
                first = firstElement;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean addLast(String addLast){
        if (addLast != null){
            ListElement lastElement = new ListElement(addLast);
            if (size == 0){
                first = lastElement;
                last = lastElement;
            }else{
                last.setNext(lastElement);
                last = lastElement;
            }
            size++;
            return true;
        }
        return false;
    }

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

    public boolean remove (String remove){
        ListElement element;
        if (first.getInfo() == remove){
            first = first.getNext();
            return true;
        }else if (last.getInfo() == remove){
            last = last.getPrev();
            return true;
        }else{
            for (int i = 1; i < size; i++) {
                element = first.getNext();
                if (element.getInfo() == remove){
                    element = element.getNext();
                    return true;
                }
            }
        }
        return false;
    }

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
