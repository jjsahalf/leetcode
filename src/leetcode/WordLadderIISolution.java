package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 10/5/16.
 */
public class WordLadderIISolution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res=new ArrayList();
        Set<String> visitedSet=new HashSet();
        if(wordList==null || wordList.size()==0){
            return res;
        }
        if(beginWord.equals(endWord)){
            List<String> list=new ArrayList();
            list.add(beginWord);
            res.add(list);
        }
        Map<String, List<String>> map=new HashMap();
        Queue<String> queue=new LinkedList();
        queue.offer(beginWord);
        visitedSet.add(beginWord);
        boolean endWordReached=false;
        while(!queue.isEmpty() && !endWordReached){
            int size=queue.size();
            List<String> thisLevelVisited=new ArrayList();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                //System.out.println("curr "+curr);
                if(isEndWordOneDistanceAway(curr,endWord)){
                    //System.out.println("sth here");
                    if(map.containsKey(endWord)){
                        List<String> endWordList=map.get(endWord);
                        if(!endWordList.contains(curr)){
                            endWordList.add(curr);
                        }
                    }else{
                        List<String> endWordList=new ArrayList();
                        endWordList.add(curr);
                        map.put(endWord, endWordList);
                    }
                    endWordReached=true;
                    continue;
                }

                Set<String> set = getOneDistanceWordInDict(curr, wordList, visitedSet);
                thisLevelVisited.addAll(set);
                for(String str:set){
                    queue.offer(str);
                    if(!map.containsKey(str)){
                        List<String> currList=new ArrayList();
                        currList.add(curr);
                        map.put(str,currList);
                    }else{
                        List<String> currList=map.get(str);
                        if(!currList.contains(curr)){
                            currList.add(curr);
                        }
                        map.put(str,currList);
                    }
                }
            }
            visitedSet.addAll(thisLevelVisited);
        }
        //System.out.println(map.size());
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            //System.out.println(entry.getKey());
            //System.out.println(entry.getValue().size());
        }
        List<String> endWordList=map.get(endWord);
        if(endWordList==null || endWordList.size()==0){
            return res;
        }
        List<String> list=new ArrayList();
        helper(list, map, res, beginWord, endWord);


        return res;
    }
    public boolean isEndWordOneDistanceAway(String curr, String endWord){
        char[] array=curr.toCharArray();
        for(int i=0;i<curr.length();i++){
            char prev=array[i];
            for(char c='a'; c<='z';c++){
                array[i]=c;
                String str=new String(array);
                /*if(curr.equals("dot")){
                    System.out.println("dot->"+str);
                }*/
                if(str.equals(endWord)){
                    return true;
                }
            }
            array[i]=prev;
        }
        return false;
    }
    public Set<String> getOneDistanceWordInDict(String curr, Set<String> wordList, Set<String> visitedSet){
        char[] array=curr.toCharArray();
        Set<String> set=new HashSet();
        for(int i=0;i<curr.length();i++){
            char prev=array[i];
            for(char c='a'; c<='z';c++){
                array[i]=c;
                String str=new String(array);
                if(!visitedSet.contains(str) && wordList.contains(str) && !str.equals(curr) ){
                    set.add(str);
                }
            }
            array[i]=prev;
        }
        return set;
    }
    public void helper(List<String> list, Map<String, List<String>> map, List<List<String>> res, String beginWord, String curr){
        list.add(curr);
        List<String> aPathList=new ArrayList();
        if(curr.equals(beginWord)){
            for(int i=list.size()-1; i>=0;i--){
                aPathList.add(list.get(i));
            }
            res.add(aPathList);
            list.remove(list.size()-1);
            return;
        }
        List<String> prevList=map.get(curr);
        for(String prev:prevList){
            helper(list, map, res, beginWord, prev);
        }
        list.remove(list.size()-1);
    }
}
