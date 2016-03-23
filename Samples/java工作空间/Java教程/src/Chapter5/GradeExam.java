// GradeExam.java
package Chapter5;

public class GradeExam {
	public static void main(String[] args) {
		char[][] answers = { // 定义存储学生答案的数组
		{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'E' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } };
		char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };// 定义正确答案的数组
		for (int i = 0; i < answers.length; i++) {
			int correctCount = 0; // 记录答对的题目个数
			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j]) // 判断给出的答案是否正确
					correctCount++; // 改变答对的题目个数
			}
			System.out.println("学生" + i + "'答对题目的个数为：" + correctCount);
		}
	}
}
