public class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        
        List<List<Integer>> res=new LinkedList();
        
        List<Integer> list=new ArrayList();
        
        dfs(res,nums,list);
        return res;
    
    }
    
    
    protected void dfs(List<List<Integer>> res, int[] nums, List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }else{
                list.add(nums[i]);
                dfs(res,nums,list);
                list.remove(list.size()-1);
            }
        }
        return;
        
    }
    

    

    
    
}
