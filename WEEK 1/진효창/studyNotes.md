# **정렬 이분탐색**
---
## 정렬

## **1. 버블 정렬 (Bubble Sort)**
- **인접한 두 요소를 비교하며 큰 값을 오른쪽으로 이동**
- **시간 복잡도:** O(N²)
- **장점:** 구현이 간단함
- **단점:** 느림, 거의 정렬된 상태에서도 비효율적  

#### 📌 **버블 정렬 과정 예시**
```
입력: 3 → 2 → 5 → 8 → 1
과정:
1. [3, 2, 5, 8, 1] → 2와 3 비교 (교환)
2. [2, 3, 5, 8, 1] → 3과 5 비교 (유지)
3. [2, 3, 5, 8, 1] → 5와 8 비교 (유지)
4. [2, 3, 5, 1, 8] → 8과 1 비교 (교환)
...
결과: 1 → 2 → 3 → 5 → 8
```

#### 📌 **버블 정렬 Java 코드**
```java
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
```

---

## **2. 선택 정렬 (Selection Sort)**
- **배열에서 가장 작은 값을 선택하여 앞에서부터 정렬**
- **시간 복잡도:** O(N²)
- **장점:** 추가적인 메모리 사용 없음 (제자리 정렬, In-Place Sort)
- **단점:** 느림, N²의 시간 복잡도로 인해 큰 배열에 비효율적

#### 📌 **선택 정렬 과정 예시**
```
입력: 3 → 2 → 5 → 8 → 1
과정:
1. [3, 2, 5, 8, 1] → 가장 작은 값 1을 선택 → [1, 2, 5, 8, 3]
2. [1, 2, 5, 8, 3] → 가장 작은 값 2는 이미 정렬됨
3. [1, 2, 5, 8, 3] → 가장 작은 값 3을 선택 → [1, 2, 3, 8, 5]
4. [1, 2, 3, 8, 5] → 가장 작은 값 5를 선택 → [1, 2, 3, 5, 8]
결과: 1 → 2 → 3 → 5 → 8
```

#### 📌 **선택 정렬 Java 코드**
```java
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
```

---

## **3. 퀵 정렬 (Quick Sort)**
- **피벗(Pivot)을 기준으로 작은 값과 큰 값을 나누어 정렬하는 알고리즘**
- **시간 복잡도:** 평균 O(N log N), 최악 O(N²)
- **장점:** 매우 빠름, 추가적인 메모리 사용이 적음 (제자리 정렬, In-Place Sort)
- **단점:** 불안정한 정렬, 최악의 경우 느림 (이미 정렬된 배열에서 성능 저하)

#### 📌 **퀵 정렬 과정 예시**
```
입력: 3 → 2 → 5 → 8 → 1
과정:
1. 피벗: 5, [3, 2, 1] | 5 | [8]
2. 피벗: 2, [1] | 2 | [3]
3. 정렬 완료 → [1, 2, 3, 5, 8]
결과: 1 → 2 → 3 → 5 → 8
```

#### 📌 **퀵 정렬 Java 코드**
```java
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
```

---
## **4. 병합 정렬 (Merge Sort)**
- **배열을 반으로 나누고 정렬된 상태로 합병하는 정렬 알고리즘**  
- **시간 복잡도: O(N log N) (최악, 평균, 최선 모두 동일)**  
- **장점:** 안정적인 정렬(Stable Sort), 최악의 경우에도 O(N log N) 보장  
- **단점:** 추가 메모리 사용 (공간 복잡도 O(N))  

---

### **📌 병합 정렬의 동작 방식**
1. **배열을 반으로 나눈다** (Divide).
2. 각각을 재귀적으로 정렬 (Conquer).
3. 두 개의 정렬된 배열을 병합 (Merge).
4. 모든 원소가 합쳐질 때까지 반복.

---

### **📌 병합 정렬의 과정 예시**  
입력: `[3, 2, 5, 8, 1]`

1. **분할 (Divide)**
   ```
   [3, 2, 5, 8, 1] → [3, 2] | [5, 8, 1]
   [3, 2] → [3] | [2]
   [5, 8, 1] → [5] | [8, 1]
   [8, 1] → [8] | [1]
   ```
