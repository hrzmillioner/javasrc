import java.util.*;

/** Re-allocate an array, bigger...
 * @author Ian Darwin
 * @version $Id$
 */
public class Array2  {
	public static void main(String argv[]) {
		int nDates = 0;
		final int MAX = 10;
		Calendar dates[] = new Calendar[MAX];
		Calendar c;
		while ((c=getDate()) != null) {

			// if (nDates >= dates.length) {
			// 	System.err.println("Too Many Dates! Simplify your life!!");
			// 	System.exit(1);  // wimp out
			// }

			// better: reallocate, making data structure dynamic
			if (nDates >= dates.length) {
				Calendar tmp[] = new Calendar[dates.length + 10];
				System.arraycopy(dates, 0, tmp, 0, dates.length);
				dates = tmp;    // copies the array reference
				// old array will be garbage collected soon...
			}
			dates[nDates++] = c;
		}
		System.out.println("Array size = " + dates.length);
	}

	static int n;
	/* Dummy method to return a sequence of 21 Calendar references,
	 * so the array should be sized >= 21.
	 */
	public static Calendar getDate() {
		if (n++ > 21)
			return null;
		return Calendar.getInstance();
	}
}
