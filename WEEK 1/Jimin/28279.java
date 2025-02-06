// ���� 28279�� �� 2 (�ǹ�2)

import java.io.*;
import java.util.*;

public class Deque2 {
	public static void main(String[] args) throws IOException {
		
		// ������ �����ϴ� ��
		Deque<Integer> deque = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st;
		
        // ����� �� �Է�
		int N = Integer.parseInt(br.readLine());
        
		// ����� ����ŭ �Է� �ޱ�
		for (int i=0; i<N; i++) {
			
			// ����� ���� �Է� �ޱ�
			st = new StringTokenizer(br.readLine());

			switch (Integer.parseInt(st.nextToken())) {
			// 1. ���� X�� ���� �տ� �ִ´�.
			case 1: 
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
				
			// 2. ���� X�� ���� �ڿ� �ִ´�.	
			case 2: 
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
				
			// 3. ���� ������ �ִٸ� �� ���� ������ ���� ����Ѵ�. ���ٸ� -1�� ��� ����Ѵ�.	
			case 3: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.pollFirst()) : "-1");
				bw.newLine();
				break;
				
			// 4. ���� ������ �ִٸ� �� ���� ������ ���� ����Ѵ�. ���ٸ� -1�� ��� ����Ѵ�.	
			case 4: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.pollLast()) : "-1");
				bw.newLine();
				break;
				
			// 5. ���� ����ִ� ������ ������ ����Ѵ�.	
			case 5: 
				bw.write(String.valueOf(deque.size()));
				bw.newLine();
				break;
				
			// 6. ���� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
			case 6: 
				bw.write(deque.isEmpty() ? "1" : "0");
				bw.newLine();
				break;
				
			// 7. ���� ������ �ִٸ� �� ���� ������ ����Ѵ�. ���ٸ� -1�� ��� ����Ѵ�.
			case 7: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.peekFirst()) : "-1");
				bw.newLine();
				break;
				
			// 8. ���� ������ �ִٸ� �� ���� ������ ����Ѵ�. ���ٸ� -1�� ��� ����Ѵ�.	
			case 8: 
				bw.write(!deque.isEmpty() ? String.valueOf(deque.peekLast()) : "-1");
				bw.newLine();
				break;
			}
		}
		br.close();
		bw.flush(); // �����ִ� ������ ��� ���
		bw.close();
	}
}