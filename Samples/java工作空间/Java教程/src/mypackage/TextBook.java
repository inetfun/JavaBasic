// TextBook.java
package mypackage;

public class TextBook {
	public void show() {
		Story story = new Story(); // 根据Story类创建story对象
		story.show(); // 调用story对象的show方法
		System.out.println("TextBook类所在的文件是TextBook.java，包是mypackage！");
	}
}
