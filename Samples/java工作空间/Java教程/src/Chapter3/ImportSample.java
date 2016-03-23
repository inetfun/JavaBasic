// ImportSmaple.java
package Chapter3;

import mypackage.*; //����mypackage���е�������
import mypackage.entity.*; //����mypackage.entity���е�������

public class ImportSample {
	public static void main(String[] args) {
		Book book = new Book(); // ����Book�ഴ��book����
		book.show(); // ����book�����show����
		TextBook textbook = new TextBook(); // ����TextBook�ഴ��textbook����
		textbook.show(); // ����textbook�����show����
		Reader reader = new Reader(); // ����Reader�ഴ��reader����
		reader.show(); // ����reader�����show����
	}
}
