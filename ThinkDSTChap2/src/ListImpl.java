import java.util.List;

public class ListImpl {

	public Object set(int index, Object element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return element;
		
	}
}
