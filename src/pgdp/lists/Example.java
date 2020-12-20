package pgdp.lists;

public class Example {

	/**
	 * This is not tested. You can change that and experiment or test with it.
	 */
	public static void main(String[] args) {

		// TODO: comment out to test the example

//		NavigableList list = new NavigableList();
//		list.addLast("Pinguine");
//		list.addLast("sind");
//		list.addLast("exzellente");
//		list.addLast("Tiere");
//		list.addLast("die");
//		list.addLast("in");
//		list.addLast("der");
//		list.addLast("Antarktis");
//		list.addLast("leben");
//
//		System.out.println(list);
//
//		sort(list);
//
//		System.out.println(list);
	}

//	static void sort(NavigableList l) {
//		if (l.isEmpty())
//			return;
//		int size = l.size();
//		if (size == 1)
//			return;
//		Cursor start = l.createCursorAt(0);
//		Cursor end = l.createCursorAt(size - 1);
//		doMergeSort(start, end, size, true);
//	}
//
//	static Cursor doMergeSort(Cursor start, Cursor end, int segmentLength, boolean returnStart) {
//		// trivial case
//		if (segmentLength == 1)
//			return start;
//		// just swap both values if necessary
//		if (segmentLength == 2) {
//			String a = start.getInfo();
//			String b = end.getInfo();
//			if (a.compareToIgnoreCase(b) > 0) {
//				start.setInfo(b);
//				end.setInfo(a);
//			}
//			return returnStart ? start : end;
//		}
//		// divide the list segment into two
//		int middlePos = segmentLength / 2;
//		Cursor middleUpper = start.createCopy();
//		for (int i = 0; i < middlePos; i++)
//			middleUpper.moveToNext();
//		Cursor middleLower = middleUpper.createCopy();
//		middleLower.moveToPrevious();
//
//		// sort recursively and get the new start and end cursors
//		Cursor newStart = doMergeSort(start, middleLower, middlePos, true);
//		Cursor newEnd = doMergeSort(middleUpper, end, segmentLength - middlePos, false);
//
//		// initial start positions of the two sorted parts
//		Cursor first = newStart.createCopy();
//		Cursor second = newStart.createCopy();
//		for (int i = 0; i < middlePos; i++)
//			second.moveToNext();
//		// merge as long as both the first part and second part have elements left
//		while (true) {
//			String a = first.getInfo();
//			String b = second.getInfo();
//			if (a.compareToIgnoreCase(b) <= 0) {
//				// if first is the same as second, the first part has no element left
//				if (first.isEqualTo(second))
//					break;
//				// just move the cursor of the first part
//				first.moveToNext();
//			} else {
//				boolean secondIsEnd = second.isEqualTo(newEnd);
//				// if second is the end and we need to remove it, move the end to the previous
//				// element so that the new end still represents the end of the segment
//				if (secondIsEnd)
//					newEnd.moveToPrevious();
//				// remove the first element of the second part ...
//				second.remove();
//				// ... move it to the next if possible ...
//				second.moveToNext();
//				boolean firstIsStart = first.isEqualTo(newStart);
//				// ... and insert the removed value before first
//				first.insertBefore(b);
//				if (firstIsStart) {
//					// if first was still the start of the list segment, move the start to the newly
//					// inserted element
//					newStart.moveToPrevious();
//				}
//				// if this was the last element in the second part, we are done
//				if (secondIsEnd)
//					break;
//			}
//		}
//		// return the new start/end, as those could have changed in the merge process
//		return returnStart ? newStart : newEnd;
//	}
}
