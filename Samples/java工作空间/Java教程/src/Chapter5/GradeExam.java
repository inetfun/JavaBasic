// GradeExam.java
package Chapter5;

public class GradeExam {
	public static void main(String[] args) {
		char[][] answers = { // ����洢ѧ���𰸵�����
		{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'E' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } };
		char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };// ������ȷ�𰸵�����
		for (int i = 0; i < answers.length; i++) {
			int correctCount = 0; // ��¼��Ե���Ŀ����
			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j]) // �жϸ����Ĵ��Ƿ���ȷ
					correctCount++; // �ı��Ե���Ŀ����
			}
			System.out.println("ѧ��" + i + "'�����Ŀ�ĸ���Ϊ��" + correctCount);
		}
	}
}