2. **정렬 후 병합 (Merge)**
   ```
   [3] + [2] → [2, 3]
   [8] + [1] → [1, 8]
   [5] + [1, 8] → [1, 5, 8]
   [2, 3] + [1, 5, 8] → [1, 2, 3, 5, 8]
   ```
결과: `[1, 2, 3, 5, 8]` (오름차순 정렬 완료)

---

### **📌 병합 정렬 Java 코드**
```java
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) arr[i] = temp[k];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
```

---

### **📌 병합 정렬의 특징**
|  | **병합 정렬 (Merge Sort)** |
|-------------|--------------------|
| **시간 복잡도** | O(N log N) (최악, 평균, 최선 동일) |
| **공간 복잡도** | O(N) (추가 배열 필요) |
| **정렬 안정성** | ✅ 안정 정렬 (Stable Sort) |
| **장점** | 데이터의 크기에 관계없이 O(N log N) 보장 |
| **단점** | 추가적인 배열 메모리 필요 |

---

### **📌 퀵 정렬 vs 병합 정렬 비교**
|  | **퀵 정렬 (Quick Sort)** | **병합 정렬 (Merge Sort)** |
|-------------|-----------------|-----------------|
| **시간 복잡도** | 평균 O(N log N), 최악 O(N²) | O(N log N) (항상 동일) |
| **공간 복잡도** | O(log N) (재귀 호출 스택) | O(N) (추가 메모리 필요) |
| **정렬 안정성** | ❌ 불안정 정렬 | ✅ 안정 정렬 |
| **데이터 특성** | 데이터가 랜덤하게 분포되어 있을 때 유리 | 큰 데이터 정렬 시 안정적 |

---

### **🔥 정리**
✔ **병합 정렬은 안정적인 정렬이 필요할 때 사용**  
✔ **O(N log N) 보장되지만, 추가 메모리를 사용함**  
✔ **퀵 정렬이 평균적으로 빠르지만, 최악의 경우 병합 정렬이 더 유리함**  
다음은 **작성 양식을 통일하여 정리한 "정렬 & 이분 탐색" 문서**입니다.  
병합 정렬과 퀵 정렬을 포함한 모든 정렬 알고리즘의 설명을 **일관된 스타일**로 정리하였으며,  
각 정렬의 **시간 복잡도, 과정 예시, Java 코드**까지 포맷을 맞췄습니다.  

---

## **정렬 알고리즘 비교**
| 정렬 알고리즘 | 평균 시간 복잡도 | 최악 시간 복잡도 | 공간 복잡도 | 특징 |
|--------------|---------------|---------------|---------------|--------|
| **버블 정렬 (Bubble Sort)** | O(N²) | O(N²) | O(1) | 느리지만 구현이 쉬움 |
| **선택 정렬 (Selection Sort)** | O(N²) | O(N²) | O(1) | 최소값을 선택하여 정렬 |
| **삽입 정렬 (Insertion Sort)** | O(N²) | O(N²) | O(1) | 거의 정렬된 배열에 유리 |
| **퀵 정렬 (Quick Sort)** | O(N log N) | O(N²) | O(log N) | 피벗을 기준으로 분할 정렬 |
| **병합 정렬 (Merge Sort)** | O(N log N) | O(N log N) | O(N) | 안정 정렬, 추가 메모리 사용 |

---
다음은 **이분 탐색(Binary Search)**에 대한 내용을 기존 정렬 알고리즘과 동일한 스타일로 정리한 초안입니다.  

---

## **이분 탐색 (Binary Search)**

### **1. 이분 탐색이란?**
- **정렬된 배열에서 원하는 값을 빠르게 찾는 탐색 알고리즘**
- **탐색 범위를 절반씩 줄여가며 찾기 때문에 O(log N)의 시간 복잡도를 가짐**
- **순차 탐색(Linear Search, O(N))보다 훨씬 빠름**
- **탐색 대상이 반드시 **오름차순 또는 내림차순으로 정렬되어 있어야 함**

---

### **2. 이분 탐색의 동작 원리**

- 이분 탐색은 반드시 "정렬된 배열"에서만 사용 가능!

