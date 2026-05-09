1class Solution {
2    
3    private void bfs(List<List<String>> watchedVideos, int[][] friends, int id, int level, Map<String, Integer> frequencyOfWatchedVideo){
4
5        Deque<Integer> queue = new ArrayDeque<>();
6        queue.add(id);
7        boolean[] visited = new boolean[friends.length];
8        visited[id] = true;
9
10        int currentLevel = 0;
11
12        while(!queue.isEmpty()){  
13            int size = queue.size();
14            currentLevel++;
15            for(int i = 0; i < size ; i++){
16                int node = queue.pollFirst();
17
18                for(int friend : friends[node]){
19                    if(!visited[friend]){
20                        queue.add(friend); visited[friend] = true;
21                    }
22                    
23                }
24            }
25            if(level == currentLevel){
26                break;
27            }
28        }
29
30        while(!queue.isEmpty()){  
31            int friend = queue.pollFirst();
32            for(String video : watchedVideos.get(friend)){
33                frequencyOfWatchedVideo.put(video, frequencyOfWatchedVideo.getOrDefault(video, 0) + 1);
34            }
35        }
36
37        // System.out.println("frequencyOfWatchedVideo : " + frequencyOfWatchedVideo);
38    }
39
40    
41    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
42
43        List<String> ans = new ArrayList<>();
44        Map<String, Integer> frequencyOfWatchedVideo = new HashMap<>();
45
46        bfs(watchedVideos, friends, id, level, frequencyOfWatchedVideo);
47
48        Map<Integer, List<String>> sortByFreq = new TreeMap<>();
49
50        for(Map.Entry<String, Integer> entry : frequencyOfWatchedVideo.entrySet()){
51
52            String movie = entry.getKey(); Integer times = entry.getValue();
53            if(sortByFreq.containsKey(times)){
54                sortByFreq.get(times).add(movie);
55            }else{
56                List<String> list = new ArrayList<>(); list.add(movie);
57                sortByFreq.put(times ,list);
58            }
59        }
60
61        for(Map.Entry<Integer, List<String>> entry : sortByFreq.entrySet()){
62
63            Collections.sort(entry.getValue());
64            ans.addAll(entry.getValue());
65        }
66
67
68
69
70        return ans;
71    }
72}