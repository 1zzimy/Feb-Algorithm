// 문제: [기본문제1] 백준 11650번 좌표 정렬하기 (실버5)
// 링크: https://www.acmicpc.net/problem/11650
// 시간: ms (런타임 에러(ArrayIndexOutOfBounds) 발생)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 점의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		// sorted int형 2차원 배열에 xi, yi 저장
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 오름차순 졍렬 -> 카운팅 정렬 사용 (이유: 정수 데이터에 최적)
		// 1. 최대값 찾기
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			if(max < arr[i][0]) {
				max = arr[i][0];
			}
		}
		
		// 2. 카운트 배열 생성 -> 빈도수를 저장
		int[] count = new int[max + 1];
		
		// 3. 카운트 배열에 빈도수 저장 -> 향상된 for문 (각 행을 차례로 순행) 
		for (int[] row : arr) {
			count[row[0]]++;
		}
		
		// 4. 누적합 계산 (안정성 확보) -> i : 정렬된 배열에서 마지막으로 위치할 인덱스 의미
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		
		// 5. 정렬된 결과 배열 생성
		int [][] sorted = new int[N][2];
		for (int i=N-1; i>=0; i--) { // 뒤에서부터 순회 (안정성 유지)
			int value = arr[i][0];
			int position = count[value] - 1;
			
			sorted[position] = arr[i]; // 위치에 복사
			count[value]--; // 카운트 감소
		}
		
		// x값이 같은 경우 y값 내림차순 정렬
		Arrays.sort(sorted, (a, b) -> {
		    if (a[0] == b[0]) {
		        return Integer.compare(a[1], b[1]);
		    }
		    return Integer.compare(a[0], b[0]);
		});
		
		// 6. 원본 배열에 정렬된 결과 복사
		for (int i=0; i<N; i++) {
			arr[i] = sorted[i];
		}
		
		// 출력
		for (int[] row : arr) {
			bw.write(row[0] + " " + row[1]);
			bw.newLine();
		}
		
		br.close();
		bw.flush(); // 출력 버퍼 비우기
		bw.close(); // 자원 정리 (권장)
	}
}