- 탐색 범위를 절반씩 줄여 O(log N)의 빠른 탐색 속도를 제공!
---
- **2-1. 동작 순서**
1. **배열이 정렬되어 있어야 한다.** 
2. **탐색 범위의 중간 값을 찾는다.**
3. **중간 값이 찾고자 하는 값과 같다면 탐색 종료.**
4. **중간 값이 찾고자 하는 값보다 크다면 왼쪽 범위를 탐색.**
5. **중간 값이 찾고자 하는 값보다 작다면 오른쪽 범위를 탐색.**
6. **탐색 범위를 계속 절반씩 줄여가며 반복.**
7. **값을 찾으면 해당 인덱스를 반환, 찾을 수 없으면 -1 반환.**

---

### **3. 이분 탐색의 과정 예시**
```
입력: 정렬된 배열 [1, 2, 3, 5, 8], 찾는 값: 3
과정:
1. 중간값(mid) 찾기 → [1, 2, 3, 5, 8], mid = 3
2. 찾는 값 3이 mid 값과 같음 → 탐색 종료
결과: 인덱스 2에서 3을 찾음
```

```
입력: 정렬된 배열 [1, 2, 3, 5, 8], 찾는 값: 6
과정:
1. 중간값(mid) 찾기 → [1, 2, 3, 5, 8], mid = 3
2. 찾는 값 6 > mid 값 3 → 오른쪽 탐색 [5, 8]
3. 중간값(mid) 찾기 → [5, 8], mid = 5
4. 찾는 값 6 > mid 값 5 → 오른쪽 탐색 [8]
5. 중간값(mid) 찾기 → [8], mid = 8
6. 찾는 값 6 < mid 값 8 → 왼쪽 탐색 (없음) → 탐색 종료
결과: 찾는 값 6이 존재하지 않음 (-1 반환)
```

---

### **4. 이분 탐색의 구현 (반복문 방식 - Iterative)**
```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid; // 찾았을 경우 인덱스 반환
            else if (arr[mid] < target) left = mid + 1; // 오른쪽 탐색
            else right = mid - 1; // 왼쪽 탐색
        }

        return -1; // 찾지 못한 경우
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8};
        int target = 3;
        int result = binarySearch(arr, target);

        if (result != -1) System.out.println("찾은 위치: " + result);
        else System.out.println("값을 찾을 수 없음");
    }
}
```

---

### **5. 이분 탐색의 구현 (재귀 방식 - Recursive)**
```java
public class RecursiveBinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1; // 종료 조건

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid; // 값을 찾은 경우
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, right, target); // 오른쪽 탐색
        else return binarySearch(arr, left, mid - 1, target); // 왼쪽 탐색
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8};
        int target = 5;
        int result = binarySearch(arr, 0, arr.length - 1, target);

        if (result != -1) System.out.println("찾은 위치: " + result);
        else System.out.println("값을 찾을 수 없음");
    }
}
```

---

### **6. 이분 탐색의 특징**
|  | **이분 탐색 (Binary Search)** |
|-------------|--------------------|
| **시간 복잡도** | O(log N) |
| **공간 복잡도** | O(1) (반복문) / O(log N) (재귀) |
| **탐색 안정성** | ✅ 항상 O(log N) 보장 |
| **장점** | 매우 빠른 탐색 속도, 대량의 데이터에서 유리 |
| **단점** | **정렬된 배열에서만 사용 가능** |

---

### **7. 이분 탐색 vs 선형 탐색 비교**
|  | **이분 탐색 (Binary Search)** | **순차 탐색 (Linear Search)** |
|-------------|-----------------|-----------------|
| **시간 복잡도** | O(log N) | O(N) |
| **공간 복잡도** | O(1) (반복문) / O(log N) (재귀) | O(1) |
| **정렬 필요 여부** | ✅ 필요 | ❌ 필요 없음 |
| **적용 데이터** | 정렬된 데이터 | 정렬되지 않은 데이터 |
| **탐색 속도** | 매우 빠름 (N이 클수록 유리) | 느림 (N이 클수록 불리) |

---

### **🔥 정리**
✔ **이분 탐색은 정렬된 배열에서만 사용 가능**  
✔ **탐색 범위를 절반씩 줄이므로 O(log N)으로 매우 빠름**  
✔ **반복문과 재귀 방식으로 구현 가능**  
✔ **O(N)의 순차 탐색보다 훨씬 효율적이며, 특히 큰 데이터에서 성능 차이가 큼**  

---
