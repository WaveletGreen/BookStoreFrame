import java.util.List;

import com.BookStore.action.UserFunction;
import com.BookStore.entity.BookInfo;
import com.BookStore.entity.Page;

public class test2 {

	public static void main(String[] args) {
		textGetBooksByPage();
	}

	private static void textGetBooksByPage() {
		UserFunction function = new UserFunction();
		function.setPage(new Page());
		List<BookInfo> infos = function.getBooksByPage("sadasd",-5,5);
		for (BookInfo bookInfo : infos) {
			System.out.println(bookInfo.getBookName());
		}
	}
}
