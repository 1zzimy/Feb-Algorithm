// ���� 11279�� �ִ� �� (�ǹ�2)

import java.io.*;
import java.util.*;

public class MaxHeap {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// PriorityQueue�� �⺻������ ���� ���ڰ� ���� ������ �ּ� �� ���
		// ���� ū ���ڰ� ���� ������ �ϰ� �ʹٸ�, Collections.reverseOrder()�� ���
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) { // ����, x�� �ڿ������
				maxHeap.add(x); // �迭�� x �� �߰�
			} else if (x == 0) { // ����, x�� 0�̶��
				// �迭���� ���� ū ���� ����ϰ� �� ���� �迭���� ����
				bw.write(maxHeap.isEmpty() ? "0" : String.valueOf(maxHeap.poll())); 
				bw.newLine();
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
