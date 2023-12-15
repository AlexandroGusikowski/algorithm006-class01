class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// �����
		List<List<String>> result = new ArrayList<>();
		// �ֵ��в�����Ŀ�굥��,��Ҫת����HashSet����Ϊ��������wordList����̫������ʱ
		Set<String> wordSet = new HashSet<>(wordList);
		if (!distSet.contains(endWord))
			return result;
		// ���õ�ÿһ��Ľڵ�
		LinkedList<List<String>> queue = new LinkedList<>();
		// �����ײ�ڵ�
		queue.offer(Arrays.asList(beginWord));
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		// �趨�Ƿ񵽿��Խ����Ĳ���ˡ�
		boolean flag = false;
		while (!queue.isEmpty() && !flag) {
			int size = queue.size();
			Set<String> perVisited = new HashSet<>();
			for (int i = 0; i < size; i++) {
				List<String> tempList = queue.poll();
				// ȡlist�е����һ��Ԫ�أ������ж�
				String word = tempList.get(tempList.size() - 1);
				char[] chars = word.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char temp = chars[j];// ����ԭʼֵ
					for (char j2 = 'a'; j2 <= 'z'; j2++) {
						if (j2 == temp)
							continue;
						chars[j] = j2;
						// �õ��滻����ַ���
						String newString = new String(chars);
						if (!visited.contains(newString) && wordSet.contains(newString)) {
							List<String> newList = new ArrayList<>(tempList);
							newList.add(newString);
							if (newString.equals(endWord)) {
								flag = true;
								result.add(newList);
							}
							perVisited.add(newString);
							queue.offer(newList);
						}
					}
					chars[j] = temp;// �ָ�ԭʼֵ��
				}
			}
			visited.addAll(perVisited);
		}
		return result;
	}
	
	public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (wordList == null || wordList.size() == 0)
			return result;		
		// ת����hash�������ٶȿ졣
		Set<String> words = new HashSet<String>(wordList);
		if(!words.contains(endWord)) return result;
		Set<String> begin = new HashSet<>(), end = new HashSet<>();
		begin.add(beginWord);
		end.add(endWord);
		Map<String, List<String>> treeMap = new HashMap<>();
		boolean front = true;
		boolean flag = buildTreeMap(words, begin, end, treeMap, front);
		if (flag)
			dfs(result, treeMap, beginWord, endWord, new LinkedList<>());
		return result;
	}

	private void dfs(List<List<String>> result, Map<String, List<String>> treeMap, String beginWord, String endWord,
			LinkedList<String> list) {
		list.add(beginWord);
		if (beginWord.equals(endWord)) {
			result.add(new ArrayList<>(list));
			list.removeLast();
			return;
		}
		if (treeMap.containsKey(beginWord)) {
			for (String word : treeMap.get(beginWord)) {
				dfs(result, treeMap, word, endWord, list);
			}
		}
		list.removeLast();
	}
	private boolean buildTreeMap(Set<String> words, Set<String> begin, Set<String> end,
			Map<String, List<String>> treeMap, boolean front) {
		if (begin.size() == 0)
			return true;

		if (begin.size() > end.size())
			return buildTreeMap(words, end, begin, treeMap, !front);

		words.removeAll(begin);
		Set<String> nextLevel = new HashSet<>();
		boolean isMeet = false;
		for (String word : begin) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char tmp = chars[i];
				for (char j = 'a'; j <= 'z'; j++) {
					chars[i] = j;
					if (chars[i] == tmp)
						continue;
					String newString = String.valueOf(chars);
					if (words.contains(newString)) {
						nextLevel.add(newString);
						if (end.contains(newString)) {
							isMeet = true;
						}
						String key = front ? word : newString;
						String nextWord = front ? newString : word;
						if (!treeMap.containsKey(key)) {
							treeMap.put(key, new ArrayList<>());
						}
						treeMap.get(key).add(nextWord);
					}
				}
				chars[i] = tmp;
			}
		}
		if (isMeet)
			return true;
		return buildTreeMap(words, nextLevel, end, treeMap, front);
	}
	
}