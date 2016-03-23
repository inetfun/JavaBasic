// ImportSmaple.java
package Chapter3;

import mypackage.*; //导入mypackage包中的所需类
import mypackage.entity.*; //导入mypackage.entity包中的所需类

public class ImportSample {
	public static void main(String[] args) {
		Book book = new Book(); // 基于Book类创建book对象
		book.show(); // 调用book对象的show方法
		TextBook textbook = new TextBook(); // 基于TextBook类创建textbook对象
		textbook.show(); // 调用textbook对象的show方法
		Reader reader = new Reader(); // 基于Reader类创建reader对象
		reader.show(); // 调用reader对象的show方法
	}
}
